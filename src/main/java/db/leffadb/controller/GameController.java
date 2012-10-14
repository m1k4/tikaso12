/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.controller;

import db.leffadb.domain.Game;
import db.leffadb.domain.User;
import db.leffadb.service.GameService;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author m1k4
 */
@Controller
@RequestMapping("games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostConstruct
    private void init() {
        Game game1 = new Game();
        game1.setName("Peli1");
        gameService.create(game1);

        Game game2 = new Game();
        game2.setName("Peli2");
        gameService.create(game2);

        Game game3 = new Game();
        game3.setName("Peli3");
        gameService.create(game3);

    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("games", gameService.findAll());
        return "gamemanagement";
    }

    @RequestMapping(value = "pelit", method = RequestMethod.GET)
    public String listAllGames(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("games", gameService.findAll());
        return "redirect:/app/index";
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public String createGame(@ModelAttribute Game game) {
        gameService.create(game);
        return "redirect:/app/games/";
    }

    @RequestMapping(value = "{gameId}/update", method = RequestMethod.GET)
    public String viewUpdatePage(Model model, @PathVariable(value = "gameId") Long gameId) {
        model.addAttribute("game", gameService.findById(gameId));
        return "gameUpdate";
    }

    @RequestMapping(value = "{gameId}", method = RequestMethod.PUT)
    public String update(@PathVariable(value = "gameId") Long gameId,
            @ModelAttribute Game game) {

        game.setId(gameId);
        gameService.update(game);

        return "redirect:/app/games/";
    }

    @RequestMapping(value = "{gameId}", method = RequestMethod.GET)
    public String viewGamePage(Model model,
            @PathVariable(value = "gameId") Long gameId,
            HttpSession session) {
        Game game = gameService.findById(gameId);
        model.addAttribute("game", game);

        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);

        return "game";
    }

    @RequestMapping(value = "{gameId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "gameId") Long gameId) {
        gameService.delete(gameId);
        return "redirect:/app/games/";
    }
}
