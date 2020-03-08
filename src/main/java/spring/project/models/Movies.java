package spring.project.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import spring.project.utilities.validator.ValidateLength;

@Document(collection = "movies")
@ApiModel(description="Model Class Of Movies")
public class Movies {
	
	private static final long serialVersionUID = 1L;
	@Id
	public Object _id;
	@ValidateLength(minlength=6, maxlength=15)
	String director_name;
	String reviews;
	String duration;
	String likes;
	long gross;
	String genres;
	String actor;
	String movie_title;
	String voted_users;
	String language;
	String country;
	@Max(value=999)
	long budget;
	@NotEmpty
	@ApiModelProperty(required=true, dataType="String")
	String year;
	double rating;
	
	public Movies()
	{
	   	
	}

	public Movies(Object _id, String director_name, String reviews, String duration, String likes, long gross,
			String genres, String actor, String movie_title, String voted_users, String language, String country,
			long budget, String year, double rating) {
		super();
		this._id = _id;
		this.director_name = director_name;
		this.reviews = reviews;
		this.duration = duration;
		this.likes = likes;
		this.gross = gross;
		this.genres = genres;
		this.actor = actor;
		this.movie_title = movie_title;
		this.voted_users = voted_users;
		this.language = language;
		this.country = country;
		this.budget = budget;
		this.year = year;
		this.rating = rating;
	}

	public Object get_id() {
		return _id.toString();
	}

	public void set_id(Object _id) {
		this._id = _id;
	}

	public String getDirector_name() {
		return director_name;
	}

	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public long getGross() {
		return gross;
	}

	public void setGross(long gross) {
		this.gross = gross;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getactor() {
		return actor;
	}

	public void setactor(String actor) {
		this.actor = actor;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public String getVoted_users() {
		return voted_users;
	}

	public void setVoted_users(String voted_users) {
		this.voted_users = voted_users;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getBudget() {
		return budget;
	}

	public void setBudget(long budget) {
		this.budget = budget;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getrating() {
		return rating;
	}

	public void setrating(double rating) {
		this.rating = rating;
	}

}