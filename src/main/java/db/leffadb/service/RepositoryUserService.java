/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import db.leffadb.domain.User;
import db.leffadb.domain.Movie;
import db.leffadb.repository.UserRepository;
import db.leffadb.repository.MovieRepository;
import java.util.List;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author m1k4
 */
@Service
public class RepositoryUserService implements UserService {
 
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;
 
    @Override
    public Iterable<User> list() {
        return userRepository.findAll();
    }
 
    @Override
    @Transactional
    public Long add(String name, String password) {
        name = StringEscapeUtils.escapeHtml4(name);
         
        User user = new User();
        user.setName(name);
        user.setPassword(password);
 
        userRepository.save(user);
        
        return user.getId();
    }
 
    @Override
    @Transactional
    public void remove(Long userId) {
        User user = userRepository.findOne(userId);
        for (Movie movie : user.getMovies()) {
            movie.getusers().remove(user);
        }
 
        userRepository.delete(userId);
    }
 
    @Override
    @Transactional
    public void adduserToMovie(Long userId, Long movieId) {
        User user = userRepository.findOne(userId);
        Movie movie = movieRepository.findOne(movieId);
 
        user.getMovies().add(movie);
        movie.getusers().add(user);
    }
 
    @Override
    public User findById(Long userId) {
        return userRepository.findOne(userId);
    }    
}
