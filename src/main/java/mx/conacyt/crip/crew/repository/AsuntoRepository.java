package mx.conacyt.crip.crew.repository;

import java.util.List;
import mx.conacyt.crip.crew.domain.Asunto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Asunto entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AsuntoRepository extends MongoRepository<Asunto, String> {
    @Query(value = "{'nombre': {$regex : ?0, $options: 'i'}}")
    List<Asunto> findByQuery(String regexp);
}
