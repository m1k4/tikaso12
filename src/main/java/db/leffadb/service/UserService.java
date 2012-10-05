/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import db.leffadb.domain.User;

/**
 *
 * @author m1k4
 */
public interface UserService {
    Iterable<User> list();
    User create(String name, String password);
    void delete(Long userId);
    User findById(Long userId);
    User findByName(String name);
    void adduserToMovie(Long userId, Long movieId);
    void removeUserFromMovie(Long userId, Long movieId);
    boolean checkLogin(String name, String password);
}
