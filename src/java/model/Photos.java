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
@Table(name = "photos")
@NamedQueries({
    @NamedQuery(name = "Photos.findAll", query = "SELECT p FROM Photos p"),
    @NamedQuery(name = "Photos.findByPhotouserid", query = "SELECT p FROM Photos p WHERE p.photouserid = :photouserid"),
    @NamedQuery(name = "Photos.findByImageurl1a", query = "SELECT p FROM Photos p WHERE p.imageurl1a = :imageurl1a"),
    @NamedQuery(name = "Photos.findByImageurl1b", query = "SELECT p FROM Photos p WHERE p.imageurl1b = :imageurl1b"),
    @NamedQuery(name = "Photos.findByImageurl2a", query = "SELECT p FROM Photos p WHERE p.imageurl2a = :imageurl2a"),
    @NamedQuery(name = "Photos.findByImageurl2b", query = "SELECT p FROM Photos p WHERE p.imageurl2b = :imageurl2b"),
    @NamedQuery(name = "Photos.findByImageurl3a", query = "SELECT p FROM Photos p WHERE p.imageurl3a = :imageurl3a"),
    @NamedQuery(name = "Photos.findByImageurl3b", query = "SELECT p FROM Photos p WHERE p.imageurl3b = :imageurl3b"),
    @NamedQuery(name = "Photos.findByImageurl4a", query = "SELECT p FROM Photos p WHERE p.imageurl4a = :imageurl4a"),
    @NamedQuery(name = "Photos.findByImageurl4b", query = "SELECT p FROM Photos p WHERE p.imageurl4b = :imageurl4b"),
    @NamedQuery(name = "Photos.findByImageurl5a", query = "SELECT p FROM Photos p WHERE p.imageurl5a = :imageurl5a"),
    @NamedQuery(name = "Photos.findByImageurl5b", query = "SELECT p FROM Photos p WHERE p.imageurl5b = :imageurl5b"),
    @NamedQuery(name = "Photos.findByImageurl6a", query = "SELECT p FROM Photos p WHERE p.imageurl6a = :imageurl6a"),
    @NamedQuery(name = "Photos.findByImageurl6b", query = "SELECT p FROM Photos p WHERE p.imageurl6b = :imageurl6b"),
    @NamedQuery(name = "Photos.findByImageurl7a", query = "SELECT p FROM Photos p WHERE p.imageurl7a = :imageurl7a"),
    @NamedQuery(name = "Photos.findByImageurl7b", query = "SELECT p FROM Photos p WHERE p.imageurl7b = :imageurl7b"),
    @NamedQuery(name = "Photos.findByImageurl8a", query = "SELECT p FROM Photos p WHERE p.imageurl8a = :imageurl8a"),
    @NamedQuery(name = "Photos.findByImageurl8b", query = "SELECT p FROM Photos p WHERE p.imageurl8b = :imageurl8b"),
    @NamedQuery(name = "Photos.findByImageurl9a", query = "SELECT p FROM Photos p WHERE p.imageurl9a = :imageurl9a"),
    @NamedQuery(name = "Photos.findByImageurl9b", query = "SELECT p FROM Photos p WHERE p.imageurl9b = :imageurl9b"),
    @NamedQuery(name = "Photos.findByImageurl10a", query = "SELECT p FROM Photos p WHERE p.imageurl10a = :imageurl10a"),
    @NamedQuery(name = "Photos.findByImageurl10b", query = "SELECT p FROM Photos p WHERE p.imageurl10b = :imageurl10b"),
    @NamedQuery(name = "Photos.findByImageurl11a", query = "SELECT p FROM Photos p WHERE p.imageurl11a = :imageurl11a"),
    @NamedQuery(name = "Photos.findByImageurl11b", query = "SELECT p FROM Photos p WHERE p.imageurl11b = :imageurl11b"),
    @NamedQuery(name = "Photos.findByImageurl12a", query = "SELECT p FROM Photos p WHERE p.imageurl12a = :imageurl12a"),
    @NamedQuery(name = "Photos.findByImageurl12b", query = "SELECT p FROM Photos p WHERE p.imageurl12b = :imageurl12b"),
    @NamedQuery(name = "Photos.findByImageurl13a", query = "SELECT p FROM Photos p WHERE p.imageurl13a = :imageurl13a"),
    @NamedQuery(name = "Photos.findByImageurl13b", query = "SELECT p FROM Photos p WHERE p.imageurl13b = :imageurl13b"),
    @NamedQuery(name = "Photos.findByImageurl14a", query = "SELECT p FROM Photos p WHERE p.imageurl14a = :imageurl14a"),
    @NamedQuery(name = "Photos.findByImageurl14b", query = "SELECT p FROM Photos p WHERE p.imageurl14b = :imageurl14b"),
    @NamedQuery(name = "Photos.findByImageurl15a", query = "SELECT p FROM Photos p WHERE p.imageurl15a = :imageurl15a"),
    @NamedQuery(name = "Photos.findByImageurl15b", query = "SELECT p FROM Photos p WHERE p.imageurl15b = :imageurl15b"),
    @NamedQuery(name = "Photos.findByImageurl16a", query = "SELECT p FROM Photos p WHERE p.imageurl16a = :imageurl16a"),
    @NamedQuery(name = "Photos.findByImageurl16b", query = "SELECT p FROM Photos p WHERE p.imageurl16b = :imageurl16b")})
