package fw.ratingservice.controller;

import fw.ratingservice.model.Rating;
import fw.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping(path = "ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("influencer/{influencerId}")
    public List<Rating> getInfluencerRatings(@PathVariable Long influencerId) {
       return ratingService.getInfluencerRatings(influencerId);
    }

    @GetMapping("brand/{brandId}")
    public List<Rating> getBrandRatings(@PathVariable Long brandId) {
        return ratingService.getBrandRatings(brandId);
    }

    @GetMapping("influencer/{influencerId}/average")
    public Float getInfluencerAverageRating(@PathVariable Long influencerId) {
        return ratingService.getInfluencerAverageRating(influencerId);
    }

    @PostMapping
    public void addRating(@RequestBody Rating rating) {
        ratingService.addRating(rating);
    }

}
