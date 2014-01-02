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
import model.Inbox;

/**
 *
 * @author Chris Mitchell
 */
@Stateless
public class InboxFacade extends AbstractFacade<Inbox> {
    @PersistenceContext(unitName = "proTenPU")
    private EntityManager em;


    

    protected EntityManager getEntityManager() {
        return em;
    }


    private String replylookup;


private long llnnid;



    public InboxFacade() {
        super(Inbox.class);
    }



    /**
     * @return the replylookup
     */
    public String getReplylookup() {
        return replylookup;
    }

    /**
     * @param replylookup the replylookup to set
     */
    public void setReplylookup(String replylookup) {
        this.replylookup = replylookup;
    }




     public Inbox findRangeInre() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Inbox o " + " WHERE  o.id ='" + replylookup + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);

         List<Object[]> result = q.getResultList();

          if(result.size() == 1){

                return (Inbox) q.getSingleResult();

            }
            else{
                 return new Inbox();
            }

    }



      public List<Inbox> findRangeInboxUsr(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Inbox o " + " WHERE  o.sendtoid =" + llnnid   + " order by o.messageDate DESC ";

        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);

        return q.getResultList();
    }



        public int findRangeInboxUsrMsgCount() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Inbox o " + " WHERE  o.sendtoid =" + llnnid   + " AND " + "o.status =" + "'unread'";

        javax.persistence.Query q = getEntityManager().createQuery(eff);
       
        return q.getResultList().size();
    }




      


       public int findRangeInboxUsrCount() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Inbox o " + " WHERE  o.sendtoid ='" + llnnid + "'";

        javax.persistence.Query q = getEntityManager().createQuery(eff);
       
          List<Object[]> result2  =  q.getResultList();

          return result2.size();

    }

    /**
     * @return the llnnid
     */
    public long getLlnnid() {
        return llnnid;
    }

    /**
     * @param llnnid the llnnid to set
     */
    public void setLlnnid(long llnnid) {
        this.llnnid = llnnid;
    }

   


    








}
