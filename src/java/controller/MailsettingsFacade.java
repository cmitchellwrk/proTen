/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Mailsettings;

/**
 *
 * @author Chris Mitchell
 */
@Stateless
public class MailsettingsFacade extends AbstractFacade<Mailsettings> {
    @PersistenceContext(unitName = "proTenPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }



    private long mailloginid;

    


    public MailsettingsFacade() {
        super(Mailsettings.class);
    }

    /**
     * @return the mailloginid
     */
    public long getMailloginid() {
        return mailloginid;
    }

    /**
     * @param mailloginid the mailloginid to set
     */
    public void setMailloginid(long mailloginid) {
        this.mailloginid = mailloginid;
    }

   

 public Mailsettings findMailmem() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Mailsettings o " + " WHERE  o.idmember ='" + mailloginid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effgh);

        return (Mailsettings) q.getSingleResult();

    }




     public List<Mailsettings> findMailsetting(int[] range) {

          javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String effgh = "select o " + " FROM Mailsettings o " + " WHERE  o.idmember ='" + mailloginid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effgh);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }





}
