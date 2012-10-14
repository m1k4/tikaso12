/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.leffadb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author m1k4
 */
@Entity(name="GAMES")
public class Game extends Entertainment {
    @Column(name="ALUSTA")
    private String alusta;
    @Column(name="LAJI")
    private String lajityyppi;

    public Game() {
        setIdentifier("game");
    }

    public String getAlusta() {
        return alusta;
    }

    public void setAlusta(String alusta) {
        this.alusta = alusta;
    }

    public String getLajityyppi() {
        return lajityyppi;
    }

    public void setLajityyppi(String lajityyppi) {
        this.lajityyppi = lajityyppi;
    }
    
    
}