/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.controller;

import db.leffadb.domain.Movie;
import db.leffadb.domain.Rating;
import db.leffadb.domain.User;
import db.leffadb.service.MovieService;
import db.leffadb.service.RatingService;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author m1k4
 */
@Controller
public class RatingController {

    @Autowired
    private RatingService ratingService;
    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.POST, value = "movies/{movieId}/ratings")
    private String postRating(@ModelAttribute Rating rating,
            @PathVariable Long movieId, HttpSession session) {
        Movie movie = movieService.findById(movieId);
        User user = (User) session.getAttribute("user");

        rating.setMovie(movie);
        rating.setTimestamp(new Date());
        rating.setUser(user);
        ratingService.create(rating);
        return "redirect:/app/movies/" + movieId;
    }

    
    @RequestMapping(value = "movies/{movieId}/ratings/{ratingId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "ratingId") Long ratingId,
            @PathVariable(value = "movieId") Long movieId) {

        Rating rating = ratingService.findById(ratingId);
        ratingService.delete(rating);

        return "redirect:/app/movies/"+ movieId;
    }
}
