package model;

import controller.BlockedtwoFacade;
import controller.FavoritesFacade;
import controller.HasviewedprofiletwoFacade;
import controller.InboxFacade;
import controller.MailsettingsFacade;
import model.util.JsfUtil;
import model.util.PaginationHelper;
import controller.MembersFacade;
import controller.PhotosFacade;
import controller.SendhistoryintimateFacade;
import controller.SentFacade;
import controller.UmightlikeFacade;
import controller.UszipcodesdbFacade;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import model.util.PaginationHelperTwo;


@ManagedBean (name="membersControllerFive")
@SessionScoped
public class MembersControllerFive {





 @EJB private controller.UszipcodesdbFacade ejbFacade3;


 @EJB  private controller.PhotosFacade ejbFacade4;

     @EJB  private controller.InboxFacade ejbFacadeIn;



 @EJB private controller.MembersFacade ejbFacade;




    @EJB private controller.SentFacade ejbFacadeSent;

    @EJB private controller.MailsettingsFacade ejbFacademail;

    @EJB private controller.BlockedtwoFacade ejbFacadeBlockedtwo;


 @EJB private controller.UmightlikeFacade ejbFacadeumightlike;



 @EJB private controller.SendhistoryintimateFacade ejbFacadeSendhistoryintimate;


 @EJB private controller.HasviewedprofileFacade ejbFacadeHasviewedprofile;


 @EJB private controller.HasviewedprofiletwoFacade ejbFacadeHasviewedprofiletwo;



@EJB private controller.FavoritesFacade ejbFacadefavorites;






 public Uszipcodesdb zipcode3 = null;


    public Photos currentPhotoSetUp;


    private Mailsettings currentmail;

    //used in createFavorites function. in teh VSt1....VSt7 pages.
   private Favorites currentFavorites;

  private Favorites currentfav;


private Hasviewedprofiletwo currenthvpt;



    private Members current;

    private Members currenttwo;


 private Inbox currentin;


 private Sent senttwo;


  private Blockedtwo currentblockedtwo;


 //used in prepareViewTwo of umightlike/List page.
   private Hasviewedprofiletwo currentHasviewedprofiletwo;


   
  //used in prepareViewTwo of umightlike/List.
      private Umightlike currentumightlike;



      private Sendhistoryintimate currentSendhistoryintimate;



       private Hasviewedprofile currentHasviewedprofile;



  //used to show display in the VSt pages also.
    private Members currentmem;




     private DataModel itemszip = null;


//main date model for send/List.xhtml page
    private DataModel itemssent = null;



    private DataModel items = null;


  private DataModel itemsumightlikemain = null;


    private DataModel itemslistfl = null;


      private DataModel itemsfav = null;


       private DataModel itemstwo = null;


       private DataModel itemsumightlike = null;


        private DataModel itemshasviewedtwo = null;




    private PaginationHelper pagination;


       private PaginationHelper paginationhvpt;


  private PaginationHelper paginationlistfl;


     private PaginationHelper paginationTwo;


  private PaginationHelper paginationzip;


     private PaginationHelper paginationThree;

     
      private PaginationHelper paginationFour;

      
        private PaginationHelper paginationfav;





    private int selectedItemIndex;





 @ManagedProperty(value= "#{inboxControllerTwo}")


 private InboxControllerTwo inboxmanaged;



        private String retph2;





    public MembersControllerFive() {
    }

    


    public Members getSelected() {
        if (current == null) {
            current = new Members();
            selectedItemIndex = -1;
        }
        return current;
    }



 public Members getSelectedTwo() {
        if (currenttwo == null) {
            currenttwo = new Members();
            selectedItemIndex = -1;
        }
        return currenttwo;
    }





 public Inbox getSelectedSndMsg() {
        if (currentin == null) {

            currentin = new Inbox();
            
            selectedItemIndex = -1;
        }
        return currentin;
    }


 public String resetfavorites(){
     

  getFacade4().setCheckid(getInboxmanaged().getUsrid());


         itemsfav=null;

     return"/favorites/singles.xhtml";

 }



public String resetvisitors(){


     itemshasviewedtwo=null;

     return "/singlesvisitors/personalsvisitors.xhtml" ;


    }



 public String umightlikepage(){


     getFacade().setLnguserid(getInboxmanaged().getUsrid());
     

          if (itemsumightlike == null) {
            itemsumightlike = getPaginationThree().createPageDataModel();
        }

          List<Members> lisstt = new ArrayList<Members>();

 List<Umightlike> blitems = (List<Umightlike>)itemsumightlike.getWrappedData();


 Members currentmemb = getFacade().findMember();

getFacade().setGenderumight(currentmemb.getSeekingA());


  if( blitems.isEmpty()){


      return"/datingmatches/singlesmatches.xhtml";



  }else{




    //  if (itemsumightlike == null) {
    //        itemsumightlike = getPaginationThree().createPageDataModel();
    //    }



 //  List<Members> lisstt = new ArrayList<Members>();

//   List<Umightlike> blitems = (List<Umightlike>)itemsumightlike.getWrappedData();


int rwct = blitems.size();

// if(rwct==0){
  //  rwct=1;
  // }


String memzip = currentmemb.getZipcode();




 float fftt = calculateLatitudeRadius(75);
 float ffnn = calculateLongitudeRadius(75);


  getFacade().setZipdatathree(memzip);

            Uszipcodesdb ii = getFacade().findRangeZip();

            float fflat = (ii.getLatitude()) + fftt;

            getFacade().setFlatone(fflat);

            float iitt = (ii.getLatitude()) - fftt;

            getFacade().setFlattwo(iitt);

            float fflon = (ii.getLongitude()) + ffnn;

            getFacade().setFlonone(fflon);

            float iinn = (ii.getLongitude()) - ffnn;

            getFacade().setFlontwo(iinn);




  for( Umightlike curblock : blitems ){

    long lglg =   curblock.getIdfavperson();

    getFacade().setIdmemhold(lglg);

   Members mem1 =  getFacade().findMemberTwo();

            boolean add = lisstt.add(mem1);

     }


 int mmm = 0;

// int fff = 0;


 for( Members lissttmemhold : lisstt){

    String mmmhold = lissttmemhold.getBirthYear();


    int mmmholdint = Integer.parseInt(mmmhold);

mmm = mmm + mmmholdint;


 }


int mmmdivup = (mmm /rwct) + 3;
int mmmdivlow = (mmm /rwct) - 3;


String mmmdivstringup = Integer.toString(mmmdivup);
String mmmdivstringlow = Integer.toString(mmmdivlow);



getFacade().setYearboundup(mmmdivstringup);
getFacade().setYearboundlow(mmmdivstringlow);


getFacade().setGendmemhold(currentmemb.getSeekingA());

 //if (itemsdisplay == null) {
    //        itemsdisplay = getPaginationdisplay().createPageDataModel();
     //      return itemsdisplay;
//
      //  }else {


     return"/datingmatches/personalsmatches";


  }


     }



