package be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO;

import be.bebold.digital.recommender.bbrecommenderbe.Model.FilterOptions;
import lombok.*;

/**
 * 
 * The DetailedRecommendationDTO class represents a detailed recommendation.
 * It contains all the information needed to display a detailed recommendation.
 * This class uses Lombok annotations for generating getters, setters, toString, equals, and hashCode methods.
 * 
 * @author [Baeten Jens]
 * @version 1.0
 * @see ToolDetailedInfoDTO
 * @see FilterOptions
 * 
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DetailedRecommendationDTO {

    private long id;
    private String toolName;
    private String companyName;
    private FilterOptions filterOptions;
    private ToolDetailedInfoDTO toolInfo;
}
