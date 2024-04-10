package be.bebold.digital.recommender.bbrecommenderbe.Services;

import be.bebold.digital.recommender.bbrecommenderbe.Dtos.UpdateDTO.ToolDataDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Model.MarketingTool;
import be.bebold.digital.recommender.bbrecommenderbe.Repositories.MarketingToolRepository;
import be.bebold.digital.recommender.bbrecommenderbe.Services.Values.FeatureValuesTools;
import be.bebold.digital.recommender.bbrecommenderbe.Services.Values.StringValues;
import be.bebold.digital.recommender.bbrecommenderbe.Services.Values.ThresholdValues;
import be.bebold.digital.recommender.bbrecommenderbe.Services.Values.WeightValues;
import be.bebold.digital.recommender.bbrecommenderbe.Services.mapper.ToolDataMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class RecommendationServiceTest {

    @Mock
    private MarketingToolRepository marketingToolRepository;
    @Mock
    private RatingCalculatorService ratingCalculatorService;
    @Mock
    private ThresholdValues thresholdValues;
    @Mock
    private WeightValues weightValues;
    @Mock
    private ToolDataMapper toolDataMapper;
    @Mock
    private Iterable<MarketingTool> marketingToolsList;
    @Mock
    private MarketingTool marketingTool;
    @Mock
    private StringValues stringValues;
    @Mock
    private FeatureValuesTools featureValuesTools;

    @InjectMocks
    private RecommendationService recommendationService;

    List<MarketingTool> marketingTools;

    private ToolDataDTO toolData;
    private String[] features;



    @BeforeEach
    public void setup(){
        this.marketingTools = new ArrayList<>();
        this.features = new String[]{"Email marketing", "Leadscoring"};
        MarketingTool tool1 = new MarketingTool(1L,"MailerLite", 200, true ,100,1000, features,"Basic", "high", "Point & click","in House", 4.0);

        MarketingTool tool2 = new MarketingTool(2L,"SendInBlue", 2100, false ,1000,10000, features,"Basic", "high", "Point & click","in House", 8.0);

        marketingTools.add(tool1);
        marketingTools.add(tool2);
    }

    @Test
    void testCalculateRecommendedToolForUserInputIsInital() {


        this.toolData = new ToolDataDTO(1L, 200, true ,100,1000, features,"Basic", "high", "Point & click", "in House");

        String toolName = this.recommendationService.CalculateRecommendedToolForUserInput(this.toolData, marketingTools);

        assertEquals("MailerLite", toolName);

    }

    @Test
    void testCalculateRecommendedToolForUserInputIsNull() {

        this.toolData = new ToolDataDTO();

        String toolName = this.recommendationService.CalculateRecommendedToolForUserInput(this.toolData, marketingTools);

        assertEquals("MailerLite" , toolName);

    }

    @Test
    public void testUpdateCalculatedScoreForMarketingTools() {

        List<MarketingTool> mockTools = new ArrayList<>();
        MarketingTool tool1 = new MarketingTool();
        tool1.setId(1L);
        tool1.setToolName("MailerLite");
        tool1.setBudget(200);
        mockTools.add(tool1);

        MarketingTool tool2 = new MarketingTool();
        tool2.setId(2L);
        tool2.setToolName("SendInBlue");
        tool2.setBudget(500);
        mockTools.add(tool2);

        // Mock the findAll method of the repository to return the list of mock tools
        when(marketingToolRepository.findAll()).thenReturn(mockTools);

        // Mock the mapMarketingToolToToolDataDTO method of the mapper to return a ToolDataDTO
        when(toolDataMapper.mapMarketingToolToToolDataDTO(any(MarketingTool.class))).thenReturn(new ToolDataDTO());

        // Call the method to be tested
        recommendationService.updateCalculatedScoreForMarketingTools();

        // Verify that the save method of the repository was called for each tool in the list
        verify(marketingToolRepository, times(2)).save(any(MarketingTool.class));

    }
}

