package be.bebold.digital.recommender.bbrecommenderbe.Services.mapper;

import org.junit.jupiter.api.Test;
import be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO.DetailedRecommendationDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO.RecommendationDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO.ToolDetailedInfoDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Model.FilterOptions;
import be.bebold.digital.recommender.bbrecommenderbe.Model.Recommendation;
import be.bebold.digital.recommender.bbrecommenderbe.Model.ToolDetailedInfo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;

class RecommendationMapperTest {

    private RecommendationMapper recommendationMapper;
    private Recommendation recommendation;
    private List<Recommendation> recommendationList;

    @BeforeEach
    void setUp() {
        this.recommendationMapper = new RecommendationMapper();

        String[] features = { "Email Marketing", "Marketing Automation" };
        FilterOptions filterOptions = new FilterOptions(1L,200,true,100,1000, features,"Low","High","Point & click","in House");

        ToolDetailedInfo toolInfo = new ToolDetailedInfo(1L,"Activecampaign","Description","https://www.activecampaign.com/");
        Date date = Date.valueOf("2020-12-12");

        this.recommendation = new Recommendation(1L,"2954baf6-db43-4828-a82d-8c3f71515bff","Rudy De Bolder",date ,"Activecampaign","BeBold", filterOptions,toolInfo);   
    }


    @Test
    void testMapRecommendationToRecommendationDTO() {

        RecommendationDTO recommendationDTO = this.recommendationMapper.mapRecommendationToRecommendationDTO(this.recommendation);

        assertEquals(this.recommendation.getId(), recommendationDTO.getId());
        assertEquals(this.recommendation.getUid(), recommendationDTO.getUid());
        assertEquals(this.recommendation.getCreator(), recommendationDTO.getCreator());
        assertEquals(this.recommendation.getDate(), recommendationDTO.getDate());
        assertEquals(this.recommendation.getToolName(), recommendationDTO.getToolName());
        assertEquals(this.recommendation.getCompanyName(), recommendationDTO.getCompanyName());
    }

    @Test
    void testMapRecommendationToDetailedRecommendationDTO() {

        Optional<Recommendation> optionalRecommendation = Optional.of(this.recommendation);

        ToolDetailedInfoDTO toolDetailedInfoDTO = new ToolDetailedInfoDTO(optionalRecommendation.get().getToolInfo().getId(), optionalRecommendation.get().getToolInfo().getToolDescription(), optionalRecommendation.get().getToolInfo().getToolVideoUrl());

        DetailedRecommendationDTO detailedRecommendationDTO = this.recommendationMapper.mapRecommendationToDetailedRecommendationDTO(optionalRecommendation);

        assertEquals(optionalRecommendation.get().getId(), detailedRecommendationDTO.getId());
        assertEquals(optionalRecommendation.get().getToolName(), detailedRecommendationDTO.getToolName());
        assertEquals(optionalRecommendation.get().getCompanyName(), detailedRecommendationDTO.getCompanyName());
        assertEquals(optionalRecommendation.get().getFilterOptions(), detailedRecommendationDTO.getFilterOptions());
        assertEquals(toolDetailedInfoDTO, detailedRecommendationDTO.getToolInfo());
    }

    @BeforeEach
    void setUpList(){

        this.recommendationList = new ArrayList<>(3);

        for (int i = 1; i <= recommendationList.size(); i++) {
            String[] features = {"Feature 1", "Feature 2"};
       
            FilterOptions filterOptions =new FilterOptions(i,200,true,100,1000, features,"Low","High","Point & click","in House");

            ToolDetailedInfo toolInfo = new ToolDetailedInfo(i, "Tool " + i, "Description " + i, "https://www.tool" + i + ".com");
            Date date = Date.valueOf("2022-01-0" + i);
        
            this.recommendationList.add(new Recommendation(i, "uid" + i, "Creator " + i, date, "Tool " + i, "Company " + i, filterOptions, toolInfo));
        }
    }

    @Test
    void mapListMarketingToolToRecommendationDTO() {

        List<RecommendationDTO> recommendationDTO = this.recommendationMapper.mapListMarketingToolToRecommendationDTO(this.recommendationList);

        for (int i = 0; i < recommendationDTO.size(); i++) {
            assertEquals(this.recommendationList.get(i).getId(), recommendationDTO.get(i).getId());
            assertEquals(this.recommendationList.get(i).getUid(), recommendationDTO.get(i).getUid());
            assertEquals(this.recommendationList.get(i).getCreator(), recommendationDTO.get(i).getCreator());
            assertEquals(this.recommendationList.get(i).getDate(), recommendationDTO.get(i).getDate());
            assertEquals(this.recommendationList.get(i).getToolName(), recommendationDTO.get(i).getToolName());
            assertEquals(this.recommendationList.get(i).getCompanyName(), recommendationDTO.get(i).getCompanyName());
        }
    }
}