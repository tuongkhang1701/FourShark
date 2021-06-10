package com.fourshark.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fourshark.model.OrderModel;
import com.fourshark.service.IOrderService;
import com.fourshark.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-order"})
public class OrderAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject
	private IOrderService orderService;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		OrderModel orderModel = HttpUtil.of(request.getReader()).toModel(OrderModel.class);
		
		
		orderModel = orderService.addOrder(orderModel);
		mapper.writeValue(response.getOutputStream(), orderModel);
	}
	
	
}