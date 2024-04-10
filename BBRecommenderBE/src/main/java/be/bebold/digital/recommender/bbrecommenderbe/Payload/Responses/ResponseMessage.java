package be.bebold.digital.recommender.bbrecommenderbe.Payload.Responses;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;


/***
 * payload that is send back after every request to show what the response is.
 * @author [Baeten Jens]
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public class ResponseMessage {
    
    private String message;

    private HttpStatus status;

    private int statusCode;
}

 
