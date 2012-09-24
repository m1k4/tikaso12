/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import db.leffadb.service.MovieService;

/**
 *
 * @author m1k4
 */
@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("movies", movieService.list());
        return "movies";
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public String add(@RequestParam String name) {
        movieService.add(name);
        return "redirect:/app/movie/";
    }

    @RequestMapping("{movieId}/muokkaa")
    public String viewUpdate(Model model, @PathVariable(value = "movieId") Long movieId) {
        model.addAttribute("movie", movieService.findById(movieId));
        return "leffanmuokkaus";
    }

    @RequestMapping("{movieId}")
    public String view(Model model, @PathVariable(value = "movieId") Long movieId) {
        model.addAttribute("movie", movieService.findById(movieId));
        return "movie";
    }

    @RequestMapping(value = "{movieId}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable(value = "movieId") Long movieId) {
        movieService.remove(movieId);
        return "redirect:/app/movie/";
    }

    @RequestMapping(value = "{movieId}/update", method = RequestMethod.POST)
    public String update(@PathVariable(value = "movieId") Long movieId,
            @RequestParam String name, 
            @RequestParam String ohjaaja, 
            @RequestParam String genre, 
            @RequestParam double kesto, 
            @RequestParam int vuosi) {
        
        movieService.update(movieId, name, ohjaaja, genre, vuosi, kesto);

        return "redirect:/app/movie/";
    }
}
