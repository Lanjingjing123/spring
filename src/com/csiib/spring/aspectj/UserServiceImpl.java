package com.csiib.spring.aspectj;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println(" aspectj add user!");
	}

	@Override
	public void deleteUser() {
		System.out.println("aspectj delete user!");
	}

	@Override
	public String updateUser() {
		int i = 1/0;
		System.out.println("aspectj update user!");
		return "you are so beautiful";
	}

}
