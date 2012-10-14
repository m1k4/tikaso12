/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author m1k4
 */
@Entity(name = "MOVIES")
@Table(name = "MOVIES")
@Inheritance(strategy=InheritanceType.JOINED)
public class Movie extends Entertainment {

    @Column(name = "LENGTH_IN_MINUTES")
    private double lengthInMinutes;
    @Column(name = "OHJAAJA")
    private String ohjaaja;
    @Column(name = "GENRE")
    private String genre;

    public Movie() {
        setIdentifier("movie");
    }

    public double getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(double lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getOhjaaja() {
        return ohjaaja;
    }

    public void setOhjaaja(String ohjaaja) {
        this.ohjaaja = ohjaaja;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
