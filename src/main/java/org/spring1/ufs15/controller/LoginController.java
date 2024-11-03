package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.model.Admin;

@Controller
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    AdminDao adminRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String postLoginPage(Model model, HttpSession session) {
        if (session.getAttribute("loggedUser") != null) {
            return "redirect:/admin/dashboard/";
        }
        model.addAttribute("admin", new Admin());
        return "Login";
    }

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
            return "redirect:/admin/dashboard/";
        }
    }

    @RequestMapping(value = "/logout/")
    public String postLogout(HttpSession session) {
        Admin user = (Admin) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/login/";
        }
        session.removeAttribute("loggedUser");
        return "redirect:/";

    }

}