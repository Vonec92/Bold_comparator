package be.bebold.digital.recommender.bbrecommenderbe.Controllers;

import java.util.List;

import be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO.RecommendationDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Model.Recommendation;
import be.bebold.digital.recommender.bbrecommenderbe.Repositories.RecommendationRepository;
import be.bebold.digital.recommender.bbrecommenderbe.Services.mapper.RecommendationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * The OverviewController class is responsible for handling HTTP requests
 * related to Recommendations.
 * @author Baeten Jens
 * @version 1.0
 */
@RestController
public class OverviewController {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private RecommendationMapper recommendationMapper;

    /**
     * Returns a list of RecommendationDTO objects for the user with the given UID.
     * 
     * @param uid the UID of the user whose recommendations are being retrieved.
     * @return a list of {@link RecommendationDTO} objects for the user with the
     *         given UID.
     */
    @GetMapping("/personal/{uid}")
    public List<RecommendationDTO> getRecommendationsForCurrentUser(@PathVariable("uid") String uid) {

        List<Recommendation> recommendations = recommendationRepository.findByUid(uid);
        return recommendationMapper.mapListMarketingToolToRecommendationDTO(recommendations);

    }

    /**
     * 
     * Returns a list of all RecommendationDTO objects.
     * 
     * @return a list of all {@link RecommendationDTO} objects.
     */
    @GetMapping("/all")
    public List<RecommendationDTO> getAllRecommendations() {

        List<Recommendation> recommendations = recommendationRepository.findAll();
        return recommendationMapper.mapListMarketingToolToRecommendationDTO(recommendations);

    }

}
