package be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Date;

class RecommendationDTOTest {

    @Test
    void getAndSetId() {
        RecommendationDTO recommendationDTO = new RecommendationDTO();
        Long id = 1L;
        recommendationDTO.setId(id);
        assertEquals(id, recommendationDTO.getId());
    }

    @Test
    void getAndSetUid() {
        RecommendationDTO recommendationDTO = new RecommendationDTO();
        String uid = "2954baf6-db43-4828-a82d-8c3f71515bff";
        recommendationDTO.setUid(uid);
        assertEquals(uid, recommendationDTO.getUid());
    }

    @Test
    void getAndSetCreator() {
        RecommendationDTO recommendationDTO = new RecommendationDTO();
        String creator = "Rudy De Bolder";
        recommendationDTO.setCreator(creator);
        assertEquals(creator, recommendationDTO.getCreator());
    }

    @Test
    void getAndSetDate() {
        RecommendationDTO recommendationDTO = new RecommendationDTO();
        Date date = Date.valueOf("2020-12-12");
        recommendationDTO.setDate(date);
        assertEquals(date, recommendationDTO.getDate());
    }

    @Test
    void getAndSetToolName() {
        RecommendationDTO recommendationDTO = new RecommendationDTO();
        String toolName = "Activecampaign";
        recommendationDTO.setToolName(toolName);
        assertEquals(toolName, recommendationDTO.getToolName());
    }

    @Test
    void getAndSetCompanyName() {
        RecommendationDTO recommendationDTO = new RecommendationDTO();
        String companyName = "BeBold";
        recommendationDTO.setCompanyName(companyName);
        assertEquals(companyName, recommendationDTO.getCompanyName());
    }

    @Test
    void testToString() {
        Date date = Date.valueOf("2020-12-12");
        RecommendationDTO recommendationDTO = new RecommendationDTO(1L, "2954baf6-db43-4828-a82d-8c3f71515bff", "Rudy De Bolder", date ,"Activecampaign", "BeBold");

        String expected = "RecommendationDTO(id=1, uid=2954baf6-db43-4828-a82d-8c3f71515bff, creator=Rudy De Bolder, date=2020-12-12, toolName=Activecampaign, companyName=BeBold)";
        assertEquals(expected, recommendationDTO.toString());
    }

    @Test
    void testHashCodeAndEquals(){
        Date date = Date.valueOf("2020-12-12");
        RecommendationDTO dto1 = new RecommendationDTO(1L, "2954baf6-db43-4828-a82d-8c3f71515bff", "Rudy De Bolder", date ,"Activecampaign", "BeBold");
        RecommendationDTO dto2 = new RecommendationDTO(1L, "2954baf6-db43-4828-a82d-8c3f71515bff", "Rudy De Bolder", date ,"Activecampaign", "BeBold");

        assertTrue(dto1.equals(dto2));
        assertEquals(dto1.hashCode(), dto2.hashCode());

    }

    @Test
    void testDetailedInfoIsNotEqualsOrHascode(){
        Date date = Date.valueOf("2020-12-12");
        RecommendationDTO dto1 = new RecommendationDTO(1L, "2954baf6-db43-4828-a82d-8c3f71515bff", "Rudy De Bolder", date ,"Activecampaign", "BeBold");
        
        Date date2 = Date.valueOf("2022-10-10");
        RecommendationDTO dto2 = new RecommendationDTO(2L, "28f2ea89-daed-474d-91fd-9b4dd5deb229", "Boris De Bolder", date2 ,"MailerLite", "Tesla");


        assertFalse(dto1.equals(dto2));
        assertNotEquals(dto1.hashCode(), dto2.hashCode());
        
    }
}