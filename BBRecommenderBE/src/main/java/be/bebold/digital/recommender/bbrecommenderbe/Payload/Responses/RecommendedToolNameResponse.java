package be.bebold.digital.recommender.bbrecommenderbe.Payload.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;


/***
 * payload that is send back after every calculation
 * @author [Baeten Jens]
 * @version 1.0
 */
@AllArgsConstructor
@Getter
public class RecommendedToolNameResponse {

    private String toolName;
    
}
