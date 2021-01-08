package com.example.projet_techno_web.controller;

import com.example.projet_techno_web.data.ChatDAO;
import com.example.projet_techno_web.data.UserDAO;
import com.example.projet_techno_web.model.Chat;
import com.example.projet_techno_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes({"UserLogged"})

public class ChatController {

    @Autowired
    private final ChatDAO chatDAO;
    private final UserDAO userDAO;

    public ChatController(ChatDAO chatDAO, UserDAO userDAO) {this.chatDAO =chatDAO; this.userDAO=userDAO;}

    @GetMapping("/chat/{idR}")
    public String showPage(@PathVariable Long idR, @ModelAttribute("UserLogged") User userLogged, Model model){


        Long idS = userLogged.getId() ;

        Optional<User> listUser = userDAO.findById(idR);
        User contact = listUser.get();
        model.addAttribute("user", contact);



        model.addAttribute("chatEnvoye", chatDAO.findByIdS(1,idS));
        model.addAttribute("chatRecu", chatDAO.findByIdR(idR,1));

        model.addAttribute("newChat", new Chat());
        return "Chat";
    }


    @PostMapping("/chat")
    public String redirectToChat(@ModelAttribute("UserLogged") User userlogged,@ModelAttribute Chat newChat){
        //User user = new User(newUser.getId(), newUser.getlName(), newUser.getfName(), newUser.geteMail(), newUser.getPassword());


        Long idS = userlogged.getId();


        Chat chat = new Chat(newChat.getId(), newChat.getText(), idS, idS);
        chatDAO.save(chat);

        return "redirect:chat/"+idS;
    }

}
