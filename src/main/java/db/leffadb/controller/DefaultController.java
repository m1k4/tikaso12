package db.leffadb.controller;

import db.leffadb.domain.Profile;
import db.leffadb.domain.User;
import db.leffadb.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

    @Autowired
    private Profile profile;
    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String viewIndex(Model model, HttpSession session) {
        session.setAttribute("profile", profile);
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("yllapito")
    public String viewYllapito() {
        return "yllapitomenu";
    }

    @RequestMapping("rekisteroityminen")
    public String viewRekisteroityminen() {
        return "rekisteroityminen";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "password", required = true) String password,
            HttpSession session) {

        User user = userService.findByNameAndPassword(name, password);
        if (user == null) {
            return "redirect:/";
        }

        session.setAttribute("user", user);
        return "redirect:/app/users/" + user.getId();

    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
