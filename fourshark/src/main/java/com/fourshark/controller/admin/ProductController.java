package com.fourshark.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fourshark.constant.SystemConstant;
import com.fourshark.model.ProductModel;
import com.fourshark.paging.PageRequest;
import com.fourshark.paging.Pageble;
import com.fourshark.service.IBrandService;
import com.fourshark.service.ICategoryService;
import com.fourshark.service.IProductService;
import com.fourshark.sort.Sorter;
import com.fourshark.utils.FormUtil;
import com.fourshark.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-product" })
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private IProductService productService;

	@Inject IBrandService brandService;
	
	@Inject 
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductModel product = FormUtil.toModel(ProductModel.class, req);
		String view = "";
		
		if (product.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(product.getPage(), product.getMaxPageItem(),
					new Sorter(product.getSortName(), product.getSortBy()));
			product.setListResult(productService.findAll(pageble));
			product.setTotalItem(productService.getTotalItem());
			product.setTotalPage((int) Math.ceil((double) product.getTotalItem() / product.getMaxPageItem()));

			view = "/views/admin/product/list.jsp";
		}
		else if(product.getType().equals(SystemConstant.EDIT)) {
			if (product.getId() != null) {
				product = productService.findOneById(product.getId());
			}
			req.setAttribute("categories", categoryService.findAll());
			req.setAttribute("brands", brandService.findAll());
			view = "/views/admin/product/edit.jsp";
			
		}
		
		MessageUtil.showMessage(req);
		req.setAttribute(SystemConstant.MODEL, product);
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
