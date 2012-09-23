/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author m1k4
 */
@Entity(name = "MOVIE")
public class Movie implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LENGTH_IN_MINUTES")
    private Integer lengthInMinutes;
    @ManyToMany
    private List<User> users;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Integer getLengthInMinutes() {
        return lengthInMinutes;
    }
 
    public void setLengthInMinutes(Integer lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }
 
    public List<User> getusers() {
        return users;
    }
 
    public void setusers(List<User> users) {
        this.users = users;
    }
}
