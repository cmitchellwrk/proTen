/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Chris Mitchell
 */
@Entity
@Table(name = "mailsettings")
@NamedQueries({
    @NamedQuery(name = "Mailsettings.findAll", query = "SELECT m FROM Mailsettings m"),
    @NamedQuery(name = "Mailsettings.findById", query = "SELECT m FROM Mailsettings m WHERE m.id = :id"),
    @NamedQuery(name = "Mailsettings.findByIdmember", query = "SELECT m FROM Mailsettings m WHERE m.idmember = :idmember"),
    @NamedQuery(name = "Mailsettings.findByGender", query = "SELECT m FROM Mailsettings m WHERE m.gender = :gender"),
    @NamedQuery(name = "Mailsettings.findByCountry", query = "SELECT m FROM Mailsettings m WHERE m.country = :country"),
    @NamedQuery(name = "Mailsettings.findByFirstcontactmessgesize", query = "SELECT m FROM Mailsettings m WHERE m.firstcontactmessgesize = :firstcontactmessgesize"),
    @NamedQuery(name = "Mailsettings.findByAgefrom", query = "SELECT m FROM Mailsettings m WHERE m.agefrom = :agefrom"),
    @NamedQuery(name = "Mailsettings.findByAgeto", query = "SELECT m FROM Mailsettings m WHERE m.ageto = :ageto"),
    @NamedQuery(name = "Mailsettings.findByWithin", query = "SELECT m FROM Mailsettings m WHERE m.within = :within"),
    @NamedQuery(name = "Mailsettings.findByHangout", query = "SELECT m FROM Mailsettings m WHERE m.hangout = :hangout"),
    @NamedQuery(name = "Mailsettings.findByFriendship", query = "SELECT m FROM Mailsettings m WHERE m.friendship = :friendship"),
    @NamedQuery(name = "Mailsettings.findByActivitypartner", query = "SELECT m FROM Mailsettings m WHERE m.activitypartner = :activitypartner"),
    @NamedQuery(name = "Mailsettings.findByDating", query = "SELECT m FROM Mailsettings m WHERE m.dating = :dating"),
    @NamedQuery(name = "Mailsettings.findByLongterm", query = "SELECT m FROM Mailsettings m WHERE m.longterm = :longterm"),
    @NamedQuery(name = "Mailsettings.findByIntimateencounter", query = "SELECT m FROM Mailsettings m WHERE m.intimateencounter = :intimateencounter"),
    @NamedQuery(name = "Mailsettings.findByTalkemail", query = "SELECT m FROM Mailsettings m WHERE m.talkemail = :talkemail"),
    @NamedQuery(name = "Mailsettings.findByOtherrelationship", query = "SELECT m FROM Mailsettings m WHERE m.otherrelationship = :otherrelationship"),
    @NamedQuery(name = "Mailsettings.findByUsedrugs", query = "SELECT m FROM Mailsettings m WHERE m.usedrugs = :usedrugs"),
    @NamedQuery(name = "Mailsettings.findBySmoke", query = "SELECT m FROM Mailsettings m WHERE m.smoke = :smoke"),
    @NamedQuery(name = "Mailsettings.findByHavemessagedintenct", query = "SELECT m FROM Mailsettings m WHERE m.havemessagedintenct = :havemessagedintenct"),
    @NamedQuery(name = "Mailsettings.findByEmailaddress", query = "SELECT m FROM Mailsettings m WHERE m.emailaddress = :emailaddress"),
    @NamedQuery(name = "Mailsettings.findByEmail1", query = "SELECT m FROM Mailsettings m WHERE m.email1 = :email1"),
    @NamedQuery(name = "Mailsettings.findByEmail2", query = "SELECT m FROM Mailsettings m WHERE m.email2 = :email2"),
    @NamedQuery(name = "Mailsettings.findByEmail3", query = "SELECT m FROM Mailsettings m WHERE m.email3 = :email3"),
    @NamedQuery(name = "Mailsettings.findByEmail4", query = "SELECT m FROM Mailsettings m WHERE m.email4 = :email4"),
    @NamedQuery(name = "Mailsettings.findByEmail5", query = "SELECT m FROM Mailsettings m WHERE m.email5 = :email5")})
