package be.bebold.digital.recommender.bbrecommenderbe.Dtos.UpdateDTO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class ToolDataDTOTest {

    private ToolDataDTO toolDataDTO;

    private String[] features;

    @BeforeEach
    void setUp() {
        this.features    = new String[] {"feature1", "feature2"};
        this.toolDataDTO = new ToolDataDTO(1L, 200, true ,100,1000, features,"Basic", "high", "Point & click","in House");
    }

    @Test
    void getAndSetId() {
        Long id = 2L;
        this.toolDataDTO.setId(id);
        assertEquals(id, this.toolDataDTO.getId());
    }

    @Test
    void getAndSetBudget() {
        Integer budget = 300;
        this.toolDataDTO.setBudget(budget);
        assertEquals(budget, this.toolDataDTO.getBudget());
    }

    @Test
    void getAndSetHasFreeTrialTrue() {
        Boolean hasFreeTrial = true;
        this.toolDataDTO.setHasFreeTrial(hasFreeTrial);
        assertEquals(hasFreeTrial, this.toolDataDTO.getHasFreeTrial());
    }

    
    @Test
    void getAndSetHasFreeTrialFalse() {
        Boolean hasFreeTrial = false;
        this.toolDataDTO.setHasFreeTrial(hasFreeTrial);
        assertEquals(hasFreeTrial, this.toolDataDTO.getHasFreeTrial());
    }

    @Test
    void getAndSetHasFreeTrialNull() {
        Boolean hasFreeTrial = null;
        this.toolDataDTO.setHasFreeTrial(hasFreeTrial);
        assertEquals(hasFreeTrial, this.toolDataDTO.getHasFreeTrial());
    }


    @Test
    void getAndSetEmailsPerMonth() {
        Integer countOfUsers = 100;
        this.toolDataDTO.setEmailsPerMonth(countOfUsers);
        assertEquals(countOfUsers, this.toolDataDTO.getEmailsPerMonth());
    }

    @Test
    void getAndSetContacts() {
        Integer contracts = 1;
        this.toolDataDTO.setContacts(contracts);
        assertEquals(contracts, this.toolDataDTO.getContacts());
    }

    @Test
    void getAndSetFeatures() {
        String[] features = {"feature1", "feature2"};
        this.toolDataDTO.setFeatures(features);
        assertEquals(features, this.toolDataDTO.getFeatures());
    }

    @Test
    void getAndSetFeaturesNull() {
        String[] features = {"feature1", "feature2"};
        this.toolDataDTO.setFeatures(features);
        assertEquals(features, this.toolDataDTO.getFeatures());
    }

    @Test
    void getAndSetLevelOfSupport() {
        String levelOfSupport = "High";
        this.toolDataDTO.setLevelOfSupport(levelOfSupport);
        assertEquals(levelOfSupport, this.toolDataDTO.getLevelOfSupport());
    }

    @Test
    void getAndSetLevelOfSupportNull() {
        String levelOfSupport = null;
        this.toolDataDTO.setLevelOfSupport(levelOfSupport);
        assertEquals(levelOfSupport, this.toolDataDTO.getLevelOfSupport());
    }

    @Test
    void getAndSetDbQuality() {
        String dbQuality = "High";
        this.toolDataDTO.setDbQuality(dbQuality);
        assertEquals(dbQuality, this.toolDataDTO.getDbQuality());
    }


    @Test
    void getAndSetHasDragAndDrop() {
        String hasDragAndDrop = "Point & click";
        this.toolDataDTO.setHasDragAndDrop(hasDragAndDrop);
        assertEquals(hasDragAndDrop, this.toolDataDTO.getHasDragAndDrop());
    }

    @Test
    void AllArgsConstructor(){   
        assertEquals(1L, this.toolDataDTO.getId());
        assertEquals(200, this.toolDataDTO.getBudget());
        assertEquals(true, this.toolDataDTO.getHasFreeTrial());
        assertEquals(100, this.toolDataDTO.getEmailsPerMonth());
        assertEquals(1000, this.toolDataDTO.getContacts());
        assertEquals(this.features, this.toolDataDTO.getFeatures());
        assertEquals("Basic", this.toolDataDTO.getLevelOfSupport());
        assertEquals("high", this.toolDataDTO.getDbQuality());
        assertEquals("Point & click", this.toolDataDTO.getHasDragAndDrop());

    
    }

    @Test
    void testToStringAllArgsConstructorToString(){
        String expected = "ToolDataDTO(id=1, budget=200, hasFreeTrial=true, emailsPerMonth=100, contacts=1000, features=[feature1, feature2], levelOfSupport=Basic, dbQuality=high, hasDragAndDrop=Point & click, implementationModel=in House)";
        assertEquals(expected, this.toolDataDTO.toString());
    }

    @Test
    void testToStringAndSetters() {
        String[] features = {"feature1", "feature2"};
        this.toolDataDTO.setFeatures(features);
        this.toolDataDTO.setLevelOfSupport("Basic");
        this.toolDataDTO.setDbQuality("high");
        this.toolDataDTO.setHasDragAndDrop("Point & click");

        // this.toolDataDTO.setScore(5.0);
        String expected = "ToolDataDTO(id=1, budget=200, hasFreeTrial=true, emailsPerMonth=100, contacts=1000, features=[feature1, feature2], levelOfSupport=Basic, dbQuality=high, hasDragAndDrop=Point & click, implementationModel=in House)";  assertEquals(expected, this.toolDataDTO.toString());
    }
}