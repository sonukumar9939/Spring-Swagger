package spring.project.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import spring.project.models.Movies;

public interface MoviesRepository extends MongoRepository<Movies, String> {
	//Movies findBy_id(ObjectId _id);
	Movies findBy_id(String id);

	List<Movies> findAll();

	List<Movies> findByCountry(String country);

	List<Movies> findByGrossGreaterThan(long value);

	List<Movies> findByRatingGreaterThan(double value);
	//List<Movies> findByBudgetGretaerThan(int value);
	// List<Movies> findTop10ByGross(long gross);
	List<Movies> findByActor(String name);
	

}
