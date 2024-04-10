package be.bebold.digital.recommender.bbrecommenderbe.Controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO.DetailedRecommendationDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Model.Recommendation;
import be.bebold.digital.recommender.bbrecommenderbe.Repositories.RecommendationRepository;
import be.bebold.digital.recommender.bbrecommenderbe.Services.mapper.RecommendationMapper;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class DetailControllerTest {

  @Mock
  private RecommendationRepository recommendationRepository;

  @Mock
  private RecommendationMapper recommendationMapper;

  @InjectMocks
  private DetailController detailController = new DetailController();

  @Test
  public void testGetDetailedRecommendationById() {
    // Mock recommendation
    Long id = 1L;
    Recommendation recommendation = new Recommendation();
    recommendation.setId(id);

    // mock detailedRecommendationDTO
    DetailedRecommendationDTO detailedRecommendationDTO = new DetailedRecommendationDTO();
    detailedRecommendationDTO.setId(id);

    // Mock repository
    when(recommendationRepository.findById(id)).thenReturn(Optional.of(recommendation));

    // Mock mapper
    when(recommendationMapper.mapRecommendationToDetailedRecommendationDTO(Optional.of(recommendation))).thenReturn(detailedRecommendationDTO);

    // Call the controller method
    DetailedRecommendationDTO result = detailController.getDetailedRecommendationById(id);

    // Verify the wanted result
    assertNotNull(result);
    assertEquals(id, result.getId());

    // verify that the methods were called
    verify(recommendationRepository).findById(id);
    verify(recommendationMapper).mapRecommendationToDetailedRecommendationDTO(Optional.of(recommendation));
  }

  @Test
  public void getDetailedRecommendationByIdIsNotPresent() {

    Long id = -1L;
    DetailedRecommendationDTO actualDto = detailController.getDetailedRecommendationById(id);

    assertNull(actualDto);

    verify(recommendationRepository).findById(id);
  }
  
}
