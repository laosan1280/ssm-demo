package com.srain.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srain.mapper.UserDao;
import com.srain.pojo.User;
import com.srain.service.UserService;

@Service
public class UserServiceImpl implements UserService {  
	
	@Autowired 
    private UserDao userDao;  
      
    public User getUserById(int userId) {  
        return userDao.queryByPrimaryKey(userId);  
    }  
  
    public void insertUser(User user) {  
        userDao.insertUser(user);  
    }  
  
    public void addUser(User user) {  
        userDao.insertUser(user);  
    }  
  
    public List<User> getAllUser() {  
        return userDao.getAllUser();  
    }  
  
}  
