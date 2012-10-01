/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.controller;

import db.leffadb.service.MovieService;
import db.leffadb.service.UserService;
import javax.servlet.http.HttpSession;
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
    
    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("users", userService.list());
        return "usermanagement";
    }
    
    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public String createUser(@RequestParam String name, @RequestParam String password, HttpSession session) {
        String id = userService.create(name, password).toString();
        session.setAttribute("name", name);
        session.setAttribute("password", password);
        
        return "redirect:/app/user/" + id + "";
    }
    
    @RequestMapping("{userId}")
    public String viewUserPage(Model model, @PathVariable(value = "userId") Long userId, HttpSession session) {
        String name = (String) session.getAttribute("name");
        String password = (String) session.getAttribute("password");
        
        if (!userService.checkLogin(name, password)) {
            return "redirect:/";
        }
        
        model.addAttribute("user", userService.findById(userId));
        model.addAttribute("movies", movieService.listMoviesWithout(userId));
        return "user";
    }
    
    @RequestMapping(value = "{userId}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable(value = "userId") Long userId) {
        userService.delete(userId);
        return "redirect:/app/user/";
    }
    
    @RequestMapping(value = "{userId}/movie", method = RequestMethod.POST)
    public String adduserToMovie(@PathVariable(value = "userId") Long userId,
            @RequestParam(value = "movieId") Long movieId) {
        userService.adduserToMovie(userId, movieId);
        return "redirect:/app/user/" + userId.toString();
    }
    
    @RequestMapping(value = "{userId}/deleteMovie/{movieId}", method = RequestMethod.POST)
    public String removeUserFromMovie(@PathVariable(value = "userId") Long userId,
            @PathVariable(value = "movieId") Long movieId) {
        userService.removeUserFromMovie(userId, movieId);
        return "redirect:/app/user/" + userId.toString();
    }
}
