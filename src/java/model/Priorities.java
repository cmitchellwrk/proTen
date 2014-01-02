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
@Table(name = "priorities")
@NamedQueries({
    @NamedQuery(name = "Priorities.findAll", query = "SELECT p FROM Priorities p"),
    @NamedQuery(name = "Priorities.findById", query = "SELECT p FROM Priorities p WHERE p.id = :id"),
    @NamedQuery(name = "Priorities.findByIdcurrent", query = "SELECT p FROM Priorities p WHERE p.idcurrent = :idcurrent"),
    @NamedQuery(name = "Priorities.findByPri1", query = "SELECT p FROM Priorities p WHERE p.pri1 = :pri1"),
    @NamedQuery(name = "Priorities.findByPri2", query = "SELECT p FROM Priorities p WHERE p.pri2 = :pri2"),
    @NamedQuery(name = "Priorities.findByPri3", query = "SELECT p FROM Priorities p WHERE p.pri3 = :pri3"),
    @NamedQuery(name = "Priorities.findByPri4", query = "SELECT p FROM Priorities p WHERE p.pri4 = :pri4"),
    @NamedQuery(name = "Priorities.findByPri5", query = "SELECT p FROM Priorities p WHERE p.pri5 = :pri5"),
    @NamedQuery(name = "Priorities.findByPri6", query = "SELECT p FROM Priorities p WHERE p.pri6 = :pri6"),
    @NamedQuery(name = "Priorities.findByPri7", query = "SELECT p FROM Priorities p WHERE p.pri7 = :pri7"),
    @NamedQuery(name = "Priorities.findByPri8", query = "SELECT p FROM Priorities p WHERE p.pri8 = :pri8"),
    @NamedQuery(name = "Priorities.findByPri9", query = "SELECT p FROM Priorities p WHERE p.pri9 = :pri9"),
    @NamedQuery(name = "Priorities.findByPri10", query = "SELECT p FROM Priorities p WHERE p.pri10 = :pri10")})
public class Priorities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "idcurrent")
    private long idcurrent;
    @Basic(optional = false)
    @Column(name = "pri1")
    private String pri1;
    @Basic(optional = false)
    @Column(name = "pri2")
    private String pri2;
    @Basic(optional = false)
    @Column(name = "pri3")
    private String pri3;
    @Basic(optional = false)
    @Column(name = "pri4")
    private String pri4;
    @Basic(optional = false)
    @Column(name = "pri5")
    private String pri5;
    @Basic(optional = false)
    @Column(name = "pri6")
    private String pri6;
    @Basic(optional = false)
    @Column(name = "pri7")
    private String pri7;
    @Basic(optional = false)
    @Column(name = "pri8")
    private String pri8;
    @Basic(optional = false)
    @Column(name = "pri9")
    private String pri9;
    @Basic(optional = false)
    @Column(name = "pri10")
    private String pri10;

    public Priorities() {
    }

    public Priorities(Long id) {
        this.id = id;
    }

    public Priorities(Long id, long idcurrent, String pri1, String pri2, String pri3, String pri4, String pri5, String pri6, String pri7, String pri8, String pri9, String pri10) {
        this.id = id;
        this.idcurrent = idcurrent;
        this.pri1 = pri1;
        this.pri2 = pri2;
        this.pri3 = pri3;
        this.pri4 = pri4;
        this.pri5 = pri5;
        this.pri6 = pri6;
        this.pri7 = pri7;
        this.pri8 = pri8;
        this.pri9 = pri9;
        this.pri10 = pri10;
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

    public String getPri1() {
        return pri1;
    }

    public void setPri1(String pri1) {
        this.pri1 = pri1;
    }

    public String getPri2() {
        return pri2;
    }

    public void setPri2(String pri2) {
        this.pri2 = pri2;
    }

    public String getPri3() {
        return pri3;
    }

    public void setPri3(String pri3) {
        this.pri3 = pri3;
    }

    public String getPri4() {
        return pri4;
    }

    public void setPri4(String pri4) {
        this.pri4 = pri4;
    }

    public String getPri5() {
        return pri5;
    }

    public void setPri5(String pri5) {
        this.pri5 = pri5;
    }

    public String getPri6() {
        return pri6;
    }

    public void setPri6(String pri6) {
        this.pri6 = pri6;
    }

    public String getPri7() {
        return pri7;
    }

    public void setPri7(String pri7) {
        this.pri7 = pri7;
    }

    public String getPri8() {
        return pri8;
    }

    public void setPri8(String pri8) {
        this.pri8 = pri8;
    }

    public String getPri9() {
        return pri9;
    }

    public void setPri9(String pri9) {
        this.pri9 = pri9;
    }

    public String getPri10() {
        return pri10;
    }

    public void setPri10(String pri10) {
        this.pri10 = pri10;
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
        if (!(object instanceof Priorities)) {
            return false;
        }
        Priorities other = (Priorities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Priorities[id=" + id + "]";
    }

}
