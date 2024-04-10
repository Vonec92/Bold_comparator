package be.bebold.digital.recommender.bbrecommenderbe.Repositories;

import org.springframework.data.repository.CrudRepository;

import be.bebold.digital.recommender.bbrecommenderbe.Model.ToolDetailedInfo;


/***
 * Repository for the ToolDetailedInfo entity class
 * @author [Baeten Jens]
 * @version 1.0
 */
public interface ToolInfoRepository extends CrudRepository<ToolDetailedInfo, Long> {

    /***
     * Finds a toolDetailedInfo by its toolName
     * @param toolName the toolName of the toolDetailedInfo
     * @return ToolDetailedInfo the toolDetailedInfo with the given toolName
     */
    ToolDetailedInfo findByToolName(String toolName);
}
