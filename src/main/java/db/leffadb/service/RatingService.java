/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import db.leffadb.domain.Movie;
import db.leffadb.domain.Rating;
import db.leffadb.domain.User;
import java.util.List;

/**
 *
 * @author m1k4
 */
public interface RatingService {
    Rating create(Rating rating);
    Rating findById(Long id);
    List<Rating> findByUser(User user);
    Rating findByUserAndMovie(User user, Movie movie);
    void update(Rating rating);
    void delete(Rating rating);
    List<Rating> findAll();
    
}
