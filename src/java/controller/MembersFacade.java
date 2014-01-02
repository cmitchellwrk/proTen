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
import model.Hasviewedprofile;
import model.Hasviewedprofiletwo;
import model.Members;
import model.Uszipcodesdb;



import java.util.logging.Level;
import java.util.logging.Logger;

// import javax.management.Query;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.PersistenceContext;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.Query;
import model.Inbox;
import model.Lastpointsgiveperson;
import model.Points;
import model.Umightlike;

/**
 *
 * @author Chris Mitchell
 */
@Stateless
public class MembersFacade extends AbstractFacade<Members> {
    @PersistenceContext(unitName = "proTenPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

 private String checkusernameid;

    private String zipdatathree;


      private String usernamelogin;


      private long lnguserid;


      private Long idfavlookup;


      private long idmemhold;


        private String usernamecreate;


         private int trackflum;



    private float flatone;
    private float flattwo;
    private float flonone;
    private float flontwo;
    private String genderFlmem;
    private String seekingFlmem;
    private String lookingFlmem;
   
    private String agefromFlem;
    private String agetoFlem;
    

    private String stateFlmem;

    private String cityFlmem;

    private String ethnicityFlmem;
    


    private String idd;
    private String sub;

    private String senn;


     private String sennpassword;




    private String senntwo;
    

  private Long sntfromidd;

private Long sntfromiddtwo;



private Long snttoid;



private String snttoo;




private Long sentimgeurl;



//use to represent the userid of the person who might be blocked in a inbox message when the  user/
//member tries to send a reply - it checks this long to see this peron was blocked by the current user.
private Long sentfromblock;


//imageurl for blockuser.
private String subblockimageurl;

   

private Long hasviwedid;



  private javax.transaction.UserTransaction utx;

private String inboxupdateimageurl;




private String inboxstatusid;




private String gendmemhold;



private String favhvprofileimageurl;




private String yearboundup;

private String yearboundlow;





private String  genderumight;


private String emaillookup;

private Long idppreceive;

private Long memberpointsid;




private int ptsphotomem;

private int ptsprofilemem;

private int ptsfirstmessagemem;

private int ptsfunnymem;

private int ptsinterestingmem;

private int ptspersonalitymem;

private int ptsfirstdatemem;

private int ptsdateideamem;

private int ptsverifyprofilemem;









    public MembersFacade() {
        super(Members.class);
    }



 public String findlogin() {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Members o " + " WHERE  o.username ='" + getUsernamelogin() + "'";

    //    String efflon = "select o.userid " + " FROM Members o " + " WHERE  o.username ='" + usernamelogin + "'";
 
        

        javax.persistence.Query q = getEntityManager().createQuery(eff);

        List<Members> result = q.getResultList();

        if (result.size() > 0) {

            Members msm = (Members) q.getSingleResult();

            //     long plp =    msm.getUserid();



            setLnguserid(msm.getUserid());
            setUsernamecreate(msm.getUsername());

            return "welcome";
        } else {
            return "incorrect";
        }

    }




     public String findepassword() {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Members o " + " WHERE  o.email ='" + getEmaillookup() + "'";

    //    String efflon = "select o.userid " + " FROM Members o " + " WHERE  o.username ='" + usernamelogin + "'";

        javax.persistence.Query q = getEntityManager().createQuery(eff);

        List<Members> result = q.getResultList();

        if (result.size() > 0) {

            Members msm = (Members) q.getSingleResult();

       //     String foundpassword = msm.getPassword();

            //     long plp =    msm.getUserid();

          //  setLnguserid(msm.getUserid());

            return "passwordyes";

        } else {

            return "incorrect";

        }

    }



 public String findBlockedTwoReply() {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Blockedtwo o " + " WHERE  o.idcurrent = " + sentfromblock  + " AND " + "o.idofblocked = "  + snttoid ;

    //    String efflon = "select o.userid " + " FROM Members o " + " WHERE  o.username ='" + usernamelogin + "'";

        javax.persistence.Query q = getEntityManager().createQuery(eff);

        List<Blockedtwo> result = q.getResultList();

        if (result.size() > 0) {

           
            return "/mailsettings/blockuser";

        }else{
            
            return "noblock";
        }

    }




 public String findHasViewedProfileDuplicate() {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Hasviewedprofiletwo o " + " WHERE  o.idcurrent = " + hasviwedid  + " AND " + "o.idhvperson = "  + lnguserid    ;

    //    String efflon = "select o.userid " + " FROM Members o " + " WHERE  o.username ='" + usernamelogin + "'";

        javax.persistence.Query q = getEntityManager().createQuery(eff);

        List<Hasviewedprofiletwo> result = q.getResultList();

        if (result.isEmpty()) {

             return "nohvpduplicate";

        }else{

             return "duplicatexists";

        }

    }




 public String findLastpointsgiven() {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Lastpointsgiveperson o " + " WHERE  o.idpersonpointsgive = " + lnguserid  + " AND " + "o.idpersonpointsreceive = "  + idppreceive   ;

    //    String efflon = "select o.userid " + " FROM Members o " + " WHERE  o.username ='" + usernamelogin + "'";

        javax.persistence.Query q = getEntityManager().createQuery(eff);

        List<Lastpointsgiveperson> result = q.getResultList();

        if (result.isEmpty()) {

             return "noexists";

        }else{

             return "alreadyexists";

        }

    }




    public Lastpointsgiveperson findLastptsgivensingle() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();



 String eff = "select o " + " FROM Lastpointsgiveperson o " + " WHERE  o.idpersonpointsgive = " + lnguserid  + " AND " + "o.idpersonpointsreceive = "  + idppreceive   ;


        javax.persistence.Query q = getEntityManager().createQuery(eff);

        return (Lastpointsgiveperson) q.getSingleResult();
    }




 


 public List<Inbox> findRangeInboxUsr(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Inbox o " + " WHERE  o.sendtoid =" + lnguserid  + " order by o.messageDate DESC ";

        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);

