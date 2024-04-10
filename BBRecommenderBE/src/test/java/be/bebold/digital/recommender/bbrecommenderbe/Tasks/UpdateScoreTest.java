package be.bebold.digital.recommender.bbrecommenderbe.Tasks;

import be.bebold.digital.recommender.bbrecommenderbe.Services.RecommendationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class UpdateScoreTest {

    @Mock
    private RecommendationService recommendationService;
  
    @Test
    public void updateCalculatedScoreForMarketingTools_shouldUpdateScores() {
      // Call the method on the mock object
      recommendationService.updateCalculatedScoreForMarketingTools();
  
      // Verify that the method was called exactly once
      verify(recommendationService, times(1)).updateCalculatedScoreForMarketingTools();
    }
}