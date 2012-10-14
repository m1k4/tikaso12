/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.repository;

import db.leffadb.domain.Game;
import db.leffadb.domain.User;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author m1k4
 */
public interface GameRepository extends EntertainmentRepository {

    @Query("SELECT game FROM GAMES game WHERE :user NOT MEMBER OF game.users")
    List<Game> findGamesWithoutUser(@Param("user") User user);

    Collection<Game> findByIdentifier(String identifier);
}
