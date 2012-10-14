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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author m1k4
 */
@Service
public class JpaGameService implements GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = false)
    public Game create(Game object) {
        return gameRepository.save(object);
    }

    @Override
    @Transactional(readOnly = true)
    public Game findById(Long id) {
        return (Game) gameRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Game object) {
        gameRepository.save(object);
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
    public Collection<Game> findAll() {
        return gameRepository.findByIdentifier("game");
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Game> listGamesWithout(Long userId) {
        User user = userRepository.findOne(userId);
        return gameRepository.findGamesWithoutUser(user);
    }
}
