package com.sgic.myleave.service;

import java.util.List;

import com.sgic.myleave.criteria.UserCriteria;
import com.sgic.myleave.entity.User;

public interface UserService {

	boolean saveUser(User user);
	// public List<User> createUsers(User user);

	List<User> viewUser();
	// public List<User> getUser();

	boolean updateUser(User user);

	boolean deleteUser(int id);
	User findByName(String name);
	List<User> findAllByName(String name);
	List<User>search(UserCriteria userCriteria);
}
