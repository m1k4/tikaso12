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
    public Iterable<Movie> list() {
        return movieRepository.findAll();
    }
 
    @Override
    @Transactional
    public void add(String name) {
        name = StringEscapeUtils.escapeHtml4(name);
         
        Movie movie = new Movie();
        movie.setName(name);
        
        movieRepository.save(movie);
    }
 
    @Override
    @Transactional
    public void remove(Long movieId) {
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
    public Movie findById(Long id) {
        return movieRepository.findOne(id);
    }

    @Override
    public void update(Long id, String name, String ohjaaja, String genre, int vuosi, double kesto) {
        Movie movie = findById(id);
        
        movie.setName(name);
        movie.setOhjaaja(ohjaaja);
        movie.setGenre(genre);
        movie.setVuosi(vuosi);
        movie.setLengthInMinutes(kesto);
        
        movieRepository.save(movie);
    }

}
