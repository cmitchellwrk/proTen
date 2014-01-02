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
@Table(name = "lastpoints")
@NamedQueries({
    @NamedQuery(name = "Lastpoints.findAll", query = "SELECT l FROM Lastpoints l"),
    @NamedQuery(name = "Lastpoints.findById", query = "SELECT l FROM Lastpoints l WHERE l.id = :id"),
    @NamedQuery(name = "Lastpoints.findByIdpersonpointsgive", query = "SELECT l FROM Lastpoints l WHERE l.idpersonpointsgive = :idpersonpointsgive"),
    @NamedQuery(name = "Lastpoints.findByIdpersonpointsreceive", query = "SELECT l FROM Lastpoints l WHERE l.idpersonpointsreceive = :idpersonpointsreceive"),
    @NamedQuery(name = "Lastpoints.findByTotalpointslast", query = "SELECT l FROM Lastpoints l WHERE l.totalpointslast = :totalpointslast"),
    @NamedQuery(name = "Lastpoints.findByDatelastptsgiven", query = "SELECT l FROM Lastpoints l WHERE l.datelastptsgiven = :datelastptsgiven")})
public class Lastpoints implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "idpersonpointsgive")
    private long idpersonpointsgive;
    @Basic(optional = false)
    @Column(name = "idpersonpointsreceive")
    private long idpersonpointsreceive;
    @Column(name = "totalpointslast")
    private Integer totalpointslast;
    @Basic(optional = false)
    @Column(name = "datelastptsgiven")
    private String datelastptsgiven;

    public Lastpoints() {
    }

    public Lastpoints(Long id) {
        this.id = id;
    }

    public Lastpoints(Long id, long idpersonpointsgive, long idpersonpointsreceive, String datelastptsgiven) {
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

    public Integer getTotalpointslast() {
        return totalpointslast;
    }

    public void setTotalpointslast(Integer totalpointslast) {
        this.totalpointslast = totalpointslast;
    }

    public String getDatelastptsgiven() {
        return datelastptsgiven;
    }

    public void setDatelastptsgiven(String datelastptsgiven) {
        this.datelastptsgiven = datelastptsgiven;
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
        if (!(object instanceof Lastpoints)) {
            return false;
        }
        Lastpoints other = (Lastpoints) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Lastpoints[id=" + id + "]";
    }

}
