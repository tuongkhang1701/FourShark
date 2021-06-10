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
import com.fourshark.model.UserModel;
import com.fourshark.paging.PageRequest;
import com.fourshark.paging.Pageble;
import com.fourshark.service.IUserService;
import com.fourshark.sort.Sorter;
import com.fourshark.utils.FormUtil;
import com.fourshark.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-user" })
public class UserController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Inject
	private IUserService userService;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel user = FormUtil.toModel(UserModel.class, req);
		String view = "";

		if (user.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(user.getPage(), user.getMaxPageItem(),
					new Sorter(user.getSortName(), user.getSortBy()));
			user.setListResult(userService.findAll(pageble));
			user.setTotalItem(userService.getTotalItem());
			user.setTotalPage((int) Math.ceil((double) user.getTotalItem() / user.getMaxPageItem()));

			view = "/views/admin/user/list.jsp";
		}
		else if (user.getType().equals(SystemConstant.EDIT)) {
			if (user.getId() != null) {
				user = userService.findOneById(user.getId());
			}
			view = "/views/admin/user/edit.jsp";

		}
		else if(user.getType().equals(SystemConstant.REGISTER)) {
			boolean check = userService.checkEmail(user.getEmail());
			if (check) {				
				user = userService.save(user);
			}
		}
		MessageUtil.showMessage(req);
		req.setAttribute(SystemConstant.USERMODEL, user);
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
