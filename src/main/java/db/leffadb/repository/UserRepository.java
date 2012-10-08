/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.repository;

import db.leffadb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author m1k4
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndPassword(String name, String password);
}
