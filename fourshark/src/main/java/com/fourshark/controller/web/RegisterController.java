package com.fourshark.controller.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import com.fourshark.service.IUserService;

public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUserService userService;

}
