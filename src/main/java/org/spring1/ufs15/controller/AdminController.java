package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.model.Admin;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminDao adminRepository;

    @RequestMapping("/login")
    public String login() {
        return "/login/login";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String postLogin(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            HttpSession session) {

        Admin admin = adminRepository.checkCredentials(email, password);

        if (admin == null) {
            return "redirect:/admin/login";
        } else {
            session.setAttribute("loggedUser", admin);
            return "redirect:/";
        }
    }

}