package be.bebold.digital.recommender.bbrecommenderbe.Services.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import be.bebold.digital.recommender.bbrecommenderbe.Dtos.UpdateDTO.ToolDataDTO;
import be.bebold.digital.recommender.bbrecommenderbe.Model.MarketingTool;

/***
 * Mapper for that maps marketingTool class to toolDataDTO class and vice versa
 */
@Service
public class ToolDataMapper {

    /***
     * ModelMapper that maps the marketingTool to the toolDataDTO
     */
    private ModelMapper modelMapper = new ModelMapper();

    /***
        * Maps a marketingTool to a toolDataDTO
        * @param marketingTool the marketingTool that needs to be mapped
        * @return ToolDataDTO the mapped toolDataDTO
        * @author [Baeten Jens]
    */
    public ToolDataDTO mapMarketingToolToToolDataDTO(MarketingTool marketingTool) {

        return modelMapper.map(marketingTool, ToolDataDTO.class);
    }
}
