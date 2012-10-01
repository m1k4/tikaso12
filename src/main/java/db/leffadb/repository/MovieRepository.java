/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.repository;

import db.leffadb.domain.Movie;
import db.leffadb.domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author m1k4
 */
public interface MovieRepository extends CrudRepository<Movie, Long> {

    @Query("SELECT movie FROM MOVIE movie WHERE :user NOT MEMBER OF movie.users")
    List<Movie> findMoviesWithoutUser(@Param("user") User user);
}