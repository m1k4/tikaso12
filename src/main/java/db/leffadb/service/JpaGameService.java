/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import db.leffadb.domain.Game;
import db.leffadb.domain.User;
import db.leffadb.repository.GameRepository;
import db.leffadb.repository.UserRepository;
import java.util.Collection;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author m1k4
 */
@Service("gameService")
public class JpaGameService extends RepositoryService<Game> 
implements GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;

        @PostConstruct
    private void init() {
        setRepository(gameRepository);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Game object) {
        Long id = object.getId();
        delete(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        Game game = (Game) gameRepository.findOne(id);
        for (User user : game.getUsers()) {
            user.getEntertainments().remove(game);
        }
        gameRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Game> listGamesWithoutUser(Long userId) {
        User user = userRepository.findOne(userId);
        return gameRepository.findGamesWithoutUser(user);
    }
}
