package be.bebold.digital.recommender.bbrecommenderbe.Controllers;

import be.bebold.digital.recommender.bbrecommenderbe.Dtos.UpdateDTO.ToolDataDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Model.MarketingTool;
import be.bebold.digital.recommender.bbrecommenderbe.Model.Recommendation;
import be.bebold.digital.recommender.bbrecommenderbe.Model.ToolDetailedInfo;
import be.bebold.digital.recommender.bbrecommenderbe.Payload.Responses.RecommendedToolNameResponse;
import be.bebold.digital.recommender.bbrecommenderbe.Payload.Responses.ResponseMessage;
import be.bebold.digital.recommender.bbrecommenderbe.Repositories.MarketingToolRepository;
import be.bebold.digital.recommender.bbrecommenderbe.Repositories.RecommendationRepository;
import be.bebold.digital.recommender.bbrecommenderbe.Repositories.ToolInfoRepository;
import be.bebold.digital.recommender.bbrecommenderbe.Services.RecommendationService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class RecommendationControllerTest {


    @InjectMocks
    private RecommendationController recommendationController;

    @Mock
    private RecommendationRepository recommendationRepository;

    @Mock
    private ToolInfoRepository toolInfoRepository;

    @Mock
    private RecommendationService recommendationService;

    @Mock
    private MarketingToolRepository marketingToolRepository;

    @Mock
    private ObjectMapper objectMapper;

    @Test
    public void testAddRecommendedTool() {

        String toolName = "MailerLite";

        Recommendation recommendation = new Recommendation();
        recommendation.setToolName(toolName);

        ToolDetailedInfo toolInfo = new ToolDetailedInfo();
        toolInfo.setToolName(toolName);

        // mock the findAll method to return a list containing the toolInfo object
        when(toolInfoRepository.findAll()).thenReturn(Collections.singletonList(toolInfo));

        // mock the findByToolName method to return the toolInfo object
        when(toolInfoRepository.findByToolName(toolName)).thenReturn(toolInfo);

        // call the controller method and verify the result
        ResponseEntity<?> response = recommendationController.addRecommendedTool(recommendation);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Tool saved successfully", ((ResponseMessage) response.getBody()).getMessage());

        verify(toolInfoRepository).findAll();
        verify(toolInfoRepository).findByToolName(toolName);
        verify(recommendationRepository).save(recommendation);
    }

    @Test
    public void testAddRecommendedTool_errorSavingRecommendationList() {
        // // create a new Recommendation to add
        Recommendation recommendation = new Recommendation();
        recommendation.setToolName("Tool 1");
         when(recommendationRepository.save(any())).thenThrow(new RuntimeException("error saving saving recommendation list"));

         // call the controller method and verify the error response
         ResponseEntity<?> response = recommendationController.addRecommendedTool(recommendation);
         assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
         assertEquals("Invalid tool name", ((ResponseMessage) response.getBody()).getMessage());
        
    }

    @Test
    public void testAddRecommendedTool_savingUnkown() {
        // // create a new Recommendation to add
        Recommendation recommendation = new Recommendation();
        recommendation.setToolName("unknown");
        when(recommendationRepository.save(any())).thenThrow(new RuntimeException("error saving saving recommendation list"));

        // call the controller method and verify the error response
        ResponseEntity<?> response = recommendationController.addRecommendedTool(recommendation);
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
        assertEquals("Invalid tool name", ((ResponseMessage) response.getBody()).getMessage());

    }

    @Test
    public void testGetRecommendationForUserInputWithCacheNull()throws Exception  {

        String[] features = { "Email Marketing", "Marketing Automation" };

        ToolDataDTO userInput= new ToolDataDTO(1L,200,true,100,1221,features,"Low","High","Drag & drop", "in House");
        MarketingTool marketingMockTool = new MarketingTool(1L,"MailerLite",20,true,100,1221,features,"Low","High","Drag & drop","in House",10.0);

        RecommendedToolNameResponse wantedResponse =  new RecommendedToolNameResponse("MailerLite");
        String cachedToolData = null;

        List<MarketingTool> mockTools = new ArrayList<>();
        mockTools.add(marketingMockTool);

        // mock the behavior of the marketingToolRepository.findAll() method to return the mockTools list
        when(marketingToolRepository.findAll()).thenReturn(mockTools);

        // mock the CalculateRecommendedToolForUserInput method to return a tool name
        when(recommendationService.CalculateRecommendedToolForUserInput(userInput, mockTools)).thenReturn(wantedResponse.getToolName());

        ResponseEntity<?> response = recommendationController.getRecommendationForUserInput(userInput, cachedToolData);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        RecommendedToolNameResponse responseBody = (RecommendedToolNameResponse) response.getBody();
        assertEquals(wantedResponse.getToolName(), responseBody.getToolName());

        verify(marketingToolRepository).findAll();
        verify(recommendationService).CalculateRecommendedToolForUserInput(userInput,mockTools);
    }

    @Test
    public void testGetRecommendationForUserInputWithCacheNotNull() throws Exception {

        String[] features = {"Email Marketing", "Marketing Automation"};

        ToolDataDTO userInput = new ToolDataDTO(1L,200,true,100,1221,features,"Low","High","Drag & drop","in House");

        RecommendedToolNameResponse wantedResponse = new RecommendedToolNameResponse("MailerLite");

        List<MarketingTool> mockTools = new ArrayList<>();
        MarketingTool marketingMockTool = new MarketingTool(1L,"MailerLite",120,false,1200,234,null,null,"High","Point & click","in House",1.0);
        mockTools.add(marketingMockTool);

        // set up a cache with a single value that matches the input tool data
        String cachedToolData = "[{\"id\":1,\"toolName\":\"MailerLite\",\"budget\":200,\"hasFreeTrial\":true,\"countOfUsers\":100,\"contracts\":1,\"companySize\":1,\"industryType\":\"Manufacturing\",\"features\":[\"Email Marketing\",\"Marketing Automation\"],\"levelOfCustomazion\":\"Low\",\"levelOfSupport\":\"High\",\"hasCrmIntegration\":true,\"goals\":[\"Lead Generation\",\"Customer Retention\"],\"dbQuality\":\"High\",\"hasTransactionalEmail\":true,\"hasCommercialEmail\":true,\"easeOfUse\":\"Easy\",\"hasDragAndDrop\":true,\"hasGoogleAnalytics\":true,\"additionaAddOns\":[\"Google Analytics\",\"Google Ads\"],\"cookies\":[\"first_party\",\"third_party\"]}]";

        // mock the behavior of the objectMapper.readValue() method to return the mockTools list
        when(objectMapper.readValue(eq(cachedToolData), any(TypeReference.class))).thenReturn(mockTools);

        // mock the CalculateRecommendedToolForUserInput method to return a tool name
        when(recommendationService.CalculateRecommendedToolForUserInput(userInput, mockTools)).thenReturn(wantedResponse.getToolName());

        ResponseEntity<?> response = recommendationController.getRecommendationForUserInput(userInput, cachedToolData);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        RecommendedToolNameResponse responseBody = (RecommendedToolNameResponse) response.getBody();
        assertEquals(wantedResponse.getToolName(), responseBody.getToolName());

        verify(objectMapper).readValue(eq(cachedToolData), any(TypeReference.class));
        verify(recommendationService).CalculateRecommendedToolForUserInput(userInput,mockTools);

    }

    @Test
    public void testGetAllMarketingToolsData() {

        
        // create mock data to be returned by the repository
        List<MarketingTool> mockTools = new ArrayList<>();
        mockTools.add(new MarketingTool(1L,"MailerLite",120,false,1200,234,null,null,"High","Drag & drop","in House",1.0));
        mockTools.add(new MarketingTool(2L,"HubSpot",100,true,200,2,null,null,"High","Point & click","in House",3.0));

        // mock the behavior of the marketingToolRepository.findAll() method to return the mockTools list
        when(marketingToolRepository.findAll()).thenReturn(mockTools);

        // call the controller method
        List<MarketingTool> response = recommendationController.getAllMarketingToolsData();

        // assert that the response is the same as the mockTools list
        assertEquals(mockTools, response);

        verify(marketingToolRepository).findAll();
    }

}
