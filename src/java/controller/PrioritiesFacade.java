/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Priorities;

/**
 *
 * @author Chris Mitchell
 */
@Stateless
public class PrioritiesFacade extends AbstractFacade<Priorities> {
    @PersistenceContext(unitName = "proTenPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PrioritiesFacade() {
        super(Priorities.class);
    }

}
