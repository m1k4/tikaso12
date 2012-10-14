/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.repository;

import db.leffadb.domain.Entertainment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author m1k4
 */
public interface EntertainmentRepository extends JpaRepository<Entertainment, Long> {
    
}
