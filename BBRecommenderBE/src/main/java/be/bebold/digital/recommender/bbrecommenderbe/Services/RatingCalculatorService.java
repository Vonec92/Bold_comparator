package be.bebold.digital.recommender.bbrecommenderbe.Services;
import java.util.HashMap;

import org.springframework.stereotype.Component;

/***
 * Service that calculates the score for a feature based on the thresholds and the weight of the feature
 */
@Component
public class RatingCalculatorService {

    
    /** 
     * @param score score of the feature (input = point)
     * @param weight weight of the feature to calculate the weighted score
     * @return Double 
     * @apiNote This function will calculate the weighted score for a given score and weight
     */
    private Double calculateWeightedScore(int score, double weight) {
        // rounds the score to 2 decimals and returns it with the weight value
        return Math.round((score * weight) * 100.0) / 100.0;
    }
    
    
    /**
     * this function will calculate the score for a boolean value True OR False based on the thresholds returns a double with 2 decimals of a weighted score
     * @param value boolean value (input)
     * @param boolFeature hashmap with the thresholds for the boolean value to give point
     * @param weight weight of the feature to calculate the weighted score
     * @return Double
     */
    public Double calculateScoreForBoolean(Boolean value, HashMap<Boolean, Integer> boolFeature,  double weight) {
        
        if (value == null) {
            return 0.0;
        }

        int score = boolFeature.get(value);


        return calculateWeightedScore(score , weight);
    }

    /**
     * this function will calculate the score for a value based on the thresholds returns a double with 2 decimals of a weighted score
     * @param value integer value input int
     * @param thresholds array of thresholds gives the int a point based on the value
     * @param weight weight of the feature to calculate the weighted score
     * @return Double
     */
    public Double calculateScoreForInteger(Integer value, int[] thresholds, double weight) {

       // if value is negative or is Null then return 0.0
        if (value == null || value < 0) {
            return 0.0;
        }

        for (int i = 0; i < thresholds.length; i++) {
            // value is lower than the threshold
            if (value <= thresholds[i]) {
                return calculateWeightedScore(i + 1, weight);
            }
        }

        // if the value is higher than the highest threshold[length - 1] than give it a score of the length + 1 of the array
        // if the length is 4 we give it a score of 5 because we check the last index of the array twice (in the for loop and here)
        // return the score e with 2 decimals
        return calculateWeightedScore(thresholds.length + 1, weight);

    }

    /***
     * this function will calculate the score for a String[] based value on the thresholds returns a double with 2 decimals of a weighted score
     * @param inputValues String[] input
     * @param featThreshold hashmap with the thresholds for the String[] value to give point
     * @param featWeight weight of the feature to calculate the weighted score
     * @return Double
     */
    public Double calculateScoreForStringArray(String[] inputValues, HashMap<String, Integer> featThreshold, HashMap<String, Double> featWeight) {
        double score = 0.0;

        if (inputValues == null || inputValues.length == 0) {
            return 0.0;
        }

        for (String inputValue : inputValues) {
            // this can be featThreshold or weight the key values are the same.
            //for correctness, we check both if later on we change the key values on only one of them
            if (featThreshold.containsKey(inputValue) && featWeight.containsKey(inputValue)) {

                int point = featThreshold.get(inputValue);
                double weight = featWeight.get(inputValue);

                score += calculateWeightedScore(point, weight);

            }
        }

        return score;
   
    }

    /***
     * this function will calculate the score for a String based value on the thresholds returns a double with 2 decimals of a weighted score
     * @param value String input
     * @param featThreshold featThreshold for the String value to give point
     * @param featWeight weight of the feature to calculate the weighted score
     * @return Double score
     */
    public Double calculateScoreForString(String value, HashMap<String, Integer> featThreshold, HashMap<String, Double> featWeight) {
        double score = 0.0;

        if (value == null) {
            return 0.0;
        }

        if (featThreshold.containsKey(value) && featWeight.containsKey(value)) {

            int point = featThreshold.get(value);
            double weight = featWeight.get(value);

            score += calculateWeightedScore(point, weight);

        }
        return score;
    }
}
