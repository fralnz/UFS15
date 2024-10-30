package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.model.Admin;

import java.util.List;

@Controller
@RequestMapping("/login")
public class AdminController {

    @Autowired
    AdminDao adminRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postLogin(@RequestParam("mail") String mail,
                            @RequestParam("password") String password,
                            HttpSession session) {

        Admin admin = adminRepository.checkCredentials(mail, password);

        if (admin == null) {
            return "redirect:/eventi/"; //errore
        } else {
            session.setAttribute("loggedUser", admin);
            return "redirect:/"; //todo: pagina post login
        }
    }

}