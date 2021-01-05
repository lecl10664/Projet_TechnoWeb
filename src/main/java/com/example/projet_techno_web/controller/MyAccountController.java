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


@Controller
@SessionAttributes({"UserLogged"})
public class MyAccountController {

    @Autowired
    private final UserUpdateDAO userUpdateDAO;

    public MyAccountController(UserUpdateDAO userUpdateDAO) {
        this.userUpdateDAO = userUpdateDAO;
    }


    @GetMapping("/myaccount")
    public String showPage(Model model){
        model.addAttribute("newUser",new User());
        return "MyAccount";
    }

    @PostMapping("/myaccount")
    public String modifyUser(@ModelAttribute User newUser, @ModelAttribute("UserLogged") User userLogged, Model model){
        User user = new User(newUser.getId(), newUser.getlName(), newUser.getfName(), newUser.geteMail(), newUser.getPassword());

        //userUpdateDAO.updateUser(user.geteMail(),userLogged.getId());
        model.addAttribute("UserLogged",user);
        return "redirect:myaccount";
    }



}
