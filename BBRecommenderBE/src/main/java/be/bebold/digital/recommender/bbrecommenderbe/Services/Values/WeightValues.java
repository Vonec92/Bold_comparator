package be.bebold.digital.recommender.bbrecommenderbe.Services.Values;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import lombok.Getter;

/***
 * Class that contains all the values for the weights of the features of the tools. This is used to calculate the score of the marketingtools and userinput.
 * <p>
 *     Note: if you add something to the HashMaps thresholds you also add it to the weight class
 * </p>
 * @author [Baeten Jens]
 * @version 1.0
 */

@Getter
@Component
public class WeightValues {

    private StringValues stringValues = new StringValues();

    private double budgetWeight             = 2;
    private double contactsWeight           = 0.8;
    private double emailsPerMonthWeight     = 0.6;
    private double freeTrialWeight          = 0.1;
    private double emailsPerMonthThresholds = 0.3;


   
    // add hash mapping for weight 
    HashMap<String, Double> featuresWeight = new HashMap<>()
    {{
        put(stringValues.getEmailMarketingString(),         0.0);
        put(stringValues.getSocialMediaIntegrationString(), 0.4);
        put(stringValues.getABTestingString(),              0.5);
        put(stringValues.getLeadScoringString(),            0.3);
        put(stringValues.getCrmIntegration(),               0.7);
        put(stringValues.getTransactionalEmail(),           0.1);
        put(stringValues.getLeadGenerationString(),         0.2);
        put(stringValues.getRaportingString(),              0.3);  
        put(stringValues.getCdoString(),                    1.0); 
        put(stringValues.getLandingPage(),                  0.1); 

    }};

    HashMap<String, Double> hasDragAndDropWeight = new HashMap<>() 
    {{
        put(stringValues.getPointAndClickString(),      0.1);
        put(stringValues.getLimitedDragAndDropString(), 0.3);
        put(stringValues.getDragAndDropString(),        0.5);
    }};


    HashMap<String, Double> supportLevelWeight = new HashMap<>()
    {{
        put(stringValues.getBasicString(),       0.0);
        put(stringValues.getStandardString(),    0.45);
        put(stringValues.getAdvancedString(),     0.9);
    }};


    HashMap<String, Double> databaseQualityWeight = new HashMap<>()
    {{
        put(stringValues.getLowString(),     0.0);
        put(stringValues.getModerateString(),0.3);
        put(stringValues.getHighString(),    0.5);
    }};

    HashMap<String, Double> implementationModelWeight = new HashMap<>() 
    {{
        put(stringValues.getInHouseString(),          0.1);
        put(stringValues.getOutsourcedString(),       0.0);
    }};



}
