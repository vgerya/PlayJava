package models;

import play.db.ebean.Model;

import javax.persistence.*;

/**
 * @author Vitaliy Gerya
 */
@Entity
public class Proporsal extends Model {

    @Id
    public long id;

    public String title;

    @Column(length = 1000)
    public String proporsal;

    public SessionType type = SessionType.OneHourTalk;

    public boolean isApproved = false;

    public String keywords;

    @OneToOne(cascade = CascadeType.ALL)
    public Speaker speaker;
}
