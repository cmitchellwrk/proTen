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
@Table(name = "abuse")
@NamedQueries({
    @NamedQuery(name = "Abuse.findAll", query = "SELECT a FROM Abuse a"),
    @NamedQuery(name = "Abuse.findById", query = "SELECT a FROM Abuse a WHERE a.id = :id"),
    @NamedQuery(name = "Abuse.findByIdUsernameReportid", query = "SELECT a FROM Abuse a WHERE a.idUsernameReportid = :idUsernameReportid"),
    @NamedQuery(name = "Abuse.findByUsernameOffender", query = "SELECT a FROM Abuse a WHERE a.usernameOffender = :usernameOffender"),
    @NamedQuery(name = "Abuse.findByDate", query = "SELECT a FROM Abuse a WHERE a.date = :date")})
public class Abuse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "id_username_reportid")
    private long idUsernameReportid;
    @Basic(optional = false)
    @Column(name = "username_offender")
    private long usernameOffender;
    @Basic(optional = false)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @Lob
    @Column(name = "description_of_offense")
    private String descriptionOfOffense;

    public Abuse() {
    }

    public Abuse(Long id) {
        this.id = id;
    }

    public Abuse(Long id, long idUsernameReportid, long usernameOffender, String date, String descriptionOfOffense) {
        this.id = id;
        this.idUsernameReportid = idUsernameReportid;
        this.usernameOffender = usernameOffender;
        this.date = date;
        this.descriptionOfOffense = descriptionOfOffense;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdUsernameReportid() {
        return idUsernameReportid;
    }

    public void setIdUsernameReportid(long idUsernameReportid) {
        this.idUsernameReportid = idUsernameReportid;
    }

    public long getUsernameOffender() {
        return usernameOffender;
    }

    public void setUsernameOffender(long usernameOffender) {
        this.usernameOffender = usernameOffender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescriptionOfOffense() {
        return descriptionOfOffense;
    }

    public void setDescriptionOfOffense(String descriptionOfOffense) {
        this.descriptionOfOffense = descriptionOfOffense;
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
        if (!(object instanceof Abuse)) {
            return false;
        }
        Abuse other = (Abuse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Abuse[id=" + id + "]";
    }

}