        return q.getResultList();
    }







    public List<Members> findRangeFl(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();



        String eff = "select o " + " FROM Members o " + " WHERE  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
                + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() + " AND " + " o.gender ='"
                + getGenderFlmem() + "'" + " AND " + " o.seekingA ='" + getSeekingFlmem() + "'" + " AND " + " o.lookingFor ='"
                + getLookingFlmem() + "'";


        String effg = "select o " + " FROM Members o " + " WHERE  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
                + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() + " AND " + " o.gender ='"  + getSeekingFlmem() + "'"
                + " AND " + " o.lookingFor ='" + getLookingFlmem() + "'" + " AND " + " o.seekingA ='" + getGenderFlmem() + "'" + " AND " + "( o.birthYear BETWEEN "
                + getAgefromFlem() + " AND " + getAgetoFlem() + " OR " + " o.birthYear BETWEEN " + getAgetoFlem()
                + " AND " + getAgefromFlem() + ")" + " AND " + "NOT (o.userid = " + lnguserid + ")" + " AND " + " o.pointsPhotos >= " + ptsphotomem + " AND " +
                " o.pointsProfile >= " + ptsprofilemem + " AND " + " o.pointsFirstmessage >= " + ptsfirstmessagemem + " AND " + " o.pointsFunny >= " + ptsfunnymem +
                " AND " + " o.pointsInteresting >= " + ptsinterestingmem + " AND " + " o.pointsPersonality >= " + ptspersonalitymem + " AND " + " o.pointsFirstdate >= "+
                ptsfirstdatemem + " AND " + " o.pointsDateidea >= " + ptsdateideamem + " AND " + "o.pointsVerifyprofile >= " + ptsverifyprofilemem ;

//  + " AND " + "NOT (o.userid = " + lnguserid + ")";

        

        String effh = "select o " + " FROM Members o " + " WHERE  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
                + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() + " AND " + " o.gender ='"
                + getGenderFlmem() + "'" + " AND " + " o.seekingA ='" + getSeekingFlmem() + "'";


             String   efff = "Select o  from Members o";

        

        javax.persistence.Query q = getEntityManager().createQuery(effg);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }



    public int findRangeFlcount() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();



        String eff = "select o " + " FROM Members o " + " WHERE  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
                + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() + " AND " + " o.gender ='"
                + getGenderFlmem() + "'" + " AND " + " o.seekingA ='" + getSeekingFlmem() + "'" + " AND " + " o.lookingFor ='"
                + getLookingFlmem() + "'";


        String effg = "select o " + " FROM Members o " + " WHERE  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
                + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() + " AND " + " o.gender ='"  + getGenderFlmem() + "'"
                + " AND " + " o.lookingFor ='" + getLookingFlmem() + "'" + " AND " + " o.seekingA ='" + getSeekingFlmem() + "'" + " AND " + "( o.birthYear BETWEEN "
                + getAgefromFlem() + " AND " + getAgetoFlem() + " OR " + " o.birthYear BETWEEN " + getAgetoFlem()
                + " AND " + getAgefromFlem() + ")";


        String effh = "select o " + " FROM Members o " + " WHERE  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
                + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() + " AND " + " o.gender ='"
                + getGenderFlmem() + "'" + " AND " + " o.seekingA ='" + getSeekingFlmem() + "'";

String efff = "Select o  from Members o";



        javax.persistence.Query q = getEntityManager().createQuery(effg);

         List<Object[]> result2  =  q.getResultList();

          return result2.size();

    }





    

    public List<Members> findRangeFlTwo(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();



    //    String eff = "select o " + " FROM Members o " + " WHERE  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
    //            + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() + " AND " + " o.gender ='"
     //           + getGenderFlmem() + "'" + " AND " + " o.seekingA ='" + getSeekingFlmem() + "'" + " AND " + " o.lookingFor ='"
     //           + getLookingFlmem() + "'";


        String effg = "select o " + " FROM Members o " + " WHERE  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
                + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() + " AND " + " o.gender ='"  + getSeekingFlmem() + "'"
                + " AND " + " o.lookingFor ='" + getLookingFlmem() + "'" + " AND " + " o.ethnicity = '" + getEthnicityFlmem() + "'" + " AND " + " o.seekingA ='" + getGenderFlmem() + "'" + " AND " + "( o.birthYear BETWEEN "
                + getAgefromFlem() + " AND " + getAgetoFlem() + " OR " + " o.birthYear BETWEEN " + getAgetoFlem()
                + " AND " + getAgefromFlem() + ")" + " AND " + "NOT (o.userid = " + lnguserid + ")" + " AND " + " o.pointsPhotos >= " + ptsphotomem + " AND " +
                " o.pointsProfile >= " + ptsprofilemem + " AND " + " o.pointsFirstmessage >= " + ptsfirstmessagemem + " AND " + " o.pointsFunny >= " + ptsfunnymem +
                " AND " + " o.pointsInteresting >= " + ptsinterestingmem + " AND " + " o.pointsPersonality >= " + ptspersonalitymem + " AND " + " o.pointsFirstdate >= " +
                ptsfirstdatemem + " AND " + " o.pointsDateidea >= " + ptsdateideamem + " AND " + "o.pointsVerifyprofile >= " + ptsverifyprofilemem ;


//+ " AND " + "NOT (o.userid = " + lnguserid + ")";

        

     //   String effh = "select o " + " FROM Members o " + " WHERE  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
      //          + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() + " AND " + " o.gender ='"
      //          + getGenderFlmem() + "'" + " AND " + " o.seekingA ='" + getSeekingFlmem() + "'";

     //   String efff = "Select o  from Members o";



        javax.persistence.Query q = getEntityManager().createQuery(effg);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }




    

    public int findRangeFlTwocount() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();



    //    String eff = "select o " + " FROM Members o " + " WHERE  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
     //           + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() + " AND " + " o.gender ='"
     //           + getGenderFlmem() + "'" + " AND " + " o.seekingA ='" + getSeekingFlmem() + "'" + " AND " + " o.lookingFor ='"
      //          + getLookingFlmem() + "'";


        String effg = "select o " + " FROM Members o " + " WHERE  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
                + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() + " AND " + " o.gender ='"  + getSeekingFlmem() + "'"
                + " AND " + " o.lookingFor ='" + getLookingFlmem() + "'" + " AND " + " o.ethnicity = '" + getEthnicityFlmem() + "'" + " AND " + " o.seekingA ='" + getGenderFlmem() + "'" + " AND " + "( o.birthYear BETWEEN "
                + getAgefromFlem() + " AND " + getAgetoFlem() + " OR " + " o.birthYear BETWEEN " + getAgetoFlem()
                + " AND " + getAgefromFlem() + ")";



    //    String effh = "select o " + " FROM Members o " + " WHERE  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
      //          + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() + " AND " + " o.gender ='"
       //         + getGenderFlmem() + "'" + " AND " + " o.seekingA ='" + getSeekingFlmem() + "'";

    //    String efff = "Select o  from Members o";



         javax.persistence.Query q = getEntityManager().createQuery(effg);

         List<Object[]> result2  =  q.getResultList();

          return result2.size();



    }







 public List<Members> findRangeumight(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();




String efff = "Select o  from Members o " + " WHERE  o.gender = '" + getGenderumight() + "'";



        javax.persistence.Query q = getEntityManager().createQuery(efff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }



 public int findRangeumightcount() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();




String efff = "Select o  from Members o " + " WHERE  o.gender = '" + getGenderumight() + "'";



        javax.persistence.Query q = getEntityManager().createQuery(efff);

      List<Object[]> result2  =  q.getResultList();

          return result2.size();


    }






    public Uszipcodesdb findRangeZip() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Uszipcodesdb o " + " WHERE  o.zipcode = '" + getZipdatathree() + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);

        return (Uszipcodesdb) q.getSingleResult();
    }







    public Uszipcodesdb findRangeCity() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

