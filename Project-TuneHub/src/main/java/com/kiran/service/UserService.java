package com.kiran.service;

import com.kiran.entity.User;

public interface UserService {
    public String addUser(User user);
    public boolean emailExists(String email);
    public String getRole(String email);
    public User login(String email,String password);
    
    public User getUser(String email);
    public void updateUser(User user);
}
