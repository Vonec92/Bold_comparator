package be.bebold.digital.recommender.bbrecommenderbe.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToolDetailedInfoTest {

    @Test
    void getAndSetId() {
        ToolDetailedInfo toolDetailedInfo = new ToolDetailedInfo();
        toolDetailedInfo.setId(1L);
        assertEquals(1L, toolDetailedInfo.getId());
    }

    @Test
    void getAndSetToolName() {
        ToolDetailedInfo toolDetailedInfo = new ToolDetailedInfo();
        toolDetailedInfo.setToolName("Activecampaign");
        assertEquals("Activecampaign", toolDetailedInfo.getToolName());
    }

    @Test
    void getAndSetToolDescription() {
        ToolDetailedInfo toolDetailedInfo = new ToolDetailedInfo();
        toolDetailedInfo.setToolDescription("Activecampaign is a marketing automation platform.");
        assertEquals("Activecampaign is a marketing automation platform.", toolDetailedInfo.getToolDescription());
    }

    @Test
    void getAndSetToolVideoUrl() {
        ToolDetailedInfo toolDetailedInfo = new ToolDetailedInfo();
        toolDetailedInfo.setToolVideoUrl("https://www.youtube.com/watch?v=1");
        assertEquals("https://www.youtube.com/watch?v=1", toolDetailedInfo.getToolVideoUrl());
    }

    @Test
    void testToString() {
        ToolDetailedInfo toolDetailedInfo = new ToolDetailedInfo();
        toolDetailedInfo.setId(1L);
        toolDetailedInfo.setToolName("Activecampaign");
        toolDetailedInfo.setToolDescription("Activecampaign is a marketing automation platform.");
        toolDetailedInfo.setToolVideoUrl("https://www.youtube.com/watch?v=1");
        assertEquals("ToolDetailedInfo(id=1, toolName=Activecampaign, toolDescription=Activecampaign is a marketing automation platform., toolVideoUrl=https://www.youtube.com/watch?v=1)", toolDetailedInfo.toString());
    }
}