   public DataModel getItemszip() {
        if (itemszip == null) {
           itemszip = getPaginationZip().createPageDataModel();
       }
        return itemszip;
   }




public String resetsearchrad(){


       
         


    itemslistfl=null;
    return"/members/search.xhtml";

    
}





  

  public Members getSelectedMem() {
        if (currentmem == null) {

         //   currentmem = new Mem();

            selectedItemIndex = -1;
        }
        return currentmem;
    }




    public String prepareCreateTwo() {
//creates data to populate for CreateMsg.



        String username2 = getFacade().getUsernamelogin();

        if (username2 == null) {

            username2 = getFacade().getUsernamecreate();

        }


        getFacade4().setSearchRadId(current.getUserid());

getFacade4().setCheckid(getInboxmanaged().getUsrid());

String checkblock = getFacade4().findBlockedTwoReplyPh();

if(checkblock.equals("/mailsettings/blockuser")){
    return  "/mailsettings/blockuser";
}else{



getFacade().setLnguserid(getInboxmanaged().getUsrid());

        Members mmbr = getFacade().findMember();

        long sfrid = mmbr.getUserid();


        String subwants = mmbr.getLookingFor();




        Mailsettings submailset2 = getFacade4().findMailSettingsCheck();


              boolean hmie =  submailset2.getHavemessagedintenct();



              if(hmie==true){


                  getFacadeSendhistoryintimate().setSendhisidlookup(sfrid);
                  
            String gtshilookup =    getFacadeSendhistoryintimate().findSendhistoryCheck();

            if(gtshilookup.equals("sendhistoryintimateexists")){

                return"/mailsettings/blockperhassent4intimate";

            }



              }




//gender mail setting  comparison begin.
        String submailgen = submailset2.getGender();

        if (submailgen.equals("Male") && mmbr.getGender().equals("Female")) {

            return "/mailsettings/blockpergender";

        } else if (submailgen.equals("Female") && mmbr.getGender().equals("Male")) {


            return "/mailsettings/blockpergender";

        }

//end of  mail settings gender comparison


        //begin compare mail settings drugs
if ( (mmbr.getDrugs().equals("Often")|| mmbr.getDrugs().equals("Socially")) && submailset2.getUsedrugs()== true){


    return "/mailsettings/blockperusedrugs";

}

       //end. compare mail settings drugs.



if (  ( mmbr.getSmoker().equals("Occassionally") || mmbr.getSmoker().equals("Often")) && submailset2.getSmoke()== true){

    return "/mailsettings/blockpersmoker";

}



 if(mmbr.getMarried().equals("Married") && submailset2.getEmail1()==true) {

     return "/mailsettings/blockpermarried";
 }



if(submailset2.getEmail2()==true && submailset2.getHavemessagedintenct()== true){

    return"/mailsettings/blockperhassent4intimate";

}




        //begin age comaprison mail settings.



            Calendar cali = new  GregorianCalendar();

            int currentyear = (short) cali.get(Calendar.YEAR);


            int subbirthyear = Integer.parseInt(mmbr.getBirthYear());


            int currentagemem =  (currentyear - subbirthyear);


            int byearfloor =  Integer.parseInt(submailset2.getAgefrom());


            int byearceil =  Integer.parseInt(submailset2.getAgeto());


            if ((currentagemem < byearfloor) || (currentagemem > byearceil) ){

                return "/mailsettings/blockperage";

            }

            //end age comparison mail settings.





            //start radius75 mail setting check.

            if( submailset2.getWithin().equals("75 miles")){



              float fftt = calculateLatitudeRadius(75);

              float ffnn = calculateLongitudeRadius(75);



            Members mailsetmem = getFacade4().findMailSetMember();

            String mailsetzip = mailsetmem.getZipcode();


             getFacade4().setZipdatafour(mailsetzip);

             Uszipcodesdb mailsetziptwo = getFacade4().findMailZipcode();


            float mailsetlat =  mailsetziptwo.getLatitude();

            float mailsetlon = mailsetziptwo.getLongitude();


        float mailsetlatplus = mailsetlat + fftt;

        float mailsetlonplus = mailsetlon + ffnn;

        float mailsetlatminus = mailsetlat - fftt;

        float mailsetlonminus = mailsetlon - ffnn;


        if( ((mmbr.getLat()<mailsetlatminus)||(mmbr.getLat()>mailsetlatplus))||((mmbr.getLon()<mailsetlonminus)||(mmbr.getLon()>mailsetlonplus)) ){

            return "/mailsettings/blockperradius75";


        }



        }

            //end radius75 mail setting check







        int subwantsref;

        boolean checkwants = false;


        if (subwants.equals("Hang Out")) {


            subwantsref = 1;



            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getHangout() == true) {

                return "/mailsettings/blockpage";
            }


        } else if (subwants.equals("Friends")) {


            subwantsref = 2;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getFriendship() == true) {

                return "/mailsettings/blockpage";
            }






        } else if (subwants.equals("Activity Partner")) {


            subwantsref = 3;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getActivitypartner() == true) {

                return "/mailsettings/blockpage";
            }







        } else if (subwants.equals("Dating")) {



            subwantsref = 4;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getDating() == true) {

                return "/mailsettings/blockpage";
            }






        } else if (subwants.equals("Long-term")) {


            subwantsref = 5;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getLongterm() == true) {

                return "/mailsettings/blockpage";
            }





        } else if (subwants.equals("Intimate Encounter")) {


            subwantsref = 6;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getIntimateencounter() == true) {

                return "/mailsettings/blockpage";
            }






        } else if (subwants.equals("Talk/E-mail")) {


            subwantsref = 7;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getTalkemail() == true) {

                return "/mailsettings/blockpage";
            }





        } else if (subwants.equals("Other Relationship")) {


            subwantsref = 8;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getOtherrelationship() == true) {

                return "/mailsettings/blockpage";
            }





        }




        currentin = new Inbox();

        currentin.setRemoveinmsg(false);


        currentin.setImageurl(mmbr.getImageurl());

        currentin.setSentFrom(mmbr.getUsername());


//gets stored from prepareviewtwo
        currentin.setSentTo(getFacade4().getCurrentUsrn());

//gets stored from prepareviewtwo
        currentin.setSendtoid(getFacade4().getCurrentUsrid());


        currentin.setSendfromid(sfrid);



        selectedItemIndex = -1;
        recreateModelSent();
        return "/inbox/singlesmessage";


        }