//tested and works.
        String eff = "select o " + "  FROM Uszipcodesdb o  " + "   WHERE o.city = 'Norcross'" + " AND " +
                " o.statesfullname = 'Minnesota'";



  String effjj = "select o " + "  FROM Uszipcodesdb o  " + "   WHERE o.city = '" +  getCityFlmem() + "'" + " AND " +
                " o.statesfullname = '" + getStateFlmem() + "'";



        javax.persistence.Query q = getEntityManager().createQuery(effjj);

        return (Uszipcodesdb) q.getSingleResult();
    }




 public List<Uszipcodesdb> findcitytwo(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


          String eff = "select o " + "  FROM Uszipcodesdb o  " + "   WHERE o.city = " +  getCityFlmem() + " AND " +
                " o.statesfullname = " + getStateFlmem();



  String effjj = "select o " + "  FROM Uszipcodesdb o  " + "   WHERE o.city = '" +  getCityFlmem() + "'" + " AND " +
                " o.statesfullname = '" + getStateFlmem() + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effjj);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();

    }


 

  public List<Uszipcodesdb> findcitystatezip(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


          String eff = "select o " + "  FROM Uszipcodesdb o  " + "   WHERE o.city = " +  getCityFlmem() + " AND " +
                " o.statesfullname = " + getStateFlmem();



  String effjj = "select o " + "  FROM Uszipcodesdb o  " + "   WHERE o.city = '" +  getCityFlmem() + "'" + " AND " +
                " o.statesfullname = '" + getStateFlmem() + "'" + " AND " + " o.zipcode = '" + getZipdatathree() + "'" ;


        javax.persistence.Query q = getEntityManager().createQuery(effjj);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();

    }





 public List<Uszipcodesdb> findstate(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


          String eff = "select o " + "  FROM Uszipcodesdb o  " + "   WHERE o.city = " +  getCityFlmem() + " AND " +
                " o.statesfullname = " + getStateFlmem();



  String effjj = "select o " + "  FROM Uszipcodesdb o  "  +  " WHERE o.statesfullname = '" + getStateFlmem() + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effjj);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();

    }





      public Members findUsername(String ii) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Members o " + " WHERE  o.username ='" + ii + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);

        return (Members) q.getSingleResult();

    }




      public Members findMember() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Members o " + " WHERE  o.userid ='" + lnguserid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effgh);

        return (Members) q.getSingleResult();

    }





 public Members findMemberFav() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Members o " + " WHERE  o.userid ='" + idfavlookup + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effgh);

        return (Members) q.getSingleResult();

    }








      public Members findMemberTwo() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Members o " + " WHERE  o.userid = '" + idmemhold  + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effgh);

        return (Members) q.getSingleResult();

    }



      public Members findMembervin() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Members o " + " WHERE  o.userid ='" + hasviwedid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effgh);

        return (Members) q.getSingleResult();

    }


      
  public Members findMemberSentimgurl() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Members o " + " WHERE  o.userid ='" + sentimgeurl + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effgh);

        return (Members) q.getSingleResult();

    }







        public Members findMemNom() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Members o " + " WHERE  o.username ='" + getSenn() + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effgh);

        return (Members) q.getSingleResult();

    }



  public Members findMemNomTwo() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Members o " + " WHERE  o.username ='" + senntwo + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effgh);

        return (Members) q.getSingleResult();

    }




 public String findChkUsrTwo() {




          javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Members o " + " WHERE  o.username ='" + sennpassword + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effgh);


          List<Members> result = q.getResultList();

        if (result.size() > 0) {

        //    Members msm = (Members) q.getSingleResult();

           Members msm =  (Members) q.getSingleResult();

         String nmmm =   msm.getUsername();

            return nmmm;

        } else {

            return "notavailable";

        }





    }







       public String findChkUsr() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Members o " + " WHERE  o.password ='" + senn + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effgh);


          List<Members> result = q.getResultList();


            if (result.size() > 0) {

        //    Members msm = (Members) q.getSingleResult();

           Members msm =  (Members) q.getSingleResult();

         String nmmm =   msm.getPassword();

            return nmmm;

        } else {

            return "notavailable";

        }

     

    }


       


 public List<Points> findPointsProfile(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Points o " + " WHERE  o.idpersonpointsreceive ='" + lnguserid  + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();

    }



 public List<Points> findPoints(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Points o " + " WHERE  o.idpersonpointsreceive ='" + hasviwedid  + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();

    }





 public List<Umightlike> findumightlike(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Umightlike o " + " WHERE  o.idcurrent ='" + lnguserid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();

    }







 public Umightlike findumightlikesingle(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Umightlike o " + " WHERE  o.idcurrent ='" + lnguserid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);

        return (Umightlike) q.getResultList().get(0);


    }


      public List<Members> findmemholdgen(int[] range) {

          javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Members o " + " WHERE  o.gender = '" + "Female" + "'" ;


        String effghj = "select o " + " FROM Members o " + " WHERE  o.gender ='" + getGendmemhold() + "'";


        
String efff = "Select o  from Members o";



        String effg = "select o " + " FROM Members o " + " WHERE  o.birthYear  BETWEEN  " + yearboundlow + " AND " + yearboundup +
                " AND " + "o.gender ='" + getGendmemhold() + "'" + " AND " + "  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
                + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() ;

        

        javax.persistence.Query q = getEntityManager().createQuery(effg);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }


      public int findmemholdgencount() {

          javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Members o " + " WHERE  o.gender = '" + "Female" + "'" ;


        String effghj = "select o " + " FROM Members o " + " WHERE  o.gender ='" + getGendmemhold() + "'";



String efff = "Select o  from Members o";



        String effg = "select o " + " FROM Members o " + " WHERE  o.birthYear  BETWEEN  " + yearboundlow + " AND " + yearboundup +
                " AND " + "o.gender ='" + getGendmemhold() + "'" + " AND " + "  o.lat  BETWEEN  " + getFlattwo() + "  AND  " + getFlatone()
                + "  AND  " + " o.lon BETWEEN " + getFlontwo() + "  AND  " + getFlonone() ;



         javax.persistence.Query q = getEntityManager().createQuery(effg);

          List<Object[]> result2  =  q.getResultList();

          return result2.size();



    }




      public Members findRgMemTwo() {

          javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Members o " + " WHERE  o.userid ='" + lnguserid + "'";


    //    javax.persistence.Query q = getEntityManager().createQuery(effgh);
      //  q.setMaxResults(range[1] - range[0]);
       // q.setFirstResult(range[0]);
         javax.persistence.Query q = getEntityManager().createQuery(effgh);

        return (Members) q.getSingleResult();


        
  

    }




      public List<Members> findRgMem(int[] range) {

          javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effgh = "select o " + " FROM Members o " + " WHERE  o.userid ='" + lnguserid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effgh);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }




@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void updateOnlineNow() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


          String effij = " UPDATE Members o " + " SET o.now"  + " = '" + "online" + "'"  + " WHERE o.userid ='" + lnguserid + "'";


           String effik = " UPDATE Favorites o " + " SET o.now"  + " = '" + "online" + "'"  + " WHERE o.idfavperson ='" + lnguserid + "'";


           String effil = " UPDATE Hasviewedprofiletwo o " + " SET o.now"  + " = '" + "online" + "'"  + " WHERE o.idhvperson ='" + lnguserid + "'";


          String effim = " UPDATE Inbox o " + " SET o.now"  + " = '" + "online" + "'"  + " WHERE o.sendfromid ='" + lnguserid + "'";


          String effin = " UPDATE Umightlike o " + " SET o.now"  + " = '" + "online" + "'"  + " WHERE o.idfavperson ='" + lnguserid + "'";


          String effip = " UPDATE Sent o " + " SET o.now"  + " = '" + "online" + "'"  + " WHERE o.sendtoid ='" + lnguserid + "'";

          


   javax.persistence.Query q = getEntityManager().createQuery(effij);

   javax.persistence.Query qq = getEntityManager().createQuery(effik);
  javax.persistence.Query qqq = getEntityManager().createQuery(effil);

   javax.persistence.Query qqqq = getEntityManager().createQuery(effim);

   javax.persistence.Query qqqqq = getEntityManager().createQuery(effin);

   javax.persistence.Query qqqqqq = getEntityManager().createQuery(effip);

   
q.executeUpdate();
qq.executeUpdate();
 qqq.executeUpdate();
  qqqq.executeUpdate();
  qqqqq.executeUpdate();
  qqqqqq.executeUpdate();


    }





@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void updateOfflineNow() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


          String effij = " UPDATE Members o " + " SET o.now"  + " = '" + "offline" + "'"  + " WHERE o.userid ='" + lnguserid + "'";


           String effik = " UPDATE Favorites o " + " SET o.now"  + " = '" + "offline" + "'"  + " WHERE o.idfavperson ='" + lnguserid + "'";


           String effil = " UPDATE Hasviewedprofiletwo o " + " SET o.now"  + " = '" + "offline" + "'"  + " WHERE o.idhvperson ='" + lnguserid + "'";


          String effim = " UPDATE Inbox o " + " SET o.now"  + " = '" + "offline" + "'"  + " WHERE o.sendfromid ='" + lnguserid + "'";


          String effin = " UPDATE Umightlike o " + " SET o.now"  + " = '" + "offline" + "'"  + " WHERE o.idfavperson ='" + lnguserid + "'";


          String effip = " UPDATE Sent o " + " SET o.now"  + " = '" + "offline" + "'"  + " WHERE o.sendtoid ='" + lnguserid + "'";




          


          javax.persistence.Query q = getEntityManager().createQuery(effij);


   javax.persistence.Query qq = getEntityManager().createQuery(effik);

  javax.persistence.Query qqq = getEntityManager().createQuery(effil);

   javax.persistence.Query qqqq = getEntityManager().createQuery(effim);

   javax.persistence.Query qqqqq = getEntityManager().createQuery(effin);

   javax.persistence.Query qqqqqq = getEntityManager().createQuery(effip);




