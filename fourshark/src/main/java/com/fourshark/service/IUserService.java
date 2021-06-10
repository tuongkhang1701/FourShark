package com.fourshark.service;

import java.util.List;

import com.fourshark.model.UserModel;
import com.fourshark.paging.Pageble;

public interface IUserService {
	
	UserModel findByEmailAndPasswordAndStatus(String email, String password);
	
	UserModel save(UserModel userModel);
	
	UserModel update(UserModel updateUser);
	void delete(long[] ids);
	List<UserModel> findAll(Pageble pageble);
	
	List<UserModel> findAll();
	int getTotalItem();
	UserModel findOneById(long id);
	
	boolean checkEmail(String email);
	boolean checkUsername(String username);
}
