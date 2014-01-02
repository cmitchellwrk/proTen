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
@Table(name = "sendhistoryintimate")
@NamedQueries({
    @NamedQuery(name = "Sendhistoryintimate.findAll", query = "SELECT s FROM Sendhistoryintimate s"),
    @NamedQuery(name = "Sendhistoryintimate.findById", query = "SELECT s FROM Sendhistoryintimate s WHERE s.id = :id"),
    @NamedQuery(name = "Sendhistoryintimate.findByShiid", query = "SELECT s FROM Sendhistoryintimate s WHERE s.shiid = :shiid"),
    @NamedQuery(name = "Sendhistoryintimate.findBySentuser", query = "SELECT s FROM Sendhistoryintimate s WHERE s.sentuser = :sentuser")})
public class Sendhistoryintimate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id =112321321L;
    @Basic(optional = false)
    @Column(name = "shiid")
    private long shiid;
    @Basic(optional = false)
    @Column(name = "sentuser")
    private long sentuser;

    public Sendhistoryintimate() {
    }

    public Sendhistoryintimate(Long id) {
        this.id = id;
    }

    public Sendhistoryintimate(Long id, long shiid, long sentuser) {
        this.id = id;
        this.shiid = shiid;
        this.sentuser = sentuser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getShiid() {
        return shiid;
    }

    public void setShiid(long shiid) {
        this.shiid = shiid;
    }

    public long getSentuser() {
        return sentuser;
    }

    public void setSentuser(long sentuser) {
        this.sentuser = sentuser;
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
        if (!(object instanceof Sendhistoryintimate)) {
            return false;
        }
        Sendhistoryintimate other = (Sendhistoryintimate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Sendhistoryintimate[id=" + id + "]";
    }

}