//top brace above is the end of ths very first if else that goes with the checkblock function.

    }









     public String prepareCreateInbox() {
//creates data to populate for CreateMsg.



        String username2 = getFacade().getUsernamelogin();

        if (username2 == null) {

            username2 = getFacade().getUsernamecreate();

        }


      

getFacade4().setCheckid(getInboxmanaged().getUsrid());

String checkblock = getFacade4().findBlockedTwoReplyPh();

if(checkblock.equals("/mailsettings/blockuser")){
    return  "/mailsettings/blockuser";
}else{



getFacade().setLnguserid(getInboxmanaged().getUsrid());

        Members mmbr = getFacade().findMember();

        long sfrid = mmbr.getUserid();


        String subwants = mmbr.getLookingFor();




        Mailsettings submailset2 = getFacade4().findMailSettingsCheck();


              boolean hmie =  submailset2.getHavemessagedintenct();



              if(hmie==true){


                  getFacadeSendhistoryintimate().setSendhisidlookup(sfrid);

            String gtshilookup =    getFacadeSendhistoryintimate().findSendhistoryCheck();

            if(gtshilookup.equals("sendhistoryintimateexists")){

                return"/mailsettings/blockperhassent4intimate";

            }



              }




//gender mail setting  comparison begin.
        String submailgen = submailset2.getGender();

        if (submailgen.equals("Male") && mmbr.getGender().equals("Female")) {

            return "/mailsettings/blockpergender";

        } else if (submailgen.equals("Female") && mmbr.getGender().equals("Male")) {


            return "/mailsettings/blockpergender";

        }

//end of  mail settings gender comparison


        //begin compare mail settings drugs
if ( (mmbr.getDrugs().equals("Often")|| mmbr.getDrugs().equals("Socially")) && submailset2.getUsedrugs()== true){


    return "/mailsettings/blockperusedrugs";

}

       //end. compare mail settings drugs.



if (  ( mmbr.getSmoker().equals("Occassionally") || mmbr.getSmoker().equals("Often")) && submailset2.getSmoke()== true){

    return "/mailsettings/blockpersmoker";

}



 if(mmbr.getMarried().equals("Married") && submailset2.getEmail1()==true) {

     return "/mailsettings/blockpermarried";
 }



if(submailset2.getEmail2()==true && submailset2.getHavemessagedintenct()== true){

    return"/mailsettings/blockperhassent4intimate";

}




        //begin age comaprison mail settings.



            Calendar cali = new  GregorianCalendar();

            int currentyear = (short) cali.get(Calendar.YEAR);


            int subbirthyear = Integer.parseInt(mmbr.getBirthYear());


            int currentagemem =  (currentyear - subbirthyear);


            int byearfloor =  Integer.parseInt(submailset2.getAgefrom());


            int byearceil =  Integer.parseInt(submailset2.getAgeto());


            if ((currentagemem < byearfloor) || (currentagemem > byearceil) ){

                return "/mailsettings/blockperage";

            }

            //end age comparison mail settings.





            //start radius75 mail setting check.

            if( submailset2.getWithin().equals("75 miles")){



              float fftt = calculateLatitudeRadius(75);

              float ffnn = calculateLongitudeRadius(75);



            Members mailsetmem = getFacade4().findMailSetMember();

            String mailsetzip = mailsetmem.getZipcode();


             getFacade4().setZipdatafour(mailsetzip);

             Uszipcodesdb mailsetziptwo = getFacade4().findMailZipcode();


            float mailsetlat =  mailsetziptwo.getLatitude();

            float mailsetlon = mailsetziptwo.getLongitude();


        float mailsetlatplus = mailsetlat + fftt;

        float mailsetlonplus = mailsetlon + ffnn;

        float mailsetlatminus = mailsetlat - fftt;

        float mailsetlonminus = mailsetlon - ffnn;


        if( ((mmbr.getLat()<mailsetlatminus)||(mmbr.getLat()>mailsetlatplus))||((mmbr.getLon()<mailsetlonminus)||(mmbr.getLon()>mailsetlonplus)) ){

            return "/mailsettings/blockperradius75";


        }



        }

            //end radius75 mail setting check







        int subwantsref;

        boolean checkwants = false;


        if (subwants.equals("Hang Out")) {


            subwantsref = 1;



            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getHangout() == true) {

                return "/mailsettings/blockpage";
            }


        } else if (subwants.equals("Friends")) {


            subwantsref = 2;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getFriendship() == true) {

                return "/mailsettings/blockpage";
            }






        } else if (subwants.equals("Activity Partner")) {


            subwantsref = 3;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getActivitypartner() == true) {

                return "/mailsettings/blockpage";
            }







        } else if (subwants.equals("Dating")) {



            subwantsref = 4;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getDating() == true) {

                return "/mailsettings/blockpage";
            }






        } else if (subwants.equals("Long-term")) {


            subwantsref = 5;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getLongterm() == true) {

                return "/mailsettings/blockpage";
            }





        } else if (subwants.equals("Intimate Encounter")) {


            subwantsref = 6;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getIntimateencounter() == true) {

                return "/mailsettings/blockpage";
            }






        } else if (subwants.equals("Talk/E-mail")) {


            subwantsref = 7;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getTalkemail() == true) {

                return "/mailsettings/blockpage";
            }





        } else if (subwants.equals("Other Relationship")) {


            subwantsref = 8;




            Mailsettings submailset = getFacade4().findMailSettingsCheck();



            if (submailset.getOtherrelationship() == true) {

                return "/mailsettings/blockpage";
            }





        }




        currentin = new Inbox();

        currentin.setRemoveinmsg(false);


        currentin.setImageurl(mmbr.getImageurl());

        currentin.setSentFrom(mmbr.getUsername());


//gets stored from prepareviewtwo
        currentin.setSentTo(getFacade4().getCurrentUsrn());

//gets stored from prepareviewtwo
        currentin.setSendtoid(getFacade4().getCurrentUsrid());


        currentin.setSendfromid(sfrid);



        selectedItemIndex = -1;
        recreateModelSent();
        return "/inbox/singlesmessage";


        }
//top brace above is the end of ths very first if else that goes with the checkblock function.

    }












   private void recreateModelSent() {
        itemssent = null;
    }






   private SendhistoryintimateFacade getFacadeSendhistoryintimate() {
        return ejbFacadeSendhistoryintimate;
    }






private HasviewedprofiletwoFacade getFacadeHasviewedprofiletwo() {

        return ejbFacadeHasviewedprofiletwo;


    }








    private UmightlikeFacade getFacadeumightlike() {

        return ejbFacadeumightlike;

    }






    private MembersFacade getFacade() {
        return ejbFacade;
    }



    private PhotosFacade getFacade4() {
        return ejbFacade4;
    }



     private InboxFacade getFacadeIn() {
        return ejbFacadeIn;
    }


   private SentFacade getFacadeSent() {

        return ejbFacadeSent;

    }



    private MailsettingsFacade getFacademail() {
        return ejbFacademail;
    }



      private BlockedtwoFacade getFacadeBlockedtwo() {

        return ejbFacadeBlockedtwo;

    }


      

  private FavoritesFacade getFacadefavorites() {
        return ejbFacadefavorites;
    }






    public float calculateLatitudeRadius(int radius) {
        // 1 latitude degree = 68.70795454545454 miles
        // 1 latitude mile = 0.014554355556290625173426834100111 degrees
        return (float) (0.014554d * radius);
    }

    public float calculateLongitudeRadius(int radius) {
        // 1 logitude degree = 69.16022727272727 miles
        // 1 logitude mile = 0.014459177469972560994758974186 degrees
        return (float) (0.014459d * radius);
    }








    public String prepareViewTwo() {

 current = (Members) getItemslistfl().getRowData();

getFacade().setHasviwedid(current.getUserid());

getFacade4().setSearchRadId(current.getUserid());


String hsvp = getFacade().findHasViewedProfileDuplicate();




if(hsvp.equals("nohvpduplicate")){



            currentHasviewedprofiletwo = new Hasviewedprofiletwo();

            Members sssidtwo = getFacade().findMember();


            currentHasviewedprofiletwo.setIdcurrent(current.getUserid());
            currentHasviewedprofiletwo.setIdhvperson(sssidtwo.getUserid());
            currentHasviewedprofiletwo.setUsername(sssidtwo.getUsername());
            currentHasviewedprofiletwo.setImageurl(sssidtwo.getImageurl());
            currentHasviewedprofiletwo.setNow(sssidtwo.getNow());
            currentHasviewedprofiletwo.setCity(sssidtwo.getCity());


            try {

            getFacadeHasviewedprofiletwo().create(currentHasviewedprofiletwo);

         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("HasviewedprofileCreated"));
        //    return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("ResourceThree/Bundle").getString("PersistenceErrorOccured"));
         //   return null;
        }



           //possible else statement here.

        }





