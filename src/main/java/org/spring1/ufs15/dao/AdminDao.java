package org.spring1.ufs15.dao;

import org.spring1.ufs15.model.Admin;
import org.spring1.ufs15.model.Evento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AdminDao extends CrudRepository<Admin, Long> {
    @Query("SELECT a FROM Admin a WHERE a.mail = :mail AND a.password = :password")
    public Admin checkCredentials(String mail, String password);

    @Query("SELECT a FROM Admin a WHERE a.mail = :mail")
    Admin findByMail(String mail);

    @Query("SELECT a FROM Admin a WHERE a.nome = :nome")
    public List<Admin> findByNome(String nome);

    @Query("SELECT a FROM Admin a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    public List<Admin> searchByNome(String nome);

    @Query("SELECT a FROM Admin a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :attribute, '%')) OR LOWER(a.cognome) LIKE LOWER(CONCAT('%', :attribute, '%')) OR LOWER(a.mail) LIKE LOWER(CONCAT('%', :attribute, '%'))")
    public List<Admin> searchByAttribute(String attribute);

    Admin findById(long id);
}
