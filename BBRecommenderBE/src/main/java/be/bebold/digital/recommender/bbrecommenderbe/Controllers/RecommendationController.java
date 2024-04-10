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

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * REST controller for handling requests related to recommendations.
 * 
 * @author Baeten Jens
 * @version 1.0
 */
@RestController
public class RecommendationController {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private ToolInfoRepository toolInfoRepository;

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private MarketingToolRepository marketingToolRepository;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Handles HTTP POST requests to add a new {@link Recommendation} object to the database.
     *
     * @param recommendation the Recommendation object to be added.
     * @return a ResponseEntity containing a ResponseMessage indicating success or failure of the request.
     */
    @PostMapping("/recommendedtool")
    public ResponseEntity<?> addRecommendedTool(@RequestBody Recommendation recommendation)  {

        try {

            List<ToolDetailedInfo> toolInfoList = (List<ToolDetailedInfo>) toolInfoRepository.findAll();
            System.out.println(toolInfoList);
        
            // check if the tool name exists in the tool info table
            boolean toolNameExists = toolInfoList.stream()
                                                 .anyMatch(toolInfo -> toolInfo.getToolName().equals(recommendation.getToolName()));

            if (!toolNameExists) {
                throw new IllegalArgumentException("Invalid tool name");
            }

            // tool name is unique so we can use it to find the tool info in the toolinfo
            // table
            // before saving the recommation to the database we first set the
            // tooldetailedinfo (name,descript, video, etc) to the recommendation to link
            // tables together
            ToolDetailedInfo toolInfo = toolInfoRepository.findByToolName(recommendation.getToolName());
            recommendation.setToolInfo(toolInfo);
            
            recommendationRepository.save(recommendation);

            return ResponseEntity
                    .ok(new ResponseMessage("Tool saved successfully", HttpStatus.OK, HttpStatus.OK.value()));

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.unprocessableEntity().body(new ResponseMessage(e.getMessage(),
                    HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value()));
        }
    }

    /**
     * Handles HTTP POST requests to calculate the recommended tool for a given user
     * input.
     * 
     * @param userInput      the user input for which the recommended tool needs to
     *                       be calculated.
     * @param cachedToolData the cached marketing tool data in JSON format, if
     *                       available.
     * @return a ResponseEntity containing a {@link RecommendedToolNameResponse}
     *         object indicating the recommended tool.
     * @throws JsonMappingException    if there is an issue with mapping the cached
     *                                 marketing tool data from JSON to object.
     * @throws JsonProcessingException if there is an issue with processing the
     *                                 cached marketing tool data.
     */

    @PostMapping("/calculateRecommendedTool")
    public ResponseEntity<?> getRecommendationForUserInput(@RequestBody ToolDataDTO userInput,
            @RequestHeader(value = "cached_ma_data", required = false) String cachedToolData)
            throws JsonMappingException, JsonProcessingException {

        List<MarketingTool> marketingTools = null;
        // if the cache is empty, then get all the marketing tools from the database
        if (cachedToolData == null)
            marketingTools = marketingToolRepository.findAll();
        else
            // if the cache is not empty, then get the marketing tools from the cache and
            // map form JSON to OBJECT
            marketingTools = objectMapper.readValue(cachedToolData, new TypeReference<List<MarketingTool>>() {
            });

        // calculate recommended tool for input and return tool name
        String toolName = recommendationService.CalculateRecommendedToolForUserInput(userInput, marketingTools);

        return ResponseEntity.ok(new RecommendedToolNameResponse(toolName));

    }

    /**
     * Handles HTTP GET requests to retrieve all MarketingTool objects from the
     * database.
     * 
     * @return a list of all {@link MarketingTool} objects.
     */
    @GetMapping("/GetAllMarketingTools")
    public List<MarketingTool> getAllMarketingToolsData() {
        List<MarketingTool> marketingTools = marketingToolRepository.findAll();
        return marketingTools;
    }
}