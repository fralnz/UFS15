package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.dao.EventoDao;
import org.spring1.ufs15.dao.TipoDao;
import org.spring1.ufs15.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    EventoDao eventiRepository;

    @Autowired
    private TipoDao tipoRepository;

    @Autowired
    AdminDao adminRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectToDashBoard() {
        return "redirect:/admin/dashboard/";
    }

    @RequestMapping(value = "/dashboard/", method = RequestMethod.GET)
    public String adminDashboard(HttpSession session, Model model) {
        Admin user = (Admin) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/login/";
        }
        model.addAttribute("user", user);
        return "Dashboard";
    }

    @RequestMapping("/utenti/")
    public String gestisciUtenti(@RequestParam(required = false) String searchTerm, Model model, HttpSession session) {
        Admin user = (Admin) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/login/";
        }
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            model.addAttribute("adminList", adminRepository.findAll());
        } else {
            model.addAttribute(adminRepository.searchByAttribute(searchTerm));
        }
        model.addAttribute("loggedUser", user);

        return "GestisciUtenti";
    }

    @RequestMapping("/utenti/eliminaUtente/{id}")
    public String eliminaUtente(@PathVariable("id") long id, HttpSession session) {
        Admin user = (Admin) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/login/";
        }
        Admin deletedUser = adminRepository.findById(id);
        System.out.println("utente loggato: " + user);
        System.out.println("utente da eliminare: " + deletedUser);
        System.out.println("sono uguali: " + deletedUser.equals(user));
        if (deletedUser.equals(user)) {
            return "ErroreUtenteLoggato";
        }
        adminRepository.deleteById(id);
        return "redirect:/admin/utenti/";
    }

    @RequestMapping("/utenti/creaAdmin/")
    public String creaAdmin(Model model, HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login/";
        }
        model.addAttribute("admin", new Admin());
        return "ModificaUtenti";
    }

    @PostMapping("/utenti/creaAdmin/")
    public String postCreaAdmin(@Valid Admin a, BindingResult bindingResult, Model model, HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login/";
        }
        Boolean v = adminRepository.findByMail(a.getMail()) != null && !adminRepository.findByMail(a.getMail()).equalsId(a);
        System.out.println(adminRepository.findByMail(a.getMail()));
        System.out.println(a);
        System.out.println(a.equalsId(adminRepository.findByMail(a.getMail())));
        if (v) {
            model.addAttribute("errorMessage", "Esiste gia' un utente con questa mail!");
            return "ModificaUtenti";
        }
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());

            model.addAttribute("admin", a);
            model.addAttribute("org.springframework.validation.BindingResult.admin", bindingResult);

            return "ModificaUtenti";
        }

        adminRepository.save(a);
        return "redirect:/admin/utenti/";
    }

    @RequestMapping("/utenti/modificaAdmin/{id}")
    public String modificaAdmin(@PathVariable("id") long id, Model model, HttpSession session) {
        Admin loggedUser = (Admin) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login/";
        }
        Admin admin = adminRepository.findById(id);
        if (loggedUser.equals(admin)) {
            return "ErroreUtenteLoggato";
        }
        model.addAttribute("admin", admin);

        return "ModificaUtenti";
    }
}
