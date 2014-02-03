package models;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import static play.data.validation.Constraints.*;

/**
 * @author Vitaliy Gerya
 */
@Entity
public class Speaker extends Model {
    @Id
    public long id;

    @Required
    public String name;

    @Required
    @Email
    public String email;

    @Required
    @MinLength(value = 10)
    @MaxLength(value = 1000)
    @Column(length = 1000)
    public String bio;

    @Required
    public String twitterID;

    public String pictureURL;
}
