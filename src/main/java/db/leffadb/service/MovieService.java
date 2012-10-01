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
    void create(String name);
    void update(Long id, String name, String ohjaaja, String genre, int vuosi, double kesto);
    Movie findById(Long id);
    void delete(Long movieId);
    Iterable<Movie> listMoviesWithout(Long userId);
}
