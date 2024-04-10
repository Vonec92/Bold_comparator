package be.bebold.digital.recommender.bbrecommenderbe.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.bebold.digital.recommender.bbrecommenderbe.Dtos.UpdateDTO.ToolDataDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Model.MarketingTool;
import be.bebold.digital.recommender.bbrecommenderbe.Repositories.MarketingToolRepository;
import be.bebold.digital.recommender.bbrecommenderbe.Services.Values.FeatureValuesTools;
import be.bebold.digital.recommender.bbrecommenderbe.Services.Values.StringValues;
import be.bebold.digital.recommender.bbrecommenderbe.Services.Values.ThresholdValues;
import be.bebold.digital.recommender.bbrecommenderbe.Services.Values.WeightValues;
import be.bebold.digital.recommender.bbrecommenderbe.Services.mapper.ToolDataMapper;

/***
 * Service that return all the calculations and uses the {@link RatingCalculatorService} to calculate the rating for a tool
 */
@Service
public class RecommendationService {

    /* #region AUTOWIRED VARIABLES */
    @Autowired
    private MarketingToolRepository marketingToolRepository;

    @Autowired
    private WeightValues weightValue;

    @Autowired
    private RatingCalculatorService ratingCalculatorService;

    @Autowired
    private ThresholdValues thresholdValues;

    @Autowired
    private ToolDataMapper toolDataMapper;

    @Autowired
    private StringValues stringValues;

    @Autowired
    private FeatureValuesTools featureValuesTools;

    /* #endregion */

    /* #region CALCULATE FOR TOOL/INPUT */

    /***
     * Calculate the score for a tool based on the tooldata this method is used for both the marketingtool data as well as the userinput data
     * @param tooldata the tooldata that needs to be calculated
     * @return score
     */
    private double calculateScore(ToolDataDTO tooldata) {
        double score = 0.0;

        // Calculate the score for each field
        // Numeric values (budget, contracts, company size)
        score += ratingCalculatorService.calculateScoreForInteger(tooldata.getBudget(), thresholdValues.getBudgetThresholds(), weightValue.getBudgetWeight());
        score += ratingCalculatorService.calculateScoreForInteger(tooldata.getEmailsPerMonth(),thresholdValues.getEmailsPerMonthThresholds(), weightValue.getEmailsPerMonthWeight());

        // calculate for string values (industry, level of customazation, level of
        // support, db quality, ease of use)
        score += ratingCalculatorService.calculateScoreForString(tooldata.getLevelOfSupport(), thresholdValues.getSupportLevelTreshold(), weightValue.getSupportLevelWeight());
        score += ratingCalculatorService.calculateScoreForString(tooldata.getDbQuality(), thresholdValues.getDatabaseQualityTreshold(), weightValue.getDatabaseQualityWeight());
        score += ratingCalculatorService.calculateScoreForString(tooldata.getHasDragAndDrop(), thresholdValues.getHasDragAndDropTreshold(), weightValue.getHasDragAndDropWeight());
        score += ratingCalculatorService.calculateScoreForString(tooldata.getImplementationModel(), thresholdValues.getImplementationModelTreshold(), weightValue.getImplementationModelWeight());


        // Map values (features, goals, cookies, additional addons)
        score += ratingCalculatorService.calculateScoreForStringArray(tooldata.getFeatures(), thresholdValues.getFeaturesTreshold(), weightValue.getFeaturesWeight());
       
        // Boolean values (yes/no)
        score += ratingCalculatorService.calculateScoreForBoolean(tooldata.getHasFreeTrial(), thresholdValues.getHasFreeTrialTreshold(), weightValue.getFreeTrialWeight());

        return score;
    }

    /* #endregion */

    /* #region UPDATE MARKETING TOOL DATABASE */

    /**
     * this function will be used when storing the scores in the cookies so
     *          we don't need to calculate them again and again.
     * This function will run when cookies are empty or there is a change
     *          in the database so we need to recalculate the scores
     */
    public void updateCalculatedScoreForMarketingTools() {

        // Loop over all marketing tools data and give score based on database values
        for (MarketingTool tool : marketingToolRepository.findAll()) {


            setFeaturesforTool(tool);
            ToolDataDTO toolDataDTO = toolDataMapper.mapMarketingToolToToolDataDTO(tool);

            // Calculate the score for the marketing tool and round it up to 2 decimals
            Double score = Math.round((calculateScore(toolDataDTO)) * 100.0) / 100.0;

            // Update the score field
            tool.setScore(score);

            marketingToolRepository.save(tool);
        }
    }

    /* #endregion */

    /* #region CALCULATE SCORE FOR USERINPUT */
    /**
     * This function will calculate the score for the user input and compare it to the scores of the marketing tools
     * @param userInput user input form the frontend
     * @param marketingTools all marketing tools from the database or from the cache
     * @return String name of the recommended tool
     *
     */
    public String CalculateRecommendedToolForUserInput(ToolDataDTO userInput , List<MarketingTool> marketingTools) {

        // calculate the score for the user input
        double score =  Math.round((calculateScore(userInput)) * 100.0) / 100.0;

        // get all marketing tools from the database
        Iterable<MarketingTool> marketingToolsList = marketingTools;
        // MarketingTool bestMarketingTool = null;
        String toolName = null;

        // check which marketing tool has the closest score to the user input
        toolName = checkClosestTool(marketingToolsList, score).getToolName();

        return toolName;
    }

    /* #endregion */

    /* #region HELPER FUNCTIONS */
    /***
     * This function will get the closest tool to the userinput score
     * @param tools
     * @param score
     * @return
     */
    private MarketingTool checkClosestTool(Iterable<MarketingTool> tools, double score) {

        MarketingTool closestMarketingTool = new MarketingTool();

        // has to be max value because we want to find the closest(lowest) scores
        double closestScoreDiff = Double.MAX_VALUE;

        // loop over all marketing tools and check which one has the closest score
        for (MarketingTool tool : tools) {

            // absulute value = not negative
            double scoreDif = Math.abs(tool.getScore() - score);
            // if scoreDif is lower than the current closest score dif, update the closest
            // marketing tool and the closest score dif
            if (scoreDif < closestScoreDiff) {
                closestMarketingTool = tool;
                closestScoreDiff = scoreDif;
            }
        }

        return closestMarketingTool;
    }
    /* #endregion */

  /***
   * This function will set the features for each marketinTool
   * this function is used in the {@link updateCalculatedScoreForMarketingTools}
   * @param tool
   * @return
   * 
   */
    private void setFeaturesforTool(MarketingTool tool){

        if(tool.getToolName().equals(stringValues.getOracleEloquaString())) {
            tool.setFeatures(featureValuesTools.getOracleEloquaFeature());
        } else if(tool.getToolName().equals(stringValues.getAdobeMarketoString())) {
            tool.setFeatures(featureValuesTools.getAdobeMarketoFeatures());
        } else if(tool.getToolName().equals(stringValues.getSendInBlueString())) {
            tool.setFeatures(featureValuesTools.getSendInBlueFeatures());
        } else if(tool.getToolName().equals(stringValues.getActiveCampaignString())) {
            tool.setFeatures(featureValuesTools.getActiveCampaignFeatures());
        } else if(tool.getToolName().equals(stringValues.getMailerLiteString())) {
            tool.setFeatures(featureValuesTools.getMailerLiteFeatures());
        }
    }
}