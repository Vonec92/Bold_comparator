package be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO;

import java.util.Date;

import lombok.*;

/**
 * The RecommendationDTO class represents a recommendation object.
 * It contains all the information needed to display a recommendation.
 * This class uses Lombok annotations for generating getters, setters, toString, equals, and hashCode methods.
 * @author [Baeten Jens]
 * @version 1.0
 * 
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RecommendationDTO {

    private long id;
    private String uid;
    private String creator;
    private Date date;
    private String toolName;
    private String companyName;
}
