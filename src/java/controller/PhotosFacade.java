/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Photos;


import javax.persistence.Query;
import model.Blockedtwo;
import model.Favorites;
import model.Hasviewedprofile;
import model.Hasviewedprofiletwo;
import model.Inbox;
import model.Mailsettings;
import model.Members;
import model.Uszipcodesdb;
// import javax.management.Query;


/**
 *
 * @author Chris Mitchell
 */
@Stateless
public class PhotosFacade extends AbstractFacade<Photos> {
    @PersistenceContext(unitName = "proTenPU")
    private EntityManager em;




private model.PhotosControllerTwo photocont2;


    private long checkid;


    private long checkidphoto;
    


private long searchRadId;


private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private String image6;
    private String image7;
    private String image8;



private int urltrack;


private   String uploadurlname;


public int flumbeta;


private String currentUsrn;

private Long currentUsrid;



private String zipdatafour;


private String favoritesonline;


private String favoritesimageurl;


private String favoritescity;



private Long viewid;


private long sendhistidchk;



private Long instid;



private String nophotousername;




    protected EntityManager getEntityManager() {
        return em;
    }

    public PhotosFacade() {
        super(Photos.class);
    }






     public String findSetPhoto() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + checkid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);

        List<Object[]> result = q.getResultList();

            if(result.size() > 0){

                return "photoyes";
            }
            else{
                 return "photono";
            }


    }


public Photos findSingPhoto() {

          javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + checkid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);

        return  (Photos) q.getSingleResult();




    }





public void findPgPh() {

          javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


           Query qqq = em.createQuery("select o.imageurl" + 2 + "a" + " FROM Photos o " + " WHERE o.photouserid ='" + checkid + "'");



            if (qqq.getSingleResult().toString().equals("#")){


                          setFlumbeta(20);

                } else {


 


           for (int j = 1; j < 10; j++) {

                Query qq = em.createQuery("select o.imageurl" + j + "a" + " FROM Photos o " + " WHERE o.photouserid ='" + checkid + "'");


                   if (qq.getSingleResult().toString().equals("*")){


                          setFlumbeta(j);

                    break;

                    
                }



            }


    }

      // String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + checkid + "'";


      //  javax.persistence.Query q = getEntityManager().createQuery(eff);

      //  return  (Photos) q.getSingleResult();


    }





public void findSearchResPhoto() {



          javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


           Query qqq = em.createQuery("select o.imageurl" + " FROM Members o " + " WHERE o.userid ='" + currentUsrid + "'");



            if (qqq.getSingleResult().toString().equals("/Cropped/" + nophotousername + "/" + "nophotosecond.jpeg")){


                          setFlumbeta(20);

                } else {





           for (int j = 1; j < 10; j++) {

                Query qq = em.createQuery("select o.imageurl" + j + "a" + " FROM Photos o " + " WHERE o.photouserid ='" + currentUsrid + "'");

                if (qq.getSingleResult().toString().equals("*")) {

                    setFlumbeta(j);

                    break;

                }
            }



      // String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + checkid + "'";


                }

      //  javax.persistence.Query q = getEntityManager().createQuery(eff);

      //  return  (Photos) q.getSingleResult();


    }













public void findPgPhFour() {

          javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


          

  Query qqq = em.createQuery("select o.imageurl" + " FROM Members o " + " WHERE o.userid ='" + checkidphoto + "'");



            if (qqq.getSingleResult().toString().equals("/Cropped/" + nophotousername + "/" + "nophotosecond.jpeg")){


                          setFlumbeta(20);

                } else {




           for (int j = 1; j < 10; j++) {

                Query qq = em.createQuery("select o.imageurl" + j + "a" + " FROM Photos o " + " WHERE o.photouserid ='" + checkidphoto + "'");

                if (qq.getSingleResult().toString().equals("*")) {

                    setFlumbeta(j);

                    break;

                }
            }
      // String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + checkid + "'";


      //  javax.persistence.Query q = getEntityManager().createQuery(eff);
    }
      //  return  (Photos) q.getSingleResult();


    }





