/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.controller;

import db.leffadb.domain.User;
import db.leffadb.service.GameService;
import db.leffadb.service.MovieService;
import db.leffadb.service.UserService;
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

@Controller
@RequestMapping("users")
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private GameService gameService;
    
    @PostConstruct
    private void init() {
        User user = new User();
        user.setName("minä");
        user.setPassword("asd");
        userService.create(user);
    }
    
    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public String createUser(@ModelAttribute User user, HttpSession session) {
        userService.create(user);
        session.setAttribute("user", user);
        
        return "redirect:/app/users/" + user.getId();
    }

    // ei toimi kuten aattelit
    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    public String viewUser(Model model,
            @PathVariable(value = "userId") Long userId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        
        if (!user.getId().equals(userId)) {
            return "redirect:/";
        }
        
        model.addAttribute("user", userService.findById(userId));
        model.addAttribute("movies", movieService.listMoviesWithout(userId));
        model.addAttribute("games", gameService.listGamesWithout(userId));
        return "user";
    }
    
    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "usermanagement";
    }
    
    @RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "userId") Long userId) {
        userService.delete(userId);
        return "redirect:/app/users/";
    }
    
    @RequestMapping(value = "{userId}/entertainments/{id}", method = RequestMethod.POST)
    public String adduserToEntertainment(@PathVariable(value = "userId") Long userId,
            @PathVariable(value = "id") Long id) {
        userService.adduserToEntertainment(userId, id);
        return "redirect:/app/users/" + userId;
    }
    
    @RequestMapping(value = "{userId}/entertainments/{id}", method = RequestMethod.DELETE)
    public String removeUserFromEntertainment(@PathVariable(value = "userId") Long userId,
            @PathVariable(value = "id") Long id) {
        userService.removeUserFromEntertainment(userId, id);
        return "redirect:/app/users/" + userId;
    }
}