q.executeUpdate();


qq.executeUpdate();
 qqq.executeUpdate();
  qqqq.executeUpdate();
  qqqqq.executeUpdate();
  qqqqqq.executeUpdate();




    }









@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void deleteInSentbox() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


           String effik = " DELETE  " + " FROM Inbox o " + " WHERE  o.sendtoid =  " + lnguserid  ;
          String effim = " DELETE  " + " FROM Inbox o " + " WHERE  o.sendfromid =  " + lnguserid  ;

           String effij = " DELETE  " + " FROM Sent o " + " WHERE  o.sendfromid =  " + lnguserid  ;
        String effio = " DELETE  " + " FROM Sent o " + " WHERE  o.sendtoid =  " + lnguserid  ;


          javax.persistence.Query q = getEntityManager().createQuery(effik);
          javax.persistence.Query qa = getEntityManager().createQuery(effim);
 javax.persistence.Query qb = getEntityManager().createQuery(effij);
 javax.persistence.Query qc = getEntityManager().createQuery(effio);



q.executeUpdate();
qa.executeUpdate();
qb.executeUpdate();
qc.executeUpdate();


    }











@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void deleteMember() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


           String effik = " DELETE  " + " FROM Members o " + " WHERE  o.userid =  " + lnguserid  ;


          javax.persistence.Query q = getEntityManager().createQuery(effik);


q.executeUpdate();


    }






@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void deletePointsDidea() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


           String effip = " DELETE  " + " FROM Points o " + " WHERE  o.idpersonpointsreceive =  " + lnguserid  ;
String effim = " DELETE  " + " FROM Lastpointsgiveperson  o " + " WHERE  o.idpersonpointsreceive =  " + lnguserid  ;


          javax.persistence.Query q = getEntityManager().createQuery(effip);
  javax.persistence.Query qq = getEntityManager().createQuery(effip);


q.executeUpdate();
qq.executeUpdate();





    }




@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void deleteOther() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


           String effik = " DELETE  " + " FROM Blockedtwo o " + " WHERE  o.idcurrent =  " + lnguserid  ;
           String effij = " DELETE  " + " FROM Favorites o " + " WHERE  o.idcurrent =  " + lnguserid  ;
           String effim = " DELETE  " + " FROM Mailsettings o " + " WHERE  o.idmember =  " + lnguserid  ;
           String effin = " DELETE  " + " FROM Hasviewedprofiletwo o " + " WHERE  o.idcurrent =  " + lnguserid  ;
           String effir = " DELETE  " + " FROM Sendhistoryintimate o " + " WHERE  o.shiid =  " + lnguserid  ;

           
 javax.persistence.Query qa = getEntityManager().createQuery(effik);
 javax.persistence.Query qb = getEntityManager().createQuery(effij);
 javax.persistence.Query qc = getEntityManager().createQuery(effim);
 javax.persistence.Query qd = getEntityManager().createQuery(effin);
 javax.persistence.Query qe = getEntityManager().createQuery(effir);



qa.executeUpdate();
qb.executeUpdate();
qc.executeUpdate();
qd.executeUpdate();
qe.executeUpdate();


    }




@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void deletePhotos() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

    String effip = " DELETE  " + " FROM Photos o " + " WHERE  o.photouserid =  " + lnguserid  ;


          javax.persistence.Query q = getEntityManager().createQuery(effip);


q.executeUpdate();



    }




@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void deleteUmightlike() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

   String effip = " DELETE  " + " FROM Umightlike o " + " WHERE  o.idcurrent =  " + lnguserid  ;
  // String effim = " DELETE  " + " FROM Umightlike o " + " WHERE  o.idcurrent =  " + lnguserid  ;


          javax.persistence.Query q = getEntityManager().createQuery(effip);
     //   javax.persistence.Query qa = getEntityManager().createQuery(effim);


q.executeUpdate();
//qa.executeUpdate();


    }





public Members findMemberParam(long userparam) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String effij = "select o " + " FROM Members o " + " WHERE  o.userid ='" + userparam + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effij);

        return (Members) q.getSingleResult();

    }






@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void updateInboxSent() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


          String effij = " UPDATE Inbox o " + " SET o.imageurl"  + " = '" + inboxupdateimageurl + "'" + " WHERE o.sendfromid ='" + lnguserid + "'";

   String effik = " UPDATE Sent o " + " SET o.imageurl"  + " = '" + inboxupdateimageurl + "'" + " WHERE o.sendtoid ='" + lnguserid + "'";


   String effil = " UPDATE Favorites o " + " SET o.imageurl"  + " = '" + inboxupdateimageurl + "'" + " WHERE o.idfavperson ='" + lnguserid + "'";


    String effim = " UPDATE Hasviewedprofiletwo o " + " SET o.imageurl"  + " = '" + inboxupdateimageurl + "'" + " WHERE o.idhvperson ='" + lnguserid + "'";

   

          javax.persistence.Query q = getEntityManager().createQuery(effij);
          javax.persistence.Query qq = getEntityManager().createQuery(effik);

  javax.persistence.Query qfh = getEntityManager().createQuery(effil);
          javax.persistence.Query qqfh = getEntityManager().createQuery(effim);


q.executeUpdate();


qq.executeUpdate();



qfh.executeUpdate();


qqfh.executeUpdate();



    }