public void findPgPhTwo() {

          javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();



  Query qqq = em.createQuery("select o.imageurl" + " FROM Members o " + " WHERE o.userid ='" + viewid + "'");



            if (qqq.getSingleResult().toString().equals("/Cropped/" + nophotousername + "/" + "nophotosecond.jpeg")){


                          setFlumbeta(20);

                } else {




           for (int j = 1; j < 10; j++) {

                Query qq = em.createQuery("select o.imageurl" + j + "a" + " FROM Photos o " + " WHERE o.photouserid ='" + viewid + "'");

                if (qq.getSingleResult().toString().equals("*")) {

                    setFlumbeta(j);

                    break;

                }
            }
      // String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + checkid + "'";

    }
      //  javax.persistence.Query q = getEntityManager().createQuery(eff);

      //  return  (Photos) q.getSingleResult();


    }




public void findPgPhInSn() {

          javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();




  Query qqq = em.createQuery("select o.imageurl" + " FROM Members o " + " WHERE o.userid ='" + instid + "'");



            if (qqq.getSingleResult().toString().equals("/Cropped/" + nophotousername + "/" + "nophotosecond.jpeg")){


                          setFlumbeta(20);

                } else {


          


           for (int j = 1; j < 10; j++) {

                Query qq = em.createQuery("select o.imageurl" + j + "a" + " FROM Photos o " + " WHERE o.photouserid ='" + instid + "'");

                if (qq.getSingleResult().toString().equals("*")) {

                    setFlumbeta(j);

                    break;

                }
            }
      // String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + checkid + "'";

    }
      //  javax.persistence.Query q = getEntityManager().createQuery(eff);

      //  return  (Photos) q.getSingleResult();


    }








    /**
     * @return the checkid
     */
    public long getCheckid() {
        return checkid;
    }

    /**
     * @param checkid the checkid to set
     */
    public void setCheckid(long checkid) {
        this.checkid = checkid;
    }





    public List<Photos> findUsrPhotos(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + checkid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }



    public List<Photos> findSearchRadPhotos(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid = '" + viewid + "'" ;


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }



     public List<Photos> findSearchViewPhotos(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + viewid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }




       public List<Photos> findSearchViewPhotosUiRepeat(int[] range) {
       
           javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + viewid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
        

    }


        public Photos findSearchViewPhotosUiRepeatTwo() {

           javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();



        String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + viewid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);
   //     q.setMaxResults(range[1] - range[0]);
   //     q.setFirstResult(range[0]);


        return (Photos) q.getSingleResult();




    }






     public List<Photos> findSearchViewPhotosTwo(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + checkid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }







  public List<Photos> findSearchPhotosChekid(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + checkid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }










 public String findBlockedTwoReplyPh() {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Blockedtwo o " + " WHERE  o.idcurrent = " + searchRadId  + " AND " + " o.idofblocked = " + checkid ;

    //    String efflon = "select o.userid " + " FROM Members o " + " WHERE  o.username ='" + usernamelogin + "'";

        javax.persistence.Query q = getEntityManager().createQuery(eff);

        List<Blockedtwo> result = q.getResultList();

        if (result.size() > 0) {


            return "/mailsettings/blockuser";

        }else{

            return "noblock";
        }

    }

     


      public Mailsettings findMailSettingsCheck() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Mailsettings o " + " WHERE  o.idmember ='" + sendhistidchk + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);

        return (Mailsettings) q.getSingleResult();

    }

    //  String effgh = "select o " + " FROM Members o " + " WHERE  o.userid ='" + lnguserid + "'";



       public String findRangeInboxUsrExist() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Inbox o " + " WHERE  o.sentTo = '" + "andy" + "'"  ;

        String effhh = "Select o From Inbox o";

        javax.persistence.Query q = getEntityManager().createQuery(eff);

          List<Inbox> result = q.getResultList();

      //   int uuii = q.getResultList().size();

          
        if (result.size() > 0) {

            return "no";

        } else {
             
            return "yes";

        }

       // return q.getResultList();

    }



        public Members findMailSetMember() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


     //   String eff = "select o " + " FROM Mailsettings o " + " WHERE  o.idmember ='" + searchRadId + "'";

         String effgh = "select o " + " FROM Members o " + " WHERE  o.userid ='" + searchRadId + "'";


        javax.persistence.Query q = getEntityManager().createQuery(effgh);

        return (Members) q.getSingleResult();

    }



         public Uszipcodesdb findMailZipcode() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


     //   String eff = "select o " + " FROM Mailsettings o " + " WHERE  o.idmember ='" + searchRadId + "'";

       //  String effgh = "select o " + " FROM Members o " + " WHERE  o.userid ='" + zipdatafour + "'";

            String eff = "select o " + " FROM Uszipcodesdb o " + " WHERE  o.zipcode ='" + zipdatafour + "'";



        javax.persistence.Query q = getEntityManager().createQuery(eff);

        return (Uszipcodesdb) q.getSingleResult();

    }





