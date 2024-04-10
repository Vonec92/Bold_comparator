package be.bebold.digital.recommender.bbrecommenderbe.Services.Values;

import org.springframework.stereotype.Component;

import lombok.Getter;

/***
    * Class that contains all the values for the features of the tools. This is used to calculate the score of the marketingtools. 
*/

@Getter
@Component
public class FeatureValuesTools {
    
    private String[] mailerLiteFeatures     = { "Email marketing", "Social media integration", "A/B testing", "Reporting", "Landings pages" };
    private String[] sendInBlueFeatures     = { "Email marketing", "Social media integration", "A/B testing", "Reporting", "CRM integration",  "Transactional Emails", "Landings pages"};
    private String[] activeCampaignFeatures = { "Email marketing", "Social media integration", "Leadscoring", "CRM integration",  "Transactional Emails","Landings pages"};
    private String[] adobeMarketoFeatures   = { "Email marketing", "Social media integration", "A/B testing", "Leadscoring", "CRM integration",  "Transactional Emails","Lead generation", "Reporting","Custom Data Objects", "Landings pages" };
    private String[] oracleEloquaFeature    = { "Email marketing", "Social media integration", "A/B testing", "Leadscoring", "CRM integration",  "Transactional Emails","Lead generation", "Reporting","Custom Data Objects", "Landings pages" };

}