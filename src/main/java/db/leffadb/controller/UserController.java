/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.controller;

import db.leffadb.domain.User;
import db.leffadb.service.MovieService;
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

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;

    @PostConstruct
    private void init() {
        userService.create("minä", "asd");
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public String createUser(@RequestParam String name,
            @RequestParam String password, HttpSession session) {
        User user = userService.create(name, password);
        session.setAttribute("user", user);

        return "redirect:/app/users/" + user.getId();
    }

    @RequestMapping("{userId}")
    public String viewUser(Model model,
            @PathVariable(value = "userId") Long userId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String name = user.getName();
        String password = user.getPassword();

        if (!userService.checkLogin(name, password)) {
            return "redirect:/";
        }

        model.addAttribute("user", userService.findById(userId));
        model.addAttribute("movies", movieService.listMoviesWithout(userId));
        return "user";
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("users", userService.list());
        return "usermanagement";
    }

    @RequestMapping(value = "{userId}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable(value = "userId") Long userId) {
        userService.delete(userId);
        return "redirect:/app/users/";
    }

    @RequestMapping(value = "{userId}/movie", method = RequestMethod.POST)
    public String adduserToMovie(@PathVariable(value = "userId") Long userId,
            @RequestParam(value = "movieId") Long movieId) {
        userService.adduserToMovie(userId, movieId);
        return "redirect:/app/users/" + userId.toString();
    }

    @RequestMapping(value = "{userId}/deleteMovie/{movieId}", method = RequestMethod.POST)
    public String removeUserFromMovie(@PathVariable(value = "userId") Long userId,
            @PathVariable(value = "movieId") Long movieId) {
        userService.removeUserFromMovie(userId, movieId);
        return "redirect:/app/users/" + userId.toString();
    }
}
