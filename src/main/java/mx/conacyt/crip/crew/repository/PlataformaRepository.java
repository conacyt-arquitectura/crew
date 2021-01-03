package mx.conacyt.crip.crew.repository;

import mx.conacyt.crip.crew.domain.Plataforma;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Plataforma entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PlataformaRepository extends MongoRepository<Plataforma, String> {
}