@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void updateInboxViewed() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


          String effij = " UPDATE Inbox o " + " SET o.status"  + " = '" + "read" + "'" + " WHERE o.id ='" + inboxstatusid + "'";

            String effik = " UPDATE Sent o " + " SET o.status"  + " = '" + "read" + "'" + " WHERE o.id ='" + inboxstatusid + "'";

 //  String effik = " UPDATE Sent o " + " SET o.status"  + " = '" + inboxupdateimageurl + "'" + " WHERE o.sendtoid ='" + lnguserid + "'";




          javax.persistence.Query q = getEntityManager().createQuery(effij);
         javax.persistence.Query qq = getEntityManager().createQuery(effik);


q.executeUpdate();


  qq.executeUpdate();


    }





@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void updateNophotosetup() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


            //  String sssend = " UPDATE Photos o " + " SET o.imageurl1a"   + _namec + "'" + " WHERE o.photouserid ='" + "23" + "'";
            String sssend = " UPDATE Photos o " + " SET o.imageurl" + 1 + "a" + " = '" + "/Cropped/" + usernamecreate + "/" + "nophotosecond.jpeg" + "'" + " WHERE o.photouserid ='" + lnguserid + "'";


         //   String effik = " UPDATE Sent o " + " SET o.status"  + " = '" + "read" + "'" + " WHERE o.id ='" + inboxstatusid + "'";

 //  String effik = " UPDATE Sent o " + " SET o.status"  + " = '" + inboxupdateimageurl + "'" + " WHERE o.sendtoid ='" + lnguserid + "'";

   String sssendthree = " UPDATE Members o " + " SET o.imageurl" + " = '" + "/Cropped/" + usernamecreate + "/" + "nophotosecond.jpeg" + "'" + " WHERE o.userid ='"   + lnguserid + "'";


   //  String sssend = " UPDATE Photos o " + " SET o.imageurl1a"   + _namec + "'" + " WHERE o.photouserid ='" + "23" + "'";
            String sssendfour = " UPDATE Photos o " + " SET o.imageurl" + 2 + "a" + " = '" + "#" + "'" + " WHERE o.photouserid ='" + lnguserid + "'";


          javax.persistence.Query q = getEntityManager().createQuery(sssend);

            javax.persistence.Query qq = getEntityManager().createQuery(sssendthree);

  javax.persistence.Query qqq = getEntityManager().createQuery(sssendfour);




q.executeUpdate();

qq.executeUpdate();

