package mx.conacyt.crip.crew.repository;

import mx.conacyt.crip.crew.domain.Avatar;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Avatar entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AvatarRepository extends MongoRepository<Avatar, String> {
}
