package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(value = "/")
    public String homeRedirect() {
        return "PaginaMuseo";
    }
}
