/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import db.leffadb.domain.User;
import db.leffadb.domain.Movie;
import db.leffadb.repository.UserRepository;
import db.leffadb.repository.MovieRepository;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author m1k4
 */
@Service
public class RepositoryMovieService implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Movie> list() {
        return movieRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void create(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long movieId) {
        Movie movie = movieRepository.findOne(movieId);
        for (User user : movie.getUsers()) {
            user.getMovies().remove(movie);
        }

        movieRepository.delete(movie);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Movie> listMoviesWithout(Long userId) {
        User user = userRepository.findOne(userId);
        return movieRepository.findMoviesWithoutUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Movie findById(Long id) {
        return movieRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Iterable<Movie> findByName(String name) {
        return movieRepository.findByName(name);
    }


}
