package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.spring1.ufs15.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.model.Admin;

import java.util.List;

@Controller
@RequestMapping("/login/")
public class AdminController {

    @Autowired
    AdminDao adminRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String postLoginPage(Model model) {
        model.addAttribute("admin", new Admin());
        return "Login";
    }

    // faccio un metodo uguale per la richiesta POST (ricevere i dati dal DB)
    @PostMapping(value = "/")
    public String postLogin(@Valid Admin admin, BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "Login";
        }

        Admin user = adminRepository.checkCredentials(admin.getMail(), admin.getPassword());
        System.out.println("admin: " + admin);
        System.out.println("admin loggato: " + user);

        if (user == null) {
            return "redirect:/login/";
        } else {
            session.setAttribute("loggedUser", user);
            return "redirect:/eventi/";
        }

    }

}