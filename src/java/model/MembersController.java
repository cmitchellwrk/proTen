package model;

import controller.BlockedtwoFacade;
import controller.DeletedfeedbackFacade;
import controller.InboxFacade;
import controller.LastpointsgivepersonFacade;
import controller.MailsettingsFacade;
import java.text.ParseException;
import model.util.JsfUtil;
import model.util.PaginationHelper;
import controller.MembersFacade;
import controller.MembersFacadeTwo;

import controller.PhotosFacade;
import controller.PointsFacade;
import controller.SentFacade;
import controller.UszipcodesdbFacade;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import javax.faces.application.FacesMessage;
import javax.servlet.http.HttpSession;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.bean.ManagedProperty;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import java.util.Properties;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.event.ComponentSystemEvent;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.File;
import java.io.FileNotFoundException;




@ManagedBean (name="membersController")
@SessionScoped
public class MembersController {



private boolean isnewusr= false;

private boolean isnewpass= false;



private String username;

private String password;


private String emailfind;




//used for  create account page
private HtmlInputText inputName, inputZip, inputCity, inputState;



//used for  create account page
private HtmlInputText usrNamNew;


//used for  create account page
private HtmlInputText usrPasswordNew;


//used for  create account page
private String checkusernamenew;

//used for create account page
private String checkpasswordnew;

//used for create account page.
private String zipcodevalid;




    private String zip2;
    private String nam;
    private String sal;
    private float curlat;
    private float curlon;
    private long tracker;



 @EJB private controller.UszipcodesdbFacade ejbFacade3;

 @EJB private controller.PhotosFacade ejbFacade4;

 @EJB private controller.InboxFacade ejbFacadeIn;

 @EJB  private controller.SentFacade ejbFacadeSent;

 @EJB private controller.MembersFacade ejbFacade;

 @EJB private controller.MailsettingsFacade ejbFacademail;

 @EJB private controller.BlockedtwoFacade ejbFacadeBlockedtwo;

//possible delete if does not work. as of 7/8 not working.
 @EJB private controller.MembersFacadeTwo ejbFacadememberstwo;


 @EJB private controller.DeletedfeedbackFacade ejbFacadedeletefeedback;


 @EJB private controller.PointsFacade ejbFacadePoints;


  @EJB private controller.LastpointsgivepersonFacade ejbFacadeLastPtsgiven;


//used for delete account function
   private Deletedfeedback currentdeletefeedback;


    private Mailsettings currentmail;



    //used for main createaccount page for new members.
    private Members current;


    private Members currenttwo;


    public Uszipcodesdb zipcode3 = null;


    public Photos currentPhotoSetUp;


    private Inbox currentin;


    private Sent senttwo;


    private Blockedtwo currentblockedtwo;


       private Points currentPoints;

      private Lastpointsgiveperson currentLastptsgiven;
      

    private DataModel items = null;

    private DataModel itemstwo = null;

    private PaginationHelper pagination;

    private PaginationHelper paginationTwo;

    private int selectedItemIndex;

    private String retph2;



 @ManagedProperty(value= "#{inboxControllerTwo}")


 private InboxControllerTwo inboxmanaged;




    public MembersController() {
    }


    
public  int daysBetween(Date d1, Date d2){
 return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
 }





