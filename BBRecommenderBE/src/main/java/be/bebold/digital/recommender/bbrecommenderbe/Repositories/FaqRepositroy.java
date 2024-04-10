package be.bebold.digital.recommender.bbrecommenderbe.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import be.bebold.digital.recommender.bbrecommenderbe.Model.Faq;

/***
 * Repository for the FAQ enity class
 * @author [Baeten Jens]
 * @version 1.0
 */


public interface FaqRepositroy extends CrudRepository<Faq, Long>{

    List<Faq> findAll();
}
