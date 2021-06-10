package com.fourshark.dao;

import java.util.List;

import com.fourshark.model.UserModel;
import com.fourshark.paging.Pageble;

public interface IUserDAO extends GenericDAO<UserModel> {
	
	public UserModel findByEmailAndPasswordAndStatus(String email, String password);

	long save(UserModel userModel);
	
	boolean checkEmail(String email);

	List<UserModel> findAll(Pageble pageble);
	
	List<UserModel> findAll();

	void update(UserModel newUser);

	void delete(long id);

	UserModel findOneById(Long id);

	int getTotalItem();
	
	boolean checkUsername(String userName);
}
