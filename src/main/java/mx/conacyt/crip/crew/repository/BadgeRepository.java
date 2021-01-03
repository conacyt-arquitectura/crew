package mx.conacyt.crip.crew.repository;

import mx.conacyt.crip.crew.domain.Badge;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Badge entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BadgeRepository extends MongoRepository<Badge, String> {
}