public class Photos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "photouserid")
    private Long photouserid;
    @Basic(optional = false)
    @Column(name = "imageurl1a")
    private String imageurl1a;
    @Basic(optional = false)
    @Column(name = "imageurl1b")
    private String imageurl1b;
    @Basic(optional = false)
    @Column(name = "imageurl2a")
    private String imageurl2a;
    @Basic(optional = false)
    @Column(name = "imageurl2b")
    private String imageurl2b;
    @Basic(optional = false)
    @Column(name = "imageurl3a")
    private String imageurl3a;
    @Basic(optional = false)
    @Column(name = "imageurl3b")
    private String imageurl3b;
    @Basic(optional = false)
    @Column(name = "imageurl4a")
    private String imageurl4a;
    @Basic(optional = false)
    @Column(name = "imageurl4b")
    private String imageurl4b;
    @Basic(optional = false)
    @Column(name = "imageurl5a")
    private String imageurl5a;
    @Basic(optional = false)
    @Column(name = "imageurl5b")
    private String imageurl5b;
    @Basic(optional = false)
    @Column(name = "imageurl6a")
    private String imageurl6a;
    @Basic(optional = false)
    @Column(name = "imageurl6b")
    private String imageurl6b;
    @Basic(optional = false)
    @Column(name = "imageurl7a")
    private String imageurl7a;
    @Basic(optional = false)
    @Column(name = "imageurl7b")
    private String imageurl7b;
    @Basic(optional = false)
    @Column(name = "imageurl8a")
    private String imageurl8a;
    @Basic(optional = false)
    @Column(name = "imageurl8b")
    private String imageurl8b;
    @Basic(optional = false)
    @Column(name = "imageurl9a")
    private String imageurl9a;
    @Basic(optional = false)
    @Column(name = "imageurl9b")
    private String imageurl9b;
    @Basic(optional = false)
    @Column(name = "imageurl10a")
    private String imageurl10a;
    @Basic(optional = false)
    @Column(name = "imageurl10b")
    private String imageurl10b;
    @Basic(optional = false)
    @Column(name = "imageurl11a")
    private String imageurl11a;
    @Basic(optional = false)
    @Column(name = "imageurl11b")
    private String imageurl11b;
    @Basic(optional = false)
    @Column(name = "imageurl12a")
    private String imageurl12a;
    @Basic(optional = false)
    @Column(name = "imageurl12b")
    private String imageurl12b;
    @Basic(optional = false)
    @Column(name = "imageurl13a")
    private String imageurl13a;
    @Basic(optional = false)
    @Column(name = "imageurl13b")
    private String imageurl13b;
    @Basic(optional = false)
    @Column(name = "imageurl14a")
    private String imageurl14a;
    @Basic(optional = false)
    @Column(name = "imageurl14b")
    private String imageurl14b;
    @Basic(optional = false)
    @Column(name = "imageurl15a")
    private String imageurl15a;
    @Basic(optional = false)
    @Column(name = "imageurl15b")
    private String imageurl15b;
    @Basic(optional = false)
    @Column(name = "imageurl16a")
    private String imageurl16a;
    @Basic(optional = false)
    @Column(name = "imageurl16b")
    private String imageurl16b;

    public Photos() {
    }

    public Photos(Long photouserid) {
        this.photouserid = photouserid;
    }

    public Photos(Long photouserid, String imageurl1a, String imageurl1b, String imageurl2a, String imageurl2b, String imageurl3a, String imageurl3b, String imageurl4a, String imageurl4b, String imageurl5a, String imageurl5b, String imageurl6a, String imageurl6b, String imageurl7a, String imageurl7b, String imageurl8a, String imageurl8b, String imageurl9a, String imageurl9b, String imageurl10a, String imageurl10b, String imageurl11a, String imageurl11b, String imageurl12a, String imageurl12b, String imageurl13a, String imageurl13b, String imageurl14a, String imageurl14b, String imageurl15a, String imageurl15b, String imageurl16a, String imageurl16b) {
        this.photouserid = photouserid;
        this.imageurl1a = imageurl1a;
        this.imageurl1b = imageurl1b;
        this.imageurl2a = imageurl2a;
        this.imageurl2b = imageurl2b;
        this.imageurl3a = imageurl3a;
        this.imageurl3b = imageurl3b;
        this.imageurl4a = imageurl4a;
        this.imageurl4b = imageurl4b;
        this.imageurl5a = imageurl5a;
        this.imageurl5b = imageurl5b;
        this.imageurl6a = imageurl6a;
        this.imageurl6b = imageurl6b;
        this.imageurl7a = imageurl7a;
        this.imageurl7b = imageurl7b;
        this.imageurl8a = imageurl8a;
        this.imageurl8b = imageurl8b;
        this.imageurl9a = imageurl9a;
        this.imageurl9b = imageurl9b;
        this.imageurl10a = imageurl10a;
        this.imageurl10b = imageurl10b;
        this.imageurl11a = imageurl11a;
        this.imageurl11b = imageurl11b;
        this.imageurl12a = imageurl12a;
        this.imageurl12b = imageurl12b;
        this.imageurl13a = imageurl13a;
        this.imageurl13b = imageurl13b;
        this.imageurl14a = imageurl14a;
        this.imageurl14b = imageurl14b;
        this.imageurl15a = imageurl15a;
        this.imageurl15b = imageurl15b;
        this.imageurl16a = imageurl16a;
        this.imageurl16b = imageurl16b;
    }

    public Long getPhotouserid() {
        return photouserid;
    }

    public void setPhotouserid(Long photouserid) {
        this.photouserid = photouserid;
    }

    public String getImageurl1a() {
        return imageurl1a;
    }

    public void setImageurl1a(String imageurl1a) {
        this.imageurl1a = imageurl1a;
    }

    public String getImageurl1b() {
        return imageurl1b;
    }

    public void setImageurl1b(String imageurl1b) {
        this.imageurl1b = imageurl1b;
    }

    public String getImageurl2a() {
        return imageurl2a;
    }

    public void setImageurl2a(String imageurl2a) {
        this.imageurl2a = imageurl2a;
    }

    public String getImageurl2b() {
        return imageurl2b;
    }

    public void setImageurl2b(String imageurl2b) {
        this.imageurl2b = imageurl2b;
    }

    public String getImageurl3a() {
        return imageurl3a;
    }

    public void setImageurl3a(String imageurl3a) {
        this.imageurl3a = imageurl3a;
    }

    public String getImageurl3b() {
        return imageurl3b;
    }

    public void setImageurl3b(String imageurl3b) {
        this.imageurl3b = imageurl3b;
    }

    public String getImageurl4a() {
        return imageurl4a;
    }

    public void setImageurl4a(String imageurl4a) {
        this.imageurl4a = imageurl4a;
    }

    public String getImageurl4b() {
        return imageurl4b;
    }

    public void setImageurl4b(String imageurl4b) {
        this.imageurl4b = imageurl4b;
    }

    public String getImageurl5a() {
        return imageurl5a;
    }

    public void setImageurl5a(String imageurl5a) {
        this.imageurl5a = imageurl5a;
    }

    public String getImageurl5b() {
        return imageurl5b;
    }

    public void setImageurl5b(String imageurl5b) {
        this.imageurl5b = imageurl5b;
    }

    public String getImageurl6a() {
        return imageurl6a;
    }

    public void setImageurl6a(String imageurl6a) {
        this.imageurl6a = imageurl6a;
    }

    public String getImageurl6b() {
        return imageurl6b;
    }

    public void setImageurl6b(String imageurl6b) {
        this.imageurl6b = imageurl6b;
    }

    public String getImageurl7a() {
        return imageurl7a;
    }

    public void setImageurl7a(String imageurl7a) {
        this.imageurl7a = imageurl7a;
    }

    public String getImageurl7b() {
        return imageurl7b;
    }

    public void setImageurl7b(String imageurl7b) {
        this.imageurl7b = imageurl7b;
    }

    public String getImageurl8a() {
        return imageurl8a;
    }

    public void setImageurl8a(String imageurl8a) {
        this.imageurl8a = imageurl8a;
    }

    public String getImageurl8b() {
        return imageurl8b;
    }

    public void setImageurl8b(String imageurl8b) {
        this.imageurl8b = imageurl8b;
    }

    public String getImageurl9a() {
        return imageurl9a;
    }

    public void setImageurl9a(String imageurl9a) {
        this.imageurl9a = imageurl9a;
    }

    public String getImageurl9b() {
        return imageurl9b;
    }

    public void setImageurl9b(String imageurl9b) {
        this.imageurl9b = imageurl9b;
    }

    public String getImageurl10a() {
        return imageurl10a;
    }

    public void setImageurl10a(String imageurl10a) {
        this.imageurl10a = imageurl10a;
    }

    public String getImageurl10b() {
        return imageurl10b;
    }

    public void setImageurl10b(String imageurl10b) {
        this.imageurl10b = imageurl10b;
    }

    public String getImageurl11a() {
        return imageurl11a;
    }

    public void setImageurl11a(String imageurl11a) {
        this.imageurl11a = imageurl11a;
    }

    public String getImageurl11b() {
        return imageurl11b;
    }

    public void setImageurl11b(String imageurl11b) {
        this.imageurl11b = imageurl11b;
    }

    public String getImageurl12a() {
        return imageurl12a;
    }

    public void setImageurl12a(String imageurl12a) {
        this.imageurl12a = imageurl12a;
    }

    public String getImageurl12b() {
        return imageurl12b;
    }

    public void setImageurl12b(String imageurl12b) {
        this.imageurl12b = imageurl12b;
    }

    public String getImageurl13a() {
        return imageurl13a;
    }

    public void setImageurl13a(String imageurl13a) {
        this.imageurl13a = imageurl13a;
    }

    public String getImageurl13b() {
        return imageurl13b;
    }

    public void setImageurl13b(String imageurl13b) {
        this.imageurl13b = imageurl13b;
    }

    public String getImageurl14a() {
        return imageurl14a;
    }

    public void setImageurl14a(String imageurl14a) {
        this.imageurl14a = imageurl14a;
    }

    public String getImageurl14b() {
        return imageurl14b;
    }

    public void setImageurl14b(String imageurl14b) {
        this.imageurl14b = imageurl14b;
    }

    public String getImageurl15a() {
        return imageurl15a;
    }

    public void setImageurl15a(String imageurl15a) {
        this.imageurl15a = imageurl15a;
    }

    public String getImageurl15b() {
        return imageurl15b;
    }

    public void setImageurl15b(String imageurl15b) {
        this.imageurl15b = imageurl15b;
    }

    public String getImageurl16a() {
        return imageurl16a;
    }

    public void setImageurl16a(String imageurl16a) {
        this.imageurl16a = imageurl16a;
    }

    public String getImageurl16b() {
        return imageurl16b;
    }

    public void setImageurl16b(String imageurl16b) {
        this.imageurl16b = imageurl16b;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (photouserid != null ? photouserid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photos)) {
            return false;
        }
        Photos other = (Photos) object;
        if ((this.photouserid == null && other.photouserid != null) || (this.photouserid != null && !this.photouserid.equals(other.photouserid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Photos[photouserid=" + photouserid + "]";
    }

}
