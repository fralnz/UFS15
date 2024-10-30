package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.model.Admin;

import java.util.List;

@Controller
@RequestMapping("/login")
public class AdminController {

    @Autowired
    AdminDao adminRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String postLoginPage(Model model) {

        return "Login";

    }

    // faccio un metodo uguale per la richiesta POST (ricevere i dati dal DB)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postLogin(Model model) {

        return "Login";

    }

}