public class Mailsettings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id =112321321L;
    @Basic(optional = false)
    @Column(name = "idmember")
    private long idmember;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "country")
    private String country = "United States";
    @Basic(optional = false)
    @Column(name = "firstcontactmessgesize")
    private String firstcontactmessgesize = "Any size";
    @Basic(optional = false)
    @Column(name = "agefrom")
    private String agefrom = "18";
    @Basic(optional = false)
    @Column(name = "ageto")
    private String ageto = "99";
    @Basic(optional = false)
    @Column(name = "within")
    private String within = "Any";
    @Basic(optional = false)
    @Column(name = "hangout")
    private boolean hangout= false;
    @Basic(optional = false)
    @Column(name = "friendship")
    private boolean friendship = false;
    @Basic(optional = false)
    @Column(name = "activitypartner")
    private boolean activitypartner = false;
    @Basic(optional = false)
    @Column(name = "dating")
    private boolean dating = false;
    @Basic(optional = false)
    @Column(name = "longterm")
    private boolean longterm = false;
    @Basic(optional = false)
    @Column(name = "intimateencounter")
    private boolean intimateencounter = false;
    @Basic(optional = false)
    @Column(name = "talkemail")
    private boolean talkemail = false;
    @Basic(optional = false)
    @Column(name = "otherrelationship")
    private boolean otherrelationship = false;
    @Basic(optional = false)
    @Column(name = "usedrugs")
    private boolean usedrugs = false;
    @Basic(optional = false)
    @Column(name = "smoke")
    private boolean smoke = false;
    @Basic(optional = false)
    @Column(name = "havemessagedintenct")
    private boolean havemessagedintenct = false;
    @Basic(optional = false)
    @Column(name = "emailaddress")
    private String emailaddress = "xyzxyz@gmail.com";
    @Basic(optional = false)
    @Column(name = "email1")
    private boolean email1 = false;
    @Basic(optional = false)
    @Column(name = "email2")
    private boolean email2 = false;
    @Basic(optional = false)
    @Column(name = "email3")
    private boolean email3 = false;
    @Basic(optional = false)
    @Column(name = "email4")
    private boolean email4 = false;
    @Basic(optional = false)
    @Column(name = "email5")
    private boolean email5 = false;


    public Mailsettings() {
    }

    public Mailsettings(Long id) {
        this.id = id;
    }

    public Mailsettings(Long id, long idmember, String gender, String country, String firstcontactmessgesize, String agefrom, String ageto, String within, boolean hangout, boolean friendship, boolean activitypartner, boolean dating, boolean longterm, boolean intimateencounter, boolean talkemail, boolean otherrelationship, boolean usedrugs, boolean smoke, boolean havemessagedintenct, String emailaddress, boolean email1, boolean email2, boolean email3, boolean email4, boolean email5) {
        this.id = id;
        this.idmember = idmember;
        this.gender = gender;
        this.country = country;
        this.firstcontactmessgesize = firstcontactmessgesize;
        this.agefrom = agefrom;
        this.ageto = ageto;
        this.within = within;
        this.hangout = hangout;
        this.friendship = friendship;
        this.activitypartner = activitypartner;
        this.dating = dating;
        this.longterm = longterm;
        this.intimateencounter = intimateencounter;
        this.talkemail = talkemail;
        this.otherrelationship = otherrelationship;
        this.usedrugs = usedrugs;
        this.smoke = smoke;
        this.havemessagedintenct = havemessagedintenct;
        this.emailaddress = emailaddress;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.email4 = email4;
        this.email5 = email5;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdmember() {
        return idmember;
    }

    public void setIdmember(long idmember) {
        this.idmember = idmember;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstcontactmessgesize() {
        return firstcontactmessgesize;
    }

    public void setFirstcontactmessgesize(String firstcontactmessgesize) {
        this.firstcontactmessgesize = firstcontactmessgesize;
    }

    public String getAgefrom() {
        return agefrom;
    }

    public void setAgefrom(String agefrom) {
        this.agefrom = agefrom;
    }

    public String getAgeto() {
        return ageto;
    }

    public void setAgeto(String ageto) {
        this.ageto = ageto;
    }

    public String getWithin() {
        return within;
    }

    public void setWithin(String within) {
        this.within = within;
    }

    public boolean getHangout() {
        return hangout;
    }

    public void setHangout(boolean hangout) {
        this.hangout = hangout;
    }

    public boolean getFriendship() {
        return friendship;
    }

    public void setFriendship(boolean friendship) {
        this.friendship = friendship;
    }

    public boolean getActivitypartner() {
        return activitypartner;
    }

    public void setActivitypartner(boolean activitypartner) {
        this.activitypartner = activitypartner;
    }

    public boolean getDating() {
        return dating;
    }

    public void setDating(boolean dating) {
        this.dating = dating;
    }

    public boolean getLongterm() {
        return longterm;
    }

    public void setLongterm(boolean longterm) {
        this.longterm = longterm;
    }

    public boolean getIntimateencounter() {
        return intimateencounter;
    }

    public void setIntimateencounter(boolean intimateencounter) {
        this.intimateencounter = intimateencounter;
    }

    public boolean getTalkemail() {
        return talkemail;
    }

    public void setTalkemail(boolean talkemail) {
        this.talkemail = talkemail;
    }

    public boolean getOtherrelationship() {
        return otherrelationship;
    }

    public void setOtherrelationship(boolean otherrelationship) {
        this.otherrelationship = otherrelationship;
    }

    public boolean getUsedrugs() {
        return usedrugs;
    }

    public void setUsedrugs(boolean usedrugs) {
        this.usedrugs = usedrugs;
    }

    public boolean getSmoke() {
        return smoke;
    }

    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }

    public boolean getHavemessagedintenct() {
        return havemessagedintenct;
    }

    public void setHavemessagedintenct(boolean havemessagedintenct) {
        this.havemessagedintenct = havemessagedintenct;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public boolean getEmail1() {
        return email1;
    }

    public void setEmail1(boolean email1) {
        this.email1 = email1;
    }

    public boolean getEmail2() {
        return email2;
    }

    public void setEmail2(boolean email2) {
        this.email2 = email2;
    }

    public boolean getEmail3() {
        return email3;
    }

    public void setEmail3(boolean email3) {
        this.email3 = email3;
    }

    public boolean getEmail4() {
        return email4;
    }

    public void setEmail4(boolean email4) {
        this.email4 = email4;
    }

    public boolean getEmail5() {
        return email5;
    }

    public void setEmail5(boolean email5) {
        this.email5 = email5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mailsettings)) {
            return false;
        }
        Mailsettings other = (Mailsettings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mailsettings[id=" + id + "]";
    }

}
