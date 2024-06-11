package uns.ac.rs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import uns.ac.rs.entity.Review;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ReviewRepository implements PanacheMongoRepository<Review> {

    public Optional<Review> findByIdOptional(UUID id) {
        Review found = find("_id", id).firstResult();
        return Optional.ofNullable(found);
    }

    public List<Review> findByTarget(Review.ReviewType targetType, String targetId) {
        return list("targetType = ?1 and targetId = ?2", targetType, targetId);
    }
}

