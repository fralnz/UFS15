package org.spring1.ufs15.config;

import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.dao.EventoDao;
import org.spring1.ufs15.dao.TipoDao;
import org.spring1.ufs15.model.Admin;
import org.spring1.ufs15.model.Evento;
import org.spring1.ufs15.model.Tipo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class Config {

    @Bean
    CommandLineRunner adminStarter(AdminDao adminRepo) {
        return args -> {
            adminRepo.save(new Admin("pippo@pera.it", "SafePass@8", "Pippo", "Pera"));
            adminRepo.save(new Admin("francesco@lanza.it", "SafePass@8", "Francesco", "Lanza"));
            adminRepo.save(new Admin("giulia@banica.it", "SafePass@8", "Giulia", "Banica"));
            adminRepo.save(new Admin("jacopo@grassi.it", "SafePass@8", "Jacopo", "Grassi"));
            adminRepo.save(new Admin("dario@chin.it", "SafePass@8", "Dario", "Chin"));
            adminRepo.save(new Admin("francesco@mazzi.it", "SafePass@8", "Francesco", "Mazzi"));
            adminRepo.save(new Admin("federico@giacomantonio.it", "SafePass@8", "Federico", "Giacomantonio"));
        };
    }

    @Bean
    CommandLineRunner dataStarter(EventoDao eventiRepo, TipoDao tipiRepo) {
        return args -> {

            // TIPI
            Tipo tipoMostra = new Tipo("Mostra d'Arte");
            Tipo tipoEvento = new Tipo("Evento Sociale");
            tipiRepo.save(tipoMostra);
            tipiRepo.save(tipoEvento);

            // MOSTRE
            eventiRepo.save(new Evento(
                    "Van Gogh",
                    "Mostra assurda",
                    "Amsterdam",
                    LocalDateTime.of(2024, 1, 8, 14, 45),
                    LocalDateTime.of(2024, 2, 12, 18, 30),
                    104,
                    8,
                    2,
                    tipoMostra,
                    "https://i.etsystatic.com/39443269/r/il/7df356/4980122961/il_fullxfull.4980122961_dgl4.jpg"
            ));

            eventiRepo.save(new Evento(
                    "Picasso",
                    "Esposizione unica",
                    "Madrid",
                    LocalDateTime.of(2024, 3, 15, 10, 15),
                    LocalDateTime.of(2024, 4, 30, 20, 45),
                    105,
                    9,
                    3,
                    tipoMostra,
                    "https://www.itagnol.com/wp-content/uploads/2017/06/guernica-picasso.jpg"
            ));

            eventiRepo.save(new Evento(
                    "Monet",
                    "Impressionismo",
                    "Paris",
                    LocalDateTime.of(2024, 6, 1, 12, 0),
                    LocalDateTime.of(2024, 7, 31, 16, 30),
                    106,
                    10,
                    4,
                    tipoMostra ,
                    "https://www.storicang.it/medio/2021/11/11/claude-monet-bain-a-la-grenouillere-1869-metropolitan-museum-of-art-new-york_bf22f32f_1200x630.jpg"
            ));

            eventiRepo.save(new Evento(
                    "Da Vinci",
                    "Rinascimento",
                    "Firenze",
                    LocalDateTime.of(2024, 9, 1, 15, 45),
                    LocalDateTime.of(2024, 10, 31, 21, 0),
                    107,
                    11,
                    5,
                    tipoMostra,
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/800px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg"
            ));

            eventiRepo.save(new Evento(
                    "Michelangelo",
                    "Capolavori",
                    "Roma",
                    LocalDateTime.of(2024, 1, 8, 9, 30),
                    LocalDateTime.of(2024, 2, 12, 13, 15),
                    108,
                    12,
                    6,
                    tipoMostra,
                    "https://www.storicang.it/medio/2020/06/25/la-creazione-di-adamo-dettaglio-della-cappella-sistina_884eb509_800x372.jpg"

            ));

            // EVENTI
            eventiRepo.save(new Evento(
                    "Conferenza sull'ambiente",
                    "Tutti ambientalisti quando si parla delle cose degli altri",
                    "Francesco Mazzi",
                    LocalDateTime.of(2024, 1, 8, 9, 30),
                    LocalDateTime.of(2024, 2, 12, 13, 15),
                    108,
                    12,
                    6,
                    tipoEvento,
                    "https://www.missionescienza.it/wp-content/uploads/2021/05/ambiente.jpg"
            ));
        };
    }
}
