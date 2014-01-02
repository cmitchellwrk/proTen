/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Blockedtwo;

/**
 *
 * @author Chris Mitchell
 */
@Stateless
public class BlockedtwoFacade extends AbstractFacade<Blockedtwo> {
    @PersistenceContext(unitName = "proTenPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }



    private long checkblockid;

    

    public BlockedtwoFacade() {
        super(Blockedtwo.class);
    }





       public List<Blockedtwo> findBlockedmembers(int[] range) {

          javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Blockedtwo o " + " WHERE  o.idcurrent = " + checkblockid ;


        javax.persistence.Query q = getEntityManager().createQuery(effgh);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

       


    /**
     * @return the checkblockid
     */
    public long getCheckblockid() {
        return checkblockid;
    }

    /**
     * @param checkblockid the checkblockid to set
     */
    public void setCheckblockid(long checkblockid) {
        this.checkblockid = checkblockid;
    }


    




}
