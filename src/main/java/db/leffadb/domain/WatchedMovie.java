/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author m1k4
 */
@Entity
public class WatchedMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "KATSOTTU")
    private Date timestamp;
    
    @Column(name = "ARVOSANA")
    private int arvosana;
}
