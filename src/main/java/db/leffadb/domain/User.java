/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author m1k4
 */
@Entity(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    @NotBlank
    private String name;
    @Column(name = "PASSWORD")
    @NotBlank
    private String password;
    @ManyToMany(mappedBy = "users")
    @JoinColumn(name = "ENTERTAINMENTS")
    private List<Entertainment> entertainments;

//    @OneToMany(mappedBy = "user")
//    @JoinColumn(name="RATINGS")
//    private List<Rating> ratings;
    public Long getId() {
        return id;
    }

//    public List<Rating> getRatings() {
//        return ratings;
//    }
//
//    public void setRatings(List<Rating> ratings) {
//        this.ratings = ratings;
//    }
//    
//    public void addRating(Rating rating) {
//        ratings.add(rating);
//    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entertainment> getEntertainments() {
        return entertainments;
    }

    public void setEntertainments(List<Entertainment> entertainments) {
        this.entertainments = entertainments;
    }

    public List<Entertainment> getMovies() {
        List<Entertainment> movies = new ArrayList<Entertainment>();
        for (Entertainment entertainment : entertainments) {
            if (entertainment.getIdentifier().equals("movie")) {
                movies.add(entertainment);
            }
        }
        return movies;
    }

    public List<Entertainment> getGames() {
        List<Entertainment> games = new ArrayList<Entertainment>();
        for (Entertainment entertainment : entertainments) {
            if (entertainment.getIdentifier().equals("game")) {
                games.add(entertainment);
            }
        }
        return games;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
