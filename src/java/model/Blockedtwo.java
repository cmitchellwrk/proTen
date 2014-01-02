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
@Table(name = "blockedtwo")
@NamedQueries({
    @NamedQuery(name = "Blockedtwo.findAll", query = "SELECT b FROM Blockedtwo b"),
    @NamedQuery(name = "Blockedtwo.findById", query = "SELECT b FROM Blockedtwo b WHERE b.id = :id"),
    @NamedQuery(name = "Blockedtwo.findByUnblock", query = "SELECT b FROM Blockedtwo b WHERE b.unblock = :unblock"),
    @NamedQuery(name = "Blockedtwo.findByIdcurrent", query = "SELECT b FROM Blockedtwo b WHERE b.idcurrent = :idcurrent"),
    @NamedQuery(name = "Blockedtwo.findByIdofblocked", query = "SELECT b FROM Blockedtwo b WHERE b.idofblocked = :idofblocked"),
    @NamedQuery(name = "Blockedtwo.findByImageurl", query = "SELECT b FROM Blockedtwo b WHERE b.imageurl = :imageurl")})
public class Blockedtwo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id =112321321L;
    @Basic(optional = false)
    @Column(name = "unblock")
    private boolean unblock;
    @Basic(optional = false)
    @Column(name = "idcurrent")
    private long idcurrent;
    @Basic(optional = false)
    @Column(name = "idofblocked")
    private long idofblocked;
    @Basic(optional = false)
    @Column(name = "imageurl")
    private String imageurl;

    public Blockedtwo() {
    }

    public Blockedtwo(Long id) {
        this.id = id;
    }

    public Blockedtwo(Long id, boolean unblock, long idcurrent, long idofblocked, String imageurl) {
        this.id = id;
        this.unblock = unblock;
        this.idcurrent = idcurrent;
        this.idofblocked = idofblocked;
        this.imageurl = imageurl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getUnblock() {
        return unblock;
    }

    public void setUnblock(boolean unblock) {
        this.unblock = unblock;
    }

    public long getIdcurrent() {
        return idcurrent;
    }

    public void setIdcurrent(long idcurrent) {
        this.idcurrent = idcurrent;
    }

    public long getIdofblocked() {
        return idofblocked;
    }

    public void setIdofblocked(long idofblocked) {
        this.idofblocked = idofblocked;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
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
        if (!(object instanceof Blockedtwo)) {
            return false;
        }
        Blockedtwo other = (Blockedtwo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Blockedtwo[id=" + id + "]";
    }

}
