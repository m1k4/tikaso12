/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import db.leffadb.domain.Movie;
import db.leffadb.domain.Rating;
import db.leffadb.domain.User;
import db.leffadb.repository.RatingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author m1k4
 */
@Service
public class RepositoryRatingService implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    @Transactional(readOnly = false)
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    @Transactional(readOnly = true)
    public Rating findById(Long id) {
        return ratingRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rating> findByUser(User user) {
        return ratingRepository.findByUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Rating findByUserAndMovie(User user, Movie movie) {
        return ratingRepository.findByUserAndMovie(user, movie);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Rating rating) {
        ratingRepository.delete(rating);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }
}
