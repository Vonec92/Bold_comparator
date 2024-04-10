package be.bebold.digital.recommender.bbrecommenderbe.Services.Values;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WeightValuesTest {
    @Test
    public void testBudgetWeight() {
        WeightValues weightValues = new WeightValues();
        assertEquals(2.0, weightValues.getBudgetWeight());
    }

    @Test
    public void testContactsWeight() {
        WeightValues weightValues = new WeightValues();
        assertEquals(0.8, weightValues.getContactsWeight());
    }

    @Test
    public void testEmailsPerMonthWeight() {
        WeightValues weightValues = new WeightValues();
        assertEquals(0.6, weightValues.getEmailsPerMonthWeight());
    }

    @Test
    public void testFreeTrialWeight() {
        WeightValues weightValues = new WeightValues();
        assertEquals(0.1, weightValues.getFreeTrialWeight());
    }

    @Test
    public void testDragAndDropWeight() {
        WeightValues weightValues = new WeightValues();
        assertEquals(0.1, weightValues.getHasDragAndDropWeight().get(weightValues.getStringValues().getPointAndClickString()));
        assertEquals(0.3, weightValues.getHasDragAndDropWeight().get(weightValues.getStringValues().getLimitedDragAndDropString()));
        assertEquals(0.5, weightValues.getHasDragAndDropWeight().get(weightValues.getStringValues().getDragAndDropString()));
    }

    @Test
    public void testEmailsPerMonthThresholds() {
        WeightValues weightValues = new WeightValues();
        assertEquals(0.3, weightValues.getEmailsPerMonthThresholds());
    }

    @Test
    public void testFeaturesWeight() {
        WeightValues weightValues = new WeightValues();
        assertEquals(0.0, weightValues.getFeaturesWeight().get(weightValues.getStringValues().getEmailMarketingString()));
        assertEquals(0.4, weightValues.getFeaturesWeight().get(weightValues.getStringValues().getSocialMediaIntegrationString()));
        assertEquals(0.5, weightValues.getFeaturesWeight().get(weightValues.getStringValues().getABTestingString()));
        assertEquals(0.3, weightValues.getFeaturesWeight().get(weightValues.getStringValues().getLeadScoringString()));
        assertEquals(0.7, weightValues.getFeaturesWeight().get(weightValues.getStringValues().getCrmIntegration()));
        assertEquals(0.1, weightValues.getFeaturesWeight().get(weightValues.getStringValues().getTransactionalEmail()));
        assertEquals(0.2, weightValues.getFeaturesWeight().get(weightValues.getStringValues().getLeadGenerationString()));
        assertEquals(0.3, weightValues.getFeaturesWeight().get(weightValues.getStringValues().getRaportingString()));
        assertEquals(1.0, weightValues.getFeaturesWeight().get(weightValues.getStringValues().getCdoString()));
        assertEquals(0.1, weightValues.getFeaturesWeight().get(weightValues.getStringValues().getLandingPage()));
    }

    @Test
    public void testSupportLevelWeight() {
        WeightValues weightValues = new WeightValues();
        assertEquals(0.0, weightValues.getSupportLevelWeight().get(weightValues.getStringValues().getBasicString()));
        assertEquals(0.45, weightValues.getSupportLevelWeight().get(weightValues.getStringValues().getStandardString()));
        assertEquals(0.9, weightValues.getSupportLevelWeight().get(weightValues.getStringValues().getAdvancedString()));
    }

    @Test
    public void testDatabaseQualityWeight() {
        WeightValues weightValues = new WeightValues();
        assertEquals(0.0, weightValues.getDatabaseQualityWeight().get(weightValues.getStringValues().getLowString()));
        assertEquals(0.3, weightValues.getDatabaseQualityWeight().get(weightValues.getStringValues().getModerateString()));
        assertEquals(0.5, weightValues.getDatabaseQualityWeight().get(weightValues.getStringValues().getHighString()));
    }
}