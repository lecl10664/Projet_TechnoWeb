package com.example.projet_techno_web.controller;

import com.example.projet_techno_web.data.LogementDAO;
import com.example.projet_techno_web.data.OccupationLogementDAO;
import com.example.projet_techno_web.model.Logement;
import com.example.projet_techno_web.model.OccupationLogement;
import com.example.projet_techno_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("UserLogged")
public class Reservation {

    @Autowired
    private final LogementDAO logementDAO;
    private final OccupationLogementDAO occupationLogementDAO;

    public Reservation (LogementDAO logementDAO, OccupationLogementDAO occupationLogementDAO){
        this.logementDAO = logementDAO;
        this.occupationLogementDAO = occupationLogementDAO;
    }


    @GetMapping("reservation/{idL}")
    public String showPage(@PathVariable Long idL, Model model){
        List<OccupationLogement> listOL = occupationLogementDAO.findByIDL(idL);
        OccupationLogement OL = listOL.get(listOL.size()-1);

        model.addAttribute("OL",OL);
        model.addAttribute("newOL", new OccupationLogement());

        return "Reservation";
    }


    @PostMapping("toReservation")
    public String redirectToReservation(@ModelAttribute("logement")Logement logement){
        long dir = logement.getId();
        return "redirect:reservation/"+dir;
    }




    @PostMapping("addReservation")
    public String ajoutReservation(@ModelAttribute("newOL") OccupationLogement newOL){
        long dir = newOL.getIdLogement();

        List<OccupationLogement> listOL = occupationLogementDAO.findByIDL(dir);
        OccupationLogement OL = listOL.get(listOL.size()-1);

        OccupationLogement finalOL = new OccupationLogement(OL.getIdOwner(), OL.getIdMembre(), OL.getIdLogement(), newOL.getDateA(), newOL.getDateD(),1);
        occupationLogementDAO.save(finalOL);

        return "redirect:reservation/"+dir;
    }




    @PostMapping("reservationOK")
    public String reservationOK(@ModelAttribute("UserLogged") User userLogged, @ModelAttribute("newOL") OccupationLogement newOL) {
        long dir = newOL.getIdLogement();

        List<OccupationLogement> listOL = occupationLogementDAO.findByIDL(dir);
        OccupationLogement OL = listOL.get(listOL.size() - 1);

        OccupationLogement finalOL = new OccupationLogement(OL.getIdOwner(), userLogged.getId(), OL.getIdLogement(), OL.getDateA(), OL.getDateD(), 2);
        occupationLogementDAO.save(finalOL);


        return "redirect:reservation/"+dir;
    }



    @PostMapping("reservationFini")
    public String reservationFini(@ModelAttribute("newOL") OccupationLogement newOL){
        long dir = newOL.getIdLogement();

        List<OccupationLogement> listOL = occupationLogementDAO.findByIDL(dir);
        OccupationLogement OL = listOL.get(listOL.size()-1);

        OccupationLogement finalOL = new OccupationLogement(OL.getIdOwner(), OL.getIdMembre(), OL.getIdLogement(), OL.getDateA(), OL.getDateD(), 0);
        occupationLogementDAO.save(finalOL);

        return "redirect:reservation/"+dir;
    }





}
