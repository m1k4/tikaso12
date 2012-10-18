/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.service;

import db.leffadb.domain.Entertainment;
import db.leffadb.repository.EntertainmentRepository;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author m1k4
 */

@Service
public class JpaEntertainmentService extends RepositoryService<Entertainment> 
implements EntertainmentService {

    @Autowired
    private EntertainmentRepository entertainmentRepository;

    @PostConstruct
    private void init() {
        setRepository(entertainmentRepository);
    }
}
