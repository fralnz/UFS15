package org.spring1.ufs15.config;

import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.model.Admin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(AdminDao adminRepo) {
        return args -> {
            adminRepo.save(new Admin(1, "pippo@pera.it", "puppa", "Pippo", "Pera"));
        };
    }
}
