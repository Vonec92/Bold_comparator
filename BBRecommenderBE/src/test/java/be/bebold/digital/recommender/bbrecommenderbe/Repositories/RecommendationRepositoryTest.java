package be.bebold.digital.recommender.bbrecommenderbe.Repositories;

import be.bebold.digital.recommender.bbrecommenderbe.Model.Recommendation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RecommendationRepositoryTest {
    @Test
    void findAll() {
        List<Recommendation> recommendations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            recommendations.add(new Recommendation());
        }
        RecommendationRepository recommendationRepository = mock(RecommendationRepository.class);
        assertNotNull(when(recommendationRepository.findAll()).thenReturn(recommendations));
    }
}