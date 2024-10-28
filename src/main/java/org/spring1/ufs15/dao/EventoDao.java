package org.spring1.ufs15.dao;

import org.spring1.ufs15.model.Evento;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EventoDao extends CrudRepository<Evento, Long> {

    default <S extends Evento> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    default Optional<Evento> findById(Long aLong) {
        return Optional.empty();
    }

    default boolean existsById(Long aLong) {
        return false;
    }

    default Iterable<Evento> findAll() {
        return null;
    }

    default Iterable<Evento> findAllById(Iterable<Long> longs) {
        return null;
    }

    default long count() {
        return 0;
    }

    default void deleteById(Long aLong) {

    }

    default void delete(Evento entity) {

    }

    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    default void deleteAll(Iterable<? extends Evento> entities) {

    }

    default void deleteAll() {

    }

    List<Evento> findByTitolo(String titolo);

    List<Evento> findByOrganizzatore(String organizzatore);

    List<Evento> findByIdTipo(int idTipo);

    List<Evento> findByDescrizione(String descrizione);

    List<Evento> findByDataInizio(Date dataInizio);

    List<Evento> findByDataFine(Date dataFine);

    List<Evento> findByEtaMinima(int etaMinima);

    List<Evento> findByLimitePersone(int limitePersone);

    List<Evento> findByIdStanza(int idStanza);

    Evento findById(long id);

/*    @Query("SELECT a FROM Evento a WHERE a.id = :id")
    Evento checkInfo(@Param("titolo") String titolo, @Param("organizzatore") String organizzatore, @Param("descrizione") String descrizione, @Param("dataInizio") Date dataInizio, @Param("dataFine") Date dataFine);
*/
}
