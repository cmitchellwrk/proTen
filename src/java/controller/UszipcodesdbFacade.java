/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Uszipcodesdb;

/**
 *
 * @author Chris Mitchell
 */
@Stateless
public class UszipcodesdbFacade extends AbstractFacade<Uszipcodesdb> {
    @PersistenceContext(unitName = "proTenPU")
    private EntityManager em;



 private Uszipcodesdb current;

    private String zipdatathree;


    

    protected EntityManager getEntityManager() {
        return em;
    }




    public UszipcodesdbFacade() {
        super(Uszipcodesdb.class);
    }




    /**
     * @return the zipdatathree
     */
    public String getZipdatathree() {
        return zipdatathree;
    }

    /**
     * @param zipdatathree the zipdatathree to set
     */
    public void setZipdatathree(String zipdatathree) {
        this.zipdatathree = zipdatathree;
    }



 public Uszipcodesdb findRangeZip() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Uszipcodesdb o " + " WHERE  o.zipcode ='" + getZipdatathree() + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);

        if(q.getResultList().isEmpty()){

             current = new Uszipcodesdb();
             current.setCity(" ");
             current.setState(" ");
             current.setLatitude(0);
             current.setLongitude(0);
             current.setStatesfullname(" ");
             current.setZipcode("5");

            return current;

            
        } else{

        return (Uszipcodesdb) q.getSingleResult();

     }



    }




}
