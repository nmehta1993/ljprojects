package com.ljproject.service;

import java.util.List;

import com.ljproject.model.Role;
import com.ljproject.model.User;




public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	String addUser(User user);
	public User findById(long id);
	public void sendEmailforApprove(User user);
	public List<User> listUser();
	void deleteUserById(long id);
	List<User> userList();
	List<Role> roleList();
}
