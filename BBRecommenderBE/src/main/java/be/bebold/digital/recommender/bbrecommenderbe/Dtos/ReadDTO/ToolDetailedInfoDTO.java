package be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO;

import lombok.*;

/**
 * The ToolDetailedInfoDTO class represents ToolDetailedInfo object with information about a tool.
 * It contains all the information needed to display detailed information about a tool.
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
public class ToolDetailedInfoDTO {

    private long id;
    private String toolDescription;
    private String toolVideoUrl;
}
