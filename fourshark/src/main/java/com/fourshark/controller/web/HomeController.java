package com.fourshark.controller.web;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fourshark.dao.IProductDAO;
import com.fourshark.model.CartModel;
import com.fourshark.model.ProductModel;
import com.fourshark.model.UserModel;
import com.fourshark.service.ICategoryService;
import com.fourshark.service.IPaymentService;
import com.fourshark.service.IProductService;
import com.fourshark.service.IUserService;
import com.fourshark.utils.FormUtil;
import com.fourshark.utils.SessionUtil;

@WebServlet(urlPatterns = {"/home", "/login", "/logout", "/register", "/cart", "/about"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ResourceBundle bundle = ResourceBundle.getBundle("message");
	
	@Inject IPaymentService paymentService;
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private IProductService productService;

	@Inject
	private IUserService userService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");
		
		if (message != null && alert != null) {
			request.setAttribute("message", bundle.getString(message));
			request.setAttribute("alert", alert);
		}
		
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			request.setAttribute("status", "login");
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		}
		else if(action != null && action.equals("register")) {
			request.setAttribute("status", "register");
			RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
			rd.forward(request, response);
		}
		else if(action != null && action.equals("detailProduct")) {
			UserModel user = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
			Long id = Long.parseLong(request.getParameter("id"));
			ProductModel model = productService.findOneById(id);
			request.setAttribute("user", user);
			request.setAttribute("model", model);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/detailProduct.jsp");
			rd.forward(request, response);
		}
		else if(action != null && action.equals("cart")) {
			request.setAttribute("payments", paymentService.findAll());
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/cart.jsp");
			rd.forward(request, response);
		}
		else if(action != null && action.equals("checkout")) {
			request.setAttribute("payments", paymentService.findAll());
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/checkout.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/home");
			
		}
		else if (action != null && action.equals("about")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/aboutIntroduce.jsp");
			rd.forward(request, response);
			
		}
		else if (action != null && action.equals("introduce")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/introduce.jsp");
			rd.forward(request, response);
			
		}
		else if (action != null && action.equals("contact")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/contact.jsp");
			rd.forward(request, response);
			
		}
		else if (action != null && action.equals("leader")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/leader.jsp");
			rd.forward(request, response);
			
		}
		else if (action != null && action.equals("search")) {
			String keyword = request.getParameter("keyword");
			List<ProductModel> list = productService.findByKeyword(keyword);
			request.setAttribute("parentCategories", categoryService.getListParentCategory());
			request.setAttribute("listAfterSearch", list);
			CartModel cart = (CartModel) SessionUtil.getInstance().getValue(request, "cart");
			if (cart == null) {
				cart = new CartModel();
				SessionUtil.getInstance().putValue(request, "cart", cart);
			}
			
			request.setAttribute("listAfterSearch", list);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
			
		}
		else if (action != null && action.equals("category")) {
			Long idCate = Long.parseLong(request.getParameter("id"));
			List<ProductModel> list = productService.findByCategoryId(idCate);
			CartModel cart = (CartModel) SessionUtil.getInstance().getValue(request, "cart");
			if (cart == null) {
				cart = new CartModel();
				SessionUtil.getInstance().putValue(request, "cart", cart);
			}
			request.setAttribute("parentCategories", categoryService.getListParentCategory());
			request.setAttribute("listAfterSearch", list);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			List<ProductModel> list = productService.findAll();
			request.setAttribute("products", list);
			request.setAttribute("parentCategories", categoryService.getListParentCategory());
			CartModel cart = (CartModel) SessionUtil.getInstance().getValue(request, "cart");
			if (cart == null) {
				cart = new CartModel();
				SessionUtil.getInstance().putValue(request, "cart", cart);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");
		String email = request.getParameter("Email");
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, request);
			model = userService.findByEmailAndPasswordAndStatus(model.getEmail(), model.getPassword());
			if (model != null) {
				SessionUtil.getInstance().putValue(request, "USERMODEL", model);
				if (model.getRole().getCode().equals("USER")) {
					response.sendRedirect(request.getContextPath() + "/home");
				}
				else if(model.getRole().getCode().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath() + "/admin-home");
				}
			}
			else {
				response.sendRedirect(request.getContextPath() + "/login?action=login&message=username_password_invalid&alert=danger");
			}
			
		}
		else if(action != null && action.equals("register")) {
			UserModel model = FormUtil.toModel(UserModel.class, request);
			model = userService.save(model);
			if (model != null) {
				response.sendRedirect(request.getContextPath() + "/register?action=register&message=register_success&alert=success");
			}
			else {
				response.sendRedirect(request.getContextPath() + "/register?action=register&message=have_field_invalid&alert=danger");
			}
		}
		
		
	}

}