public Mailsettings findMailSettingsZip() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Mailsettings o " + " WHERE  o.idmember ='" + searchRadId + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);

        return (Mailsettings) q.getSingleResult();

    }








    public List<Photos> findSearchRadId(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Photos o " + " WHERE  o.photouserid ='" + searchRadId + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }




    public String findDuplicateFavorites() {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        String eff = "select o " + " FROM Favorites o " + " WHERE  o.idcurrent = " + checkid  + " AND " + " o.idfavperson = " + searchRadId ;

    //    String efflon = "select o.userid " + " FROM Members o " + " WHERE  o.username ='" + usernamelogin + "'";

        javax.persistence.Query q = getEntityManager().createQuery(eff);

        List<Favorites> result = q.getResultList();

        if (result.size() > 0) {


            return "DuplicateExists";

        }else{

            return "NoDuplicates";
        }

    }




    public List<Favorites> findFavorites(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Favorites o " + " WHERE  o.idcurrent = " + checkid ;


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }


     public int findFavoritescount() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Favorites o " + " WHERE  o.idcurrent = " + checkid ;


        javax.persistence.Query q = getEntityManager().createQuery(eff);


        List<Object[]> result2  =  q.getResultList();

          return result2.size();



    }





     public List<Hasviewedprofile> findHasviewedprofile(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Hasviewedprofile o " + " WHERE  o.idcurrent ='" + checkid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }


 public List<Hasviewedprofiletwo> findHasviewedprofiletwo(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();


        String eff = "select o " + " FROM Hasviewedprofiletwo o " + " WHERE  o.idcurrent ='" + checkid + "'";


        javax.persistence.Query q = getEntityManager().createQuery(eff);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }


public int findHasviewedprofiletwocount() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        
        String eff = "select o " + " FROM Hasviewedprofiletwo o " + " WHERE  o.idcurrent ='" + checkid + "'";

        javax.persistence.Query q = getEntityManager().createQuery(eff);
        
        
       List<Object[]> result2  =  q.getResultList();

          return result2.size();

        
    }




    /**
     * @return the image1
     */
    public String getImage1() {
        return image1;
    }

    /**
     * @param image1 the image1 to set
     */
    public void setImage1(String image1) {
        this.image1 = image1;
    }

    /**
     * @return the image2
     */
    public String getImage2() {
        return image2;
    }

    /**
     * @param image2 the image2 to set
     */
    public void setImage2(String image2) {
        this.image2 = image2;
    }

    /**
     * @return the image3
     */
    public String getImage3() {
        return image3;
    }

    /**
     * @param image3 the image3 to set
     */
    public void setImage3(String image3) {
        this.image3 = image3;
    }

    /**
     * @return the image4
     */
    public String getImage4() {
        return image4;
    }

    /**
     * @param image4 the image4 to set
     */
    public void setImage4(String image4) {
        this.image4 = image4;
    }

    /**
     * @return the image5
     */
    public String getImage5() {
        return image5;
    }

    /**
     * @param image5 the image5 to set
     */
    public void setImage5(String image5) {
        this.image5 = image5;
    }

    /**
     * @return the image6
     */
    public String getImage6() {
        return image6;
    }

    /**
     * @param image6 the image6 to set
     */
    public void setImage6(String image6) {
        this.image6 = image6;
    }

    /**
     * @return the image7
     */
    public String getImage7() {
        return image7;
    }

    /**
     * @param image7 the image7 to set
     */
    public void setImage7(String image7) {
        this.image7 = image7;
    }

    /**
     * @return the image8
     */
    public String getImage8() {
        return image8;
    }

    /**
     * @param image8 the image8 to set
     */
    public void setImage8(String image8) {
        this.image8 = image8;
    }

    /**
     * @return the urltrack
     */
    public int getUrltrack() {
        return urltrack;
    }

    /**
     * @param urltrack the urltrack to set
     */
    public void setUrltrack(int urltrack) {
        this.urltrack = urltrack;
    }

    /**
     * @return the flumbeta
     */
    public int getFlumbeta() {
        return flumbeta;
    }

    /**
     * @param flumbeta the flumbeta to set
     */
    public void setFlumbeta(int flumbeta) {
        this.flumbeta = flumbeta;
    }

    /**
     * @return the searchRadId
     */
    public long getSearchRadId() {
        return searchRadId;
    }

    /**
     * @param searchRadId the searchRadId to set
     */
    public void setSearchRadId(long searchRadId) {
        this.searchRadId = searchRadId;
    }

    /**
     * @return the currentUsrn
     */
    public String getCurrentUsrn() {
        return currentUsrn;
    }

    /**
     * @param currentUsrn the currentUsrn to set
     */
    public void setCurrentUsrn(String currentUsrn) {
        this.currentUsrn = currentUsrn;
    }

    /**
     * @return the currentUsrid
     */
    public Long getCurrentUsrid() {
        return currentUsrid;
    }

    /**
     * @param currentUsrid the currentUsrid to set
     */
    public void setCurrentUsrid(Long currentUsrid) {
        this.currentUsrid = currentUsrid;
    }

    /**
     * @return the zipdatafour
     */
    public String getZipdatafour() {
        return zipdatafour;
    }

    /**
     * @param zipdatafour the zipdatafour to set
     */
    public void setZipdatafour(String zipdatafour) {
        this.zipdatafour = zipdatafour;
    }

    /**
     * @return the favoritesonline
     */
    public String getFavoritesonline() {
        return favoritesonline;
    }

    /**
     * @param favoritesonline the favoritesonline to set
     */
    public void setFavoritesonline(String favoritesonline) {
        this.favoritesonline = favoritesonline;
    }

    /**
     * @return the favoritesimageurl
     */
    public String getFavoritesimageurl() {
        return favoritesimageurl;
    }

    /**
     * @param favoritesimageurl the favoritesimageurl to set
     */
    public void setFavoritesimageurl(String favoritesimageurl) {
        this.favoritesimageurl = favoritesimageurl;
    }

    /**
     * @return the favoritescity
     */
    public String getFavoritescity() {
        return favoritescity;
    }

    /**
     * @param favoritescity the favoritescity to set
     */
    public void setFavoritescity(String favoritescity) {
        this.favoritescity = favoritescity;
    }

    /**
     * @return the viewid
     */
    public Long getViewid() {
        return viewid;
    }

    /**
     * @param viewid the viewid to set
     */
    public void setViewid(Long viewid) {
        this.viewid = viewid;
    }

    /**
     * @return the sendhistidchk
     */
    public long getSendhistidchk() {
        return sendhistidchk;
    }

    /**
     * @param sendhistidchk the sendhistidchk to set
     */
    public void setSendhistidchk(long sendhistidchk) {
        this.sendhistidchk = sendhistidchk;
    }

    /**
     * @return the instid
     */
    public Long getInstid() {
        return instid;
    }

    /**
     * @param instid the instid to set
     */
    public void setInstid(Long instid) {
        this.instid = instid;
    }

    /**
     * @return the uploadurlname
     */
    public String getUploadurlname() {
        return uploadurlname;
    }

    /**
     * @param uploadurlname the uploadurlname to set
     */
    public void setUploadurlname(String uploadurlname) {
        this.uploadurlname = uploadurlname;
    }

    /**
     * @return the photocont2
     */
    public model.PhotosControllerTwo getPhotocont2() {
        return photocont2;
    }

    /**
     * @param photocont2 the photocont2 to set
     */
    public void setPhotocont2(model.PhotosControllerTwo photocont2) {
        this.photocont2 = photocont2;
    }

    /**
     * @return the checkidphoto
     */
    public long getCheckidphoto() {
        return checkidphoto;
    }

    /**
     * @param checkidphoto the checkidphoto to set
     */
    public void setCheckidphoto(long checkidphoto) {
        this.checkidphoto = checkidphoto;
    }

    /**
     * @return the nophotousername
     */
    public String getNophotousername() {
        return nophotousername;
    }

    /**
     * @param nophotousername the nophotousername to set
     */
    public void setNophotousername(String nophotousername) {
        this.nophotousername = nophotousername;
    }

   













}
