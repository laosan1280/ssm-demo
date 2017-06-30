package com.srain.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.srain.pojo.User;
import com.srain.service.UserService;

@Controller  
@RequestMapping("/user")  
public class UserController {  
	
    @Autowired
    private UserService userService;  
      
    @RequestMapping("/userList")  
    public String userList(HttpServletRequest request,Model model){  
        List<User> uList = userService.getAllUser();  
        model.addAttribute("uList", uList);  
        return "userList";  
    }  
      
    @RequestMapping("/showUser")  
    public String showUser(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = userService.getUserById(userId);  
        model.addAttribute("user", user);  
        return "showUser";  
    }  
      
    @RequestMapping("/addUserUI")  
    public String addUserUI(){  
        return "addUser";  
    }  
      
    @RequestMapping("/addUser")  
    public String addUser(HttpServletRequest request,Model model){  
        User user = new User();  
        user.setName(String.valueOf(request.getParameter("name")));  
        user.setPassword(String.valueOf(request.getParameter("password")));  
        user.setAge(Integer.parseInt(String.valueOf(request.getParameter("age"))));  
        userService.addUser(user);  
        return "redirect:/user/userList";  
    }  
}  
