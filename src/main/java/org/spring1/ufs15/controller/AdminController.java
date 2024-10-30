package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import org.spring1.ufs15.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    AdminDao adminRepository;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String adminDashboard(HttpSession session) {
        return "Dashboard";
    }
}
