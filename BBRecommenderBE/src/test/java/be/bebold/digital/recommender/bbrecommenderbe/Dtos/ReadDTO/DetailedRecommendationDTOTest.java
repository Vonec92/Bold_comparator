package be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO;

import org.junit.jupiter.api.Test;

import be.bebold.digital.recommender.bbrecommenderbe.Model.FilterOptions;

import static org.junit.jupiter.api.Assertions.*;

class DetailedRecommendationDTOTest {

    @Test
    void getId() {
        DetailedRecommendationDTO detailedRecommendationDTO = new DetailedRecommendationDTO();
        Long id = 1L;
        detailedRecommendationDTO.setId(id);
        assertEquals(id, detailedRecommendationDTO.getId());
    }

    @Test
    void getToolName() {
        DetailedRecommendationDTO detailedRecommendationDTO = new DetailedRecommendationDTO();
        String toolName = "Activecampaign";
        detailedRecommendationDTO.setToolName(toolName);
        assertEquals(toolName, detailedRecommendationDTO.getToolName());
    }

    @Test
    void getCompanyName() {
        DetailedRecommendationDTO detailedRecommendationDTO = new DetailedRecommendationDTO();
        String companyName = "BeBold";
        detailedRecommendationDTO.setCompanyName(companyName);
        assertEquals(companyName, detailedRecommendationDTO.getCompanyName());
    }

    @Test
    void getFilterOptions() {
        DetailedRecommendationDTO detailedRecommendationDTO = new DetailedRecommendationDTO();

        String[] features = { "Email Marketing", "Marketing Automation" };
        FilterOptions filterOptions = new FilterOptions(1L,200,true,100,1000, features,"Low","High","Point & click","in House");

        detailedRecommendationDTO.setFilterOptions(filterOptions);
        assertEquals(filterOptions, detailedRecommendationDTO.getFilterOptions());
    }

    @Test
    void getToolInfo() {
        DetailedRecommendationDTO detailedRecommendationDTO = new DetailedRecommendationDTO();
        ToolDetailedInfoDTO toolInfo = new ToolDetailedInfoDTO(1L, "Marketing Automation Tool", "https://youtube.com/watch/v1");
        detailedRecommendationDTO.setToolInfo(toolInfo);
        assertEquals(toolInfo, detailedRecommendationDTO.getToolInfo());
    }

    @Test
    void AllArgsConstructor(){
        String[] features = { "Email Marketing", "Marketing Automation" };
        FilterOptions filterOptions = new FilterOptions(1L,200,true,100,1000, features,"Low","High","Point & click","in House");

        ToolDetailedInfoDTO toolInfo = new ToolDetailedInfoDTO(1L, "Marketing Automation Tool", "https://youtube.com/watch/v1");
        DetailedRecommendationDTO detailedRecommendationDTO = new DetailedRecommendationDTO(1L, "Activecampaign", "BeBold", filterOptions, toolInfo);


        assertEquals(1L, detailedRecommendationDTO.getId());
        assertEquals("Activecampaign", detailedRecommendationDTO.getToolName());
        assertEquals("BeBold", detailedRecommendationDTO.getCompanyName());
        assertEquals(filterOptions, detailedRecommendationDTO.getFilterOptions());
        assertEquals(toolInfo, detailedRecommendationDTO.getToolInfo());
        
    }

    @Test
    void testToString() {
        String[] features = { "Email Marketing", "Marketing Automation" };
        FilterOptions filterOptions = new FilterOptions(1L,200,true,100,1000, features,"Low","High","Point & click","in House");
        ToolDetailedInfoDTO toolInfo = new ToolDetailedInfoDTO(1L, "Marketing Automation Tool", "https://youtube.com/watch/v1");
        DetailedRecommendationDTO detailedRecommendationDTO = new DetailedRecommendationDTO(1L, "Activecampaign", "BeBold", filterOptions, toolInfo);

        String expected = "DetailedRecommendationDTO(id=1, toolName=Activecampaign, companyName=BeBold, filterOptions=FilterOptions(id=1, budget=200, hasFreeTrial=true, emailsPerMonth=100, contacts=1000, features=[Email Marketing, Marketing Automation], levelOfSupport=Low, dbQuality=High, hasDragAndDrop=Point & click, implementationModel=in House), toolInfo=ToolDetailedInfoDTO(id=1, toolDescription=Marketing Automation Tool, toolVideoUrl=https://youtube.com/watch/v1))";  assertEquals(expected, detailedRecommendationDTO.toString());
    }


    @Test
    void testHashCodeAndEquals(){
        String toolName = "MailerLite";
        String companyName = "Be Bold";

        DetailedRecommendationDTO dto1 = new DetailedRecommendationDTO();
        dto1.setId(1L);
        dto1.setToolName(toolName);
        dto1.setCompanyName(companyName);

        DetailedRecommendationDTO dto2 = new DetailedRecommendationDTO();
        dto2.setId(1L);
        dto2.setToolName(toolName);
        dto2.setCompanyName(companyName);


        assertTrue(dto1.equals(dto2));
        assertEquals(dto1.hashCode(), dto2.hashCode());

    }

    @Test
    void testDetailedInfoIsNotEqualsOrHascode(){
        String toolName = "MailerLite";
        String companyName = "Be Bold";
        String companyName2 = "Tesla";

        DetailedRecommendationDTO dto1 = new DetailedRecommendationDTO();
        dto1.setId(1L);
        dto1.setToolName(toolName);
        dto1.setCompanyName(companyName);
        dto1.setFilterOptions(new FilterOptions());
        dto1.setToolInfo(new ToolDetailedInfoDTO());

        DetailedRecommendationDTO dto2 = new DetailedRecommendationDTO();
        dto2.setId(2L);
        dto2.setToolName(toolName);
        dto2.setCompanyName(companyName2);
        dto2.setFilterOptions(new FilterOptions());
        dto2.setToolInfo(new ToolDetailedInfoDTO());


        assertFalse(dto1.equals(dto2));
        assertNotEquals(dto1.hashCode(), dto2.hashCode());
        
    }

}