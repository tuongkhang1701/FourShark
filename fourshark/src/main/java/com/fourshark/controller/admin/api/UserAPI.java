package com.fourshark.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fourshark.model.UserModel;
import com.fourshark.service.IUserService;
import com.fourshark.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-user"})
public class UserAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		UserModel userModel = HttpUtil.of(request.getReader()).toModel(UserModel.class);
		
		
		userModel = userService.save(userModel);
		mapper.writeValue(response.getOutputStream(), userModel);
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json"); 
		UserModel updateUser = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		//updateUser.setModifiedBy(((UserModel)SessionUtil.getInstance().getValue(req, "USERMODEL")).getEmail());
		
		updateUser = userService.update(updateUser);
		mapper.writeValue(resp.getOutputStream(), updateUser);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json"); 
		UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		userService.delete(userModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
	
	
}
