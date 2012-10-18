/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import db.leffadb.domain.Entertainment;
import db.leffadb.domain.User;
import db.leffadb.domain.Movie;
import db.leffadb.repository.UserRepository;
import db.leffadb.repository.MovieRepository;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author m1k4
 */
@Service("movieService")
public class JpaMovieService extends RepositoryService<Movie>
        implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void init() {
        setRepository(movieRepository);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long movieId) {
        Movie movie = (Movie) movieRepository.findOne(movieId);
        for (User user : movie.getUsers()) {
            user.getEntertainments().remove(movie);
        }

        movieRepository.delete(movie);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Movie object) {
        Long movieId = object.getId();
        delete(movieId);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Movie> listMoviesWithoutUser(Long userId) {
        User user = userRepository.findOne(userId);
        return movieRepository.findMoviesWithoutUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Movie> findByName(String name) {
        return movieRepository.findByName(name);
    }
}
