package model;

import controller.BlockedtwoFacade;
import controller.HasviewedprofiletwoFacade;
import model.util.JsfUtil;
import model.util.PaginationHelper;
import controller.InboxFacade;
import controller.MailsettingsFacade;
import controller.MembersFacade;
import controller.MembersFacadeTwo;
import controller.PhotosFacade;
import controller.SentFacade;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;

import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import model.util.PaginationHelperTwo;



@ManagedBean (name="inboxControllerTwo")
@SessionScoped
public class InboxControllerTwo {



    public InboxControllerTwo() {
    }



 @EJB private controller.MembersFacadeTwo ejbFacadememberstwo;



    private Inbox current;



  private DataModel items = null;


  private DataModel itemsthree = null;



private boolean checkallboolsentbox= false;



    @EJB private controller.InboxFacade ejbFacade;


    private PaginationHelper pagination;

    

      private PaginationHelper paginationtwo;


    private int selectedItemIndex;



    private Members currentmem;



     private PaginationHelper paginationIn;




 @EJB private controller.SentFacade ejbFacadeSent;



 // used for List page in sent folder.
    private PaginationHelper  paginationsent;


      private DataModel itemssent = null;

      


 //also used in View page of sent/view to display the specific row of sent items.
    private Sent senttwo;



 private String replytoidlookup;


    @EJB
    private controller.MembersFacade ejbFacademem;


    @EJB
    private controller.SentFacade ejbFacadesent;


  private String rree;
    private String sstt;
    private String replyid;

    private String sssre;

     public Sent currentsent;

 private Inbox currentreply;



@EJB private controller.BlockedtwoFacade ejbFacadeblockedtwo;

   private Blockedtwo currentblockedtwo;

 

private boolean checkallboolinbox= false;




 @EJB private controller.HasviewedprofiletwoFacade ejbFacadeHasviewedprofiletwo;

   private Hasviewedprofiletwo currentHasviewedprofiletwo;


 @EJB
    private controller.PhotosFacade ejbFacade4;



 private String retph2;


 
private String rowcolor;



private long usrid;


private long searchrdid;



private long sfrid;



@EJB private controller.MailsettingsFacade ejbFacademail;



 private Mailsettings currentmail;



private int pagecontrolnumsession;




private int newmsg;




 private MailsettingsFacade getFacademail() {
        return ejbFacademail;
    }


    public Inbox getSelected() {
        if (current == null) {

          //  current = new Inbox();

           //selectedItemIndex = -1;
        }
        return current;
    }


     public Members getSelectedMem() {
        if (currentmem == null) {

         //   currentmem = new Mem();

            selectedItemIndex = -1;
        }
        return currentmem;
    }




 public Mailsettings getSelectedMail() {

        if (currentmail == null) {
            currentmail = new Mailsettings();
            selectedItemIndex = -1;
        }
        return currentmail;

    }

     



     public Inbox getSelectedTwo() {
        if (currentreply == null) {

            currentreply = getFacade().findRangeInre();


            selectedItemIndex = -1;
        }
        return currentreply;
    }









    private MembersFacadeTwo getFacadememberstwo() {

        return ejbFacadememberstwo;

    }





    private InboxFacade getFacade() {
        return ejbFacade;
    }



     private MembersFacade getFacademem() {
        return ejbFacademem;
    }


 

private BlockedtwoFacade getFacadeblockedtwo() {
        return ejbFacadeblockedtwo;
    }





 private HasviewedprofiletwoFacade getFacadeHasviewedprofiletwo() {

        return ejbFacadeHasviewedprofiletwo;


    }


    private PhotosFacade getFacade4() {
        return ejbFacade4;
    }


 private SentFacade getFacadesent() {

        return ejbFacadeSent;

    }


 public String prepareUpdateMailSettings() {

      //  currentmail = (Mailsettings)getItems().getRowData();

      //  selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();


        try {
            getFacademail().edit(currentmail);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("MailsettingsUpdated"));
            return "/mailsettings/List2_1";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }



