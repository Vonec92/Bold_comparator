package be.bebold.digital.recommender.bbrecommenderbe.Model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;



class RecommendationTest {

    @Test
    void getAndSetId(){
        Recommendation recommendation = new Recommendation();
        recommendation.setId(1L);
        assertEquals(1L, recommendation.getId());
    }

    @Test
    void getAndSetUid() {
        Recommendation recommendation = new Recommendation();
        recommendation.setUid("2954baf6-db43-4828-a82d-8c3f71515bff");
        assertEquals("2954baf6-db43-4828-a82d-8c3f71515bff", recommendation.getUid());
    }

    @Test
    void getAndSetCreator() {
        Recommendation recommendation = new Recommendation();
        recommendation.setCreator("Rudy De Bolder");
        assertEquals("Rudy De Bolder", recommendation.getCreator());
    }

    @Test
    void getAndSetDate() {
        Recommendation recommendation = new Recommendation();
        Date date = Date.valueOf("2020-12-12");
        recommendation.setDate(date);
        assertEquals(date, recommendation.getDate());
    }

    @Test
    void getAndSetToolName() {
        Recommendation recommendation = new Recommendation();
        recommendation.setToolName("Activecampaign");
        assertEquals("Activecampaign", recommendation.getToolName());
    }

    @Test
    void getAndSetCompanyName() {
        Recommendation recommendation = new Recommendation();
        recommendation.setCompanyName("BeBold");
        assertEquals("BeBold", recommendation.getCompanyName());
    }

    @Test
    void getAndSetFilterOptions() {
        String[] features = { "Email Marketing", "Marketing Automation" };
        FilterOptions filterOptions =new FilterOptions(1L,200,true,100,1000, features,"Low","High","Point & click","in House");

        Recommendation recommendation = new Recommendation();
        recommendation.setFilterOptions(filterOptions);
        assertEquals(filterOptions, recommendation.getFilterOptions());
    }

    @Test
    void getAndSetToolInfo() {
        ToolDetailedInfo toolDetailedInfo = new ToolDetailedInfo(1L,"Activecampaign","Description","https://www.activecampaign.com/");

        Recommendation recommendation = new Recommendation();
        recommendation.setToolInfo(toolDetailedInfo);
        assertEquals(toolDetailedInfo, recommendation.getToolInfo());

    }

    @Test
    void testToString() {
        String[] features = { "Email Marketing", "Marketing Automation" };
        Date date = Date.valueOf("2020-12-12");

        FilterOptions filterOptions = new FilterOptions(1L,200,true,100,1000, features,"Low","High","Point & click","in House");
        ToolDetailedInfo toolInfo = new ToolDetailedInfo(1L,"Activecampaign","Description","https://www.activecampaign.com/");
        Recommendation recommendation = new Recommendation(1L,"2954baf6-db43-4828-a82d-8c3f71515bff","Rudy De Bolder",date ,"Activecampaign","BeBold", filterOptions,toolInfo);


        String expected = "Recommendation(id=1, uid=2954baf6-db43-4828-a82d-8c3f71515bff, creator=Rudy De Bolder, date=2020-12-12, toolName=Activecampaign, companyName=BeBold, filterOptions=FilterOptions(id=1, budget=200, hasFreeTrial=true, emailsPerMonth=100, contacts=1000, features=[Email Marketing, Marketing Automation], levelOfSupport=Low, dbQuality=High, hasDragAndDrop=Point & click, implementationModel=in House), toolInfo=ToolDetailedInfo(id=1, toolName=Activecampaign, toolDescription=Description, toolVideoUrl=https://www.activecampaign.com/))";
        assertEquals(expected,recommendation.toString());
    }
}