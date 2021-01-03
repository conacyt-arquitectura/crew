package mx.conacyt.crip.crew.repository;

import mx.conacyt.crip.crew.domain.Area;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Area entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AreaRepository extends MongoRepository<Area, String> {
}
