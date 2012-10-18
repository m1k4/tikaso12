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
public interface MovieService extends ServiceInterface<Movie> {

    Iterable<Movie> findByName(String name);

    Iterable<Movie> listMoviesWithoutUser(Long userId);
}
