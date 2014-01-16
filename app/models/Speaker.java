package models;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Vitaliy Gerya
 */
@Entity
public class Speaker extends Model {
    @Id
    public long id;

    public String name;

    public String email;

    @Column(length = 1000)
    public String bio;

    public String twitterID;

    public String pictureURL;
}
