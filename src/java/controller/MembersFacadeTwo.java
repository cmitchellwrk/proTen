/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Blockedtwo;
import model.Hasviewedprofile;
import model.Hasviewedprofiletwo;
import model.Members;
import model.Uszipcodesdb;



import java.util.logging.Level;
import java.util.logging.Logger;

// import javax.management.Query;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.PersistenceContext;

import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.Query;
import model.Inbox;
import model.Umightlike;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;

/**
 *
 * @author Chris Mitchell
 */
@Stateful
public class MembersFacadeTwo extends AbstractFacade<Members>  {
    @PersistenceContext(unitName = "proTenPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    
    public MembersFacadeTwo() {
        super(Members.class);
    }



private long useruser;

    /**
     * @return the useruser
     */
    public long getUseruser() {
        return useruser;
    }

    /**
     * @param useruser the useruser to set
     */
    public void setUseruser(long useruser) {
        this.useruser = useruser;
    }




}
