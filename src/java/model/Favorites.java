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
@Table(name = "favorites")
@NamedQueries({
    @NamedQuery(name = "Favorites.findAll", query = "SELECT f FROM Favorites f"),
    @NamedQuery(name = "Favorites.findById", query = "SELECT f FROM Favorites f WHERE f.id = :id"),
    @NamedQuery(name = "Favorites.findByIdcurrent", query = "SELECT f FROM Favorites f WHERE f.idcurrent = :idcurrent"),
    @NamedQuery(name = "Favorites.findByIdfavperson", query = "SELECT f FROM Favorites f WHERE f.idfavperson = :idfavperson"),
    @NamedQuery(name = "Favorites.findByUsername", query = "SELECT f FROM Favorites f WHERE f.username = :username"),
    @NamedQuery(name = "Favorites.findByNow", query = "SELECT f FROM Favorites f WHERE f.now = :now"),
    @NamedQuery(name = "Favorites.findByImageurl", query = "SELECT f FROM Favorites f WHERE f.imageurl = :imageurl"),
    @NamedQuery(name = "Favorites.findByCity", query = "SELECT f FROM Favorites f WHERE f.city = :city")})
public class Favorites implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id =112321321L;
    @Basic(optional = false)
    @Column(name = "idcurrent")
    private long idcurrent;
    @Basic(optional = false)
    @Column(name = "idfavperson")
    private long idfavperson;
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

    public Favorites() {
    }

    public Favorites(Long id) {
        this.id = id;
    }

    public Favorites(Long id, long idcurrent, long idfavperson, String username, String now, String imageurl, String city) {
        this.id = id;
        this.idcurrent = idcurrent;
        this.idfavperson = idfavperson;
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

    public long getIdfavperson() {
        return idfavperson;
    }

    public void setIdfavperson(long idfavperson) {
        this.idfavperson = idfavperson;
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
        if (!(object instanceof Favorites)) {
            return false;
        }
        Favorites other = (Favorites) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Favorites[id=" + id + "]";
    }

}
