package org.spring1.ufs15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Objects;

@Entity
//@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 25)
    String mail;

    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$",
            message = "La password deve essere composta da almeno 8 caratteri, contenere almeno una lettera maiuscola, una minuscola, un numero e un carattere speciale")
    String password;

    @NotNull
    @Size(min = 1, max = 25)
    String nome;

    @NotNull
    @Size(min = 1, max = 25)
    String cognome;

    public Admin() {
    }

    public Admin(String mail, String password, String nome, String cognome) {
        this.mail = mail;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
    }

    public Admin(Integer id, String mail, String password, String nome, String cognome) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) && Objects.equals(mail, admin.mail) && Objects.equals(password, admin.password) && Objects.equals(nome, admin.nome) && Objects.equals(cognome, admin.cognome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mail, password, nome, cognome);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
