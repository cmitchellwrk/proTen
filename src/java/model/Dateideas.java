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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Chris Mitchell
 */
@Entity
@Table(name = "dateideas")
@NamedQueries({
    @NamedQuery(name = "Dateideas.findAll", query = "SELECT d FROM Dateideas d"),
    @NamedQuery(name = "Dateideas.findById", query = "SELECT d FROM Dateideas d WHERE d.id = :id"),
    @NamedQuery(name = "Dateideas.findByIdmember", query = "SELECT d FROM Dateideas d WHERE d.idmember = :idmember"),
    @NamedQuery(name = "Dateideas.findByIdeacatagory", query = "SELECT d FROM Dateideas d WHERE d.ideacatagory = :ideacatagory")})
public class Dateideas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "idmember")
    private long idmember;
    @Lob
    @Column(name = "idea")
    private String idea;
    @Column(name = "ideacatagory")
    private String ideacatagory;

    public Dateideas() {
    }

    public Dateideas(Long id) {
        this.id = id;
    }

    public Dateideas(Long id, long idmember) {
        this.id = id;
        this.idmember = idmember;
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

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public String getIdeacatagory() {
        return ideacatagory;
    }

    public void setIdeacatagory(String ideacatagory) {
        this.ideacatagory = ideacatagory;
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
        if (!(object instanceof Dateideas)) {
            return false;
        }
        Dateideas other = (Dateideas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dateideas[id=" + id + "]";
    }

}
