package com.example.projet_techno_web.controller;

import com.example.projet_techno_web.data.ChatDAO;
import com.example.projet_techno_web.data.UserDAO;
import com.example.projet_techno_web.model.Chat;
import com.example.projet_techno_web.model.Message;
import com.example.projet_techno_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"UserLogged"})


public class ChatController {

    @Autowired
    private final ChatDAO chatDAO;
    private final UserDAO userDAO;


    public ChatController(ChatDAO chatDAO, UserDAO userDAO) {this.chatDAO =chatDAO; this.userDAO=userDAO;}




    @GetMapping("/chat/{idR}")
    public String showPage(@PathVariable Long idR, @ModelAttribute("UserLogged") User userLogged, Model model) {

        Optional<User> listUser = userDAO.findById(idR);
        User checkUser = listUser.get();
        model.addAttribute("UserChat", checkUser);


        if (userLogged.getId() < idR) {
            List<Chat> listChat = chatDAO.findByIDs(userLogged.getId(), idR);
            Chat chat = listChat.get(0);
            List<Message> listMsg = chat.getMessages();
            model.addAttribute("listMsg",listMsg);
        } else if (userLogged.getId() > idR) {
            List<Chat> listChat = chatDAO.findByIDs(idR, userLogged.getId());
            Chat chat = listChat.get(0);
            List<Message> listMsg = chat.getMessages();
            model.addAttribute("listMsg",listMsg);
        }


        model.addAttribute("newMsg",new Message());

        return "Chat";
    }


    @PostMapping("/toChat")
    public String redirectToChat(@ModelAttribute("newUser") User newUser, Model model){
        long dir = newUser.getId();
        return "redirect:chat/"+dir;
    }




    @PostMapping("/chat")
    public String addMessage(@ModelAttribute("UserLogged") User userLogged, @ModelAttribute("newMsg") Message msg, Model model){


        if (userLogged.getId() < msg.getIdUser()) {
            List<Chat> listChat = chatDAO.findByIDs(userLogged.getId(), msg.getIdUser());
            Chat chat = listChat.get(0);
            chat.getMessages().add(msg);
            chatDAO.save(chat);
        } else if (userLogged.getId() > msg.getIdUser()){
            List<Chat> listChat = chatDAO.findByIDs(msg.getIdUser(), userLogged.getId());
            Chat chat = listChat.get(0);
            chat.getMessages().add(msg);
            chatDAO.save(chat);
        }

        return "redirect:chat/"+msg.getIdUser();
    }

}
