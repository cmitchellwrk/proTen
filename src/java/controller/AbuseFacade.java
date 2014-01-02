/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Abuse;

/**
 *
 * @author Chris Mitchell
 */
@Stateless
public class AbuseFacade extends AbstractFacade<Abuse> {
    @PersistenceContext(unitName = "proTenPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AbuseFacade() {
        super(Abuse.class);
    }

}
