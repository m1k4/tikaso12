/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import db.leffadb.domain.Entertainment;
import db.leffadb.domain.Movie;
import db.leffadb.domain.Rating;
import db.leffadb.domain.User;
import db.leffadb.repository.RatingRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author m1k4
 */
@Service
public class JpaRatingService extends RepositoryService<Rating> implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @PostConstruct
    private void init() {
        setRepository(ratingRepository);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rating> findByUser(User user) {
        return ratingRepository.findByUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Rating findByUserAndEntertainment(User user, Entertainment entertainment) {
        return ratingRepository.findByUserAndEntertainment(user, entertainment);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Rating rating) {
        User user = rating.getUser();
        user.getRatings().remove(rating);

        ratingRepository.delete(rating);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteByEntertainmentId(Long id) {
        for (Rating rating : ratingRepository.findAll()) {
            if (rating.getEntertainment().getId() == id) {
                ratingRepository.delete(rating);
            }
        }
    }
}
