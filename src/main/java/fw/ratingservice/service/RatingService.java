package fw.ratingservice.service;

import fw.ratingservice.model.Rating;
import fw.ratingservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }


    public List<Rating> getInfluencerRatings(Long influencerId) {
        return ratingRepository.findRatingByInfluencerId(influencerId);
    }

    public List<Rating> getBrandRatings(Long brandId) {
        return ratingRepository.findRatingByBrandId(brandId);
    }

    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }

    public Float getInfluencerAverageRating(Long influencerId) {
        return ratingRepository.findAverageRatingByInfluencerId(influencerId);
    }
}
