package be.bebold.digital.recommender.bbrecommenderbe.Dtos.ReadDTO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToolDetailedInfoDTOTest {


    @Test
    void getId() {
        ToolDetailedInfoDTO toolDetailedInfoDTO = new ToolDetailedInfoDTO();
        Long id = 1L;
        toolDetailedInfoDTO.setId(id);
        assertEquals(id, toolDetailedInfoDTO.getId());
    }

    @Test
    void getToolDescription() {
        ToolDetailedInfoDTO toolDetailedInfoDTO = new ToolDetailedInfoDTO();
        String toolDescription = "toolDescription";
        toolDetailedInfoDTO.setToolDescription(toolDescription);
        assertEquals(toolDescription, toolDetailedInfoDTO.getToolDescription());
    }

    @Test
    void getToolVideoUrl() {
        ToolDetailedInfoDTO toolDetailedInfoDTO = new ToolDetailedInfoDTO();
        String toolVideoUrl = "www.youtube.com";
        toolDetailedInfoDTO.setToolVideoUrl(toolVideoUrl);
        assertEquals(toolVideoUrl, toolDetailedInfoDTO.getToolVideoUrl());
    }

    @Test
    void testToStringFullArgs(){
        ToolDetailedInfoDTO toolDetailedInfoDTO = new ToolDetailedInfoDTO(1L,"www.youtube.com","toolDescription");

        String expected = "ToolDetailedInfoDTO(id=1, toolDescription=www.youtube.com, toolVideoUrl=toolDescription)";
        assertEquals(expected, toolDetailedInfoDTO.toString());

    }

    @Test
    void testToStringSetters() {
        ToolDetailedInfoDTO toolDetailedInfoDTO = new ToolDetailedInfoDTO();
        Long id = 1L;
        String toolVideoUrl = "www.youtube.com";
        String toolDescription = "toolDescription";

        toolDetailedInfoDTO.setId(id);
        toolDetailedInfoDTO.setToolDescription(toolDescription);
        toolDetailedInfoDTO.setToolVideoUrl(toolVideoUrl);

        String expected = "ToolDetailedInfoDTO(id=1, toolDescription=toolDescription, toolVideoUrl=www.youtube.com)";
        assertEquals(expected, toolDetailedInfoDTO.toString());
    }
}