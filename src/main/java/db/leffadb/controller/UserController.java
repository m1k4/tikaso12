/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.controller;

import db.leffadb.service.MovieService;
import db.leffadb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
@RequestMapping("user")
public class UserController {
 
    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;
 
    @RequestMapping(value= {"/", ""}, method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.list());
        return "users";
    }
 
    @RequestMapping(value= {"/", ""}, method = RequestMethod.POST)
    public String add(@RequestParam String name, @RequestParam String password) {
        String id = userService.add(name, password).toString();
        
        return "redirect:/app/user/" + id + "";
    }
 
    @RequestMapping("{userId}")
    public String view(Model model, @PathVariable(value = "userId") Long userId) {
        model.addAttribute("user", userService.findById(userId));
        model.addAttribute("movies", movieService.listMoviesWithout(userId));
        return "user";
    }
 
    @RequestMapping(value = "{userId}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable(value = "userId") Long userId) {
        userService.remove(userId);
        return "redirect:/app/user/";
    }
 
    @RequestMapping(value = "{userId}/movie", method = RequestMethod.POST)
    public String adduserToMovie(@PathVariable(value = "userId") Long userId,
            @RequestParam(value = "movieId") Long movieId) {
        userService.adduserToMovie(userId, movieId);
        return "redirect:/app/user/" + userId.toString();
    }
    
}
