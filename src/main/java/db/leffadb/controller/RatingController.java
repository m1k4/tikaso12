/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.controller;

import db.leffadb.domain.Entertainment;
import db.leffadb.domain.Movie;
import db.leffadb.domain.Rating;
import db.leffadb.domain.User;
import db.leffadb.service.EntertainmentService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author m1k4
 */
@Controller
public class RatingController {

    @Autowired
    private RatingService ratingService;
    @Autowired
    private EntertainmentService entertainmentService;

    @RequestMapping(method = RequestMethod.POST, value = "entertainments/{Id}/ratings")
    private String postRating(@ModelAttribute Rating rating,
            @PathVariable(value = "Id") Long entertainmentId,
            HttpSession session) {
        Entertainment entertainment = entertainmentService.findById(entertainmentId);
        User user = (User) session.getAttribute("user");

        rating.setEntertainment(entertainment);
        rating.setTimestamp(new Date());
        rating.setUser(user);
        user.getRatings().add(rating);
        ratingService.create(rating);

        return "redirect:/app/users/" + user.getId();
    }

    @RequestMapping(value = "entertainments/{Id}/ratings/{ratingId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "ratingId") Long ratingId,
            @PathVariable(value = "Id") Long entertainmentId, HttpSession session) {

        Rating rating = ratingService.findById(ratingId);
        ratingService.delete(rating);

        User user = (User) session.getAttribute("user");
        return "redirect:/app/users/" + user.getId();
    }
}
