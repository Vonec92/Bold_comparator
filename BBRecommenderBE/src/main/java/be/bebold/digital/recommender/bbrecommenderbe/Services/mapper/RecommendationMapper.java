package be.bebold.digital.recommender.bbrecommenderbe.Services.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO.DetailedRecommendationDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO.RecommendationDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Model.Recommendation;

/***
 * Mapper for that maps recommendation class to recommendationDTO class and vice versa
 * @author [Baeten Jens]
 * @version 1.0
*/

@Service
public class RecommendationMapper {

    private ModelMapper modelMapper = new ModelMapper();

    /***
     * Maps a recommendation to a recommendationDTO
     * @param recommendation the recommendation that needs to be mapped
     * @return RecommendationDTO the mapped recommendationDTO
     * @author [Baeten Jens]
     */
    public RecommendationDTO mapRecommendationToRecommendationDTO(Recommendation recommendation) {

        return modelMapper.map(recommendation, RecommendationDTO.class);
    }

    /***
     * Maps a Optional recommendation to a detailedRecommendationDTO
     * @param recommendation the recommendation that needs to be mapped
     * @return DetailedRecommendationDTO the mapped detailedRecommendationDTO
     * @author [Baeten Jens]
     */
    public DetailedRecommendationDTO mapRecommendationToDetailedRecommendationDTO(Optional<Recommendation> recommendation) {

        return modelMapper.map(recommendation, DetailedRecommendationDTO.class);
    }

    /***
     * Maps a list of recommendations to a list of recommendationDTOs
     * @param recommendations the list of recommendations that needs to be mapped
     * @return List RecommendationDTO the mapped list of recommendationDTOs
     * @author [Baeten Jens]
     */
    public List<RecommendationDTO> mapListMarketingToolToRecommendationDTO(List<Recommendation> recommendations) {

        return recommendations.stream()
                //lambda this = recommendation
                .map(this::mapRecommendationToRecommendationDTO)
                .collect(Collectors.toList());
    }

}
