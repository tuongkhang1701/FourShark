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

import com.fourshark.model.DetailOrderModel;
import com.fourshark.model.ProductModel;
import com.fourshark.service.IDetailOrderService;
import com.fourshark.service.IProductService;
@WebServlet(urlPatterns = { "/admin-detail" })
public class DetailOrderController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDetailOrderService detailService;
	
	@Inject
	private IProductService productService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(req.getParameter("id"));
		
		List<DetailOrderModel> list = detailService.findById(id);
		
		List<ProductModel> productList = productService.findAll();
		req.setAttribute("productList", productList);
		req.setAttribute("detailList", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/detail/list.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
