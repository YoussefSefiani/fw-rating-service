package fw.ratingservice.repository;

import fw.ratingservice.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findRatingByInfluencerId(Long influencerId);
    List<Rating> findRatingByBrandId(Long brandId);

    @Query(nativeQuery = true, value = "SELECT AVG(r.amount) FROM Rating r WHERE r.influencer_id = ?1")
    Float findAverageRatingByInfluencerId(Long influencerId);

}
