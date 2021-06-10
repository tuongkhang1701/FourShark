package com.fourshark.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fourshark.model.ProductModel;
import com.fourshark.service.IProductService;
import com.fourshark.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-product"})
public class ProductAPI extends HttpServlet{
	
	@Inject
	IProductService productService;

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); 
		ProductModel productModel = HttpUtil.of(request.getReader()).toModel(ProductModel.class);
		
		
		
		productModel = productService.save(productModel);
		mapper.writeValue(response.getOutputStream(), productModel);
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json"); 
		ProductModel updateProduct = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
		
		updateProduct = productService.update(updateProduct);
		mapper.writeValue(resp.getOutputStream(), updateProduct);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json"); 
		ProductModel productModel = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
		productService.delete(productModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
