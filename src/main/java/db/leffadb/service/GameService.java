/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import db.leffadb.domain.Game;

/**
 *
 * @author m1k4
 */
public interface GameService extends ServiceInterface<Game> {
    Iterable<Game> listGamesWithout(Long userId);
}
