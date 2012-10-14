/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.repository;

import db.leffadb.domain.Entertainment;
import db.leffadb.domain.Movie;
import db.leffadb.domain.Rating;
import db.leffadb.domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author m1k4
 */
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUser(User user);
    Rating findByUserAndEntertainment(User user, Entertainment entertainment);
}
