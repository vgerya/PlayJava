package models;

import play.db.ebean.Model;

import javax.persistence.*;
import javax.validation.Valid;

import static play.data.validation.Constraints.*;

/**
 * @author Vitaliy Gerya
 */
@Entity
public class Proposal extends Model {

    @Id
    public long id;

    @Required
    public String title;

    @Required
    @MinLength(value = 10)
    @MaxLength(value = 1000)
    @Column(length = 1000)
    public String proposal;

    @Required
    public SessionType type = SessionType.OneHourTalk;

    @Required
    public boolean isApproved = false;

    public String keywords;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    public Speaker speaker;
}
