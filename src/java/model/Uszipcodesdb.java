/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Chris Mitchell
 */
@Entity
@Table(name = "uszipcodesdb")
@NamedQueries({
    @NamedQuery(name = "Uszipcodesdb.findAll", query = "SELECT u FROM Uszipcodesdb u"),
    @NamedQuery(name = "Uszipcodesdb.findByZipcode", query = "SELECT u FROM Uszipcodesdb u WHERE u.zipcode = :zipcode"),
    @NamedQuery(name = "Uszipcodesdb.findByCity", query = "SELECT u FROM Uszipcodesdb u WHERE u.city = :city"),
    @NamedQuery(name = "Uszipcodesdb.findByState", query = "SELECT u FROM Uszipcodesdb u WHERE u.state = :state"),
    @NamedQuery(name = "Uszipcodesdb.findByLatitude", query = "SELECT u FROM Uszipcodesdb u WHERE u.latitude = :latitude"),
    @NamedQuery(name = "Uszipcodesdb.findByLongitude", query = "SELECT u FROM Uszipcodesdb u WHERE u.longitude = :longitude"),
    @NamedQuery(name = "Uszipcodesdb.findByStatesfullname", query = "SELECT u FROM Uszipcodesdb u WHERE u.statesfullname = :statesfullname")})

    public class Uszipcodesdb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "zipcode")
    private String zipcode;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @Column(name = "latitude")
    private float latitude;
    @Basic(optional = false)
    @Column(name = "longitude")
    private float longitude;
    @Basic(optional = false)
    @Column(name = "statesfullname")
    private String statesfullname;


    
    public Uszipcodesdb() {
    }

    public Uszipcodesdb(String zipcode) {
        this.zipcode = zipcode;
    }

    public Uszipcodesdb(String zipcode, String city, String state, float latitude, float longitude, String statesfullname) {
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
        this.statesfullname= statesfullname;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

     public String getStatesfullname() {
        return statesfullname;
    }

    public void setStatesfullname(String statesfullname) {
        this.statesfullname = statesfullname;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zipcode != null ? zipcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uszipcodesdb)) {
            return false;
        }
        Uszipcodesdb other = (Uszipcodesdb) object;
        if ((this.zipcode == null && other.zipcode != null) || (this.zipcode != null && !this.zipcode.equals(other.zipcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Uszipcodesdb[zipcode=" + zipcode + "]";
    }

}
