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
import db.leffadb.service.UserService;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author m1k4
 */
@Controller
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private RatingService ratingService;

    @PostConstruct
    private void init() {
        movieService.create("Testi1");
        movieService.create("Testi2");
        movieService.create("Testi3");

    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("movies", movieService.list());
        return "moviemanagement";
    }

    @RequestMapping(value = "leffat", method = RequestMethod.GET)
    public String listAllMovies(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("movies", movieService.list());
        return "redirect:/app/index";
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public String createMovie(@RequestParam String name) {
        movieService.create(name);
        return "redirect:/app/movies/";
    }

    @RequestMapping(value = "{movieId}/update", method = RequestMethod.GET)
    public String viewUpdatePage(Model model, @PathVariable(value = "movieId") Long movieId) {
        model.addAttribute("movie", movieService.findById(movieId));
        return "leffanmuokkaus";
    }

    @RequestMapping("{movieId}")
    public String viewMoviePage(Model model,
            @PathVariable(value = "movieId") Long movieId,
            HttpSession session) {
        Movie movie = movieService.findById(movieId);

        model.addAttribute("movie", movie);

        User user = (User) session.getAttribute("user");

        Rating rating = ratingService.findByUserAndMovie(user, movie);

        model.addAttribute("user", user);
        model.addAttribute("rating", rating);

        return "movie";
    }

    @RequestMapping(value = "{movieId}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable(value = "movieId") Long movieId) {
        movieService.delete(movieId);
        return "redirect:/app/movies/";
    }

    @RequestMapping(value = "{movieId}/update", method = RequestMethod.POST)
    public String update(@PathVariable(value = "movieId") Long movieId,
            @RequestParam String name,
            @RequestParam String ohjaaja,
            @RequestParam String genre,
            @RequestParam double kesto,
            @RequestParam int vuosi) {

        movieService.update(movieId, name, ohjaaja, genre, vuosi, kesto);

        return "redirect:/app/movies/";
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public String find(RedirectAttributes redirectAttributes,
            @RequestParam String hakusana) {
        redirectAttributes.addFlashAttribute("movies", movieService.findByName(hakusana));
        return "redirect:/app/index";
    }
}
