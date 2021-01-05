package com.example.projet_techno_web.controller;

import com.example.projet_techno_web.data.ChatDAO;
import com.example.projet_techno_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"UserLogged"})
public class ChatController {

    @Autowired
    private final ChatDAO chatDAO;

    public ChatController(ChatDAO chatDAO) {this.chatDAO =chatDAO;}

    @GetMapping("/chat/{idR}")
    public String showPage(@PathVariable Long idR, @ModelAttribute("UserLogged") User userLogged, Model model){
        Long idS = userLogged.getId();


        return ;
    }


    @PostMapping("/chat")
    public String redirectToChat(@ModelAttribute User newUser){
        User user = new User(newUser.getId(), newUser.getlName(), newUser.getfName(), newUser.geteMail(), newUser.getPassword());
        Long idR = user.getId() +1;
        return "redirect:user/"+idR;
    }

}