if(getItemsumightlike().getRowCount()<20){


currentumightlike = new Umightlike();

currentumightlike.setId(112321321L );
currentumightlike.setIdcurrent(getFacade().getLnguserid());
currentumightlike.setIdfavperson(current.getUserid());
currentumightlike.setUsername("111");
currentumightlike.setNow("offline");
currentumightlike.setImageurl("111");
currentumightlike.setCity("111");



 try {
            getFacadeumightlike().create(currentumightlike);
         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeCreated"));

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

        }




}





if( getItemsumightlike().getRowCount()==20 ){


itemsumightlike = getItemsumightlike();


List<Umightlike> blitems = (List<Umightlike>)itemsumightlike.getWrappedData();


  currentumightlike =  blitems.get(0);


   try {
            getFacadeumightlike().remove(currentumightlike);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
        }



currentumightlike = new Umightlike();

currentumightlike.setId(112321321L );
currentumightlike.setIdcurrent(getFacade().getLnguserid());
currentumightlike.setIdfavperson(current.getUserid());
currentumightlike.setUsername("111");
currentumightlike.setNow("offline");
currentumightlike.setImageurl("111");
currentumightlike.setCity("111");



 try {
            getFacadeumightlike().create(currentumightlike);
         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeCreated"));

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

        }




}








           getFacade4().setFavoritesimageurl(current.getImageurl());

           getFacade4().setFavoritescity(current.getCity());




      Long ssrrdd = current.getUserid();

        getFacade4().setViewid(ssrrdd);

        getFacade4().setSendhistidchk(ssrrdd);




// below two fields sets username and userid to retrieve for message population.
        getFacade4().setCurrentUsrn(current.getUsername());

        getFacade4().setCurrentUsrid(current.getUserid());


        //end of final else statement braces?



      //  selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
getFacade4().setNophotousername(current.getUsername());

        getFacade4().findPgPhFour();

        int fbfb = getFacade4().getFlumbeta();

        if (fbfb == 1) {
            setRetph2("hh1");
        } else if (fbfb == 2) {
            setRetph2("hh1");
        } else if (fbfb == 3) {
            setRetph2("hh2");
        } else if (fbfb == 4) {
            setRetph2("hh3");
        } else if (fbfb == 5) {
            setRetph2("hh4");
        } else if (fbfb == 6) {
            setRetph2("hh5");
        } else if (fbfb == 7) {
            setRetph2("hh6");
        } else if (fbfb == 8) {
            setRetph2("hh7");
        } else if (fbfb == 9) {
            setRetph2("hh8");
        }else if (fbfb == 20) {
            setRetph2("hh9");
        }


        return "/hasviewedprofiletwo/Personals.xhtml";




    }







    


    public String prepareViewUmightList() {

//test to make sure.

 getFacade().setLnguserid(getInboxmanaged().getUsrid());


 Members currentmemb = getFacade().findMember();

getFacade().setGenderumight(currentmemb.getSeekingA());


//test to make sure.

 current = (Members) getItems().getRowData();

 

getFacade().setHasviwedid(current.getUserid());

getFacade4().setSearchRadId(current.getUserid());


String hsvp = getFacade().findHasViewedProfileDuplicate();




if(hsvp.equals("nohvpduplicate")){



            currentHasviewedprofiletwo = new Hasviewedprofiletwo();

            Members sssidtwo = getFacade().findMember();


            currentHasviewedprofiletwo.setIdcurrent(current.getUserid());
            currentHasviewedprofiletwo.setIdhvperson(sssidtwo.getUserid());
            currentHasviewedprofiletwo.setUsername(sssidtwo.getUsername());
            currentHasviewedprofiletwo.setImageurl(sssidtwo.getImageurl());
            currentHasviewedprofiletwo.setNow(sssidtwo.getNow());
            currentHasviewedprofiletwo.setCity(sssidtwo.getCity());


            try {

            getFacadeHasviewedprofiletwo().create(currentHasviewedprofiletwo);

         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("HasviewedprofileCreated"));
        //    return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("ResourceThree/Bundle").getString("PersistenceErrorOccured"));
         //   return null;
        }



           //possible else statement here.

        }





if(getItemsumightlike().getRowCount()<20){


currentumightlike = new Umightlike();

currentumightlike.setId(112321321L );
currentumightlike.setIdcurrent(getFacade().getLnguserid());
currentumightlike.setIdfavperson(current.getUserid());
currentumightlike.setUsername("111");
currentumightlike.setNow("offline");
currentumightlike.setImageurl("111");
currentumightlike.setCity("111");



 try {
            getFacadeumightlike().create(currentumightlike);
         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeCreated"));

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

        }




}





if( getItemsumightlike().getRowCount()==20 ){


itemsumightlike = getItemsumightlike();


List<Umightlike> blitems = (List<Umightlike>)itemsumightlike.getWrappedData();


  currentumightlike =  blitems.get(0);


   try {
            getFacadeumightlike().remove(currentumightlike);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
        }



currentumightlike = new Umightlike();

currentumightlike.setId(112321321L );
currentumightlike.setIdcurrent(getFacade().getLnguserid());
currentumightlike.setIdfavperson(current.getUserid());
currentumightlike.setUsername("111");
currentumightlike.setNow("offline");
currentumightlike.setImageurl("111");
currentumightlike.setCity("111");



 try {
            getFacadeumightlike().create(currentumightlike);
         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeCreated"));

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

        }




}








           getFacade4().setFavoritesimageurl(current.getImageurl());

           getFacade4().setFavoritescity(current.getCity());




      Long ssrrdd = current.getUserid();

        getFacade4().setViewid(ssrrdd);

        getFacade4().setSendhistidchk(ssrrdd);