      //  return "Edit";

    }




    public int getMsgCount() {

              return getFacade().findRangeInboxUsrMsgCount();


    }







    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().findRangeInboxUsrCount();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRangeInboxUsr(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return pagination;
    }



 public PaginationHelper getPaginationTwo() {
        if (paginationtwo == null) {
            paginationtwo = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().findRangeInboxUsrCount();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRangeInboxUsr(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return paginationtwo;
    }






 public PaginationHelper getPaginationSent() {
        if (paginationsent == null) {
            paginationsent = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacadesent().findSentMemCount();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacadesent().findSentMem(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return paginationsent;
    }





    public PaginationHelper getPaginationIn() {
        if (paginationIn == null) {
            paginationIn = new PaginationHelper(10) {

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
        return paginationIn;
    }


    

public String sentreset(){

    itemssent=null;
    
    return"/sent/List";


}




    public String prepareList() {
        recreateModel();
        return "List";
    }




    


     public String prepareViewTwo() {


        current = (Inbox) getItems().getRowData();


getFacademem().setHasviwedid(current.getSendfromid());



String hsvp = getFacademem().findHasViewedProfileDuplicate();


// get the member info to check if there is duplicate viewed before adding  hasviewed.
  Members vinmem = getFacademem().findMembervin();


  currentmem = vinmem;



if(hsvp.equals("nohvpduplicate")){



            currentHasviewedprofiletwo = new Hasviewedprofiletwo();

            Members sssidtwo = getFacademem().findMember();


            currentHasviewedprofiletwo.setIdcurrent(current.getSendfromid());
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


//................................................................................
// below two fields sets username and userid to retrieve for message population.
        getFacade4().setCurrentUsrn(current.getSentFrom());

        getFacade4().setCurrentUsrid(current.getSendfromid());


getFacade4().setFavoritescity(currentmem.getCity());

getFacade4().setFavoritesimageurl(current.getImageurl());



        Long ssrrdd = current.getSendfromid();



        getFacade4().setSearchRadId(ssrrdd);
        
searchrdid=ssrrdd;
        


        getFacade4().setViewid(ssrrdd);

        getFacade4().setSendhistidchk(ssrrdd);





getFacade4().setInstid(ssrrdd);

getFacade4().setNophotousername(current.getSentFrom());

  getFacade4().findPgPhInSn();



     //   int fbfb = getFacade4().getFlumbeta();

    //    if (fbfb == 1) {
     //       setRetph2("vv1in");
     //   } else if (fbfb == 2) {
     //       setRetph2("vv1in");
     //   } else if (fbfb == 3) {
     //       setRetph2("vv2in");
     //   } else if (fbfb == 4) {
     //       setRetph2("vv3in");
     //   } else if (fbfb == 5) {
     //       setRetph2("vv4in");
     //   } else if (fbfb == 6) {
     //       setRetph2("vv5in");
     //   } else if (fbfb == 7) {
      //      setRetph2("vv6in");
     //   } else if (fbfb == 8) {
      //      setRetph2("vv7in");
      //  } else if (fbfb == 9) {
      //      setRetph2("vv8in");
      //  }else if (fbfb == 20) {
      //      setRetph2("vv9in");
      //  }



        return "/inbox/singlesprofile.xhtml";





    }











    
 //   public String prepareView() {
 //       current = (Inbox)getItems().getRowData();
  //      selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
  //      return "View";
  //  }


     
//get row information to display the message for that row.
     public String prepareView() {


        current = (Inbox) getItems().getRowData();

//update read field in message.
        //.......................................................
getFacademem().setInboxstatusid(current.getId());


getFacademem().updateInboxViewed();

//.............................................................



        //seting up id for block check...........................................
       getFacademem().setSentfromblock(current.getSendfromid());

//end of block check set up id.

     getFacademem().setSubblockimageurl(current.getImageurl());
  //........................................................................
       




        String rlrl = current.getReplyToId();

        setReplytoidlookup(rlrl);

        getFacade().setReplylookup(getReplytoidlookup());




 String bb = current.getSubject();
         getFacademem().setSub(bb);




        String ss = current.getSentFrom();
        getFacademem().setSenn(ss);

        //potentially a tricky function if there are duplicate usernames. could cause problems.

        String sstoo = current.getSentTo();
        getFacademem().setSnttoo(sstoo);

        

// get member info  of person who send the message
Members uu = getFacademem().findMemNom();

//get their id
         sfrid = uu.getUserid();

getFacademem().setSntfromidd(sfrid);



//get send to id from original meesage
 Long sntfrmid = current.getSendtoid();


getFacademem().setSnttoid(sntfrmid);




        String rr = current.getId();
        getFacademem().setIdd(rr);


        setReplyid(rr);

        setSstt(ss);

        setRree(bb);

        // rree = current.getSubject();

        // String zzz = current.getSubject();

        // current.setSubjectRe(zzz);


if(rlrl.equals("-1")){

    return"/inbox/viewmessage";

}else{



        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "/inbox/viewmessagereply";


         }

    }


public String prepareResetIndex() {
        recreateModel();

        current = null;
        currentreply= null;

        return "/index";
        
    }





    public String prepareCreate() {
        current = new Inbox();
        selectedItemIndex = -1;
        return "Create";
    }

 public String prepareBlockedtwo() {
        currentblockedtwo = new Blockedtwo();
       selectedItemIndex = -1;
        return "/inbox/yourmessages/";
    }



    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("InboxCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }



    

 public String createblock() {
        try {


               Members mmbr = getFacademem().findMember();

  currentblockedtwo = new Blockedtwo();

currentblockedtwo.setIdcurrent(mmbr.getUserid());

currentblockedtwo.setUnblock(false);


  currentblockedtwo.setIdofblocked(getFacademem().getSentfromblock());
//currentblockedtwo.setIdofblocked(28);


  currentblockedtwo.setImageurl(getFacademem().getSubblockimageurl());

//currentblockedtwo.setImageurl("test");


            getFacadeblockedtwo().create(currentblockedtwo);


            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("ResourceTwo/Bundle").getString("BlockedtwoCreated"));
            return prepareBlockedtwo();
       
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("ResourceTwo/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }









     public String createFromReply() {
        try {


            String dd = current.getId();
            String rrdd = current.getReplyToId();
           // long ssdd = current.getSendToid();
            long ssdd = current.getSendtoid();


            String ssff = current.getSentFrom();

      getFacademem().setSenn(ssff);

      Members mmbr = getFacademem().findMember();

               Long sfrid =  mmbr.getUserid();



            String sstt = current.getSentTo();
            String ssbb = current.getSubject();
            String ssdt = current.getMessageDate();
            String mt = current.getMsgText();
            String stst = current.getStatus();



            getFacademem().setSentimgeurl(ssdd);
              Members mbrsntimgurl = getFacademem().findMemberSentimgurl();


              
            currentsent = new Sent();

               currentsent.setRemovesntmsg(false);



            currentsent.setId(dd);
            currentsent.setReplyToId(rrdd);
            //currentsent.setSendFromid(ssdd);

            currentsent.setImageurl(mbrsntimgurl.getImageurl());


            currentsent.setSendfromid(sfrid);

            

            currentsent.setSendtoid(ssdd);



            currentsent.setSentFrom(ssff);

            currentsent.setSentTo(sstt);

            currentsent.setSubject(ssbb);

            currentsent.setMessageDate(ssdt);

            currentsent.setMsgText(mt);

            currentsent.setStatus(stst);

            currentsent.setNow("offline");

            
            getFacade().create(current);

            getFacadesent().create(currentsent);
            
recreateModel();

            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("InboxCreated"));
            return "/inbox/yourmessages";

            
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }




public void setSubjectRe(String xyz) {


   if (xyz.length()>=35){

       sssre= xyz;

   }else{

       sssre = "Re:"+xyz;

    }

}




     public String prepareCreatereply() {

         // current = (Inbox) getItems().getRowData();

        // rree = current.getSubject();

        // replyid = current.getId();

        // sstt = current.getSentFrom();

        // Long st2id = getFacademem().getSnttoid();
 Long st2id = current.getSendtoid();



String sssimgurl = current.getImageurl();



//seting up id for block check...........................................
       getFacademem().setSentfromblock(current.getSendfromid());
//end of block check set up id.

     getFacademem().setSubblockimageurl(current.getImageurl());
  //........................................................................
       
getFacademem().setSnttoid(usrid);
         //check to see if user was blocked.
         String dede =  getFacademem().findBlockedTwoReply();



if(dede.equals("/mailsettings/blockuser" )){
      return "/mailsettings/blockuser";
}else{
         

        String cc = getFacademem().getUsernamelogin();

        //set lnguserid from  original login usrid field.
getFacademem().setLnguserid(usrid);
       //  getFacademem().setSenn(cc);

      Members mmbr = getFacademem().findMember();


      //  String idid = getFacademem().getIdd();
        String idid = current.getId();


      //  String sennsenn = getFacademem().getSenn();

        String sennsenn = current.getSentFrom();


       // String subsub = getFacademem().getSub();
  String subsub = current.getSubject();

   String snttoo2from = current.getSentTo();



      //  Long senttooid = getFacademem().getSntfromidd();

  long senttooid = sfrid;


        //current = (Inbox) getItems().getRowData();

        // String zzz = current.getSubject();

        // current.setSubjectRe(zzz);


        current = new Inbox();

        setSubjectRe(subsub);

        //current.setReplyToId(replyid);
         current.setReplyToId(idid);

        //current.setSentTo(sstt);
         current.setSentTo(sennsenn);

         current.setSubject(sssre);

       //  String snttoo2from = getFacademem().getSnttoo();
        //  String snttoo2from = current.getSentTo();


        current.setSentFrom(snttoo2from);

        current.setSendtoid(senttooid);

        current.setSendfromid(st2id);

        current.setImageurl(mmbr.getImageurl());

        




        selectedItemIndex = -1;
        return "/inbox/messagereply.xhtml";

         }
         //the brace above it the end  for the if else at the begingin to check for block.


    }





 public void selectallcheckbox( AjaxBehaviorEvent vce  ){


    itemsthree = getItems();

  //   List<Blockedtwo> blitems = (List<Blockedtwo>)items.getWrappedData();


 //   List<Blockedtwo> tenblitems;
 List<Inbox> blitems = (List<Inbox>)itemsthree.getWrappedData();



     for( Inbox curblock : blitems ){

           curblock.setRemoveinmsg(true);

          }
       // selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();


    }



 

 public void selectallcheckboxSent( AjaxBehaviorEvent vce  ){


    itemssent = getItemsSent();

  //   List<Blockedtwo> blitems = (List<Blockedtwo>)items.getWrappedData();


 //   List<Blockedtwo> tenblitems;
 List<Sent> blitems = (List<Sent>)itemssent.getWrappedData();



     for( Sent curblock : blitems ){

           curblock.setRemovesntmsg(true);

          }
       // selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();


    }






public String prepareMailSettings(){


getFacademail().setMailloginid(getUsrid());

  currentmail =  (Mailsettings) getFacademail().findMailmem();

    return"/mailsettings/yourmailsettings";


}




public String preparUnblockTwo(){


     items = getItems();

  //   List<Blockedtwo> blitems = (List<Blockedtwo>)items.getWrappedData();


 //   List<Blockedtwo> tenblitems;
 List<Inbox> blitems = (List<Inbox>)items.getWrappedData();

 
   for( Inbox curblock : blitems ){


          if( curblock.getRemoveinmsg()){


       try {
            getFacade().remove(curblock);

          
       //     JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("InboxDeleted"));

       } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
        }


           

          }


    }



recreateModel();
    return"/inbox/yourmessages";


}






public String preparUnblockSent(){



     itemssent = getItemsSent();

  //   List<Blockedtwo> blitems = (List<Blockedtwo>)items.getWrappedData();


 //   List<Blockedtwo> tenblitems;
 List<Sent> blitems = (List<Sent>)itemssent.getWrappedData();


   for( Sent curblock : blitems ){


          if( curblock.getRemovesntmsg()){


       try {
            getFacadesent().remove(curblock);


      //      JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("SentDeleted"));

       } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
        }



          }


    }


 recreateModelSent();
    return"/sent/List";




}





    public String prepareEdit() {
        
      //  current = (Inbox)getItems().getRowData();

        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";

    }



    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("InboxUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }



    public String destroy() {
        current = (Inbox)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreateModel();
        return "/inbox/yourmessages";
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("InboxDeleted"));
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

       
        getFacade().setLlnnid(getUsrid());

        if (items == null) {

            items = getPagination().createPageDataModel();
            
        }

        return items;
        
    }


    

     public DataModel getItemsTwo() {
        if (items == null) {
            items = getPaginationIn().createPageDataModel();
        }
        return items;
    }



public DataModel getItemsSent() {

    getFacadesent().setSentmemid(getUsrid());

        if (itemssent == null) {

            itemssent = getPaginationSent().createPageDataModel();

        }


        return itemssent;
    }


//added from Lidt/Sent
public String prepareViewSent() {
        senttwo = (Sent)getItemsSent().getRowData();
        selectedItemIndex = paginationsent.getPageFirstItem() + getItemsSent().getRowIndex();
        return "/sent/viewmessage.xhtml";
    }


 public Sent getSelectedSentMsg() {
        if (senttwo == null) {
            senttwo = new Sent();
            selectedItemIndex = -1;
        }
        return senttwo;
    }



 




 public String resetsent(){

 getFacadesent().setSentmemid(getUsrid());



     itemssent=null;

     return"/sent/messages.xhtml";


    }


 public String resetinbox(){

 getFacade().setLlnnid(getUsrid());

     

     items=null;

     return"/inbox/yourmessages.xhtml";


    }





 public String prepareViewTwoSent(){


     senttwo = (Sent)getItemsSent().getRowData();



getFacademem().setHasviwedid(senttwo.getSendtoid());



String hsvp = getFacademem().findHasViewedProfileDuplicate();






  Members vinmem = getFacademem().findMembervin();


  currentmem = vinmem;






if(hsvp.equals("nohvpduplicate")){



            currentHasviewedprofiletwo = new Hasviewedprofiletwo();

            Members sssidtwo = getFacademem().findMember();


            currentHasviewedprofiletwo.setIdcurrent(senttwo.getSendtoid());
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





// below two fields sets username and userid to retrieve for message population.
        getFacade4().setCurrentUsrn(senttwo.getSentTo());

        getFacade4().setCurrentUsrid(senttwo.getSendtoid());

        
getFacade4().setFavoritescity(currentmem.getCity());
getFacade4().setFavoritesimageurl(currentmem.getImageurl());




   Long ssrrdd = senttwo.getSendtoid();

       getFacade4().setSearchRadId(ssrrdd);

         getFacade4().setViewid(ssrrdd);

        getFacade4().setSendhistidchk(ssrrdd);




getFacade4().setInstid(ssrrdd);

getFacade4().setNophotousername(senttwo.getSentTo());

  getFacade4().findPgPhInSn();




        int fbfb = getFacade4().getFlumbeta();

     //   if (fbfb == 1) {
      //      setRetph2("vv1st");
      //  } else if (fbfb == 2) {
     //       setRetph2("vv1st");
     //   } else if (fbfb == 3) {
      //      setRetph2("vv2st");
      //  } else if (fbfb == 4) {
      //      setRetph2("vv3st");
      //  } else if (fbfb == 5) {
      //      setRetph2("vv4st");
      //  } else if (fbfb == 6) {
     //       setRetph2("vv5st");
     //   } else if (fbfb == 7) {
     //       setRetph2("vv6st");
     //   } else if (fbfb == 8) {
      //      setRetph2("vv7st");
      //  } else if (fbfb == 9) {
      //      setRetph2("vv8st");
      //  }else if (fbfb == 20) {
      //      setRetph2("vv9st");
      //  }



        return "/sent/personals.xhtml";

    }









 public DataModel getItemsthree() {
        if (itemsthree == null) {
            itemsthree = getPaginationTwo().createPageDataModel();
        }
        return itemsthree;
    }





 

 



























private void recreateModelTwo() {

        itemsthree = null;
        checkallboolinbox = false;
    }



    private void recreateModel() {

        items = null;
       checkallboolinbox = false;
        
    }



    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "/inbox/yourmessages";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "/inbox/yourmessages";
    }

    

     public String nexttwo() {
        getPaginationTwo().nextPage();
        recreateModel();
        return "/inbox/yourmessages";
    }

    public String previoustwo() {
        getPaginationTwo().previousPage();
        recreateModel();
        return "/inbox/yourmessages";
    }





  public String nextSent() {

        getPaginationSent().nextPage();

        recreateModelSent();

        return "/sent/List";
    }
  

    public String previousSent() {

        getPaginationSent().previousPage();

        recreateModelSent();

        return "/sent/List";
    }








 private void recreateModelSent() {
        itemssent = null;
        checkallboolsentbox=false;
    }










    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    /**
     * @return the replytoidlookup
     */
    public String getReplytoidlookup() {
        return replytoidlookup;
    }

    /**
     * @param replytoidlookup the replytoidlookup to set
     */
    public void setReplytoidlookup(String replytoidlookup) {
        this.replytoidlookup = replytoidlookup;
    }

    /**
     * @return the rree
     */
    public String getRree() {
        return rree;
    }

    /**
     * @param rree the rree to set
     */
    public void setRree(String rree) {
        this.rree = rree;
    }

    /**
     * @return the sstt
     */
    public String getSstt() {
        return sstt;
    }

    /**
     * @param sstt the sstt to set
     */
    public void setSstt(String sstt) {
        this.sstt = sstt;
    }

    /**
     * @return the replyid
     */
    public String getReplyid() {
        return replyid;
    }

    /**
     * @param replyid the replyid to set
     */
    public void setReplyid(String replyid) {
        this.replyid = replyid;
    }

    /**
     * @return the checkallboolinbox
     */
    public boolean isCheckallboolinbox() {
        return checkallboolinbox;
    }

    /**
     * @param checkallboolinbox the checkallboolinbox to set
     */
    public void setCheckallboolinbox(boolean checkallboolinbox) {
        this.checkallboolinbox = checkallboolinbox;
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
     * @return the rowcolor
     */


    public String getRowcolor() {

        String style = "";

         List<Inbox> blitems = (List<Inbox>)items.getWrappedData();


   for( Inbox curblock : blitems ){


          if( curblock.getStatus().equals("unread")){

                rowcolor = "jsfcrud_unread_row";



          }

              rowcolor = "jsfcrud_odd_row,jsfcrud_even_row";


        }
   return rowcolor;

    }







    /**
     * @param rowcolor the rowcolor to set
     */
    public void setRowcolor(String rowcolor) {
        this.rowcolor = rowcolor;
    }

    /**
     * @return the checkallboolsentbox
     */
    public boolean isCheckallboolsentbox() {
        return checkallboolsentbox;
    }

    /**
     * @param checkallboolsentbox the checkallboolsentbox to set
     */
    public void setCheckallboolsentbox(boolean checkallboolsentbox) {
        this.checkallboolsentbox = checkallboolsentbox;
    }

    /**
     * @return the usrid
     */
    public long getUsrid() {
        return usrid;
    }

    /**
     * @param usrid the usrid to set
     */
    public void setUsrid(long usrid) {
        this.usrid = usrid;
    }

    /**
     * @return the searchrdid
     */
    public long getSearchrdid() {
        return searchrdid;
    }

    /**
     * @param searchrdid the searchrdid to set
     */
    public void setSearchrdid(long searchrdid) {
        this.searchrdid = searchrdid;
    }

    /**
     * @return the sfrid
     */
    public long getSfrid() {
        return sfrid;
    }

    /**
     * @param sfrid the sfrid to set
     */
    public void setSfrid(long sfrid) {
        this.sfrid = sfrid;
    }

    /**
     * @return the pagecontrolnumsession
     */
    public int getPagecontrolnumsession() {
        return pagecontrolnumsession;
    }

    /**
     * @param pagecontrolnumsession the pagecontrolnumsession to set
     */
    public void setPagecontrolnumsession(int pagecontrolnumsession) {
        this.pagecontrolnumsession = pagecontrolnumsession;
    }

    /**
     * @return the newmsg
     */
    public int getNewmsg() {

         
newmsg = getFacade().findRangeInboxUsrMsgCount();


        return newmsg;



    }

    /**
     * @param newmsg the newmsg to set
     */
    public void setNewmsg(int newmsg) {
        this.newmsg = newmsg;
    }

   
    

    @FacesConverter(forClass=Inbox.class)
    public static class InboxControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InboxControllerTwo controller = (InboxControllerTwo)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "inboxControllerTwo");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Inbox) {
                Inbox o = (Inbox) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: "+InboxController.class.getName());
            }
        }

    }

}
