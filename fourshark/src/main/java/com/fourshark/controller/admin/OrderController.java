package com.fourshark.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fourshark.constant.SystemConstant;
import com.fourshark.model.OrderModel;
import com.fourshark.model.PaymentModel;
import com.fourshark.model.UserModel;
import com.fourshark.paging.PageRequest;
import com.fourshark.paging.Pageble;
import com.fourshark.service.IOrderService;
import com.fourshark.service.IPaymentService;
import com.fourshark.service.IUserService;
import com.fourshark.sort.Sorter;
import com.fourshark.utils.FormUtil;
import com.fourshark.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-order" })
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject
	private IOrderService orderService;
	
	@Inject 
	private IPaymentService paymentService;
	
	@Inject
	private IUserService userService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderModel order = FormUtil.toModel(OrderModel.class, req);
		String view = "";
		
		if (order.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(order.getPage(), order.getMaxPageItem(),
					new Sorter(order.getSortCreatedDate(), order.getSortBy()));
			order.setListResult(orderService.findAll());
			order.setTotalItem(orderService.getTotalItem());
			order.setTotalPage((int) Math.ceil((double) order.getTotalItem() / order.getMaxPageItem()));

			view = "/views/admin/order/list.jsp";
		}
		
		MessageUtil.showMessage(req);
		List<PaymentModel> paymentList = paymentService.findAll();
		List<UserModel> userList = userService.findAll();
		req.setAttribute("userList", userList);
		req.setAttribute("paymentList", paymentList);
		req.setAttribute(SystemConstant.ORDERMODEL, order);
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