qqq.executeUpdate();


    }










 public void persistInboxSent() {
        try {

            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");

            //  String sssend = " UPDATE Photos o " + " SET o.imageurl1a"   + _namec + "'" + " WHERE o.photouserid ='" + "23" + "'";
            String sssend = " UPDATE Inbox o " + " SET o.imageurl"  + " = '" + inboxupdateimageurl + "'" + " WHERE o.sendfromid ='" + lnguserid + "'";


            String sssendtwo = " UPDATE Sent o " + " SET o.imageurl"  + " = '" + inboxupdateimageurl + "'" + " WHERE o.sendtoid ='" + lnguserid + "'";

            Query q = em.createQuery(sssend);

            Query qq = em.createQuery(sssendtwo);

            q.executeUpdate();

            qq.executeUpdate();

            utx.commit();

        } catch (Exception e) {
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }







    /**
     * @return the usernamelogin
     */
    public String getUsernamelogin() {
        return usernamelogin;
    }

    /**
     * @param usernamelogin the usernamelogin to set
     */
    public void setUsernamelogin(String usernamelogin) {
        this.usernamelogin = usernamelogin;
    }




    /**
     * @return the lnguserid
     */
    public long getLnguserid() {
        return lnguserid;
    }

    /**
     * @param lnguserid the lnguserid to set
     */
    public void setLnguserid(long lnguserid) {
        this.lnguserid = lnguserid;
    }



    /**
     * @return the usernamecreate
     */
    public String getUsernamecreate() {
        return usernamecreate;
    }

    /**
     * @param usernamecreate the usernamecreate to set
     */
    public void setUsernamecreate(String usernamecreate) {
        this.usernamecreate = usernamecreate;
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

    /**
     * @return the trackflum
     */
    public int getTrackflum() {
        return trackflum;
    }

    /**
     * @param trackflum the trackflum to set
     */
    public void setTrackflum(int trackflum) {
        this.trackflum = trackflum;
    }

    /**
     * @return the flatone
     */
    public float getFlatone() {
        return flatone;
    }

    /**
     * @param flatone the flatone to set
     */
    public void setFlatone(float flatone) {
        this.flatone = flatone;
    }

    /**
     * @return the flattwo
     */
    public float getFlattwo() {
        return flattwo;
    }

    /**
     * @param flattwo the flattwo to set
     */
    public void setFlattwo(float flattwo) {
        this.flattwo = flattwo;
    }

    /**
     * @return the flonone
     */
    public float getFlonone() {
        return flonone;
    }

    /**
     * @param flonone the flonone to set
     */
    public void setFlonone(float flonone) {
        this.flonone = flonone;
    }

    /**
     * @return the flontwo
     */
    public float getFlontwo() {
        return flontwo;
    }

    /**
     * @param flontwo the flontwo to set
     */
    public void setFlontwo(float flontwo) {
        this.flontwo = flontwo;
    }

    /**
     * @return the genderFlmem
     */
    public String getGenderFlmem() {
        return genderFlmem;
    }

    /**
     * @param genderFlmem the genderFlmem to set
     */
    public void setGenderFlmem(String genderFlmem) {
        this.genderFlmem = genderFlmem;
    }

    /**
     * @return the seekingFlmem
     */
    public String getSeekingFlmem() {
        return seekingFlmem;
    }

    /**
     * @param seekingFlmem the seekingFlmem to set
     */
    public void setSeekingFlmem(String seekingFlmem) {
        this.seekingFlmem = seekingFlmem;
    }

    /**
     * @return the lookingFlmem
     */
    public String getLookingFlmem() {
        return lookingFlmem;
    }

    /**
     * @param lookingFlmem the lookingFlmem to set
     */
    public void setLookingFlmem(String lookingFlmem) {
        this.lookingFlmem = lookingFlmem;
    }

   

  

    /**
     * @return the idd
     */
    public String getIdd() {
        return idd;
    }

    /**
     * @param idd the idd to set
     */
    public void setIdd(String idd) {
        this.idd = idd;
    }

    /**
     * @return the sub
     */
    public String getSub() {
        return sub;
    }

    /**
     * @param sub the sub to set
     */
    public void setSub(String sub) {
        this.sub = sub;
    }

    /**
     * @return the senn
     */
    public String getSenn() {
        return senn;
    }

    /**
     * @param senn the senn to set
     */
    public void setSenn(String senn) {
        this.senn = senn;
    }

    /**
     * @return the sntfromidd
     */
    public Long getSntfromidd() {
        return sntfromidd;
    }

    /**
     * @param sntfromidd the sntfromidd to set
     */
    public void setSntfromidd(Long sntfromidd) {
        this.sntfromidd = sntfromidd;
    }

    /**
     * @return the sntfromiddtwo
     */
    public Long getSntfromiddtwo() {
        return sntfromiddtwo;
    }

    /**
     * @param sntfromiddtwo the sntfromiddtwo to set
     */
    public void setSntfromiddtwo(Long sntfromiddtwo) {
        this.sntfromiddtwo = sntfromiddtwo;
    }

    /**
     * @return the snttoid
     */
    public Long getSnttoid() {
        return snttoid;
    }

    /**
     * @param snttoid the snttoid to set
     */
    public void setSnttoid(Long snttoid) {
        this.snttoid = snttoid;
    }

    /**
     * @return the snttoo
     */
    public String getSnttoo() {
        return snttoo;
    }

    /**
     * @param snttoo the snttoo to set
     */
    public void setSnttoo(String snttoo) {
        this.snttoo = snttoo;
    }

    /**
     * @return the senntwo
     */
    public String getSenntwo() {
        return senntwo;
    }

    /**
     * @param senntwo the senntwo to set
     */
    public void setSenntwo(String senntwo) {
        this.senntwo = senntwo;
    }

    /**
     * @return the sentfromblock
     */
    public Long getSentfromblock() {
        return sentfromblock;
    }

    /**
     * @param sentfromblock the sentfromblock to set
     */
    public void setSentfromblock(Long sentfromblock) {
        this.sentfromblock = sentfromblock;
    }

    /**
     * @return the subblockimageurl
     */
    public String getSubblockimageurl() {
        return subblockimageurl;
    }

    /**
     * @param subblockimageurl the subblockimageurl to set
     */
    public void setSubblockimageurl(String subblockimageurl) {
        this.subblockimageurl = subblockimageurl;
    }

    /**
     * @return the hasviwedid
     */
    public Long getHasviwedid() {
        return hasviwedid;
    }

    /**
     * @param hasviwedid the hasviwedid to set
     */
    public void setHasviwedid(Long hasviwedid) {
        this.hasviwedid = hasviwedid;
    }

    /**
     * @return the inboxupdateimageurl
     */
    public String getInboxupdateimageurl() {
        return inboxupdateimageurl;
    }

    /**
     * @param inboxupdateimageurl the inboxupdateimageurl to set
     */
    public void setInboxupdateimageurl(String inboxupdateimageurl) {
        this.inboxupdateimageurl = inboxupdateimageurl;
    }

    /**
     * @return the sentimgeurl
     */
    public Long getSentimgeurl() {
        return sentimgeurl;
    }

    /**
     * @param sentimgeurl the sentimgeurl to set
     */
    public void setSentimgeurl(Long sentimgeurl) {
        this.sentimgeurl = sentimgeurl;
    }

    /**
     * @return the inboxstatusid
     */
    public String getInboxstatusid() {
        return inboxstatusid;
    }

    /**
     * @param inboxstatusid the inboxstatusid to set
     */
    public void setInboxstatusid(String inboxstatusid) {
        this.inboxstatusid = inboxstatusid;
    }

    /**
     * @return the agefromFlem
     */
    public String getAgefromFlem() {
        return agefromFlem;
    }

    /**
     * @param agefromFlem the agefromFlem to set
     */
    public void setAgefromFlem(String agefromFlem) {
        this.agefromFlem = agefromFlem;
    }

    /**
     * @return the agetoFlem
     */
    public String getAgetoFlem() {
        return agetoFlem;
    }

    /**
     * @param agetoFlem the agetoFlem to set
     */
    public void setAgetoFlem(String agetoFlem) {
        this.agetoFlem = agetoFlem;
    }

    /**
     * @return the idmemhold
     */
    public long getIdmemhold() {
        return idmemhold;
    }

    /**
     * @param idmemhold the idmemhold to set
     */
    public void setIdmemhold(long idmemhold) {
        this.idmemhold = idmemhold;
    }

    /**
     * @return the gendmemhold
     */
    public String getGendmemhold() {
        return gendmemhold;
    }

    /**
     * @param gendmemhold the gendmemhold to set
     */
    public void setGendmemhold(String gendmemhold) {
        this.gendmemhold = gendmemhold;
    }

    /**
     * @return the favhvprofileimageurl
     */
    public String getFavhvprofileimageurl() {
        return favhvprofileimageurl;
    }

    /**
     * @param favhvprofileimageurl the favhvprofileimageurl to set
     */
    public void setFavhvprofileimageurl(String favhvprofileimageurl) {
        this.favhvprofileimageurl = favhvprofileimageurl;
    }

    /**
     * @return the yearboundup
     */
    public String getYearboundup() {
        return yearboundup;
    }

    /**
     * @param yearboundup the yearboundup to set
     */
    public void setYearboundup(String yearboundup) {
        this.yearboundup = yearboundup;
    }

    /**
     * @return the yearboundlow
     */
    public String getYearboundlow() {
        return yearboundlow;
    }

    /**
     * @param yearboundlow the yearboundlow to set
     */
    public void setYearboundlow(String yearboundlow) {
        this.yearboundlow = yearboundlow;
    }

    /**
     * @return the stateFlmem
     */
    public String getStateFlmem() {
        return stateFlmem;
    }

    /**
     * @param stateFlmem the stateFlmem to set
     */
    public void setStateFlmem(String stateFlmem) {
        this.stateFlmem = stateFlmem;
    }

    /**
     * @return the cityFlmem
     */
    public String getCityFlmem() {
        return cityFlmem;
    }

    /**
     * @param cityFlmem the cityFlmem to set
     */
    public void setCityFlmem(String cityFlmem) {
        this.cityFlmem = cityFlmem;
    }

    /**
     * @return the genderumight
     */
    public String getGenderumight() {
        return genderumight;
    }

    /**
     * @param genderumight the genderumight to set
     */
    public void setGenderumight(String genderumight) {
        this.genderumight = genderumight;
    }

    /**
     * @return the idfavlookup
     */
    public Long getIdfavlookup() {
        return idfavlookup;
    }

    /**
     * @param idfavlookup the idfavlookup to set
     */
    public void setIdfavlookup(Long idfavlookup) {
        this.idfavlookup = idfavlookup;
    }

    /**
     * @return the sennpassword
     */
    public String getSennpassword() {
        return sennpassword;
    }

    /**
     * @param sennpassword the sennpassword to set
     */
    public void setSennpassword(String sennpassword) {
        this.sennpassword = sennpassword;
    }

    /**
     * @return the emaillookup
     */
    public String getEmaillookup() {
        return emaillookup;
    }

    /**
     * @param emaillookup the emaillookup to set
     */
    public void setEmaillookup(String emaillookup) {
        this.emaillookup = emaillookup;
    }

    /**
     * @return the ethnicityFlmem
     */
    public String getEthnicityFlmem() {
        return ethnicityFlmem;
    }

    /**
     * @param ethnicityFlmem the ethnicityFlmem to set
     */
    public void setEthnicityFlmem(String ethnicityFlmem) {
        this.ethnicityFlmem = ethnicityFlmem;
    }

    /**
     * @return the idppreceive
     */
    public Long getIdppreceive() {
        return idppreceive;
    }

    /**
     * @param idppreceive the idppreceive to set
     */
    public void setIdppreceive(Long idppreceive) {
        this.idppreceive = idppreceive;
    }

    /**
     * @return the memberpointsid
     */
    public Long getMemberpointsid() {
        return memberpointsid;
    }

    /**
     * @param memberpointsid the memberpointsid to set
     */
    public void setMemberpointsid(Long memberpointsid) {
        this.memberpointsid = memberpointsid;
    }

    /**
     * @return the ptsphotomem
     */
    public int getPtsphotomem() {
        return ptsphotomem;
    }

    /**
     * @param ptsphotomem the ptsphotomem to set
     */
    public void setPtsphotomem(int ptsphotomem) {
        this.ptsphotomem = ptsphotomem;
    }

    /**
     * @return the ptsprofilemem
     */
    public int getPtsprofilemem() {
        return ptsprofilemem;
    }

    /**
     * @param ptsprofilemem the ptsprofilemem to set
     */
    public void setPtsprofilemem(int ptsprofilemem) {
        this.ptsprofilemem = ptsprofilemem;
    }

    /**
     * @return the ptsfirstmessagemem
     */
    public int getPtsfirstmessagemem() {
        return ptsfirstmessagemem;
    }

    /**
     * @param ptsfirstmessagemem the ptsfirstmessagemem to set
     */
    public void setPtsfirstmessagemem(int ptsfirstmessagemem) {
        this.ptsfirstmessagemem = ptsfirstmessagemem;
    }

    /**
     * @return the ptsfunnymem
     */
    public int getPtsfunnymem() {
        return ptsfunnymem;
    }

    /**
     * @param ptsfunnymem the ptsfunnymem to set
     */
    public void setPtsfunnymem(int ptsfunnymem) {
        this.ptsfunnymem = ptsfunnymem;
    }

    /**
     * @return the ptsinterestingmem
     */
    public int getPtsinterestingmem() {
        return ptsinterestingmem;
    }

    /**
     * @param ptsinterestingmem the ptsinterestingmem to set
     */
    public void setPtsinterestingmem(int ptsinterestingmem) {
        this.ptsinterestingmem = ptsinterestingmem;
    }

    /**
     * @return the ptspersonalitymem
     */
    public int getPtspersonalitymem() {
        return ptspersonalitymem;
    }

    /**
     * @param ptspersonalitymem the ptspersonalitymem to set
     */
    public void setPtspersonalitymem(int ptspersonalitymem) {
        this.ptspersonalitymem = ptspersonalitymem;
    }

    /**
     * @return the ptsfirstdatemem
     */
    public int getPtsfirstdatemem() {
        return ptsfirstdatemem;
    }

    /**
     * @param ptsfirstdatemem the ptsfirstdatemem to set
     */
    public void setPtsfirstdatemem(int ptsfirstdatemem) {
        this.ptsfirstdatemem = ptsfirstdatemem;
    }

    /**
     * @return the ptsdateideamem
     */
    public int getPtsdateideamem() {
        return ptsdateideamem;
    }

    /**
     * @param ptsdateideamem the ptsdateideamem to set
     */
    public void setPtsdateideamem(int ptsdateideamem) {
        this.ptsdateideamem = ptsdateideamem;
    }

    /**
     * @return the ptsverifyprofilemem
     */
    public int getPtsverifyprofilemem() {
        return ptsverifyprofilemem;
    }

    /**
     * @param ptsverifyprofilemem the ptsverifyprofilemem to set
     */
    public void setPtsverifyprofilemem(int ptsverifyprofilemem) {
        this.ptsverifyprofilemem = ptsverifyprofilemem;
    }

   
   
   
    




}
