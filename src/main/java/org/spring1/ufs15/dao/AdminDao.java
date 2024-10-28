package org.spring1.ufs15.dao;

import org.spring1.ufs15.model.Admin;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdminDao extends CrudRepository<Admin, Long> {
    @Query("SELECT a FROM Admin a WHERE a.email = :email AND a.password = :password")
    Admin checkCredentials(@Param("email") String email, @Param("password") String password);
}
