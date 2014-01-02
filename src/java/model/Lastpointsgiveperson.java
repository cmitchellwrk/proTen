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
@Table(name = "lastpointsgiveperson")
@NamedQueries({
    @NamedQuery(name = "Lastpointsgiveperson.findAll", query = "SELECT l FROM Lastpointsgiveperson l"),
    @NamedQuery(name = "Lastpointsgiveperson.findById", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.id = :id"),
    @NamedQuery(name = "Lastpointsgiveperson.findByIdpersonpointsgive", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.idpersonpointsgive = :idpersonpointsgive"),
    @NamedQuery(name = "Lastpointsgiveperson.findByIdpersonpointsreceive", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.idpersonpointsreceive = :idpersonpointsreceive"),
    @NamedQuery(name = "Lastpointsgiveperson.findByPointsPhotos", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.pointsPhotos = :pointsPhotos"),
    @NamedQuery(name = "Lastpointsgiveperson.findByPointsProfile", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.pointsProfile = :pointsProfile"),
    @NamedQuery(name = "Lastpointsgiveperson.findByPointsFirstmessage", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.pointsFirstmessage = :pointsFirstmessage"),
    @NamedQuery(name = "Lastpointsgiveperson.findByPointsFunny", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.pointsFunny = :pointsFunny"),
    @NamedQuery(name = "Lastpointsgiveperson.findByPointsInteresting", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.pointsInteresting = :pointsInteresting"),
    @NamedQuery(name = "Lastpointsgiveperson.findByPointsPersonality", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.pointsPersonality = :pointsPersonality"),
    @NamedQuery(name = "Lastpointsgiveperson.findByPointsFirstdate", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.pointsFirstdate = :pointsFirstdate"),
    @NamedQuery(name = "Lastpointsgiveperson.findByPointsDateidea", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.pointsDateidea = :pointsDateidea"),
    @NamedQuery(name = "Lastpointsgiveperson.findByPointsVerifyprofile", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.pointsVerifyprofile = :pointsVerifyprofile"),
    @NamedQuery(name = "Lastpointsgiveperson.findByDatelastptsgiven", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.datelastptsgiven = :datelastptsgiven"),
    @NamedQuery(name = "Lastpointsgiveperson.findByBadge", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.badge = :badge"),
    @NamedQuery(name = "Lastpointsgiveperson.findByBadgeimageurl", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.badgeimageurl = :badgeimageurl"),
    @NamedQuery(name = "Lastpointsgiveperson.findByTotalpointsgivensofar", query = "SELECT l FROM Lastpointsgiveperson l WHERE l.totalpointsgivensofar = :totalpointsgivensofar")})
public class Lastpointsgiveperson implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id =112321321L;
    @Basic(optional = false)
    @Column(name = "idpersonpointsgive")
    private long idpersonpointsgive  =112321321L;
    @Basic(optional = false)
    @Column(name = "idpersonpointsreceive")
    private long idpersonpointsreceive =0;
    @Column(name = "points_photos")
    private Integer pointsPhotos =0;
    @Column(name = "points_profile")
    private Integer pointsProfile =0;
    @Column(name = "points_firstmessage")
    private Integer pointsFirstmessage =0;
    @Column(name = "points_funny")
    private Integer pointsFunny =0;
    @Column(name = "points_interesting")
    private Integer pointsInteresting =0;
    @Column(name = "points_personality")
    private Integer pointsPersonality =0;
    @Column(name = "points_firstdate")
    private Integer pointsFirstdate =0;
    @Column(name = "points_dateidea")
    private Integer pointsDateidea =0;
    @Column(name = "points_verifyprofile")
    private Integer pointsVerifyprofile =0;
    @Basic(optional = false)
    @Column(name = "datelastptsgiven")
    private String datelastptsgiven = "none";
    @Column(name = "badge")
    private String badge ="none";
    @Column(name = "badgeimageurl")
    private String badgeimageurl ="none";
    @Column(name = "totalpointsgivensofar")
    private Integer totalpointsgivensofar =0;

    public Lastpointsgiveperson() {
    }

    public Lastpointsgiveperson(Long id) {
        this.id = id;
    }

    public Lastpointsgiveperson(Long id, long idpersonpointsgive, long idpersonpointsreceive, String datelastptsgiven) {
        this.id = id;
        this.idpersonpointsgive = idpersonpointsgive;
        this.idpersonpointsreceive = idpersonpointsreceive;
        this.datelastptsgiven = datelastptsgiven;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdpersonpointsgive() {
        return idpersonpointsgive;
    }

    public void setIdpersonpointsgive(long idpersonpointsgive) {
        this.idpersonpointsgive = idpersonpointsgive;
    }

    public long getIdpersonpointsreceive() {
        return idpersonpointsreceive;
    }

    public void setIdpersonpointsreceive(long idpersonpointsreceive) {
        this.idpersonpointsreceive = idpersonpointsreceive;
    }

    public Integer getPointsPhotos() {
        return pointsPhotos;
    }

    public void setPointsPhotos(Integer pointsPhotos) {
        this.pointsPhotos = pointsPhotos;
    }

    public Integer getPointsProfile() {
        return pointsProfile;
    }

    public void setPointsProfile(Integer pointsProfile) {
        this.pointsProfile = pointsProfile;
    }

    public Integer getPointsFirstmessage() {
        return pointsFirstmessage;
    }

    public void setPointsFirstmessage(Integer pointsFirstmessage) {
        this.pointsFirstmessage = pointsFirstmessage;
    }

    public Integer getPointsFunny() {
        return pointsFunny;
    }

    public void setPointsFunny(Integer pointsFunny) {
        this.pointsFunny = pointsFunny;
    }

    public Integer getPointsInteresting() {
        return pointsInteresting;
    }

    public void setPointsInteresting(Integer pointsInteresting) {
        this.pointsInteresting = pointsInteresting;
    }

    public Integer getPointsPersonality() {
        return pointsPersonality;
    }

    public void setPointsPersonality(Integer pointsPersonality) {
        this.pointsPersonality = pointsPersonality;
    }

    public Integer getPointsFirstdate() {
        return pointsFirstdate;
    }

    public void setPointsFirstdate(Integer pointsFirstdate) {
        this.pointsFirstdate = pointsFirstdate;
    }

    public Integer getPointsDateidea() {
        return pointsDateidea;
    }

    public void setPointsDateidea(Integer pointsDateidea) {
        this.pointsDateidea = pointsDateidea;
    }

    public Integer getPointsVerifyprofile() {
        return pointsVerifyprofile;
    }

    public void setPointsVerifyprofile(Integer pointsVerifyprofile) {
        this.pointsVerifyprofile = pointsVerifyprofile;
    }

    public String getDatelastptsgiven() {
        return datelastptsgiven;
    }

    public void setDatelastptsgiven(String datelastptsgiven) {
        this.datelastptsgiven = datelastptsgiven;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getBadgeimageurl() {
        return badgeimageurl;
    }

    public void setBadgeimageurl(String badgeimageurl) {
        this.badgeimageurl = badgeimageurl;
    }

    public Integer getTotalpointsgivensofar() {
        return totalpointsgivensofar;
    }

    public void setTotalpointsgivensofar(Integer totalpointsgivensofar) {
        this.totalpointsgivensofar = totalpointsgivensofar;
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
        if (!(object instanceof Lastpointsgiveperson)) {
            return false;
        }
        Lastpointsgiveperson other = (Lastpointsgiveperson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Lastpointsgiveperson[id=" + id + "]";
    }

}
