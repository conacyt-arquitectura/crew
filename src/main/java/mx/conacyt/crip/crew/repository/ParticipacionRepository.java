package mx.conacyt.crip.crew.repository;

import mx.conacyt.crip.crew.domain.Participacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Participacion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ParticipacionRepository extends MongoRepository<Participacion, String> {
    @Query("{'celula.$id': ObjectId(?0)}")
    Page<Participacion> findAllByCelula(String id, Pageable pagable);
}