// below two fields sets username and userid to retrieve for message population.
        getFacade4().setCurrentUsrn(current.getUsername());

        getFacade4().setCurrentUsrid(current.getUserid());


        //end of final else statement braces?



      //  selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();

        getFacade4().findPgPhFour();

        int fbfb = getFacade4().getFlumbeta();

        if (fbfb == 1) {
            setRetph2("vv1");
        } else if (fbfb == 2) {
            setRetph2("vv1");
        } else if (fbfb == 3) {
            setRetph2("vv2");
        } else if (fbfb == 4) {
            setRetph2("vv3");
        } else if (fbfb == 5) {
            setRetph2("vv4");
        } else if (fbfb == 6) {
            setRetph2("vv5");
        } else if (fbfb == 7) {
            setRetph2("vv6");
        } else if (fbfb == 8) {
            setRetph2("vv7");
        } else if (fbfb == 9) {
            setRetph2("vv8");
        }


        return "/hasviewedprofiletwo/Personals.xhtml";




    }















//umightlike/ listUsrtwo.xhtml click imageurl to use this function

    public String prepareViewUmightListUsr() {
        
  
   
        getFacade4().setCheckid(getInboxmanaged().getUsrid());


 current = (Members) getItemsumightlikemain().getRowData();

getFacade().setHasviwedid(current.getUserid());

getFacade4().setSearchRadId(current.getUserid());


String hsvp = getFacade().findHasViewedProfileDuplicate();




if(hsvp.equals("nohvpduplicate")){



            currentHasviewedprofiletwo = new Hasviewedprofiletwo();

            Members sssidtwo = getFacade().findMember();


            currentHasviewedprofiletwo.setIdcurrent(current.getUserid());
            currentHasviewedprofiletwo.setIdhvperson(sssidtwo.getUserid());
            currentHasviewedprofiletwo.setUsername(sssidtwo.getUsername());
            currentHasviewedprofiletwo.setImageurl(sssidtwo.getImageurl());
            currentHasviewedprofiletwo.setNow(sssidtwo.getNow());
            currentHasviewedprofiletwo.setCity(sssidtwo.getCity());


            try {

            getFacadeHasviewedprofiletwo().create(currentHasviewedprofiletwo);

         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("HasviewedprofileCreated"));
        //    return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("ResourceThree/Bundle").getString("PersistenceErrorOccured"));
         //   return null;
        }



           //possible else statement here.

        }





if(getItemsumightlike().getRowCount()<20){


currentumightlike = new Umightlike();

currentumightlike.setId(112321321L );
currentumightlike.setIdcurrent(getFacade().getLnguserid());
currentumightlike.setIdfavperson(current.getUserid());
currentumightlike.setUsername("111");
currentumightlike.setNow("offline");
currentumightlike.setImageurl("111");
currentumightlike.setCity("111");



 try {
            getFacadeumightlike().create(currentumightlike);
         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeCreated"));

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

        }




}





if( getItemsumightlike().getRowCount()==20 ){


itemsumightlike = getItemsumightlike();


List<Umightlike> blitems = (List<Umightlike>)itemsumightlike.getWrappedData();


  currentumightlike =  blitems.get(0);


   try {
            getFacadeumightlike().remove(currentumightlike);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
        }



currentumightlike = new Umightlike();

currentumightlike.setId(112321321L );
currentumightlike.setIdcurrent(getFacade().getLnguserid());
currentumightlike.setIdfavperson(current.getUserid());
currentumightlike.setUsername("111");
currentumightlike.setNow("offline");
currentumightlike.setImageurl("111");
currentumightlike.setCity("111");



 try {
            getFacadeumightlike().create(currentumightlike);
         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeCreated"));

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

        }




}

           getFacade4().setFavoritesimageurl(current.getImageurl());

           getFacade4().setFavoritescity(current.getCity());




      Long ssrrdd = current.getUserid();

        getFacade4().setViewid(ssrrdd);

        getFacade4().setSendhistidchk(ssrrdd);




// below two fields sets username and userid to retrieve for message population.
        getFacade4().setCurrentUsrn(current.getUsername());

        getFacade4().setCurrentUsrid(current.getUserid());


        //end of final else statement braces?



      //  selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();

        getFacade4().setNophotousername(current.getUsername());
        
        getFacade4().findPgPhTwo();

        int fbfb = getFacade4().getFlumbeta();

        if (fbfb == 1) {
            setRetph2("hh1");
        } else if (fbfb == 2) {
            setRetph2("hh1");
        } else if (fbfb == 3) {
            setRetph2("hh2");
        } else if (fbfb == 4) {
            setRetph2("hh3");
        } else if (fbfb == 5) {
            setRetph2("hh4");
        } else if (fbfb == 6) {
            setRetph2("hh5");
        } else if (fbfb == 7) {
            setRetph2("hh6");
        } else if (fbfb == 8) {
            setRetph2("hh7");
        } else if (fbfb == 9) {
            setRetph2("hh8");
        }else if (fbfb == 20) {
            setRetph2("hh9");
        }


        return "/singlesvisitors/personals.xhtml";




    }














//favorites list.xhtml click imageurl.
    
    public String prepareViewFav() {



         currentfav = (Favorites)getItemsfav().getRowData();
          long idfavp = currentfav.getIdfavperson();



            getFacade().setIdfavlookup(idfavp);

          current = getFacade().findMemberFav();

    //    selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
       // return "View";


 // current = (Members) getItemslistfl().getRowData();

getFacade().setHasviwedid(current.getUserid());


String hsvp = getFacade().findHasViewedProfileDuplicate();




if(hsvp.equals("nohvpduplicate")){



            currentHasviewedprofiletwo = new Hasviewedprofiletwo();

            
       //     getFacade().setLnguserid(getInboxmanaged().getUsrid());

            Members sssidtwo = getFacade().findMember();


            currentHasviewedprofiletwo.setIdcurrent(current.getUserid());
            currentHasviewedprofiletwo.setIdhvperson(sssidtwo.getUserid());
            currentHasviewedprofiletwo.setUsername(sssidtwo.getUsername());
            currentHasviewedprofiletwo.setImageurl(sssidtwo.getImageurl());
            currentHasviewedprofiletwo.setNow(sssidtwo.getNow());
            currentHasviewedprofiletwo.setCity(sssidtwo.getCity());


            try {

            getFacadeHasviewedprofiletwo().create(currentHasviewedprofiletwo);

         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("HasviewedprofileCreated"));
        //    return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("ResourceThree/Bundle").getString("PersistenceErrorOccured"));
         //   return null;
        }



           //possible else statement here.

        }





if(getItemsumightlike().getRowCount()<20){


currentumightlike = new Umightlike();

currentumightlike.setId(112321321L );
currentumightlike.setIdcurrent(getFacade().getLnguserid());
currentumightlike.setIdfavperson(current.getUserid());
currentumightlike.setUsername("111");
currentumightlike.setNow("offline");
currentumightlike.setImageurl("111");
currentumightlike.setCity("111");



 try {
            getFacadeumightlike().create(currentumightlike);
         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeCreated"));

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

        }




}





