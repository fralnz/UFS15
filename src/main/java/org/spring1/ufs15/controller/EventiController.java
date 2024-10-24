package org.spring1.ufs15.controller;

import org.spring1.ufs15.dao.EventoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/evento")
public class EventiController {

    @Autowired
    private EventoDao eventoRepository;

    @RequestMapping("/")
    public ModelAndView evento() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("DettagliEvento");
        modelAndView.addObject("evento", eventoRepository.findAll());

        return modelAndView;
    }
}
