package db.leffadb.controller;

import db.leffadb.domain.User;
import db.leffadb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

    @Autowired
    private UserService userService;

    @RequestMapping("yllapito")
    public String viewYllapito() {
        return "menu";
    }

    @RequestMapping("rekisteroityminen")
    public String viewRekisteroityminen() {
        return "rekisteroityminen";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "password", required = true) String password) {

        for (User user : userService.list()) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return "redirect:/app/user/" + user.getId().toString();
            }
        }

        return "redirect:/";

    }
}
