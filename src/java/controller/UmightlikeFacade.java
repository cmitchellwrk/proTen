/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Umightlike;

/**
 *
 * @author Chris Mitchell
 */
@Stateless
public class UmightlikeFacade extends AbstractFacade<Umightlike> {
    @PersistenceContext(unitName = "proTenPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UmightlikeFacade() {
        super(Umightlike.class);
    }

}
