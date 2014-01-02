/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Sendhistoryintimate;

/**
 *
 * @author Chris Mitchell
 */
@Stateless
public class SendhistoryintimateFacade extends AbstractFacade<Sendhistoryintimate> {
    @PersistenceContext(unitName = "proTenPU")
    private EntityManager em;


    private long sendhisidlookup;
    

    protected EntityManager getEntityManager() {
        return em;
    }

    public SendhistoryintimateFacade() {
        super(Sendhistoryintimate.class);
    }

    /**
     * @return the sendhisidlookup
     */
    public long getSendhisidlookup() {
        return sendhisidlookup;
    }

    /**
     * @param sendhisidlookup the sendhisidlookup to set
     */
    public void setSendhisidlookup(long sendhisidlookup) {
        this.sendhisidlookup = sendhisidlookup;
    }



     public String findSendhistorylookup() {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Sendhistoryintimate o " + " WHERE  o.shiid = " + sendhisidlookup  ;

    //    String efflon = "select o.userid " + " FROM Members o " + " WHERE  o.username ='" + usernamelogin + "'";

        javax.persistence.Query q = getEntityManager().createQuery(eff);

        List<Sendhistoryintimate> result = q.getResultList();

        if (result.size()<2) {

             return "nosendhistoryintimate";

        }else{

             return "sendhistoryintimateexists";

        }

    }




  public String findSendhistoryCheck() {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Sendhistoryintimate o " + " WHERE  o.shiid = " + sendhisidlookup  ;

    //    String efflon = "select o.userid " + " FROM Members o " + " WHERE  o.username ='" + usernamelogin + "'";

        javax.persistence.Query q = getEntityManager().createQuery(eff);

        List<Sendhistoryintimate> result = q.getResultList();

        if (result.isEmpty()) {

             return "nosendhistoryintimate";

        }else{

             return "sendhistoryintimateexists";

        }

    }



    
}
