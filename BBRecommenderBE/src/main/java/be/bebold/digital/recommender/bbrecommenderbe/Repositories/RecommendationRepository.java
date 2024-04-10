package be.bebold.digital.recommender.bbrecommenderbe.Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import be.bebold.digital.recommender.bbrecommenderbe.Model.Recommendation;


/***
 * Repository for the Recommendation enity class
 * @author [Baeten Jens]
 * @version 1.0
 */
public interface RecommendationRepository extends CrudRepository<Recommendation, Long> {

    /***
     * Finds all the recommendations with the given uid
     * @param uid the uid of the recommendations
     * @return List {@link Recommendation} all the recommendations with the given uid
     */
    List<Recommendation> findByUid(String uid);

    /***
     * Finds all the recommendations
     * @return List {@link Recommendation}  all the recommendations
     */
    List<Recommendation> findAll();

    /***
     * Finds a recommendation by its id
     * @param id the id of the recommendation
     * @return Recommendation the recommendation with the given id
     */
    Recommendation findById(long id);
    
}
