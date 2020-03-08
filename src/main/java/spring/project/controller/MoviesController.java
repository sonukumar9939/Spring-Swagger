package spring.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import spring.project.models.Movies;
import spring.project.repositories.MoviesRepository;

@RestController
@RequestMapping("/movies")
@Api(value="Hollywood Movies", description="Operations pertaining to online Movies")
//@ApiIgnore
public class MoviesController {
	
	private final static Logger LOGGER= LoggerFactory.getLogger(MoviesController.class);

	@Autowired
	MoviesRepository repository;
	
	
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

	@RequestMapping(method = RequestMethod.GET, value = "/moviesList")
	@CrossOrigin(origins = "http://localhost:3000")
    @ApiOperation(value = "View a list of available products",response=MoviesController.class)
	public List<Movies> getAllMovies() {
		LOGGER.info("List of all Movies ");
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:3000")
	public Movies getMoviesById(@PathVariable("id") String id) {
		LOGGER.info("Partcular Movie with id " + id);
		return repository.findBy_id(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/country")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Movies> getMoviesByCountrty() {
		LOGGER.info("Movies made in USA");
		return repository.findByCountry("USA");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/gross")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Movies> getMoviesByGross() {
		LOGGER.info("Movies with Gross Income greater than 6 Billion");
		return repository.findByGrossGreaterThan(600000000);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/imdb")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Movies> getMoviesByRating() {
		LOGGER.info("Movies having rating greater than 8");
		return repository.findByRatingGreaterThan(8);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/actor")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Movies> getMoviesByActorName() {
		LOGGER.info("Movies with JOHNNY DEPP");
		return repository.findByActor("Johnny Depp");
	}
	 @ApiOperation(value = "Save movies to DB")
	@RequestMapping(method = RequestMethod.POST, value = "/addUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addMovies(@RequestBody Movies movie) {
		repository.save(movie);
	}

	 @ApiOperation(value = "Update a movie")
		@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void updateMovies(@PathVariable("id") String id, @RequestBody Movies movie) {
			Movies setMovie = repository.findBy_id(id);
			if (setMovie != null) {
				setMovie.setBudget(movie.getBudget());
				setMovie.setrating(movie.getrating());
				setMovie.setCountry(movie.getCountry());
				repository.save(setMovie);
			}
		}
	 //@ApiOperation(value = "Delete a movie")
	@RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
	public void deleteMovie(@PathVariable("id") String id) {
		Movies deleteMovie = repository.findBy_id(id);
		repository.delete(deleteMovie);
	}
}