if( getItemsumightlike().getRowCount()==20 ){


itemsumightlike = getItemsumightlike();


List<Umightlike> blitems = (List<Umightlike>)itemsumightlike.getWrappedData();


  currentumightlike =  blitems.get(0);


   try {
            getFacadeumightlike().remove(currentumightlike);
        //    JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
        }



currentumightlike = new Umightlike();

currentumightlike.setId(112321321L );
currentumightlike.setIdcurrent(getFacade().getLnguserid());
currentumightlike.setIdfavperson(current.getUserid());
currentumightlike.setUsername("111");
currentumightlike.setNow("offline");
currentumightlike.setImageurl("111");
currentumightlike.setCity("111");



 try {
            getFacadeumightlike().create(currentumightlike);
         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeCreated"));

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

        }




}








           getFacade4().setFavoritesimageurl(current.getImageurl());

           getFacade4().setFavoritescity(current.getCity());




      long ssrrdd = current.getUserid();

        getFacade4().setViewid(ssrrdd);

        getFacade4().setSendhistidchk(ssrrdd);
        


        
getFacade4().setSearchRadId(idfavp);



// below two fields sets username and userid to retrieve for message population.
        getFacade4().setCurrentUsrn(current.getUsername());

        getFacade4().setCurrentUsrid(current.getUserid());


        //end of final else statement braces?



      //  selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();

        getFacade4().setCheckidphoto(idfavp);

        getFacade4().setNophotousername(currentfav.getUsername());
        getFacade4().findPgPhFour();

        int fbfb = getFacade4().getFlumbeta();

        if (fbfb == 1) {
            setRetph2("hh1");
        } else if (fbfb == 2) {
            setRetph2("hh1");
        } else if (fbfb == 3) {
            setRetph2("hh2");
        } else if (fbfb == 4) {
            setRetph2("hh3");
        } else if (fbfb == 5) {
            setRetph2("hh4");
        } else if (fbfb == 6) {
            setRetph2("hh5");
        } else if (fbfb == 7) {
            setRetph2("hh6");
        } else if (fbfb == 8) {
            setRetph2("hh7");
        } else if (fbfb == 9) {
            setRetph2("hh8");
        }else if (fbfb == 20) {
            setRetph2("hh9");
        }


        return "/singlesvisitors/personals.xhtml";




    }






    public String prepareViewhvpt() {

        
         currenthvpt = (Hasviewedprofiletwo)getItemshasviewedtwo().getRowData();

          long idfavp = currenthvpt.getIdhvperson();

            getFacade().setIdfavlookup(idfavp);

          current = getFacade().findMemberFav();

    //    selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
       // return "View";

 // current = (Members) getItemslistfl().getRowData();

getFacade().setHasviwedid(current.getUserid());


String hsvp = getFacade().findHasViewedProfileDuplicate();




if(hsvp.equals("nohvpduplicate")){



            currentHasviewedprofiletwo = new Hasviewedprofiletwo();

            Members sssidtwo = getFacade().findMember();


            currentHasviewedprofiletwo.setIdcurrent(current.getUserid());
            currentHasviewedprofiletwo.setIdhvperson(sssidtwo.getUserid());
            currentHasviewedprofiletwo.setUsername(sssidtwo.getUsername());
            currentHasviewedprofiletwo.setImageurl(sssidtwo.getImageurl());
            currentHasviewedprofiletwo.setNow(sssidtwo.getNow());
            currentHasviewedprofiletwo.setCity(sssidtwo.getCity());


            try {

            getFacadeHasviewedprofiletwo().create(currentHasviewedprofiletwo);

         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("HasviewedprofileCreated"));
        //    return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("ResourceThree/Bundle").getString("PersistenceErrorOccured"));
         //   return null;
        }



           //possible else statement here.

        }





if(getItemsumightlike().getRowCount()<20){


currentumightlike = new Umightlike();

currentumightlike.setId(112321321L );
currentumightlike.setIdcurrent(getFacade().getLnguserid());
currentumightlike.setIdfavperson(current.getUserid());
currentumightlike.setUsername("111");
currentumightlike.setNow("offline");
currentumightlike.setImageurl("111");
currentumightlike.setCity("111");



 try {
            getFacadeumightlike().create(currentumightlike);
         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeCreated"));

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

        }



}





if( getItemsumightlike().getRowCount()==20 ){


itemsumightlike = getItemsumightlike();


List<Umightlike> blitems = (List<Umightlike>)itemsumightlike.getWrappedData();


  currentumightlike =  blitems.get(0);


   try {
            getFacadeumightlike().remove(currentumightlike);
           // JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
        }



currentumightlike = new Umightlike();

currentumightlike.setId(112321321L );
currentumightlike.setIdcurrent(getFacade().getLnguserid());
currentumightlike.setIdfavperson(current.getUserid());
currentumightlike.setUsername("111");
currentumightlike.setNow("offline");
currentumightlike.setImageurl("111");
currentumightlike.setCity("111");



 try {
            getFacadeumightlike().create(currentumightlike);
         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeCreated"));

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

        }




}









           getFacade4().setFavoritesimageurl(current.getImageurl());

           getFacade4().setFavoritescity(current.getCity());




      long ssrrdd = current.getUserid();

        getFacade4().setViewid(ssrrdd);

        getFacade4().setSendhistidchk(ssrrdd);

        


        getFacade4().setSearchRadId(ssrrdd);



// below two fields sets username and userid to retrieve for message population.
        getFacade4().setCurrentUsrn(current.getUsername());

        getFacade4().setCurrentUsrid(current.getUserid());


        //end of final else statement braces?



      //  selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();

        getFacade4().setCheckidphoto(idfavp);

   getFacade4().setCheckid(getInboxmanaged().getUsrid());





getFacade4().setNophotousername(currenthvpt.getUsername());

        getFacade4().findPgPhFour();

        int fbfb = getFacade4().getFlumbeta();

        if (fbfb == 1) {
            setRetph2("hh1");
        } else if (fbfb == 2) {
            setRetph2("hh1");
        } else if (fbfb == 3) {
            setRetph2("hh2");
        } else if (fbfb == 4) {
            setRetph2("hh3");
        } else if (fbfb == 5) {
            setRetph2("hh4");
        } else if (fbfb == 6) {
            setRetph2("hh5");
        } else if (fbfb == 7) {
            setRetph2("hh6");
        } else if (fbfb == 8) {
            setRetph2("hh7");
        } else if (fbfb == 9) {
            setRetph2("hh8");
        } else if (fbfb == 20) {
            setRetph2("hh9");
        }


        return "/singlesvisitors/personals.xhtml";




    }
















 public DataModel getItemsumightlike() {
        if (itemsumightlike == null) {
            itemsumightlike = getPaginationThree().createPageDataModel();
        }


        return itemsumightlike;
    }




    


