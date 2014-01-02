package model;


import controller.HasviewedprofiletwoFacade;
import controller.InboxFacade;

import java.text.ParseException;
import model.util.JsfUtil;
import model.util.PaginationHelper;
import controller.MembersFacade;
import controller.PhotosFacade;
import controller.SendhistoryintimateFacade;
import controller.SentFacade;
import controller.UmightlikeFacade;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;


import javax.faces.bean.ManagedProperty;

import javax.faces.bean.RequestScoped;


import javax.servlet.http.HttpSession;
import model.util.PaginationHelperThree;



@ManagedBean (name="membersControllerSix")
@RequestScoped
public class MembersControllerSix {


  private String username;

  private String password;


 private long tracker;


 public Uszipcodesdb zipcode3 = null;


 public Photos currentPhotoSetUp;


 
 @EJB private controller.PhotosFacade ejbFacade4;


 @EJB private controller.InboxFacade ejbFacadeIn;


 @EJB private controller.MembersFacade ejbFacade;


 @EJB private controller.SentFacade ejbFacadeSent;



  private Mailsettings currentmail;

  
  //used for the bottom part description of the view one-view 8 page.
  private Members current;


  private Members currenttwo;

  

  private DataModel items = null;

  //used for /members/ListFl page
  private DataModel itemslistfl = null;

  private DataModel itemslistfl2 = null;

  
  //used for /members/ListFl2 page
  private DataModel itemslistflTwo = null;


 //    private DataModel itemstwo = null;




  private PaginationHelper pagination;


  private PaginationHelper paginationzip;


  private PaginationHelper paginationTwo;


  private PaginationHelperThree paginationlistfl;


  private PaginationHelper paginationlistflTwo;




 private Inbox currentin;


 private Sent senttwo;


 private String retph2;


 // private Blockedtwo currentblockedtwo;



 //all the FL strings below are used for the radius search page to get
    //fields to limit  radius search query.

    private String yearnow;


    private String zipcodeSearchTwo;

    private int radius;

    private String ethnicityFl;

    private String genderFl;
    private String seekingFl;
    private String lookingFl;

    private String agefromFl;

    private String agetoFl;

    private String state;


    private String cityFl;


private DataModel itemszip = null;


//end of all FL Strings and objects for search radius.

private int ptsphoto;

private int ptsprofile;

private int ptsfirstmessage;

private int ptsfunny;

private int ptsinteresting;

private int ptspersonality;

private int ptsfirstdate;

private int ptsdateidea;

private int ptsverifyprofile;





 @ManagedProperty(value= "#{inboxControllerTwo}")

 private InboxControllerTwo inboxmanaged;



   
  //used in prepareViewTwo of umightlike/List.
      private Umightlike currentumightlike;


 @EJB private controller.HasviewedprofiletwoFacade ejbFacadeHasviewedprofiletwo;


 //used in prepareViewTwo of umightlike/List page.
   private Hasviewedprofiletwo currentHasviewedprofiletwo;

   


 @EJB private controller.UmightlikeFacade ejbFacadeumightlike;


 private DataModel itemsumightlike = null;


  


 @EJB private controller.SendhistoryintimateFacade ejbFacadeSendhistoryintimate;

 private Sendhistoryintimate currentSendhistoryintimate;





  private int selectedItemIndex;




