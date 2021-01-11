package com.example.projet_techno_web.controller;


import com.example.projet_techno_web.data.LogementDAO;
import com.example.projet_techno_web.data.UserDAO;
import com.example.projet_techno_web.data.UserUpdateDAO;
import com.example.projet_techno_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@SessionAttributes({"UserLogged"})
public class MyAccountController {

    @Autowired
    private final UserUpdateDAO userUpdateDAO;

    @Autowired
    private final UserDAO userDAO;

    public MyAccountController(UserUpdateDAO userUpdateDAO, UserDAO userDAO) {
        this.userUpdateDAO = userUpdateDAO;
        this.userDAO = userDAO;
    }


    @GetMapping("/myaccount")
    public String showPage(Model model){
        model.addAttribute("newUser",new User());
        return "MyAccount";
    }

    @PostMapping("/myaccount")
    public String modifyUser(@ModelAttribute("UserLogged") User userLogged, @ModelAttribute("newUser") User newUser, Model model){
        User user = new User(newUser.getId(), newUser.getlName(), newUser.getfName(), newUser.geteMail(), newUser.getPassword());

        Optional<User> listUser = userDAO.findById(userLogged.getId());
        User checkUser = listUser.get();


        if (checkUser.geteMail() != user.geteMail()){
            userUpdateDAO.updateUserMail(user.geteMail(),userLogged.getId());
        }
        if(checkUser.getPassword() != user.getPassword()){
            userUpdateDAO.updateUserPW(user.getPassword(), userLogged.getId());
        }
        if(checkUser.getlName() != user.getlName()){
            userUpdateDAO.updateUserLName(user.getlName(), userLogged.getId());
        }
        if(checkUser.getfName() != user.getfName()){
            userUpdateDAO.updateUserFName(user.getfName(), userLogged.getId());
        }

        //model.addAttribute("UserLogged",user);
        return "redirect:myaccount";
    }



}
