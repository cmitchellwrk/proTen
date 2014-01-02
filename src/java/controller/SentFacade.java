/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Sent;

/**
 *
 * @author Chris Mitchell
 */
@Stateless
public class SentFacade extends AbstractFacade<Sent> {
    @PersistenceContext(unitName = "proTenPU")
    private EntityManager em;




private long sentmemid;



    protected EntityManager getEntityManager() {
        return em;
    }

    public SentFacade() {
        super(Sent.class);
    }
    

     public List<Sent> findSentMem(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String ssmm = "select o " + " FROM Sent o " + " WHERE  o.sendfromid =" + sentmemid  + " order by o.messageDate DESC ";


        javax.persistence.Query q = getEntityManager().createQuery(ssmm);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }


      public int findSentMemCount() {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


       // String ssmm = "select o " + " FROM Sent o " + " WHERE  o.sendfromid =" + sentmemid  + " order by o.messageDate DESC ";

      String eff = "select o " + " FROM Sent o " + " WHERE  o.sendfromid ='" + sentmemid + "'";

        javax.persistence.Query q = getEntityManager().createQuery(eff);

          List<Object[]> result2  =  q.getResultList();

          return result2.size();



    }




    /**
     * @return the sentmemid
     */
    public long getSentmemid() {
        return sentmemid;
    }

    /**
     * @param sentmemid the sentmemid to set
     */
    public void setSentmemid(long sentmemid) {
        this.sentmemid = sentmemid;
    }














}
