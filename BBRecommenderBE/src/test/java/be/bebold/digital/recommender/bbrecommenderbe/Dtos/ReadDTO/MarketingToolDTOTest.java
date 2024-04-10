package be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarketingToolDTOTest {

    @Test
    void getAndSetId() {
        MarketingToolDTO marketingToolDTO = new MarketingToolDTO();
        Long id = 1L;
        marketingToolDTO.setId(id);
        assertEquals(id, marketingToolDTO.getId());
    }

    @Test
    void getAndSetToolName() {
        MarketingToolDTO marketingToolDTO = new MarketingToolDTO();
        String toolName = "Activecampaign";
        marketingToolDTO.setToolName(toolName);
        assertEquals(toolName, marketingToolDTO.getToolName());
    }

    @Test
    void getAndSetScore() {
        MarketingToolDTO marketingToolDTO = new MarketingToolDTO();
        Double score = 5.0;
        marketingToolDTO.setScore(score);
        assertEquals(score, marketingToolDTO.getScore());
    }


    @Test
    void AllArgsConstructor(){
        MarketingToolDTO marketingToolDTO = new MarketingToolDTO(1L, "Activecampaign", 5.0);
        assertEquals(1L, marketingToolDTO.getId());
        assertEquals("Activecampaign", marketingToolDTO.getToolName());
        assertEquals(5.0, marketingToolDTO.getScore());

    }
    @Test
    void testToString() {
        MarketingToolDTO marketingToolDTO = new MarketingToolDTO(1L, "Activecampaign", 5.0);
        assertEquals("MarketingToolDTO(id=1, toolName=Activecampaign, score=5.0)", marketingToolDTO.toString());
    }


    @Test
    void testHashCodeAndEquals(){
        MarketingToolDTO dto1 = new MarketingToolDTO(1L, "Activecampaign", 5.0);

        MarketingToolDTO dto2 = new MarketingToolDTO(1L, "Activecampaign", 5.0);


        assertTrue(dto1.equals(dto2));
        assertEquals(dto1.hashCode(), dto2.hashCode());

    }

    @Test
    void testDetailedInfoIsNotEqualsOrHascode(){
        MarketingToolDTO dto1 = new MarketingToolDTO(1L, "Activecampaign", 5.0);

        MarketingToolDTO dto2 = new MarketingToolDTO(2L, "MailerLite", 2.0);

        assertFalse(dto1.equals(dto2));
        assertNotEquals(dto1.hashCode(), dto2.hashCode());
        
    }
}