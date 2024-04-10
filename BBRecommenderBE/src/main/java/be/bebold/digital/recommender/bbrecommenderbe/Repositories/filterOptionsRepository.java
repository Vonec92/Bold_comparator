package be.bebold.digital.recommender.bbrecommenderbe.Repositories;

import org.springframework.data.repository.CrudRepository;

import be.bebold.digital.recommender.bbrecommenderbe.Model.FilterOptions;

/***
 * Repository for the filterOptions enity class
 * @author [Baeten Jens]
 * @version 1.0
 */
public interface filterOptionsRepository extends CrudRepository<FilterOptions, Long>{ }
