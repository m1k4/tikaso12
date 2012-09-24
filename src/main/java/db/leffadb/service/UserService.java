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
    Long add(String name, String password); 
    void remove(Long userId);
    User findById(Long userId);
    void adduserToMovie(Long userId, Long movieId);
}
