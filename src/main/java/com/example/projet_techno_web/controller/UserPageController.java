package com.example.projet_techno_web.controller;

import com.example.projet_techno_web.data.UserDAO;
import com.example.projet_techno_web.model.Chat;
import com.example.projet_techno_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"UserLogged"})
public class UserPageController {

    @Autowired
    private final UserDAO userDAO;

    public UserPageController(UserDAO userDAO) {this.userDAO = userDAO;}


    @GetMapping("/user/{id}")
    public String showPage(Model model, @PathVariable Long id){

        model.addAttribute("newUser", new User());

        Optional<User> listUser = userDAO.findById(id);
        User checkUser = listUser.get();
        model.addAttribute("user", checkUser);


        return "User";
    }



    @PostMapping("/user")
    public String redirectUserPage(@ModelAttribute User newUser){
        User user = new User(newUser.getId(), newUser.getlName(), newUser.getfName(), newUser.geteMail(), newUser.getPassword());
        Long idUser = user.getId();
        return "redirect:user/"+idUser;
    }
}
