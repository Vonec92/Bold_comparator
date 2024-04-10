package be.bebold.digital.recommender.bbrecommenderbe.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterOptionsTest {

    @Test
    void getAndSetId() {
        FilterOptions filterOptions = new FilterOptions();
        filterOptions.setId(1L);
        assertEquals(1L, filterOptions.getId());
    }

    @Test
    void getAndSetBudget() {
        FilterOptions filterOptions = new FilterOptions();
        filterOptions.setBudget(200);
        assertEquals(200, filterOptions.getBudget());
    }

    @Test
    void getAndSetHasFreeTrial() {
        FilterOptions filterOptions = new FilterOptions();
        filterOptions.setHasFreeTrial(true);
        assertEquals(true, filterOptions.getHasFreeTrial());
    }

    @Test
    void getAndSetEmailsPerMonth() {
        FilterOptions filterOptions = new FilterOptions();
        filterOptions.setEmailsPerMonth(100);
        assertEquals(100, filterOptions.getEmailsPerMonth());
    }


    @Test
    void getAndSetFeatures() {
        FilterOptions filterOptions = new FilterOptions();
        String[] features = { "Email Marketing", "Marketing Automation" };
        filterOptions.setFeatures(features);
        assertEquals(features, filterOptions.getFeatures());
    }


    @Test
    void getAndSetLevelOfSupport() {
        FilterOptions filterOptions = new FilterOptions();
        filterOptions.setLevelOfSupport("High");
        assertEquals("High", filterOptions.getLevelOfSupport());
    }

    @Test
    void getAndSetDbQuality() {
        FilterOptions filterOptions = new FilterOptions();
        filterOptions.setDbQuality("High");
        assertEquals("High", filterOptions.getDbQuality());
    }


    @Test
    void getAndSetHasDragAndDrop() {
        FilterOptions filterOptions = new FilterOptions();
        filterOptions.setHasDragAndDrop("Point & click");
        assertEquals("Point & click", filterOptions.getHasDragAndDrop());
    }

    // @Test
    // void getAndSetScore() {
    //     FilterOptions filterOptions = new FilterOptions();
    //     filterOptions.setScore(10.0);
    //     assertEquals(10.0, filterOptions.getScore());
    // }

    // test To Sting
    @Test
    void testAndSetToString() {
        String[] features = { "Email Marketing", "Marketing Automation" };
        FilterOptions filterOptions = new FilterOptions(1L,200,true,100,1000, features,"Low","High","Point & click", "in House");

        String expected = "FilterOptions(id=1, budget=200, hasFreeTrial=true, emailsPerMonth=100, contacts=1000, features=[Email Marketing, Marketing Automation], levelOfSupport=Low, dbQuality=High, hasDragAndDrop=Point & click, implementationModel=in House)";
        assertEquals(expected, filterOptions.toString());


    }
}