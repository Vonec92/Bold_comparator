package be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO;

import lombok.*;

/**
 * The MarketingToolDTO class represents a MarketingTool object.
 * It contains the basic information needed to display a marketing tool.
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
public class MarketingToolDTO {

    private long id;
    private String toolName;
    private double score;
}
