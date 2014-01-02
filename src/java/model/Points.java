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
@Table(name = "points")
@NamedQueries({
    @NamedQuery(name = "Points.findAll", query = "SELECT p FROM Points p"),
    @NamedQuery(name = "Points.findById", query = "SELECT p FROM Points p WHERE p.id = :id"),
    @NamedQuery(name = "Points.findByIdpersonpointsreceive", query = "SELECT p FROM Points p WHERE p.idpersonpointsreceive = :idpersonpointsreceive"),
    @NamedQuery(name = "Points.findByPointsPhotos", query = "SELECT p FROM Points p WHERE p.pointsPhotos = :pointsPhotos"),
    @NamedQuery(name = "Points.findByPointsProfile", query = "SELECT p FROM Points p WHERE p.pointsProfile = :pointsProfile"),
    @NamedQuery(name = "Points.findByPointsFirstmessage", query = "SELECT p FROM Points p WHERE p.pointsFirstmessage = :pointsFirstmessage"),
    @NamedQuery(name = "Points.findByPointsFunny", query = "SELECT p FROM Points p WHERE p.pointsFunny = :pointsFunny"),
    @NamedQuery(name = "Points.findByPointsInteresting", query = "SELECT p FROM Points p WHERE p.pointsInteresting = :pointsInteresting"),
    @NamedQuery(name = "Points.findByPointsPersonality", query = "SELECT p FROM Points p WHERE p.pointsPersonality = :pointsPersonality"),
    @NamedQuery(name = "Points.findByPointsFirstdate", query = "SELECT p FROM Points p WHERE p.pointsFirstdate = :pointsFirstdate"),
    @NamedQuery(name = "Points.findByPointsDateidea", query = "SELECT p FROM Points p WHERE p.pointsDateidea = :pointsDateidea"),
    @NamedQuery(name = "Points.findByPointsVerifyprofile", query = "SELECT p FROM Points p WHERE p.pointsVerifyprofile = :pointsVerifyprofile"),
    @NamedQuery(name = "Points.findByBadge", query = "SELECT p FROM Points p WHERE p.badge = :badge"),
    @NamedQuery(name = "Points.findByBadgeimageurl", query = "SELECT p FROM Points p WHERE p.badgeimageurl = :badgeimageurl"),
    @NamedQuery(name = "Points.findByTotalscore", query = "SELECT p FROM Points p WHERE p.totalscore = :totalscore")})
public class Points implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id =112321321L;
    @Basic(optional = false)
    @Column(name = "idpersonpointsreceive")
    private long idpersonpointsreceive;
    @Column(name = "points_photos")
    private Integer pointsPhotos =0;
    @Column(name = "points_profile")
    private Integer pointsProfile =0;
    @Column(name = "points_firstmessage")
    private Integer pointsFirstmessage=0;
    @Column(name = "points_funny")
    private Integer pointsFunny =0;
    @Column(name = "points_interesting")
    private Integer pointsInteresting=0;
    @Column(name = "points_personality")
    private Integer pointsPersonality=0;
    @Column(name = "points_firstdate")
    private Integer pointsFirstdate=0;
    @Column(name = "points_dateidea")
    private Integer pointsDateidea=0;
    @Column(name = "points_verifyprofile")
    private Integer pointsVerifyprofile=0;
    @Column(name = "badge")
    private String badge="none";
    @Column(name = "badgeimageurl")
    private String badgeimageurl="none";
    @Column(name = "totalscore")
    private Integer totalscore=0;

    public Points() {
    }

    public Points(Long id) {
        this.id = id;
    }

    public Points(Long id, long idpersonpointsreceive) {
        this.id = id;
        this.idpersonpointsreceive = idpersonpointsreceive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
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
        if (!(object instanceof Points)) {
            return false;
        }
        Points other = (Points) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Points[id=" + id + "]";
    }

}