    public MembersControllerSix() {
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





public  int daysBetween(Date d1, Date d2){
 return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
 }



  public DataModel getItemszip() {
        if (itemszip == null) {
           itemszip = getPaginationZip().createPageDataModel();
       }
        return itemszip;
   }



 public DataModel getItemszipstate() {
        if (itemszip == null) {
           itemszip = getPaginationstate().createPageDataModel();
       }
        return itemszip;
   }


 public DataModel getItemscitystatezip() {
        if (itemszip == null) {
           itemszip = getPaginationcitystatezip().createPageDataModel();
       }
        return itemszip;
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



//MAIN SEARCH ON THE SEARCHRAD PAGE***********************************************************************
  public String createsearch() {

      getPaginationlistfl().setPage(0);
      

itemslistfl=null;

itemslistflTwo=null;


      try {

          if(getZipcodeSearchTwo().isEmpty()==true && getCityFl().isEmpty()==true)   {


          //do state search  only


    getFacade().setLnguserid(getInboxmanaged().getUsrid());

      Members proxymem = getFacade().findMember();

              //  String proxyzip = proxymem.getZipcode();


            float fftt = calculateLatitudeRadius(getRadius()+2);

            float ffnn = calculateLongitudeRadius(getRadius()+2);


          //  getFacade().setCityFlmem(getCityFl());
            getFacade().setStateFlmem(getState());



 itemszip = getItemszipstate();
   List<Uszipcodesdb> blitems = (List<Uszipcodesdb>)itemszip.getWrappedData();


   if(blitems.isEmpty()){
       return "/members/searchnone.xhtml";
   }

         Uszipcodesdb ii =  blitems.get(0);

        //  Uszipcodesdb ii = getFacade().findRangeCity();



            float fflat = (ii.getLatitude()) + fftt;

            getFacade().setFlatone(fflat);

            float iitt = (ii.getLatitude()) - fftt;

            getFacade().setFlattwo(iitt);

            float fflon = (ii.getLongitude()) + ffnn;

            getFacade().setFlonone(fflon);

            float iinn = (ii.getLongitude()) - ffnn;

            getFacade().setFlontwo(iinn);

            //end of zipcode radius data processing
            String gen = getGenderFl();

            getFacade().setGenderFlmem(gen);

            getFacade().setSeekingFlmem(getSeekingFl());

            getFacade().setLookingFlmem(getLookingFl());

            getFacade().setEthnicityFlmem(getEthnicityFl());
      //      getFacade().setSignFlmem(getSignFl());
         //   getFacade().setStateFlmem(getState());
        //   getFacade().setCityFlmem(getCityFl());

            getFacade().setPtsphotomem(ptsphoto);
            getFacade().setPtsprofilemem(ptsprofile);
            getFacade().setPtsfirstmessagemem(ptsfirstmessage);
            getFacade().setPtsfunnymem(ptsfunny);
            getFacade().setPtsinterestingmem(ptsinteresting);
            getFacade().setPtspersonalitymem(ptspersonality);
            getFacade().setPtsfirstdatemem(ptsfirstdate);
            getFacade().setPtsdateideamem(ptsdateidea);
            getFacade().setPtsverifyprofilemem(ptsverifyprofile);
            

            Calendar cal=Calendar.getInstance();
            int currentyear=cal.get(Calendar.YEAR);

            String afro = getAgefromFl();

            int afroint = Integer.parseInt(afro);


            String ato = getAgetoFl();

            int atoint = Integer.parseInt(ato);



           int afroyear =   currentyear-afroint;

           int atoyear = currentyear-atoint;


getFacade().setAgefromFlem(Integer.toString(atoyear));

getFacade().setAgetoFlem(Integer.toString(afroyear));


if(getEthnicityFl().isEmpty() || getEthnicityFl().equals("All Ethnicities")){

    return "/members/searchall.xhtml";
    
}



  return "/members/searchsome.xhtml";

  


      } else if(getZipcodeSearchTwo().isEmpty()==true && getCityFl().isEmpty()==false )   {
//search on city and state




    getFacade().setLnguserid(getInboxmanaged().getUsrid());

      Members proxymem = getFacade().findMember();

              //  String proxyzip = proxymem.getZipcode();


            float fftt = calculateLatitudeRadius(getRadius()+2);

            float ffnn = calculateLongitudeRadius(getRadius()+2);


            getFacade().setCityFlmem(getCityFl());
            getFacade().setStateFlmem(getState());



 itemszip = getItemszip();
   List<Uszipcodesdb> blitems = (List<Uszipcodesdb>)itemszip.getWrappedData();


   if(blitems.isEmpty()){


       return "/members/searchnone";
   }

         Uszipcodesdb ii =  blitems.get(0);

        //  Uszipcodesdb ii = getFacade().findRangeCity();



            float fflat = (ii.getLatitude()) + fftt;

            getFacade().setFlatone(fflat);

            float iitt = (ii.getLatitude()) - fftt;

            getFacade().setFlattwo(iitt);

            float fflon = (ii.getLongitude()) + ffnn;

            getFacade().setFlonone(fflon);

            float iinn = (ii.getLongitude()) - ffnn;

            getFacade().setFlontwo(iinn);

            //end of zipcode radius data processing
            String gen = getGenderFl();

            getFacade().setGenderFlmem(gen);

            getFacade().setSeekingFlmem(getSeekingFl());

            getFacade().setLookingFlmem(getLookingFl());

            getFacade().setEthnicityFlmem(getEthnicityFl());
      //      getFacade().setSignFlmem(getSignFl());
         //   getFacade().setStateFlmem(getState());
        //   getFacade().setCityFlmem(getCityFl());
 getFacade().setPtsphotomem(ptsphoto);
            getFacade().setPtsprofilemem(ptsprofile);
            getFacade().setPtsfirstmessagemem(ptsfirstmessage);
            getFacade().setPtsfunnymem(ptsfunny);
            getFacade().setPtsinterestingmem(ptsinteresting);
            getFacade().setPtspersonalitymem(ptspersonality);
            getFacade().setPtsfirstdatemem(ptsfirstdate);
            getFacade().setPtsdateideamem(ptsdateidea);
            getFacade().setPtsverifyprofilemem(ptsverifyprofile);






            Calendar cal=Calendar.getInstance();
            int currentyear=cal.get(Calendar.YEAR);

            String afro = getAgefromFl();

            int afroint = Integer.parseInt(afro);


            String ato = getAgetoFl();

            int atoint = Integer.parseInt(ato);



           int afroyear =   currentyear-afroint;

           int atoyear = currentyear-atoint;


getFacade().setAgefromFlem(Integer.toString(atoyear));

getFacade().setAgetoFlem(Integer.toString(afroyear));



if(getEthnicityFl().isEmpty() || getEthnicityFl().equals("All Ethnicities")){

    return "/members/searchall.xhtml";

}


  return "/members/searchsome.xhtml";




          }else if(getCityFl().isEmpty()==true && getZipcodeSearchTwo().isEmpty()==false )   {

//search on zipcode





    getFacade().setLnguserid(getInboxmanaged().getUsrid());

      Members proxymem = getFacade().findMember();

              //  String proxyzip = proxymem.getZipcode();


            float fftt = calculateLatitudeRadius(getRadius());

            float ffnn = calculateLongitudeRadius(getRadius());


            getFacade().setZipdatathree(getZipcodeSearchTwo());


 // itemszip = getItemszip();
 //  List<Uszipcodesdb> blitems = (List<Uszipcodesdb>)itemszip.getWrappedData();


      //    Uszipcodesdb ii =  blitems.get(0);

          Uszipcodesdb ii = getFacade().findRangeZip();



            float fflat = (ii.getLatitude()) + fftt;

            getFacade().setFlatone(fflat);

            float iitt = (ii.getLatitude()) - fftt;

            getFacade().setFlattwo(iitt);

            float fflon = (ii.getLongitude()) + ffnn;

            getFacade().setFlonone(fflon);

            float iinn = (ii.getLongitude()) - ffnn;

            getFacade().setFlontwo(iinn);

            //end of zipcode radius data processing
            String gen = getGenderFl();

            getFacade().setGenderFlmem(gen);

            getFacade().setSeekingFlmem(getSeekingFl());

            getFacade().setLookingFlmem(getLookingFl());

            getFacade().setEthnicityFlmem(getEthnicityFl());
      //      getFacade().setSignFlmem(getSignFl());
         //   getFacade().setStateFlmem(getState());
        //   getFacade().setCityFlmem(getCityFl());
 getFacade().setPtsphotomem(ptsphoto);
            getFacade().setPtsprofilemem(ptsprofile);
            getFacade().setPtsfirstmessagemem(ptsfirstmessage);
            getFacade().setPtsfunnymem(ptsfunny);
            getFacade().setPtsinterestingmem(ptsinteresting);
            getFacade().setPtspersonalitymem(ptspersonality);
            getFacade().setPtsfirstdatemem(ptsfirstdate);
            getFacade().setPtsdateideamem(ptsdateidea);
            getFacade().setPtsverifyprofilemem(ptsverifyprofile);







            Calendar cal=Calendar.getInstance();
            int currentyear=cal.get(Calendar.YEAR);

            String afro = getAgefromFl();

            int afroint = Integer.parseInt(afro);


            String ato = getAgetoFl();

            int atoint = Integer.parseInt(ato);



           int afroyear =   currentyear-afroint;

           int atoyear = currentyear-atoint;


getFacade().setAgefromFlem(Integer.toString(atoyear));

getFacade().setAgetoFlem(Integer.toString(afroyear));



if(getEthnicityFl().isEmpty() || getEthnicityFl().equals("All Ethnicities")){

    return "/members/searchall.xhtml";
    

}


  return "/members/searchsome.xhtml";



          }else if(getCityFl().isEmpty()==false && getZipcodeSearchTwo().isEmpty()==false )   {
//search on city state zip




    getFacade().setLnguserid(getInboxmanaged().getUsrid());

      Members proxymem = getFacade().findMember();

              //  String proxyzip = proxymem.getZipcode();


            float fftt = calculateLatitudeRadius(getRadius()+2);

            float ffnn = calculateLongitudeRadius(getRadius()+2);


            getFacade().setCityFlmem(getCityFl());
            getFacade().setStateFlmem(getState());

   getFacade().setZipdatathree(getZipcodeSearchTwo());





 itemszip = getItemscitystatezip();


   List<Uszipcodesdb> blitems = (List<Uszipcodesdb>)itemszip.getWrappedData();


   if(blitems.isEmpty()){
       return "/members/searchnone.xhtml";
   }

         Uszipcodesdb ii =  blitems.get(0);

        //  Uszipcodesdb ii = getFacade().findRangeCity();



            float fflat = (ii.getLatitude()) + fftt;

            getFacade().setFlatone(fflat);

            float iitt = (ii.getLatitude()) - fftt;

            getFacade().setFlattwo(iitt);

            float fflon = (ii.getLongitude()) + ffnn;

            getFacade().setFlonone(fflon);

            float iinn = (ii.getLongitude()) - ffnn;

            getFacade().setFlontwo(iinn);

            //end of zipcode radius data processing
            String gen = getGenderFl();

            getFacade().setGenderFlmem(gen);

            getFacade().setSeekingFlmem(getSeekingFl());

            getFacade().setLookingFlmem(getLookingFl());

            getFacade().setEthnicityFlmem(getEthnicityFl());
      //      getFacade().setSignFlmem(getSignFl());
         //   getFacade().setStateFlmem(getState());
        //   getFacade().setCityFlmem(getCityFl());
 getFacade().setPtsphotomem(ptsphoto);
            getFacade().setPtsprofilemem(ptsprofile);
            getFacade().setPtsfirstmessagemem(ptsfirstmessage);
            getFacade().setPtsfunnymem(ptsfunny);
            getFacade().setPtsinterestingmem(ptsinteresting);
            getFacade().setPtspersonalitymem(ptspersonality);
            getFacade().setPtsfirstdatemem(ptsfirstdate);
            getFacade().setPtsdateideamem(ptsdateidea);
            getFacade().setPtsverifyprofilemem(ptsverifyprofile);
            




            Calendar cal=Calendar.getInstance();
            int currentyear=cal.get(Calendar.YEAR);

            String afro = getAgefromFl();

            int afroint = Integer.parseInt(afro);


            String ato = getAgetoFl();

            int atoint = Integer.parseInt(ato);



           int afroyear =   currentyear-afroint;

           int atoyear = currentyear-atoint;


getFacade().setAgefromFlem(Integer.toString(atoyear));

getFacade().setAgetoFlem(Integer.toString(afroyear));



if(getEthnicityFl().isEmpty() || getEthnicityFl().equals("All Ethnicities")){

    return "/members/searchall.xhtml";

}
          }




itemslistfl=null;

      //  return prepareListFl();
  return "/members/searchsome.xhtml";



} catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }



    }





  





public String showPoints(){

getFacade().setMemberpointsid(current.getUserid());
    
    return "/points/List";

}






//SEND A MESSAGE TO THIS MEMBER FROM VIEW ONE - VIEW 8 ON MEMBERS.*****************************************************

public String prepareCreateTwo() {

// String username2 = getFacade().getUsernamelogin();

              //  if (username2 == null) {

                //    username2 = getFacade().getUsernamecreate();

              //  }

    
getFacade4().setCheckid(getInboxmanaged().getUsrid());

String checkblock = getFacade4().findBlockedTwoReplyPh();

if(checkblock.equals("/mailsettings/blockuser")){


    return  "/mailsettings/blockuser";

}else{





 getFacade().setLnguserid(getInboxmanaged().getUsrid());

   Members mmbr = getFacade().findMember();

   
   Members mmbst = getFacade().findMembervin();






// getFacade().setLnguserid(getInboxmanaged().getUsrid());

       // Members mmbr = getFacade().findMember();

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

        currentin.setSentTo(mmbst.getUsername());

         currentin.setSendtoid(mmbst.getUserid());

               long sfridd =  mmbr.getUserid();

        currentin.setSendfromid(sfridd);



        selectedItemIndex = -1;
        return "/members/personalsmessage";

    }

    }



//CREATE FROM THE CREATESNDMSG PAGE ON MEMBERS****************************************************************************

    public String createMsgMemSearch() {


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


   // getFacade4().setSendhistidchk(ssdd);

   // getFacade4().setInstid(currentin.getSendfromid());



//  String hhh = getFacade4().findRangeInboxUsrExist();




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

         



            JsfUtil.addSuccessMessage("Message was sent");
            return "/inbox/messages";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }

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



 public PaginationHelper getPaginationcitystatezip() {
        if (paginationzip == null) {
            paginationzip = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findcitystatezip(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return paginationzip;
    }





 public PaginationHelper getPaginationstate() {
        if (paginationzip == null) {
            paginationzip = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findstate(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return paginationzip;
    }


    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

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



      public PaginationHelper getPaginationThree() {
        if (pagination == null) {
            pagination = new PaginationHelper(80) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRangeInboxUsr(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return pagination;
    }


 public PaginationHelperThree getPaginationlistfl() {
        if (paginationlistfl == null) {
            paginationlistfl = new PaginationHelperThree(5) {

                @Override
                public int getItemsCount() {
                    return getFacade().findRangeFlcount();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRangeFl(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return paginationlistfl;
    }





 public PaginationHelper getPaginationlistflTwo() {
        if (paginationlistflTwo == null) {
            paginationlistflTwo = new PaginationHelper(5) {

                @Override
                public int getItemsCount() {
                    return getFacade().findRangeFlTwocount();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRangeFlTwo(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return paginationlistflTwo;
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




 public DataModel getItemsumightlike() {
        if (itemsumightlike == null) {
            itemsumightlike = getPaginationThree().createPageDataModel();
        }


        return itemsumightlike;
    }




    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }



  //     public DataModel getItemsTwo() {
  //        if (itemstwo == null) {
  //            itemstwo = getPaginationTwo().createPageDataModel();
   //       }
  //        return itemstwo;
 //     }


      public DataModel getItemsThree() {
        if (items == null) {
            items = getPaginationThree().createPageDataModel();
        }
        return items;
    }



   public DataModel getItemslistfl() {


       if (itemslistfl == null) {

            itemslistfl = getPaginationlistfl().createPageDataModel();
       }

       
       return itemslistfl;


    }


 

    public DataModel getItemslistflTwo() {
        if (itemslistflTwo == null) {
            itemslistflTwo = getPaginationlistflTwo().createPageDataModel();
        }
        return itemslistflTwo;

    }



 private void recreateModellistflTwo() {
        itemslistflTwo = null;
    }



     public String nextlistflTwo() {

     getPaginationlistflTwo().nextPage();

     recreateModellistflTwo();

        return "/members/ListFl2";

    }


     

    public String previouslistflTwo() {


        getPaginationlistflTwo().previousPage();

         recreateModellistflTwo();

        return "/members/ListFl2";

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

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }










    public String prepareViewTwo() {

     
 current = (Members) getItemslistfl().getRowData();


//selectedItemIndex = paginationlistfl.getPageFirstItem() + getItemslistfl().getRowIndex();


getFacade().setHasviwedid(current.getUserid());

getFacade4().setSearchRadId(current.getUserid());


String hsvp = getFacade().findHasViewedProfileDuplicate();




if(hsvp.equals("nohvpduplicate")){

            currentHasviewedprofiletwo = new Hasviewedprofiletwo();

            
             getFacade().setLnguserid(getInboxmanaged().getUsrid());

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

  getFacade().setLnguserid(getInboxmanaged().getUsrid());

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

         //   JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("UmightlikeDeleted"));

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

        getFacade4().findSearchResPhoto();

        int fbfb = getFacade4().getFlumbeta();

    //    if (fbfb == 1) {
   //         setRetph2("vv1");
    //    } else if (fbfb == 2) {
     //       setRetph2("vv1");
     //   } else if (fbfb == 3) {
     //       setRetph2("vv2");
     //   } else if (fbfb == 4) {
      //      setRetph2("vv3");
      //  } else if (fbfb == 5) {
    //        setRetph2("vv4");
    //    } else if (fbfb == 6) {
    //        setRetph2("vv5");
    //    } else if (fbfb == 7) {
    //       setRetph2("vv6");
    //    } else if (fbfb == 8) {
    //        setRetph2("vv7");
    //    } else if (fbfb == 9) {
    //        setRetph2("vv8");

    //    }  else if (fbfb == 20) {
     //       setRetph2("vv9");

     //   }


        return "/members/singlesprofile.xhtml";




    }



    



public String deleteacct(){


    getFacade().deleteInSentbox();

 // getFacade().deleteMember();

getFacade().deleteOther();

//   getFacade().deletePhotos();

getFacade().deleteUmightlike();




      HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();

        return "/login";



}








public String help(){

    return "/indexthree";

}


//parse exception is for  line 805 DATE date5
    public String logout() throws ParseException  {

        //get date today minus one month.
 Calendar date = Calendar.getInstance();
        SimpleDateFormat dateformatter = new SimpleDateFormat(" MM/dd/yyyy hh:mm:ss a zzz");
       // date.add(Calendar.MONTH, -1);

     //   String datetoday =  (dateformatter.format(date.getTime()));



         items = getItemsThree();
  //   List<Blockedtwo> blitems = (List<Blockedtwo>)items.getWrappedData();
 //   List<Blockedtwo> tenblitems;
 List<Inbox> blitems = (List<Inbox>)items.getWrappedData();




   for( Inbox curblock : blitems ){


//could be a problem with parsing. be careful.
 Date date5 = (Date)dateformatter.parse(curblock.getMessageDate());


Calendar zoo = Calendar.getInstance();
zoo.setTime(date5);

// daysBetween(date.getTime(),date1.getTime())

     int ppp =  daysBetween(zoo.getTime(), date.getTime());

          if( ppp >31 ) {


       try {
            getFacadeIn().remove(curblock);


       //     JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("InboxDeleted"));

       } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
        }




          }


    }




         getFacade().updateOfflineNow();


        username = null;



        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();



        return "/login";

    }








    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

   



    /**
     * @return the tracker
     */
    public long getTracker() {
        return tracker;
    }

    /**
     * @param tracker the tracker to set
     */
    public void setTracker(long tracker) {
        this.tracker = tracker;
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
     * @return the yearnow
     */
    public String getYearnow() {
        return yearnow;
    }

    /**
     * @param yearnow the yearnow to set
     */
    public void setYearnow(String yearnow) {
        this.yearnow = yearnow;
    }

    /**
     * @return the zipcodeSearchTwo
     */
    public String getZipcodeSearchTwo() {
        return zipcodeSearchTwo;
    }

    /**
     * @param zipcodeSearchTwo the zipcodeSearchTwo to set
     */
    public void setZipcodeSearchTwo(String zipcodeSearchTwo) {
        this.zipcodeSearchTwo = zipcodeSearchTwo;
    }

    /**
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * @return the genderFl
     */
    public String getGenderFl() {
        return genderFl;
    }

    /**
     * @param genderFl the genderFl to set
     */
    public void setGenderFl(String genderFl) {
        this.genderFl = genderFl;
    }

    /**
     * @return the seekingFl
     */
    public String getSeekingFl() {
        return seekingFl;
    }

    /**
     * @param seekingFl the seekingFl to set
     */
    public void setSeekingFl(String seekingFl) {
        this.seekingFl = seekingFl;
    }

    /**
     * @return the lookingFl
     */
    public String getLookingFl() {
        return lookingFl;
    }

    /**
     * @param lookingFl the lookingFl to set
     */
    public void setLookingFl(String lookingFl) {
        this.lookingFl = lookingFl;
    }

    /**
     * @return the agefromFl
     */
    public String getAgefromFl() {
        return agefromFl;
    }

    /**
     * @param agefromFl the agefromFl to set
     */
    public void setAgefromFl(String agefromFl) {
        this.agefromFl = agefromFl;
    }

    /**
     * @return the agetoFl
     */
    public String getAgetoFl() {
        return agetoFl;
    }

    /**
     * @param agetoFl the agetoFl to set
     */
    public void setAgetoFl(String agetoFl) {
        this.agetoFl = agetoFl;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the cityFl
     */
    public String getCityFl() {
        return cityFl;
    }

    /**
     * @param cityFl the cityFl to set
     */
    public void setCityFl(String cityFl) {
        this.cityFl = cityFl;
    }

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

    /**
     * @return the ethnicityFl
     */
    public String getEthnicityFl() {
        return ethnicityFl;
    }

    /**
     * @param ethnicityFl the ethnicityFl to set
     */
    public void setEthnicityFl(String ethnicityFl) {
        this.ethnicityFl = ethnicityFl;
    }

    /**
     * @return the ptsphoto
     */
    public int getPtsphoto() {
        return ptsphoto;
    }

    /**
     * @param ptsphoto the ptsphoto to set
     */
    public void setPtsphoto(int ptsphoto) {
        this.ptsphoto = ptsphoto;
    }

    /**
     * @return the ptsprofile
     */
    public int getPtsprofile() {
        return ptsprofile;
    }

    /**
     * @param ptsprofile the ptsprofile to set
     */
    public void setPtsprofile(int ptsprofile) {
        this.ptsprofile = ptsprofile;
    }

    /**
     * @return the ptsfirstmessage
     */
    public int getPtsfirstmessage() {
        return ptsfirstmessage;
    }

    /**
     * @param ptsfirstmessage the ptsfirstmessage to set
     */
    public void setPtsfirstmessage(int ptsfirstmessage) {
        this.ptsfirstmessage = ptsfirstmessage;
    }

    /**
     * @return the ptsfunny
     */
    public int getPtsfunny() {
        return ptsfunny;
    }

    /**
     * @param ptsfunny the ptsfunny to set
     */
    public void setPtsfunny(int ptsfunny) {
        this.ptsfunny = ptsfunny;
    }

    /**
     * @return the ptsinteresting
     */
    public int getPtsinteresting() {
        return ptsinteresting;
    }

    /**
     * @param ptsinteresting the ptsinteresting to set
     */
    public void setPtsinteresting(int ptsinteresting) {
        this.ptsinteresting = ptsinteresting;
    }

    /**
     * @return the ptspersonality
     */
    public int getPtspersonality() {
        return ptspersonality;
    }

    /**
     * @param ptspersonality the ptspersonality to set
     */
    public void setPtspersonality(int ptspersonality) {
        this.ptspersonality = ptspersonality;
    }

    /**
     * @return the ptsfirstdate
     */
    public int getPtsfirstdate() {
        return ptsfirstdate;
    }

    /**
     * @param ptsfirstdate the ptsfirstdate to set
     */
    public void setPtsfirstdate(int ptsfirstdate) {
        this.ptsfirstdate = ptsfirstdate;
    }

    /**
     * @return the ptsdateidea
     */
    public int getPtsdateidea() {
        return ptsdateidea;
    }

    /**
     * @param ptsdateidea the ptsdateidea to set
     */
    public void setPtsdateidea(int ptsdateidea) {
        this.ptsdateidea = ptsdateidea;
    }

    /**
     * @return the ptsverifyprofile
     */
    public int getPtsverifyprofile() {
        return ptsverifyprofile;
    }

    /**
     * @param ptsverifyprofile the ptsverifyprofile to set
     */
    public void setPtsverifyprofile(int ptsverifyprofile) {
        this.ptsverifyprofile = ptsverifyprofile;
    }

   










    @FacesConverter(forClass=Members.class)
    public static class MembersControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MembersControllerSix controller = (MembersControllerSix)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "membersControllerSix");
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
