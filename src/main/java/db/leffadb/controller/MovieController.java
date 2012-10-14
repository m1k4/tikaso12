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
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        Movie movie1 = new Movie();
        movie1.setName("Testi1");
        movieService.create(movie1);

        Movie movie2 = new Movie();
        movie2.setName("Testi2");
        movieService.create(movie2);

        Movie movie3 = new Movie();
        movie3.setName("Testi3");
        movieService.create(movie3);

    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "moviemanagement";
    }

    @RequestMapping(value = "leffat", method = RequestMethod.GET)
    public String listAllMovies(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("movies", movieService.findAll());
        return "redirect:/app/index";
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public String createMovie(@ModelAttribute Movie movie) {
        movieService.create(movie);
        return "redirect:/app/movies/";
    }

    @RequestMapping(value = "{movieId}/update", method = RequestMethod.GET)
    public String viewUpdatePage(Model model, @PathVariable(value = "movieId") Long movieId) {
        model.addAttribute("movie", movieService.findById(movieId));
        return "leffanmuokkaus";
    }

    
    @RequestMapping(value = "{movieId}", method = RequestMethod.PUT)
    public String update(@PathVariable(value = "movieId") Long movieId,
            @ModelAttribute Movie movie) {

        movie.setId(movieId);
        movieService.update(movie);

        return "redirect:/app/movies/";
    }

    @RequestMapping(value = "{movieId}", method = RequestMethod.GET)
    public String viewMoviePage(Model model,
            @PathVariable(value = "movieId") Long movieId,
            HttpSession session) {
        Movie movie = movieService.findById(movieId);
        model.addAttribute("movie", movie);

        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);

        Rating rating = ratingService.findByUserAndMovie(user, movie);
        model.addAttribute("rating", rating);

        return "movie";
    }

    
    // muuta DELETE:ksi
    @RequestMapping(value = "{movieId}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable(value = "movieId") Long movieId) {
        movieService.delete(movieId);
        return "redirect:/app/movies/";
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public String find(RedirectAttributes redirectAttributes,
            @RequestParam String hakusana) {
        redirectAttributes.addFlashAttribute("movies", movieService.findByName(hakusana));
        return "redirect:/app/index";
    }
}
