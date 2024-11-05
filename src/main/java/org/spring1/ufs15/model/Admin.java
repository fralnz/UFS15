package org.spring1.ufs15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

import java.security.MessageDigest;
import java.util.Objects;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Email(message = "La mail non e' valida: esempio@mail.it")
    String mail;

    @NotNull
    @Transient // This field is only used for validation and won't be persisted
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$",
            message = "La password deve essere composta da almeno 8 caratteri, contenere almeno una lettera maiuscola, una minuscola, un numero e un carattere speciale")
    String passwordChiara;

    String password;

    @NotNull
    @Size(min = 1, max = 25)
    String nome;

    @NotNull
    @Size(min = 1, max = 25)
    String cognome;

    public Admin() {
    }

    public Admin(String mail, String passwordChiara, String nome, String cognome) {
        this.mail = mail;
        this.passwordChiara = passwordChiara;
        this.password = getSha256String(passwordChiara);
        this.nome = nome;
        this.cognome = cognome;
    }

    public Admin(Integer id, String mail, String passwordChiara, String nome, String cognome) {
        this.id = id;
        this.mail = mail;
        this.passwordChiara = passwordChiara;
        this.password = getSha256String(passwordChiara);
        this.nome = nome;
        this.cognome = cognome;
    }

    // Getters and setters (include only plainPassword setter to hash password)
    public String getPasswordChiara() {
        return passwordChiara;
    }

    public void setPasswordChiara(String passwordChiara) {
        this.passwordChiara = passwordChiara;
        this.password = getSha256String(passwordChiara);
    }

    public String getPassword() {
        return password;
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
                ", passwordChiara='" + passwordChiara + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }

    private String getSha256String(final String base) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
