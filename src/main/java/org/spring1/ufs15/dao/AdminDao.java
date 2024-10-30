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

    @Override
    default <S extends Admin> S save(S entity) {
        return null;
    }

    @Override
    default <S extends Admin> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default Optional<Admin> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default Iterable<Admin> findAll() {
        return null;
    }

    @Override
    default Iterable<Admin> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(Admin entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends Admin> entities) {

    }

    @Override
    default void deleteAll() {

    }
}
