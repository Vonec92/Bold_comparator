package be.bebold.digital.recommender.bbrecommenderbe.Services.mapper;

import org.junit.jupiter.api.Test;

import be.bebold.digital.recommender.bbrecommenderbe.Dtos.UpdateDTO.ToolDataDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Model.MarketingTool;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class ToolDataMapperTest {

    private ToolDataMapper toolDataMapper;
    private MarketingTool mockMarketingTool;

    
    @BeforeEach
    void setUp() {

        this.toolDataMapper =  new ToolDataMapper();
        String[] features = { "Email Marketing", "Marketing Automation" };

       this.mockMarketingTool =  new MarketingTool(1L,"ActiveCampaign",200,true,100,1,features,"Low","High","Point & click","in House",10.0);

    }

    @Test
    void testMapMarketingToolToToolDataDTO() {

        ToolDataDTO toolDataDTO = this.toolDataMapper.mapMarketingToolToToolDataDTO(this.mockMarketingTool);

        assertEquals(this.mockMarketingTool.getId(), toolDataDTO.getId());
        assertEquals(this.mockMarketingTool.getBudget(), toolDataDTO.getBudget());
        assertEquals(this.mockMarketingTool.getHasFreeTrial(), toolDataDTO.getHasFreeTrial());
        assertEquals(this.mockMarketingTool.getEmailsPerMonth(), toolDataDTO.getEmailsPerMonth());
        assertEquals(this.mockMarketingTool.getContacts(), toolDataDTO.getContacts());
        assertArrayEquals(this.mockMarketingTool.getFeatures(), toolDataDTO.getFeatures());
        assertEquals(this.mockMarketingTool.getLevelOfSupport(), toolDataDTO.getLevelOfSupport());
        assertEquals(this.mockMarketingTool.getDbQuality(), toolDataDTO.getDbQuality());
        assertEquals(this.mockMarketingTool.getHasDragAndDrop(), toolDataDTO.getHasDragAndDrop());

        
    }
}