package org.spring1.ufs15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 25)
    String mail;

    @NotNull
    @Size(min = 1, max = 25)
    String password;

    public Admin() {
    }

    public Admin(Integer id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
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
}
