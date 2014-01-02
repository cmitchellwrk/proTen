/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Deletedfeedback;

/**
 *
 * @author Chris Mitchell
 */
@Stateless
public class DeletedfeedbackFacade extends AbstractFacade<Deletedfeedback> {
    @PersistenceContext(unitName = "proTenPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public DeletedfeedbackFacade() {
        super(Deletedfeedback.class);
    }

}
