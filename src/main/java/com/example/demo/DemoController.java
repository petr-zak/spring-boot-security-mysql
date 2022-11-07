package com.example.demo;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.AllServices;

@RestController
public class DemoController {
    private AllServices allServices;

    public DemoController(AllServices allServices) {
        this.allServices = allServices;
    }

    @GetMapping("/root")
    @ResponseBody
    public String getRoot(Authentication authentication){
        User user = allServices.authenticatedUser.getUser();
        if(user.getRoles().contains(allServices.role.ADMIN)){
            return "Logged in as \""+user.getUsername()+"\". You can got to <a href=\"/user\">/user</a>, got to <a href=\"/all\">/all</a> or <a href=\"/logout\">logout</a>.";
        }
        if(user.getRoles().contains(allServices.role.USER)){
            return "Logged in as \""+user.getUsername()+"\". You can got to <a href=\"/user\">/user</a> or <a href=\"/logout\">logout</a>. This will fail: <a href=\"/all\">/all</a> ";
        }
        return "You are not logged in. Please <a href=\"/login\">login</a> first.";
    }

    @GetMapping("/user")
    public User getUser(){
        return allServices.authenticatedUser.getUser();
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return allServices.user.findAll();
    }

    @GetMapping("/logoutdone")
    @ResponseBody
    public String logoutdone(){
        return "You have been logged out. You can <a href=\"/login\">login</a> again.";
    }
}
