package org.spring1.ufs15.dao;

import org.spring1.ufs15.model.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AdminDao extends CrudRepository<Admin, Long> {
    @Query("SELECT a FROM Admin a WHERE a.mail = :mail AND a.password = :password")
    public Admin checkCredentials(String mail, String password);
}
