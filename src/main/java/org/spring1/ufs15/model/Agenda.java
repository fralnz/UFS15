package org.spring1.ufs15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "Agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 0)
    Integer idEvento;

    @NotNull
    @Size(min = 0)
    Integer idTipo;

    public Agenda(Integer id, Integer idEvento, Integer idTipo) {
        this.id = id;
        this.idEvento = idEvento;
        this.idTipo = idTipo;
    }

    public Agenda() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }
}
