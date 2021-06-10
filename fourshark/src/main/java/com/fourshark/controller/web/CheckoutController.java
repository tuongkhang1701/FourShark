package com.fourshark.controller.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fourshark.model.CartModel;
import com.fourshark.model.OrderModel;
import com.fourshark.model.PaymentModel;
import com.fourshark.model.UserModel;
import com.fourshark.service.IDetailOrderService;
import com.fourshark.service.IOrderService;
import com.fourshark.utils.HttpUtil;
import com.fourshark.utils.SessionUtil;

@WebServlet(urlPatterns = {"/checkoutController"})
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ResourceBundle bundle = ResourceBundle.getBundle("message");
	
	@Inject
	private IOrderService orderService;
	
	@Inject
	private IDetailOrderService detailOrderService;
	
    public CheckoutController() {
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");		
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); 
		OrderModel order = HttpUtil.of(request.getReader()).toModel(OrderModel.class);
		
		orderService.addOrder(order);
		
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");
		OrderModel orderModel = new	OrderModel();
		String deliveryAddress = request.getParameter("deliveryAddress");
		if (message != null && alert != null) { 
			request.setAttribute("message", bundle.getString(message));
			request.setAttribute("alert", alert);
		}
		
		PaymentModel paymentModel = new PaymentModel();
		paymentModel.setId(Long.parseLong(request.getParameter("paymentMethod")));
		orderModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		orderModel.setDeliveryAddress(deliveryAddress);
		orderModel.setPaymentMethod(paymentModel);
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		CartModel cart = (CartModel) SessionUtil.getInstance().getValue(request, "cart");
		
		try {
			if (userModel != null) {
				orderService.addOrder(orderModel);
				response.sendRedirect("/views/web/checkout.jsp?messageResponse=checkout_success&alert=success");
				UserModel user = new UserModel();
				user.setId(orderModel.getUser().getId());
				orderService.addOrder(orderModel);
				response.sendRedirect(request.getContextPath() + "/home");
			}
			else {
				response.sendRedirect(request.getContextPath() + "/login?action=login&message=not_login&alert=danger");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
