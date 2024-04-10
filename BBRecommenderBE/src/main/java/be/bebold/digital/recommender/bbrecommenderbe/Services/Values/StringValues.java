package be.bebold.digital.recommender.bbrecommenderbe.Services.Values;

import org.springframework.stereotype.Component;

import lombok.Getter;

/***
 * Class that has all the string values of all the feature names there are
 * @author [Baeten Jens]
 * @version 1.0
 */

@Getter
@Component
public class StringValues {

    // featurs fields
    private final String emailMarketingString         = "Email marketing";
    private final String socialMediaIntegrationString = "Social media integration";
    private final String ABTestingString              = "A/B testing";
    private final String leadScoringString            = "Leadscoring";
    private final String crmIntegration               = "CRM integration";
    private final String transactionalEmail           = "Transactional Emails";
    private final String leadGenerationString         = "Lead generation";
    private final String raportingString              = "Raporting";    
    private final String cdoString                    = "Custom Data Objects";
    private final String landingPage                  = "Landings pages";

    // Level of support
    private final String basicString                  = "Basic";
    private final String standardString               = "Standard";
    private final String advancedString               = "Advanced";

    // database quality
    private final String lowString                    = "Low complexity";
    private final String moderateString               = "Moderate complexity";
    private final String highString                   = "High complexity";

    private final String pointAndClickString          = "Point & click";
    private final String dragAndDropString            = "Drag & drop";
    private final String limitedDragAndDropString     = "Limited drag & drop";

    private final String inHouseString                = "Inhouse";
    private final String outsourcedString             = "Outsourced";

    private final String oracleEloquaString           = "Oracle Eloqua";
    private final String adobeMarketoString           = "Adobe Marketo";
    private final String activeCampaignString         = "ActiveCampaign";
    private final String sendInBlueString             = "SendInBlue";
    private final String mailerLiteString             = "MailerLite";

}
