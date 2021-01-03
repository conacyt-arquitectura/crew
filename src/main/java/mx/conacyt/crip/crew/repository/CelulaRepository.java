package mx.conacyt.crip.crew.repository;

import mx.conacyt.crip.crew.domain.Celula;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Celula entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CelulaRepository extends MongoRepository<Celula, String> {
}
