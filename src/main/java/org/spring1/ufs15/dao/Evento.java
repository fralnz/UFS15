package org.spring1.ufs15.model;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "Eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min=4, max=25)
    String nome;

    @NotNull
    @Size(min=1)
    String descrizione;

    @NotNull
    @Size(min=1, max=25)
    String organizzatore;

    @NotNull
    Date dataInizio;

    @NotNull
    Date dataFine;

    @NotNull
    Integer idStanza;

    public Evento() {
    }
}
