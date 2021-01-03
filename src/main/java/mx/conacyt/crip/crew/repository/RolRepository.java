package mx.conacyt.crip.crew.repository;

import mx.conacyt.crip.crew.domain.Rol;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Rol entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RolRepository extends MongoRepository<Rol, String> {
}
