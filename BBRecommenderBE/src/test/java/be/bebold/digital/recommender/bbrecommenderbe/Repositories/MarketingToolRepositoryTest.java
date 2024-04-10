package be.bebold.digital.recommender.bbrecommenderbe.Repositories;

import be.bebold.digital.recommender.bbrecommenderbe.Model.MarketingTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MarketingToolRepositoryTest {
    private MarketingTool marketingTool;

    @BeforeEach
    public void setUp() {
        String[] features = { "Email Marketing", "Marketing Automation" };
        this.marketingTool =  new MarketingTool(1L,"ActiveCampaign",200,true,100,1,features,"Low","High","Point & click","in House",10.0);


    }
    @Test
    void findAllMarketingTools() {
        List<MarketingTool> marketingTools = new ArrayList<>();

        marketingTools.add(marketingTool);

        MarketingToolRepository marketingToolRepository = mock(MarketingToolRepository.class);
        assertNotNull(when(marketingToolRepository.findAll()).thenReturn(marketingTools));

    }
    @Test
    void findAllMarketingToolsWhenEmpty() {
        List<MarketingTool> marketingTools = new ArrayList<>();

        MarketingToolRepository marketingToolRepository = mock(MarketingToolRepository.class);
        assertNotNull(when(marketingToolRepository.findAll()).thenReturn(marketingTools));
    }



}