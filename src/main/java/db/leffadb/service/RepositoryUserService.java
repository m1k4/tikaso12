/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import db.leffadb.domain.Movie;
import db.leffadb.domain.User;
import db.leffadb.repository.MovieRepository;
import db.leffadb.repository.UserRepository;
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
    @Transactional(readOnly = true)
    public Iterable<User> list() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public User create(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        userRepository.save(user);

        return user;
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long userId) {
        User user = userRepository.findOne(userId);
        for (Movie movie : user.getMovies()) {
            movie.getUsers().remove(user);
        }

        userRepository.delete(userId);
    }

    @Override
    @Transactional(readOnly = false)
    public void adduserToMovie(Long userId, Long movieId) {
        User user = userRepository.findOne(userId);
        Movie movie = movieRepository.findOne(movieId);

        user.getMovies().add(movie);
        movie.getUsers().add(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void removeUserFromMovie(Long userId, Long movieId) {
        User user = userRepository.findOne(userId);
        Movie movie = movieRepository.findOne(movieId);

        user.getMovies().remove(movie);
        movie.getUsers().remove(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByName(String name) {
        for (User user : list()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkLogin(String name, String password) {
        for (User user : list()) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
