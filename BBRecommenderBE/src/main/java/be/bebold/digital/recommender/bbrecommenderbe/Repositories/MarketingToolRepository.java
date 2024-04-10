package be.bebold.digital.recommender.bbrecommenderbe.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import be.bebold.digital.recommender.bbrecommenderbe.Model.MarketingTool;

/***
 * Repository for the MarketingTool enity class
 * @author [Baeten Jens]
 * @version 1.0
 */
public interface MarketingToolRepository extends CrudRepository<MarketingTool, Long>{ 

    List<MarketingTool> findAll();

}
