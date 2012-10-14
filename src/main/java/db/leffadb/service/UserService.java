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
public interface UserService extends ServiceInterface<User> {

    User findByNameAndPassword(String name, String password);

    void adduserToEntertainment(Long userId, Long entertainmentId);

    void removeUserFromEntertainment(Long userId, Long entertainmentId);
}
