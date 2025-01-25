package com.jatin.inventorymanagmentsystem.services;


import com.jatin.inventorymanagmentsystem.models.User;

import java.util.List;

public class UserService {
    List<User> userList;

    public void addUser(User user){
        userList.add(user);
    }
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
