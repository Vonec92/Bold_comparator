package be.bebold.digital.recommender.bbrecommenderbe.Payload.Responses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecommendedToolNameResponseTest {

    @Test
    void getToolNameWithAllArgsConstructor() {
        String toolName = "ActiveCampaign";
        RecommendedToolNameResponse recommendedToolNameResponse = new RecommendedToolNameResponse(toolName);
        assertEquals(toolName, recommendedToolNameResponse.getToolName());
    }
      
}