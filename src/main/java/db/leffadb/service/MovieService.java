/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import db.leffadb.domain.Movie;

/**
 *
 * @author m1k4
 */
public interface MovieService {
    Iterable<Movie> list();
    Iterable<Movie> findByName(String name);
    void create(Movie movie);
    void update(Movie movie);
    Movie findById(Long id);
    void delete(Long movieId);
    Iterable<Movie> listMoviesWithout(Long userId);
}
