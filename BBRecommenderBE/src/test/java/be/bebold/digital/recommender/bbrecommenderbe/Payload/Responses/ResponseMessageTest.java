package be.bebold.digital.recommender.bbrecommenderbe.Payload.Responses;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class ResponseMessageTest {

    @Test
    void getSuccesMessageAllArgsConstructor() {
        String message = "Success";
        ResponseMessage responseMessage = new ResponseMessage(message, HttpStatus.OK, HttpStatus.OK.value());
        assertEquals(message, responseMessage.getMessage());
        
    }

    @Test
    void getErrorMessageAllArgsConstructor() {
        String message = "Error";
        ResponseMessage responseMessage = new ResponseMessage("Error", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        assertEquals(message, responseMessage.getMessage());
    }
 
    @Test
    void getOkStatusAllArgsConstructor() {
        HttpStatus status = HttpStatus.OK;
        ResponseMessage responseMessage = new ResponseMessage("Success", HttpStatus.OK, HttpStatus.OK.value());
        assertEquals(status, responseMessage.getStatus());
    }

    @Test
    void getBadRequestStatusAllArgsConstructor() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ResponseMessage responseMessage = new ResponseMessage("Error", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        assertEquals(status, responseMessage.getStatus());
    }

    @Test
    void getStatusCode200AllArgsConstructor() {
        int statusCode = 200;
        ResponseMessage responseMessage = new ResponseMessage("Success", HttpStatus.OK, HttpStatus.OK.value());
        assertEquals(statusCode, responseMessage.getStatusCode());
    }

    @Test
    void getStatusCode400AllArgsConstructor() {
        int statusCode = 400;
        ResponseMessage responseMessage = new ResponseMessage("Error", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        assertEquals(statusCode, responseMessage.getStatusCode());
    }

}