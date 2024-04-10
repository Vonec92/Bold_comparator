package be.bebold.digital.recommender.bbrecommenderbe.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

class RatingCalculatorServiceTest {

    private RatingCalculatorService ratingCalculatorService;
   
    @BeforeEach
    void setUp() {
        this.ratingCalculatorService = new RatingCalculatorService();
    }


    @Test
    void calculateScoreForBooleanTrue() {
        Boolean hasOption= true;
        HashMap<Boolean, Integer> thresholds = new HashMap<Boolean, Integer>() {{
            put(true, 5);
            put(false, 0);
        }};

        Double score = this.ratingCalculatorService.calculateScoreForBoolean(hasOption, thresholds, 0.5);
        assertEquals(2.5, score);
    }

    
    @Test
    void calculateScoreForBooleanNullValue() {
        Boolean hasOption= null;
        HashMap<Boolean, Integer> thresholds = new HashMap<Boolean, Integer>() {{
            put(true, 5);
            put(false, 0);
        }};

        Double score = this.ratingCalculatorService.calculateScoreForBoolean(hasOption, thresholds, 0.5);
        assertEquals(0.0, score);
    }

    @Test
    void testCalculationScoreForInteger() {

        int value = 500;
        int[] thresholds = new int[]{10,100,1000,20000,50000};

        Double score = this.ratingCalculatorService.calculateScoreForInteger(value, thresholds, 0.5);
        assertEquals(1.5, score);
    }

    @Test
    void testCalculationScoreForIntegerWithValueNull() {

        Integer value = null;
        int[] thresholds = new int[]{10,100,1000,20000,50000};

        Double score = this.ratingCalculatorService.calculateScoreForInteger(value, thresholds, 0.5);
        assertEquals(0.0, score);
    }

    @Test
    void testCalculationScoreForIntegerWithNegativeValue() {

        Integer value = -2;
        int[] thresholds = new int[]{10,100,1000,20000,50000};

        Double score = this.ratingCalculatorService.calculateScoreForInteger(value, thresholds, 0.5);
        assertEquals(0.0, score);
    }

    @Test
    void testCalculationScoreForIntegerWithValueHigherThanTheHighestThreshold() {

        int value = 70000;
        int[] thresholds = new int[]{10,100,1000,50000};

        Double score = this.ratingCalculatorService.calculateScoreForInteger(value, thresholds, 0.5);
        assertEquals(2.5, score);
    }

    @Test
    void calculateScoreForStringArrayStringMulipleOptions() {
        String[] features = {"leadScoring", "emailMarketing"};
        HashMap<String, Integer> thresholds = new HashMap<String, Integer>(){{
            put("leadScoring", 5);
            put("emailMarketing", 0);
        }};
        HashMap<String,Double> featWeight = new HashMap<String, Double>(){{
            put("leadScoring", 0.5);
            put("emailMarketing", 0.5);
        }};

        Double score = this.ratingCalculatorService.calculateScoreForStringArray(features, thresholds, featWeight);
        assertEquals(2.5, score);
    }

    @Test
    void calculateScoreForStringArrayMulipleOptionsFeatureIsNull() {
        String[] features = null;
        HashMap<String, Integer> thresholds = new HashMap<String, Integer>(){{
            put("leadScoring", 5);
            put("emailMarketing", 0);
        }};
        HashMap<String,Double> featWeight = new HashMap<String, Double>(){{
            put("leadScoring", 0.5);
            put("emailMarketing", 0.5);
        }};

        Double score = this.ratingCalculatorService.calculateScoreForStringArray(features, thresholds, featWeight);
        assertEquals(0.0, score);
    }

    @Test
    void calculateScoreForStringArrayMulipleOptionsfeatureLenghtIsZero() {
        String[] features = new String[0];
        HashMap<String, Integer> thresholds = new HashMap<String, Integer>(){{
            put("leadScoring", 5);
            put("emailMarketing", 0);
        }};
        HashMap<String,Double> featWeight = new HashMap<String, Double>(){{
            put("leadScoring", 0.5);
            put("emailMarketing", 0.5);
        }};

        Double score = this.ratingCalculatorService.calculateScoreForStringArray(features, thresholds, featWeight);
        assertEquals(0.0, score);
    }


    @Test
    void testCalculateScoreForStringSingleOption() {
        String feature = "Manufacturing";
        HashMap<String, Integer> thresholds = new HashMap<String, Integer>(){{
            put("Manufacturing", 5);
            put("Tech", 0);
        }};
        HashMap<String,Double> featWeight = new HashMap<String, Double>(){{
            put("Manufacturing", 0.5);
            put("Tech", 0.5);
        }};

        Double score = this.ratingCalculatorService.calculateScoreForString(feature, thresholds, featWeight);
        assertEquals(2.5, score);
    }

    @Test
    void testCalculateScoreForStringSingleOptionWhenStringIsNull() {
        String feature = null;
        HashMap<String, Integer> thresholds = new HashMap<String, Integer>(){{
            put("Manufacturing", 5);
            put("Tech", 0);
        }};
        HashMap<String,Double> featWeight = new HashMap<String, Double>(){{
            put("Manufacturing", 0.5);
            put("Tech", 0.5);
        }};

        Double score = this.ratingCalculatorService.calculateScoreForString(feature, thresholds, featWeight);
        assertEquals(0.0, score);
    }
}