package com.kiran.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.entity.User;
import com.kiran.repository.UserRepo;
import com.kiran.service.UserService;

@Service
public class UserServieImp implements UserService{
	@Autowired
	UserRepo repo;

	public String addUser(User user) {
		repo.save(user);
		return "User added Successfully";
	}

	//to check the duplicate entries
	public boolean emailExists(String email) {
		if (repo.findByEmail(email)!=null)
		{
			return true;
		}
		else
		{
			return false;
		}

	}
	
	public User login(String email,String password) {
		return repo.findByEmailAndPassword(email, password);
	}

	public String getRole(String email) {
		User user=repo.findByEmail(email);
		return user.getRole();	
	}

	@Override
	public User getUser(String email) {
		return repo.findByEmail(email);
		
	}

	@Override
	public void updateUser(User user) {
		repo.save(user);
		
	}



}
