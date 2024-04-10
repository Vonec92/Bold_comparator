package be.bebold.digital.recommender.bbrecommenderbe.Services.Values;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import lombok.Getter;

/***
 * Class that contains all the values for the thresholds of the features of the tools. This is used to calculate the score of the marketingtools and userinput.
 * <p>
 * Note:if you add something to the HashMaps thresholds you also add it to the weight class
 * </p>
 * @author [Baeten Jens]
 * @version 1.0
 */

@Getter
@Component
public class ThresholdValues {

    private StringValues stringValues = new StringValues();

    int[] budgetThresholds = {
        40, // 1 point
        50, // 2 points
        200, // 3 points
        4200, // 4 points
        // 4200+ // 5 points
       
    };

    int[] contactsThresholds = {
            0, // 1 point
            0, // 2 points
            10000, // 3 points
            50000, // 4 points     
    };

    int[] emailsPerMonthThresholds = {
            0, // 1 point
            0, // 2 points
            0, // 3 points
            20000, // 4 points
            
    };

    HashMap<Boolean, Integer> hasFreeTrialTreshold = new HashMap<>() {
        {
            put(true, 1);
            put(false, 0);
        }
    };


    HashMap<String, Integer> hasDragAndDropTreshold = new HashMap<>() 
        {{
            put(stringValues.getPointAndClickString(),      2);
            put(stringValues.getLimitedDragAndDropString(), 3);
            put(stringValues.getDragAndDropString(),        5);
        }};

    HashMap<String, Integer> featuresTreshold = new HashMap<>() {
        {
            put(stringValues.getEmailMarketingString(),         1);
            put(stringValues.getSocialMediaIntegrationString(), 1);
            put(stringValues.getABTestingString(),              1);
            put(stringValues.getLeadScoringString(),            2);
            put(stringValues.getCrmIntegration(),               2);
            put(stringValues.getTransactionalEmail(),           2);
            put(stringValues.getLeadGenerationString(),         1);
            put(stringValues.getRaportingString(),              3);  
            put(stringValues.getCdoString(),                    3); 
            put(stringValues.getLandingPage(),                  3); 
        }
    };

    HashMap<String, Integer> supportLevelTreshold = new HashMap<>() {
        {
            put(stringValues.getBasicString(),      1);
            put(stringValues.getStandardString(),   3);
            put(stringValues.getAdvancedString(),   5);
        }
    };

    HashMap<String, Integer> databaseQualityTreshold = new HashMap<>() {
        {
            put(stringValues.getLowString(),        1);
            put(stringValues.getModerateString(),   3);
            put(stringValues.getHighString(),       5);
        }
    };

    HashMap<String, Integer> implementationModelTreshold = new HashMap<>() {
        {
            put(stringValues.getInHouseString(),          1);
            put(stringValues.getOutsourcedString(),       0);
        }
    };

}
