package com.fourshark.controller.web;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fourshark.model.CartModel;
import com.fourshark.model.DetailOrderModel;
import com.fourshark.model.OrderModel;
import com.fourshark.model.PaymentModel;
import com.fourshark.model.UserModel;
import com.fourshark.service.IDetailOrderService;
import com.fourshark.service.IOrderService;
import com.fourshark.service.IPaymentService;
import com.fourshark.service.IProductService;
import com.fourshark.utils.SessionUtil;

@WebServlet(urlPatterns = { "/cartController" })
public class CartController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private IProductService productService;

	@Inject
	private IOrderService orderService;

	@Inject
	private IDetailOrderService detailOrderService;
	
	@Inject
	private IPaymentService paymentService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			doGet_Display(request, response);
		} else if (action.equalsIgnoreCase("add")) {
			doGet_Add(request, response);
		} else if (action.equalsIgnoreCase("remove")) {
			doGet_Remove(request, response);
		} else if (action.equalsIgnoreCase("checkout")) {
			doGet_Checkout(request, response);
		}
		UserModel user = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		request.setAttribute("user", user);
		request.setAttribute("payments", paymentService.findAll());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/cart.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected HttpSession doGet_Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Long id = Long.parseLong(request.getParameter("id"));

		List<CartModel> listItems = (List<CartModel>) session.getAttribute("cartlist");
		int quantity = 1;
		int check = isExisting(id, listItems);

		if (check != -1) {
			if (listItems.get(check).getQuantity() == quantity) {
				listItems.remove(check);
			}

			else if (listItems.get(check).getQuantity() >= quantity) {
				quantity = listItems.get(check).getQuantity() - quantity;
				listItems.get(check).setQuantity(quantity);
			}

		}

		// listItems.remove(check);
		session.setAttribute("cartlist", listItems);
		return session;

	}

	protected void doGet_Display(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/cart.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected HttpSession doGet_Add(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Long id = Long.parseLong(request.getParameter("id"));
		int quantity = 1;
		if (id != null) {
			if (request.getParameter("quantity") != null) {
				quantity = Integer.parseInt(request.getParameter("quantity"));
			}
			if (session.getAttribute("cartlist") == null) {

				List<CartModel> listItems = new ArrayList<CartModel>();
				try {
					listItems.add(new CartModel(productService.findProduct(id), quantity));
				} catch (Exception e) {
					e.printStackTrace();
				}

				session.setAttribute("cartlist", listItems);
			} else {
				List<CartModel> listItems = (List<CartModel>) session.getAttribute("cartlist");

				int check = isExisting(id, listItems);

				if (check == -1) {
					try {
						listItems.add(new CartModel(productService.findProduct(id), quantity));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				else {
					quantity = listItems.get(check).getQuantity() + quantity;
					listItems.get(check).setQuantity(quantity);
				}
				session.setAttribute("cartlist", listItems);
			}

		}
		return session;

	}

	protected HttpSession doGet_Checkout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		OrderModel orderModel = new	OrderModel();
		String deliveryAddress = request.getParameter("deliveryAddress");
		PaymentModel paymentModel = new PaymentModel();
		paymentModel.setId(Long.parseLong(request.getParameter("paymentMethod")));
		orderModel.setDeliveryAddress(deliveryAddress);
		orderModel.setPaymentMethod(paymentModel);
		
		@SuppressWarnings("unchecked")
		List<CartModel> checkout = (List<CartModel>) session.getAttribute("cartlist");
		for (CartModel cartModel : checkout) {
			
			UserModel user = ((UserModel)SessionUtil.getInstance().getValue(request, "USERMODEL"));
			OrderModel order = orderService.addOrder(new OrderModel(deliveryAddress, paymentModel, user));
			Long idDetail = detailOrderService.addDetailOrder(new DetailOrderModel(cartModel.getProduct(), orderService.findById(order.getId()), cartModel.getQuantity(),
					((UserModel)SessionUtil.getInstance().getValue(request, "USERMODEL")).getEmail(), cartModel.getProduct().getPrice()));
		}
		
		session.removeAttribute("cartlist");
		return session;
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private int isExisting(Long id, List<CartModel> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}

}
