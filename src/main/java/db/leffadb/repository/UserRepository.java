/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.repository;

import db.leffadb.domain.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author m1k4
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
