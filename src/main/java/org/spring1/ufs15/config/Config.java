package org.spring1.ufs15.config;

import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.dao.EventoDao;
import org.spring1.ufs15.model.Admin;
import org.spring1.ufs15.model.Evento;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    CommandLineRunner adminStarter(AdminDao adminRepo) {
        return args -> {
            adminRepo.save(new Admin(1, "pippo@pera.it", "puppa", "Pippo", "Pera"));
        };
    }

    @Bean
    CommandLineRunner eventiStarter(EventoDao eventiRepo) {
        return args -> {
            eventiRepo.save(new Evento(1, "Van Gogh", "Mostra assurda", "Amsterdam", null, null, 104, 8, 2, 1));
        };
    }
}
