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
@Table(name = "deletedfeedback")
@NamedQueries({
    @NamedQuery(name = "Deletedfeedback.findAll", query = "SELECT d FROM Deletedfeedback d"),
    @NamedQuery(name = "Deletedfeedback.findById", query = "SELECT d FROM Deletedfeedback d WHERE d.id = :id"),
    @NamedQuery(name = "Deletedfeedback.findByUsernamedelete", query = "SELECT d FROM Deletedfeedback d WHERE d.usernamedelete = :usernamedelete"),
    @NamedQuery(name = "Deletedfeedback.findByPassworddelete", query = "SELECT d FROM Deletedfeedback d WHERE d.passworddelete = :passworddelete"),
    @NamedQuery(name = "Deletedfeedback.findByReasonfordelete", query = "SELECT d FROM Deletedfeedback d WHERE d.reasonfordelete = :reasonfordelete"),
    @NamedQuery(name = "Deletedfeedback.findByHowmanydates", query = "SELECT d FROM Deletedfeedback d WHERE d.howmanydates = :howmanydates"),
    @NamedQuery(name = "Deletedfeedback.findByRecommendation", query = "SELECT d FROM Deletedfeedback d WHERE d.recommendation = :recommendation")})
public class Deletedfeedback implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "usernamedelete")
    private String usernamedelete;
    @Basic(optional = false)
    @Column(name = "passworddelete")
    private String passworddelete;
    @Basic(optional = false)
    @Column(name = "reasonfordelete")
    private String reasonfordelete;
    @Basic(optional = false)
    @Column(name = "howmanydates")
    private String howmanydates;
    @Basic(optional = false)
    @Lob
    @Column(name = "suggestions")
    private String suggestions;
    @Basic(optional = false)
    @Column(name = "recommendation")
    private String recommendation;

    public Deletedfeedback() {
    }

    public Deletedfeedback(Long id) {
        this.id = id;
    }

    public Deletedfeedback(Long id, String usernamedelete, String passworddelete, String reasonfordelete, String howmanydates, String suggestions, String recommendation) {
        this.id = id;
        this.usernamedelete = usernamedelete;
        this.passworddelete = passworddelete;
        this.reasonfordelete = reasonfordelete;
        this.howmanydates = howmanydates;
        this.suggestions = suggestions;
        this.recommendation = recommendation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsernamedelete() {
        return usernamedelete;
    }

    public void setUsernamedelete(String usernamedelete) {
        this.usernamedelete = usernamedelete;
    }

    public String getPassworddelete() {
        return passworddelete;
    }

    public void setPassworddelete(String passworddelete) {
        this.passworddelete = passworddelete;
    }

    public String getReasonfordelete() {
        return reasonfordelete;
    }

    public void setReasonfordelete(String reasonfordelete) {
        this.reasonfordelete = reasonfordelete;
    }

    public String getHowmanydates() {
        return howmanydates;
    }

    public void setHowmanydates(String howmanydates) {
        this.howmanydates = howmanydates;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
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
        if (!(object instanceof Deletedfeedback)) {
            return false;
        }
        Deletedfeedback other = (Deletedfeedback) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Deletedfeedback[id=" + id + "]";
    }

}
