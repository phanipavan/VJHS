package com.vjhs.interfaces;

import java.util.List;

import com.vjhs.pojo.LoginAdmin;

public interface LoginAdminOperations {

	LoginAdmin getLoginDetails(String userName);

	boolean checkUser(String userName);
	
	boolean addUserAdmin(LoginAdmin loginAdmin);

	boolean updateUserAdmin(String userId);

	boolean deleteUserAdmin(String userId);

	List<LoginAdmin> getAllUserAdmins();

}
