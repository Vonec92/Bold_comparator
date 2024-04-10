package be.bebold.digital.recommender.bbrecommenderbe.Controllers;

import be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO.DetailedRecommendationDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Model.Recommendation;
import be.bebold.digital.recommender.bbrecommenderbe.Repositories.RecommendationRepository;
import be.bebold.digital.recommender.bbrecommenderbe.Services.mapper.RecommendationMapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling requests related to detailed recommendations.
 * @author Baeten Jens
 * @version 1.0
 */
@RestController
public class DetailController {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private RecommendationMapper recommendationMapper;

    /**
     * Retrieves a detailed recommendation with the specified ID from the database.
     *
     * @param id the ID of the recommendation to retrieve
     * @return a {@link DetailedRecommendationDTO} object representing the detailed
     *         recommendation,
     *         or null if no recommendation with the specified ID exists
     */

    @GetMapping("/detail/{id}")
    public DetailedRecommendationDTO getDetailedRecommendationById(@PathVariable("id") Long id) {

        Optional<Recommendation> recommendation = recommendationRepository.findById(id);

        if (recommendation.isPresent()) {
            return recommendationMapper.mapRecommendationToDetailedRecommendationDTO(recommendation);
        }

        return null;

    }
}
