package com.fourshark.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.fourshark.dao.IUserDAO;
import com.fourshark.model.RoleModel;
import com.fourshark.model.UserModel;
import com.fourshark.paging.Pageble;
import com.fourshark.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDAO userDAO;


	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	Date date = new Date();
	
	@Override
	public UserModel findByEmailAndPasswordAndStatus(String email, String password) {
		return  userDAO.findByEmailAndPasswordAndStatus(email, password);
	}

	@Override
	public UserModel save(UserModel userModel) {
		userModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		RoleModel role = new RoleModel();
		role.setId(4L);
		userModel.setRole(role);
		long id = userDAO.save(userModel);
		return userDAO.findOneById(id);
	}

	@Override
	public UserModel update(UserModel newUser) {
		newUser.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		userDAO.update(newUser);
		return userDAO.findOneById(newUser.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			userDAO.delete(id);
		}
		
	}

	@Override
	public List<UserModel> findAll(Pageble pageble) {
		
		return userDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return userDAO.getTotalItem();
	}

	@Override
	public UserModel findOneById(long id) {
		return userDAO.findOneById(id);
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.checkEmail(email);
	}

	@Override
	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		return userDAO.checkUsername(username);
	}

	@Override
	public List<UserModel> findAll() {
		
		return userDAO.findAll();
	}

}
