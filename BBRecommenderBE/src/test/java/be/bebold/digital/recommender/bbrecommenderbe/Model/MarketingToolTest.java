package be.bebold.digital.recommender.bbrecommenderbe.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarketingToolTest {

    @Test
    void getAndSetId() {
        MarketingTool marketingTool = new MarketingTool();
        marketingTool.setId(1L);
        assertEquals(1L, marketingTool.getId());
    }

    @Test
    void getAndSetBudget() {
        MarketingTool marketingTool = new MarketingTool();
        marketingTool.setBudget(200);
        assertEquals(200, marketingTool.getBudget());
    }

    @Test
    void getAndSetHasFreeTrial() {
        MarketingTool marketingTool = new MarketingTool();
        marketingTool.setHasFreeTrial(true);
        assertEquals(true, marketingTool.getHasFreeTrial());
    }

    @Test
    void getAndSetEmailsPerMonth() {
        MarketingTool marketingTool = new MarketingTool();
        marketingTool.setEmailsPerMonth(100);
        assertEquals(100, marketingTool.getEmailsPerMonth());
    }

    @Test
    void getAndSetContracts() {
        MarketingTool marketingTool = new MarketingTool();
        marketingTool.setContacts(1);
        assertEquals(1, marketingTool.getContacts());
    }

    @Test
    void getAndSetFeatures() {
        MarketingTool marketingTool = new MarketingTool();
        String[] features = { "Email Marketing", "Marketing Automation" };
        marketingTool.setFeatures(features);
        assertEquals(features, marketingTool.getFeatures());
    }

    @Test
    void getAndSetLevelOfSupport() {
        MarketingTool marketingTool = new MarketingTool();
        marketingTool.setLevelOfSupport("High");
        assertEquals("High", marketingTool.getLevelOfSupport());
    }
    @Test
    void getAndSetDbQuality() {
        MarketingTool marketingTool = new MarketingTool();
        marketingTool.setDbQuality("High");
        assertEquals("High", marketingTool.getDbQuality());
    }


    @Test
    void getAndSetHasDragAndDrop() {
        MarketingTool marketingTool = new MarketingTool();
        marketingTool.setHasDragAndDrop("Point & click");
        assertEquals("Point & click", marketingTool.getHasDragAndDrop());
    }

    @Test
    void getAndSetScore() {
        MarketingTool marketingTool = new MarketingTool();
        marketingTool.setScore(10.0);
        assertEquals(10.0, marketingTool.getScore());
    }

    // test To Sting
    @Test
    void testToString() {
        String[] features = { "Email Marketing", "Marketing Automation" };
        MarketingTool marketingTool = new MarketingTool(1L,"ActiveCampaign",200,true,100,1,features,"Low","High","Point & click","in House",10.0);

        String expected = "MarketingTool(id=1, toolName=ActiveCampaign, budget=200, hasFreeTrial=true, emailsPerMonth=100, contacts=1, features=[Email Marketing, Marketing Automation], levelOfSupport=Low, dbQuality=High, hasDragAndDrop=Point & click, implementationModel=in House, score=10.0)";
        assertEquals(expected,marketingTool.toString());


    }

}