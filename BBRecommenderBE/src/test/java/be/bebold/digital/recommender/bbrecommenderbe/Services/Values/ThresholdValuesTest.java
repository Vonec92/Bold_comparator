package be.bebold.digital.recommender.bbrecommenderbe.Services.Values;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ThresholdValuesTest {

        private final ThresholdValues thresholdValues = new ThresholdValues();

        @Test
        public void testBudgetThresholds() {
            assertEquals(40, thresholdValues.getBudgetThresholds()[0]);
            assertEquals(50, thresholdValues.getBudgetThresholds()[1]);
            assertEquals(200, thresholdValues.getBudgetThresholds()[2]);
            assertEquals(4200, thresholdValues.getBudgetThresholds()[3]);
        }

        @Test
        public void testContactsThresholds() {
            assertEquals(0, thresholdValues.getContactsThresholds()[0]);
            assertEquals(0, thresholdValues.getContactsThresholds()[1]);
            assertEquals(10000, thresholdValues.getContactsThresholds()[2]);
            assertEquals(50000, thresholdValues.getContactsThresholds()[3]);
        }

        @Test
        public void testEmailsPerMonthThresholds() {
            assertEquals(0, thresholdValues.getEmailsPerMonthThresholds()[0]);
            assertEquals(0, thresholdValues.getEmailsPerMonthThresholds()[1]);
            assertEquals(0, thresholdValues.getEmailsPerMonthThresholds()[2]);
            assertEquals(20000, thresholdValues.getEmailsPerMonthThresholds()[3]);
        }

        @Test
        public void testHasFreeTrialThreshold() {
            assertTrue(thresholdValues.getHasFreeTrialTreshold().containsKey(true));
            assertTrue(thresholdValues.getHasFreeTrialTreshold().containsKey(false));
            assertEquals(1, thresholdValues.getHasFreeTrialTreshold().get(true));
            assertEquals(0, thresholdValues.getHasFreeTrialTreshold().get(false));
        }

        @Test
        public void testHasDragAndDropThreshold() {
            assertTrue(thresholdValues.getHasDragAndDropTreshold().containsKey("Point & click"));
            assertTrue(thresholdValues.getHasDragAndDropTreshold().containsKey("Drag & drop"));
            assertTrue(thresholdValues.getHasDragAndDropTreshold().containsKey("Limited drag & drop"));
            assertEquals(2, thresholdValues.getHasDragAndDropTreshold().get("Point & click"));
            assertEquals(3, thresholdValues.getHasDragAndDropTreshold().get("Limited drag & drop"));
            assertEquals(5, thresholdValues.getHasDragAndDropTreshold().get("Drag & drop"));

        }

        @Test
        public void testFeaturesThreshold() {
            assertEquals(1, thresholdValues.getFeaturesTreshold().get(thresholdValues.getStringValues().getEmailMarketingString()));
            assertEquals(1, thresholdValues.getFeaturesTreshold().get(thresholdValues.getStringValues().getSocialMediaIntegrationString()));
            assertEquals(1, thresholdValues.getFeaturesTreshold().get(thresholdValues.getStringValues().getABTestingString()));
            assertEquals(2, thresholdValues.getFeaturesTreshold().get(thresholdValues.getStringValues().getLeadScoringString()));
            assertEquals(2, thresholdValues.getFeaturesTreshold().get(thresholdValues.getStringValues().getCrmIntegration()));
            assertEquals(2, thresholdValues.getFeaturesTreshold().get(thresholdValues.getStringValues().getTransactionalEmail()));
            assertEquals(1, thresholdValues.getFeaturesTreshold().get(thresholdValues.getStringValues().getLeadGenerationString()));
            assertEquals(3, thresholdValues.getFeaturesTreshold().get(thresholdValues.getStringValues().getRaportingString()));
            assertEquals(3, thresholdValues.getFeaturesTreshold().get(thresholdValues.getStringValues().getCdoString()));
            assertEquals(3, thresholdValues.getFeaturesTreshold().get(thresholdValues.getStringValues().getLandingPage()));
        }

        @Test
        public void testSupportLevelThreshold() {
            assertEquals(1, thresholdValues.getSupportLevelTreshold().get(thresholdValues.getStringValues().getBasicString()));
            assertEquals(3, thresholdValues.getSupportLevelTreshold().get(thresholdValues.getStringValues().getStandardString()));
            assertEquals(5, thresholdValues.getSupportLevelTreshold().get(thresholdValues.getStringValues().getAdvancedString()));
        }

        @Test
        public void testDatabaseQuality(){
            assertEquals(1, thresholdValues.getDatabaseQualityTreshold().get(thresholdValues.getStringValues().getLowString()));
            assertEquals(3, thresholdValues.getDatabaseQualityTreshold().get(thresholdValues.getStringValues().getModerateString()));
            assertEquals(5, thresholdValues.getDatabaseQualityTreshold().get(thresholdValues.getStringValues().getHighString()));

        }
    }