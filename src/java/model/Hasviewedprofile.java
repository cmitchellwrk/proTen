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
@Table(name = "hasviewedprofile")
@NamedQueries({
    @NamedQuery(name = "Hasviewedprofile.findAll", query = "SELECT h FROM Hasviewedprofile h"),
    @NamedQuery(name = "Hasviewedprofile.findById", query = "SELECT h FROM Hasviewedprofile h WHERE h.id = :id"),
    @NamedQuery(name = "Hasviewedprofile.findByIdcurrent", query = "SELECT h FROM Hasviewedprofile h WHERE h.idcurrent = :idcurrent"),
    @NamedQuery(name = "Hasviewedprofile.findByIdhvperson", query = "SELECT h FROM Hasviewedprofile h WHERE h.idhvperson = :idhvperson"),
    @NamedQuery(name = "Hasviewedprofile.findByUsername", query = "SELECT h FROM Hasviewedprofile h WHERE h.username = :username"),
    @NamedQuery(name = "Hasviewedprofile.findByNow", query = "SELECT h FROM Hasviewedprofile h WHERE h.now = :now"),
    @NamedQuery(name = "Hasviewedprofile.findByImageurl", query = "SELECT h FROM Hasviewedprofile h WHERE h.imageurl = :imageurl"),
    @NamedQuery(name = "Hasviewedprofile.findByCity", query = "SELECT h FROM Hasviewedprofile h WHERE h.city = :city")})
public class Hasviewedprofile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id = 112321321L;
    @Basic(optional = false)
    @Column(name = "idcurrent")
    private long idcurrent;
    @Basic(optional = false)
    @Column(name = "idhvperson")
    private long idhvperson;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "now")
    private String now;
    @Basic(optional = false)
    @Column(name = "imageurl")
    private String imageurl;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;

    public Hasviewedprofile() {
    }

    public Hasviewedprofile(Long id) {
        this.id = id;
    }

    public Hasviewedprofile(Long id, long idcurrent, long idhvperson, String username, String now, String imageurl, String city) {
        this.id = id;
        this.idcurrent = idcurrent;
        this.idhvperson = idhvperson;
        this.username = username;
        this.now = now;
        this.imageurl = imageurl;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdcurrent() {
        return idcurrent;
    }

    public void setIdcurrent(long idcurrent) {
        this.idcurrent = idcurrent;
    }

    public long getIdhvperson() {
        return idhvperson;
    }

    public void setIdhvperson(long idhvperson) {
        this.idhvperson = idhvperson;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
        if (!(object instanceof Hasviewedprofile)) {
            return false;
        }
        Hasviewedprofile other = (Hasviewedprofile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Hasviewedprofile[id=" + id + "]";
    }

}