    public Deletedfeedback getSelecteddeletefeedback() {
        if (currentdeletefeedback == null) {
            currentdeletefeedback = new Deletedfeedback();
            selectedItemIndex = -1;
        }
        return currentdeletefeedback;
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






    private MembersFacadeTwo getFacadememberstwo() {

        return ejbFacadememberstwo;

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



       private DeletedfeedbackFacade getFacadedeletefeedback() {
        return ejbFacadedeletefeedback;
    }



        private PointsFacade getFacadePoints() {
        return ejbFacadePoints;
    }


       
  private LastpointsgivepersonFacade getFacadeLastptsgiven() {
        return ejbFacadeLastPtsgiven;
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



    public String nophotsetup(){


        getFacade().setLnguserid(getInboxmanaged().getUsrid());
        Members mmtwo = getFacade().findRgMemTwo();


String emptee = mmtwo.getUsername();

      // String emptee = current.getUsername();



   
      try{
          File f1 = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/Cropped/" + "nophoto.jpeg" );
          File f2 = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/Cropped/" + emptee + "/" + "nophotosecond.jpeg");
          InputStream in = new FileInputStream(f1);

          //For Append the file.
          //OutputStream out = new FileOutputStream(f2,true);

          //For Overwrite the file.
          OutputStream out = new FileOutputStream(f2);

          byte[] buf = new byte[1024];
          int len;
          while ((len = in.read(buf)) > 0){
            out.write(buf, 0, len);
          }
          in.close();
          out.close();
          System.out.println("File copied.");
        }
        catch(FileNotFoundException ex){
          System.out.println(ex.getMessage() + " in the specified directory.");
          System.exit(0);
        }
        catch(IOException e){
          System.out.println(e.getMessage());
        }




getFacade().setUsernamecreate(emptee);


getFacade().updateNophotosetup();


getFacade().setInboxupdateimageurl("/Cropped/"+ emptee +"/nophotosecond.jpeg");



getFacade().updateInboxSent();




        return"/inbox/yourmessages.xhtml";


    }






    public String create() {

      //  if(isnewusr == true){

   // return "/members/signup.xhtml";

//}

        

        try {



             current.setLat(curlat);
             current.setLon(curlon);

              String uu = current.getUsername();

              getFacade().setUsernamecreate(uu);



              username = current.getUsername();
             

            getFacade().create(current);


              Long lloo = getFacade().findUsername(uu).getUserid();

                   getInboxmanaged().setUsrid(lloo);


              getFacade4().setCheckid(lloo);

               getFacade().setLnguserid(lloo);

                getFacade4().setSearchRadId(lloo);

                    getFacadeIn().setLlnnid(lloo);

                        getFacademail().setMailloginid(lloo);

                     getFacadeSent().setSentmemid(lloo);

                //begin section setup member photo database for uploads

             currentPhotoSetUp = new Photos();

            currentPhotoSetUp.setImageurl1a("*");
            currentPhotoSetUp.setImageurl1b("*");

            currentPhotoSetUp.setImageurl2a("*");
            currentPhotoSetUp.setImageurl2b("*");

            currentPhotoSetUp.setImageurl3a("*");
            currentPhotoSetUp.setImageurl3b("*");

            currentPhotoSetUp.setImageurl4a("*");
            currentPhotoSetUp.setImageurl4b("*");

            currentPhotoSetUp.setImageurl5a("*");
            currentPhotoSetUp.setImageurl5b("*");

            currentPhotoSetUp.setImageurl6a("*");
            currentPhotoSetUp.setImageurl6b("*");

            currentPhotoSetUp.setImageurl7a("*");
            currentPhotoSetUp.setImageurl7b("*");

            currentPhotoSetUp.setImageurl8a("*");
            currentPhotoSetUp.setImageurl8b("*");

            currentPhotoSetUp.setImageurl9a("*");
            currentPhotoSetUp.setImageurl9b("*");

            currentPhotoSetUp.setImageurl10a("*");
            currentPhotoSetUp.setImageurl10b("*");

            currentPhotoSetUp.setImageurl11a("*");
            currentPhotoSetUp.setImageurl11b("*");

            currentPhotoSetUp.setImageurl12a("*");
            currentPhotoSetUp.setImageurl12b("*");

            currentPhotoSetUp.setImageurl13a("*");
            currentPhotoSetUp.setImageurl13b("*");

            currentPhotoSetUp.setImageurl14a("*");
            currentPhotoSetUp.setImageurl14b("*");

            currentPhotoSetUp.setImageurl15a("*");
            currentPhotoSetUp.setImageurl15b("*");

            currentPhotoSetUp.setImageurl16a("*");
            currentPhotoSetUp.setImageurl16b("*");



             currentPhotoSetUp.setPhotouserid(lloo);

            getFacade4().create(currentPhotoSetUp);


                   String emptee = uu;


            File dir2 = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/Uploads/"   + emptee);

           boolean success2 = dir2.mkdirs();


            File dir3 = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/Cropped/"   + emptee);

           boolean success3 = dir3.mkdirs();



currentmail = new Mailsettings();

currentmail.setGender("Either");


currentmail.setIdmember(lloo);


getFacademail().create(currentmail);


currentPoints = new Points();
currentPoints.setIdpersonpointsreceive(lloo);

getFacadePoints().create(currentPoints);




// currentLastptsgiven = new Lastpointsgiveperson();

 // currentLastptsgiven.setIdpersonpointsreceive(lloo);

// getFacadeLastptsgiven().create(currentLastptsgiven);

 




            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("MembersCreated"));
            return "/members/newmemberupload.xhtml";
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


            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("InboxCreated"));
            return getRetph2();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }






public String prepareCreateTwo() {

 String username2 = getFacade().getUsernamelogin();

                if (username2 == null) {

                    username2 = getFacade().getUsernamecreate();

                }

        currentin = new Inbox();

        currentin.setRemoveinmsg(false);


        currentin.setImageurl("test");

        currentin.setSentFrom(username2);

        currentin.setSentTo(current.getUsername());

        currentin.setSendtoid(current.getUserid());

          Members mmbr = getFacade().findMember();

               Long sfrid =  mmbr.getUserid();



        currentin.setSendfromid(sfrid);




        selectedItemIndex = -1;
        return "CreateSndMsg";

    }








    public String prepareEdit() {
        current = (Members)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }



     public String prepareEditTwo() {



       // currenttwo = (Members) getItems().getRowData();

         getFacade().setLnguserid(getInboxmanaged().getUsrid());
         
                currenttwo =  (Members) getFacade().findMember();

      // selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "/members/editmyprofile.xhtml";
    }





    public String update() {
        
        
        
              if(curlat==0.0 && curlon==0.0){


        try {


            getFacade().edit(currenttwo);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("MembersUpdated"));
            return "/inbox/yourmessages.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }


        } else{

              currenttwo.setLat(curlat);
             currenttwo.setLon(curlon);

                  try {


            getFacade().edit(currenttwo);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("MembersUpdated"));
            return "/inbox/yourmessages.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }




        }






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


      public DataModel getItemsThree() {
        if (items == null) {
            items = getPaginationThree().createPageDataModel();
        }
        return items;
    }



      public String returnlogin(){


      HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();

        return "/login";

          

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




    public void checkLogin(ComponentSystemEvent event) {

        FacesContext fc = FacesContext.getCurrentInstance();

        if (username == null) {

            //  FacesContext fc = FacesContext.getCurrentInstance();

//NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();

            //navigationHandler.handleNavigation(context, null, "/login?faces-redirect=true");

            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();

            nav.performNavigation("login");

        }

    }



    public String emaillookup(){


 try {

            getFacade().setEmaillookup(emailfind);

            String bb = getFacade().findepassword();

            String cc = "incorrect";

           if (bb.equals(cc)) {
      
               emailfind="";

          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("EmailDoesnotExist"));

          return "/footerpages/passwordfind.xhtml";



            } else {



                Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("cgmrain@gmail.com","1rainman1");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("cgmrain@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailfind));
			message.setSubject("Testing Subject");
			message.setText("Thank you for using Chemispark.com," +
					"\n\n Here is your password :" + bb);

			Transport.send(message);

			System.out.println("Done");


		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}



          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("PasswordSent"));

          emailfind="";
 return "/footerpages/passwordfind.xhtml";


           }

        } catch (Exception e) {
           // JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
             JsfUtil.addErrorMessage(e, "please try again");
            return null;
        }
        


    }




     public String login() {
        try {

            getFacade().setUsernamelogin(getUsername().trim());
            getFacade().setEmaillookup(getPassword().trim());

            String bb = getFacade().findlogin();
            String rr = getFacade().findepassword();
            

            String cc = "welcome";
            String ee = "passwordyes";


           if (bb.equals(cc)) {

               long jj = getFacade().getLnguserid();

   //check projsix login fundtion for details on below.

               
     //main member userid set in stateful session bean .
               
    getInboxmanaged().setUsrid(jj);


           //   getFacade4().setSearchRadId(jj);


           //   getFacademail().setMailloginid(jj);
 
           //   getFacadeBlockedtwo().setCheckblockid(jj);

              
  getFacade().updateOnlineNow();


  getFacadeIn().setLlnnid(getInboxmanaged().getUsrid());


                return "/inbox/yourmessages";

            } else {

                return "nologin";
           }

        } catch (Exception e) {
           // JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
             JsfUtil.addErrorMessage(e, "please try again");
            return null;
        }
    }



     



public String deleteacct(){


        try {

            getFacadedeletefeedback().create(currentdeletefeedback);

            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/ResourceFour/Bundle").getString("DeletedfeedbackCreated"));

          //  return prepareCreate();

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/ResourceFour/Bundle").getString("PersistenceErrorOccured"));

            return null;

        }

   


    getFacade().deleteInSentbox();

  getFacade().deleteMember();

getFacade().deleteOther();

   getFacade().deletePhotos();

getFacade().deleteUmightlike();

//last one added - did not test for problems
getFacade().deletePointsDidea();


      HttpSession  session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();

        return "/login";



}






public String help(){

    return "/indexthree";

}





public String logoutnonuser() throws ParseException   {

if(getInboxmanaged().getUsrid()==0L){
    
    return"/login";
    
    
}



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




    return"/login";


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





    private UszipcodesdbFacade getFacade3() {
        return ejbFacade3;
    }



 public Uszipcodesdb getZipcodesItemsTwo() {

        getFacade3().setZipdatathree(zip2);

        zipcode3 = getFacade3().findRangeZip();

        return zipcode3;
    }



    private void performLookup(String zip, StringBuilder city,
            StringBuilder states) {

        // Production code would actually perform the lookup.
        // For now, we assume that every possible zip code is
        // in Dallas, Texas.

        //******you need to add something to handle if the user doesnt enter a zipcode but clicks
        //******on the  component so ther is no index out of bounds exception.

        //  zipcode2 = getZipcodesItems().get(0);

        zipcode3 = getZipcodesItemsTwo();

        if(zipcode3.getZipcode().equals("5")){

        //  JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("Nozipcode"));

           setZipcodevalid("Please enter a valid zipcode");
           
        } else {
            setZipcodevalid(" ");
        }

        sal = zipcode3.getCity();

        nam = zipcode3.getState();

        curlat = zipcode3.getLatitude();

        //String tt = String.valueOf(curlat);

        curlon = zipcode3.getLongitude();

        //String gg = String.valueOf(curlon);

        city.append(sal);
        states.append(nam);


      

//laat.append(tt);
//loon.append(gg);
    }



public void checkUsrNew(AjaxBehaviorEvent event) {

  //  String newnom = event.toString();

String oohhahh = getUsrNamNew().getValue().toString();

getFacade().setSennpassword(oohhahh);

String isnewnom = getFacade().findChkUsrTwo();


if(isnewnom.equals(getUsername())){

    setCheckusernamenew("");

    setIsnewusr(true);

}else if (isnewnom.equals("notavailable")){

     setCheckusernamenew("");

     setIsnewusr(true);

}else{

    
     setCheckusernamenew("That username is already taken.");

     setIsnewusr(false);


    }


       }






public void checkUsrNewTwo(AjaxBehaviorEvent event) {

  //  String newnom = event.toString();

String oohhahh = getUsrPasswordNew().getValue().toString();

getFacade().setSenn(oohhahh);

String isnewnom = getFacade().findChkUsr();



if(isnewnom.equals(getPassword())){

    setCheckpasswordnew("");

    setIsnewusr(true);

}else if (isnewnom.equals("notavailable")){

     setCheckpasswordnew("");

     setIsnewusr(true);

}else{


     setCheckpasswordnew("That password is already taken.");

     setIsnewusr(false);


    }




       }




    public void zipAutoFillListener(AjaxBehaviorEvent vce) {
        String zip = vce.toString();

        String cgm = getInputZip().getValue().toString();

        zip2 = cgm;

        StringBuilder city = new StringBuilder();
        StringBuilder states = new StringBuilder();

        //StringBuilder laat = new StringBuilder();
        //StringBuilder loon = new StringBuilder();

        performLookup(zip, city, states);

        inputCity.setValue(city.toString());
        inputState.setValue(states.toString());

        //inputLat.setValue(laat.toString());
        //inputLon.setValue(loon.toString());
        //inputLat.setValue("yes");
        //inputLon.setValue("yes");

        FacesContext context = FacesContext.getCurrentInstance();
         boolean added = true; // actual application may fail to add user
	FacesMessage doneMessage = null;

	if (added) {
	    doneMessage = new FacesMessage("Successfully added new user");

	} else {
	    doneMessage = new FacesMessage("Failed to add new user");

	}

        FacesContext.getCurrentInstance().addMessage(null, doneMessage);

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
     * @return the inputName
     */
    public HtmlInputText getInputName() {
        return inputName;
    }

    /**
     * @param inputName the inputName to set
     */
    public void setInputName(HtmlInputText inputName) {
        this.inputName = inputName;
    }

    /**
     * @return the inputZip
     */
    public HtmlInputText getInputZip() {
        return inputZip;
    }

    /**
     * @param inputZip the inputZip to set
     */
    public void setInputZip(HtmlInputText inputZip) {
        this.inputZip = inputZip;
    }

    /**
     * @return the inputCity
     */
    public HtmlInputText getInputCity() {
        return inputCity;
    }

    /**
     * @param inputCity the inputCity to set
     */
    public void setInputCity(HtmlInputText inputCity) {
        this.inputCity = inputCity;
    }

    /**
     * @return the inputState
     */
    public HtmlInputText getInputState() {
        return inputState;
    }

    /**
     * @param inputState the inputState to set
     */
    public void setInputState(HtmlInputText inputState) {
        this.inputState = inputState;
    }

    /**
     * @return the usrNamNew
     */
    public HtmlInputText getUsrNamNew() {
        return usrNamNew;
    }

    /**
     * @param usrNamNew the usrNamNew to set
     */
    public void setUsrNamNew(HtmlInputText usrNamNew) {
        this.usrNamNew = usrNamNew;
    }

    /**
     * @return the checkusernamenew
     */
    public String getCheckusernamenew() {
        return checkusernamenew;
    }

    /**
     * @param checkusernamenew the checkusernamenew to set
     */
    public void setCheckusernamenew(String checkusernamenew) {
        this.checkusernamenew = checkusernamenew;
    }

    /**
     * @return the zip2
     */
    public String getZip2() {
        return zip2;
    }

    /**
     * @param zip2 the zip2 to set
     */
    public void setZip2(String zip2) {
        this.zip2 = zip2;
    }

    /**
     * @return the nam
     */
    public String getNam() {
        return nam;
    }

    /**
     * @param nam the nam to set
     */
    public void setNam(String nam) {
        this.nam = nam;
    }

    /**
     * @return the sal
     */
    public String getSal() {
        return sal;
    }

    /**
     * @param sal the sal to set
     */
    public void setSal(String sal) {
        this.sal = sal;
    }

    /**
     * @return the curlat
     */
    public float getCurlat() {
        return curlat;
    }

    /**
     * @param curlat the curlat to set
     */
    public void setCurlat(float curlat) {
        this.curlat = curlat;
    }

    /**
     * @return the curlon
     */
    public float getCurlon() {
        return curlon;
    }

    /**
     * @param curlon the curlon to set
     */
    public void setCurlon(float curlon) {
        this.curlon = curlon;
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
     * @return the isnewusr
     */
    public boolean isIsnewusr() {
        return isnewusr;
    }

    /**
     * @param isnewusr the isnewusr to set
     */
    public void setIsnewusr(boolean isnewusr) {
        this.isnewusr = isnewusr;
    }

   
    /**
     * @return the isnewpass
     */
    public boolean isIsnewpass() {
        return isnewpass;
    }

    /**
     * @param isnewpass the isnewpass to set
     */
    public void setIsnewpass(boolean isnewpass) {
        this.isnewpass = isnewpass;
    }

    /**
     * @return the usrPasswordNew
     */
    public HtmlInputText getUsrPasswordNew() {
        return usrPasswordNew;
    }

    /**
     * @param usrPasswordNew the usrPasswordNew to set
     */
    public void setUsrPasswordNew(HtmlInputText usrPasswordNew) {
        this.usrPasswordNew = usrPasswordNew;
    }

    /**
     * @return the checkpasswordnew
     */
    public String getCheckpasswordnew() {
        return checkpasswordnew;
    }

    /**
     * @param checkpasswordnew the checkpasswordnew to set
     */
    public void setCheckpasswordnew(String checkpasswordnew) {
        this.checkpasswordnew = checkpasswordnew;
    }

    /**
     * @return the emailfind
     */
    public String getEmailfind() {
        return emailfind;
    }

    /**
     * @param emailfind the emailfind to set
     */
    public void setEmailfind(String emailfind) {
        this.emailfind = emailfind;
    }

    /**
     * @return the zipcodevalid
     */
    public String getZipcodevalid() {
        return zipcodevalid;
    }

    /**
     * @param zipcodevalid the zipcodevalid to set
     */
    public void setZipcodevalid(String zipcodevalid) {
        this.zipcodevalid = zipcodevalid;
    }

   

    

    
  
   














    @FacesConverter(forClass=Members.class)
    public static class MembersControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MembersController controller = (MembersController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "membersController");
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