public DataModel getItemsumightlikemain() {



  
if(itemsumightlikemain==null){

itemsumightlikemain = getPaginationFour().createPageDataModel();


    }

    //    }

        return itemsumightlikemain;

    }





    public PaginationHelper getPaginationlistfl() {
        if (paginationlistfl == null) {
            paginationlistfl = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRangeFl(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return paginationlistfl;
    }





 public PaginationHelper getPaginationhvpt() {
        if (paginationhvpt == null) {
            paginationhvpt = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade4().findHasviewedprofiletwocount();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade4().findHasviewedprofiletwo(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return paginationhvpt;
    }




    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().findRangeumightcount();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRangeumight(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return pagination;
    }




     public PaginationHelper getPaginationTwo() {
        if (paginationTwo == null) {
            paginationTwo = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRangeFl(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return paginationTwo;
    }

    









      public PaginationHelper getPaginationZip() {
        if (paginationzip == null) {
            paginationzip = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findcitytwo(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return paginationzip;
    }







      public PaginationHelper getPaginationThree() {
        if (paginationThree == null) {
            paginationThree = new PaginationHelper(25) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findumightlike(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return paginationThree;
    }



  public PaginationHelper getPaginationFour() {
        if (paginationFour == null) {
            paginationFour = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().findmemholdgencount();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findmemholdgen(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return paginationFour;
    }



 public PaginationHelper getPaginationfav() {
        if (paginationfav == null) {
            paginationfav = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade4().findFavoritescount();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade4().findFavorites(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return paginationfav;
    }










    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Members)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Members();
        selectedItemIndex = -1;
        return "Create";
    }




    //not in use
    public String create() {

        try {

        

getFacademail().create(currentmail);




            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("MembersCreated"));
            return "memcreatepicupload";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }








 public String createTest() {
        try {
            getFacadeIn().create(currentin);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("InboxCreated"));
            return "/inbox/messages";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }





//inbox creatsendmsg page.
    public String createMsgTwo() {
        try {


            getFacadeIn().create(currentin); // create for inbox message.


            String dd = currentin.getId();
            String rrdd = currentin.getReplyToId();
            // long ssdd = current.getSendToid();

            long ssdd = currentin.getSendtoid();





            String cururl = currentin.getImageurl();


            String ssff = currentin.getSentFrom();


            String sstt = currentin.getSentTo();

            getFacade().setSenntwo(sstt);

            Members sssidtwo = getFacade().findMemNomTwo();



            getFacade().setSenn(ssff);
            //be careful here

            Members sssid = getFacade().findMemNom();

            Long stuid = sssid.getUserid();



            String ssbb = currentin.getSubject();
            String ssdt = currentin.getMessageDate();
            String mt = currentin.getMsgText();
            String stst = currentin.getStatus();








            senttwo = new Sent();

            senttwo.setId(dd);

            senttwo.setRemovesntmsg(false);

            //picture must be of person sent to not person sent from.
            senttwo.setImageurl(sssidtwo.getImageurl());


            senttwo.setReplyToId(rrdd);
            //currentsent.setSendFromid(ssdd);

            senttwo.setSendfromid(stuid);


            senttwo.setSendtoid(ssdd);


            senttwo.setSentFrom(ssff);
            senttwo.setSentTo(sstt);
            senttwo.setSubject(ssbb);
            senttwo.setMessageDate(ssdt);
            senttwo.setMsgText(mt);
            senttwo.setStatus(stst);
            senttwo.setNow("offline");







if(sssidtwo.getLookingFor().equals("Intimate Encounter")){


        getFacadeSendhistoryintimate().setSendhisidlookup(stuid);

String  shistest = getFacadeSendhistoryintimate().findSendhistorylookup();


if(shistest.equals("nosendhistoryintimate")){

currentSendhistoryintimate = new Sendhistoryintimate();
currentSendhistoryintimate.setShiid(stuid);
currentSendhistoryintimate.setSentuser(ssdd);



  try {
            getFacadeSendhistoryintimate().create(currentSendhistoryintimate);
            //JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("SendhistoryintimateCreated"));
          //  return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
           // return null;
        }

}




            }





            getFacadeSent().create(senttwo);

            recreateModelSent();


            JsfUtil.addSuccessMessage("Message was sent");
            return "/inbox/messages";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }







    }






//inbox createsendmsgTwo page
    public String createMsgMemSend() {
        try {


            getFacadeIn().create(currentin); // create for inbox message.


            String dd = currentin.getId();
            String rrdd = currentin.getReplyToId();
            // long ssdd = current.getSendToid();

            long ssdd = currentin.getSendtoid();





            String cururl = currentin.getImageurl();


            String ssff = currentin.getSentFrom();


            String sstt = currentin.getSentTo();

            getFacade().setSenntwo(sstt);

            Members sssidtwo = getFacade().findMemNomTwo();



            getFacade().setSenn(ssff);
            //be careful here

            Members sssid = getFacade().findMemNom();

            Long stuid = sssid.getUserid();



            String ssbb = currentin.getSubject();
            String ssdt = currentin.getMessageDate();
            String mt = currentin.getMsgText();
            String stst = currentin.getStatus();





 Mailsettings submailset2 = getFacade4().findMailSettingsCheck();

        String bbb = submailset2.getFirstcontactmessgesize();

if(bbb.equals("50 characters +") && mt.length()<=49){

    return "/mailsettings/blockpermessagelength.xhtml";

}else if (bbb.equals("100 charatcters +") && mt.length()<=99){

 return "/mailsettings/blockpermessagelength.xhtml";

}else if (bbb.equals("200 characters +")&& mt.length()<=199){

 return "/mailsettings/blockpermessagelength.xhtml";

}else if (bbb.equals("300 characters +")&& mt.length()<=299){

 return "/mailsettings/blockpermessagelength.xhtml";

}



            



            senttwo = new Sent();

            senttwo.setId(dd);

            senttwo.setRemovesntmsg(false);

            //picture must be of person sent to not person sent from.
            senttwo.setImageurl(sssidtwo.getImageurl());


            senttwo.setReplyToId(rrdd);
            //currentsent.setSendFromid(ssdd);

            senttwo.setSendfromid(stuid);


            senttwo.setSendtoid(ssdd);


            senttwo.setSentFrom(ssff);
            senttwo.setSentTo(sstt);
            senttwo.setSubject(ssbb);
            senttwo.setMessageDate(ssdt);
            senttwo.setMsgText(mt);
            senttwo.setStatus(stst);
            senttwo.setNow("offline");







if(sssidtwo.getLookingFor().equals("Intimate Encounter")){


        getFacadeSendhistoryintimate().setSendhisidlookup(stuid);

String  shistest = getFacadeSendhistoryintimate().findSendhistorylookup();


if(shistest.equals("nosendhistoryintimate")){

currentSendhistoryintimate = new Sendhistoryintimate();
currentSendhistoryintimate.setShiid(stuid);
currentSendhistoryintimate.setSentuser(ssdd);



  try {
            getFacadeSendhistoryintimate().create(currentSendhistoryintimate);
            //JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("SendhistoryintimateCreated"));
          //  return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
           // return null;
        }

}




            }





            getFacadeSent().create(senttwo);

            recreateModelSent();


            JsfUtil.addSuccessMessage("Message was sent");
            return "/inbox/messages";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }







    }
















 public String createMsg() {
        try {


              String dd = currentin.getId();
            String rrdd = currentin.getReplyToId();
           // long ssdd = current.getSendToid();
            long ssdd = currentin.getSendtoid();




            String ssff = currentin.getSentFrom();
            String sstt = currentin.getSentTo();


            getFacade().setSenn(ssff);
            //be careful here
          Members sssid =  getFacade().findMemNom();

         Long stuid = sssid.getUserid();



            String ssbb = currentin.getSubject();
            String ssdt = currentin.getMessageDate();
            String mt = currentin.getMsgText();
            String stst = currentin.getStatus();



             senttwo = new Sent();

             senttwo.setRemovesntmsg(false);

            senttwo.setId(dd);

            senttwo.setReplyToId(rrdd);

            senttwo.setImageurl(currentin.getImageurl());

            //currentsent.setSendFromid(ssdd);
            senttwo.setSendfromid(stuid);


            senttwo.setSendtoid(ssdd);


            senttwo.setSentFrom(ssff);
            senttwo.setSentTo(sstt);
            senttwo.setSubject(ssbb);
            senttwo.setMessageDate(ssdt);
            senttwo.setMsgText(mt);
            senttwo.setStatus(stst);

            senttwo.setNow("offline");

           getFacadeIn().create(currentin);

            getFacadeSent().create(senttwo);


            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("InboxCreated"));
            return getRetph2();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }






    public String prepareEdit() {
        current = (Members)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }



     public String prepareEditTwo() {

       // currenttwo = (Members) getItems().getRowData();

                currenttwo =  (Members) getFacade().findMember();

      // selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "/members/viewEditMember";
    }

     

 public String destroyhvpt() {
        currenthvpt = (Hasviewedprofiletwo)getItemshasviewedtwo().getRowData();
        selectedItemIndex = paginationhvpt.getPageFirstItem() + getItemshasviewedtwo().getRowIndex();
        performDestroyhvpt();
        recreateModelhvpt();
        return "List";
    }



    public String destroy() {
        current = (Members)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("MembersDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
        }
    }



    
     private void performDestroyhvpt() {
        try {
            getFacadeHasviewedprofiletwo().remove(currenthvpt);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("MembersDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
        }
    }



     private void performDestroyfavorites() {
        try {
            getFacadefavorites().remove(currentfav);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("MembersDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
        }
    }





    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count-1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex+1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }



     public DataModel getItemsTwo() {
        if (itemstwo == null) {
            itemstwo = getPaginationTwo().createPageDataModel();
        }
        return itemstwo;
    }



     

//hasviewedprofiletwo/List.xhtml main items

public DataModel getItemshasviewedtwo() {


getFacade4().setCheckid(getInboxmanaged().getUsrid());

        if (itemshasviewedtwo == null) {
            itemshasviewedtwo = getPaginationhvpt().createPageDataModel();
        }
        return itemshasviewedtwo;
    }




 public String destroyFavorites() {

        currentfav = (Favorites)getItemsfav().getRowData();
      //  selectedItemIndex = pagination.getPageFirstItem() + getItemslistfl().getRowIndex();
        performDestroyfavorites();
        recreateModelfav();
        return "/favorites/List";
    }


 


       public DataModel getItemslistfl() {
        if (itemslistfl == null) {
            itemslistfl = getPaginationlistfl().createPageDataModel();
        }
        return itemslistfl;

    }




  public DataModel getItemsfav() {

     getFacade4().setCheckid(getInboxmanaged().getUsrid());
     
        if (itemsfav == null) {
            itemsfav = getPaginationfav().createPageDataModel();
        }
        return itemsfav;
    }


 public String nextfav() {
        getPaginationfav().nextPage();
        recreateModelfav();
        return "/favorites/List";
    }

    public String previousfav() {
        getPaginationfav().previousPage();
        recreateModelfav();
        return "/favorites/List";
    }




    private void recreateModelfav() {
        itemsfav = null;
    }



    


       private void recreateModelhvpt() {
        itemshasviewedtwo = null;
    }


    public String nexthvpt() {
        getPaginationhvpt().nextPage();
        recreateModelhvpt();
        return "List";
    }

    public String previoushvpt() {
        getPaginationhvpt().previousPage();
        recreateModelhvpt();
        return "List";
    }






    private void recreateModel() {
        items = null;
    }


    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }



     private void recreateModellistfl() {
        itemslistfl = null;
    }



     public String nextlistfl() {
        getPaginationlistfl().nextPage();
        recreateModellistfl();
        return "/members/ListFl";
    }

    public String previouslistfl() {
        getPaginationlistfl().previousPage();
        recreateModellistfl();
        return "/members/ListFl";
    }







    private void recreateModelFour() {
        itemsumightlikemain = null;
    }



    public String nextFour() {
        getPaginationFour().nextPage();
        recreateModelFour();
        return "/umightlike/ListUsrtwo";
    }

    public String previousFour() {
        getPaginationFour().previousPage();
        recreateModelFour();
        return "/umightlike/ListUsrtwo";
    }







    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }






public String showPoints(){

getFacade().setMemberpointsid(getFacade4().getViewid());

    return "/points/List";

}






      public String createFavorites() {


          getFacade4().setCheckid(getInboxmanaged().getUsrid());

 String dfcheck = getFacade4().findDuplicateFavorites();


if (dfcheck.equals("DuplicateExists")){


    return"/favorites/singles.xhtml";



}else {



currentFavorites = new Favorites();

currentFavorites.setIdcurrent(getFacade4().getCheckid());

currentFavorites.setIdfavperson(getFacade4().getViewid());

currentFavorites.setImageurl(getFacade4().getFavoritesimageurl() );

currentFavorites.setCity(getFacade4().getFavoritescity());

currentFavorites.setUsername(getFacade4().getCurrentUsrn());

currentFavorites.setNow("online");





        try {




            getFacadefavorites().create(currentFavorites);


         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("FavoritesCreated"));


            recreateModelfav();


            return "/favorites/singles.xhtml";

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }


    }
    }







    private UszipcodesdbFacade getFacade3() {
        return ejbFacade3;
    }




   
  

   

   

   

   

   



    /**
     * @return the retph2
     */
    public String getRetph2() {
        return retph2;
    }

    /**
     * @param retph2 the retph2 to set
     */
    public void setRetph2(String retph2) {
        this.retph2 = retph2;
    }

    /**
  
   
   
   


    /**
     * @return the inboxmanaged
     */
    public InboxControllerTwo getInboxmanaged() {
        return inboxmanaged;
    }

    /**
     * @param inboxmanaged the inboxmanaged to set
     */
    public void setInboxmanaged(InboxControllerTwo inboxmanaged) {
        this.inboxmanaged = inboxmanaged;
    }










    @FacesConverter(forClass=Members.class)
    public static class MembersControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MembersControllerFive controller = (MembersControllerFive)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "membersControllerFive");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Members) {
                Members o = (Members) object;
                return getStringKey(o.getUserid());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: "+MembersController.class.getName());
            }
        }

    }

}
