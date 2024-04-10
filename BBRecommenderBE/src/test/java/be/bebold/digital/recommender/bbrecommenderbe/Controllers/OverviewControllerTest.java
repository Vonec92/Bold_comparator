package be.bebold.digital.recommender.bbrecommenderbe.Controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO.RecommendationDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Model.Recommendation;
import be.bebold.digital.recommender.bbrecommenderbe.Repositories.RecommendationRepository;
import be.bebold.digital.recommender.bbrecommenderbe.Services.mapper.RecommendationMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
@ExtendWith(SpringExtension.class)
class OverviewControllerTest {

  @Mock
  private RecommendationRepository recommendationRepository;

  @Mock
  private RecommendationMapper recommendationMapper;

  @InjectMocks
  private OverviewController overviewController;

  @Test
  public void testGetRecommendationsForCurrentUser() {
    String uid1 = "2954baf6-db43-4828-a82d-8c3f71515bff";
    String uid2 = "ee597c59-9814-447b-9e44-c3ec28369d62";

    List<Recommendation> recommendations = new ArrayList<>();
    Recommendation rec1 = new Recommendation();
    rec1.setUid(uid1);
    Recommendation rec2 = new Recommendation();
    rec2.setUid(uid2);

    recommendations.add(rec1);
    recommendations.add(rec2);

    when(recommendationRepository.findByUid(uid1)).thenReturn(recommendations);
    when(recommendationRepository.findByUid(uid2)).thenReturn(recommendations);

    List<RecommendationDTO> recommendationDTOs = new ArrayList<>();
    RecommendationDTO rec1DTO = new RecommendationDTO();
    rec1DTO.setUid(uid1);
    RecommendationDTO rec2DTO = new RecommendationDTO();
    rec2DTO.setUid(uid2);

    when(recommendationMapper.mapListMarketingToolToRecommendationDTO(recommendations)).thenReturn(recommendationDTOs);

    List<RecommendationDTO> result = overviewController.getRecommendationsForCurrentUser(uid1);

    assertEquals(recommendationDTOs, result);

    verify(recommendationRepository).findByUid(uid1);
    verify(recommendationMapper).mapListMarketingToolToRecommendationDTO(recommendations);


  }

  @Test
  public void testGetAllRecommendations() {
    String uid1 = "2954baf6-db43-4828-a82d-8c3f71515bff";
    String uid2 = "ee597c59-9814-447b-9e44-c3ec28369d62";
    List<Recommendation> recommendations = new ArrayList<>();
    Recommendation rec1 = new Recommendation();
    rec1.setUid(uid1);
    Recommendation rec2 = new Recommendation();
    rec2.setUid(uid2);

    when(recommendationRepository.findAll()).thenReturn(recommendations);

    List<RecommendationDTO> recommendationDTOs = new ArrayList<>();
    RecommendationDTO rec1DTO = new RecommendationDTO();
    rec1DTO.setUid(uid1);
    RecommendationDTO rec2DTO = new RecommendationDTO();
    rec2DTO.setUid(uid2);

    when(recommendationMapper.mapListMarketingToolToRecommendationDTO(recommendations)).thenReturn(recommendationDTOs);

    List<RecommendationDTO> result = overviewController.getAllRecommendations();

    assertEquals(recommendationDTOs, result);

    verify(recommendationRepository).findAll();
    verify(recommendationMapper).mapListMarketingToolToRecommendationDTO(recommendations);
  }
}
