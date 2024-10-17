package it.itsrizzoli.ScuolaForm;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;


public class Persona {
    @NotNull
    @Size(min = 3, max = 20)
    String titolo;

    @Min(0)
    @Max(30)
    Integer id_tipo;

    @Min(0)
    Integer id_stanza;

    @NotNull
    @Size(min = 3, max = 500)
    String descrizione;

    @NotNull
    @Size(min = 3, max = 20)
    String organizzatore;

    @NotNull
    Date data_inizio;

    @NotNull
    Date data_fine;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Integer id_tipo) {
        this.id_tipo = id_tipo;
    }

    public Integer getId_stanza() {
        return id_stanza;
    }

    public void setId_stanza(Integer id_stanza) {
        this.id_stanza = id_stanza;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getOrganizzatore() {
        return organizzatore;
    }

    public void setOrganizzatore(String organizzatore) {
        this.organizzatore = organizzatore;
    }

    public Date getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(Date data_inizio) {
        this.data_inizio = data_inizio;
    }

    public Date getData_fine() {
        return data_fine;
    }

    public void setData_fine(Date data_fine) {
        this.data_fine = data_fine;
    }
}
