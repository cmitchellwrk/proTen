package model;

import controller.LastpointsgivepersonFacade;
import controller.MembersFacade;
import model.Points;
import model.util.JsfUtil;
import model.util.PaginationHelper;
import controller.PointsFacade;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;


import javax.faces.bean.ManagedProperty;

import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean (name="pointsController")
@ViewScoped
public class PointsController {




    private Points current;
    private DataModel items = null;
  private DataModel itemstwo = null;

    @EJB private controller.PointsFacade ejbFacade;

    private PaginationHelper pagination;
    private int selectedItemIndex;



     @EJB private controller.MembersFacade ejbFacademem;



  private boolean isonce = false;


  private boolean isonceb = false;


  private boolean isoncec = false;



  private boolean isonced = false;



  private boolean isoncee = false;


  private boolean isoncef = false;



  private boolean isonceg = false;



  private boolean isonceh = false;


  private boolean isoncei = false;


  


   @EJB private controller.LastpointsgivepersonFacade ejbFacadeLastptsgive;

     private Lastpointsgiveperson currentLastptsgive;


    public PointsController() {
    }




 @ManagedProperty(value= "#{inboxControllerTwo}")


 private InboxControllerTwo inboxmanaged;


 





    public Points getSelected() {
        if (current == null) {
            current = new Points();
            selectedItemIndex = -1;
        }
        return current;
    }

    private PointsFacade getFacade() {
        return ejbFacade;
    }

    

    private MembersFacade getFacadeMem() {
        return ejbFacademem;
    }



      private LastpointsgivepersonFacade getFacadeLastptsgive() {
        return ejbFacadeLastptsgive;
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
                    return new ListDataModel(getFacadeMem().findPoints(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return pagination;
    }



      public PaginationHelper getPaginationtwo() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacadeMem().findPointsProfile(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
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
        current = (Points)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "/points/PointsView.xhtml";
    }

    public String prepareCreate() {
        current = new Points();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resourcefive/Bundle").getString("PointsCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resourcefive/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }



    public String prepareEdit() {
        current = (Points)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }


     public String preparePoints() {
        current = (Points)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }



    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resourcefive/Bundle").getString("PointsUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resourcefive/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }



    public String resetinbox(){

 // getFacadeMem().setLlnnid(current.getIdpersonpointsreceive());



    // items=null;

        current = null;
     return"/inbox/yourmessages.xhtml";


    }




    
    public String updatePoints() {



        getFacadeMem().setIdppreceive(current.getIdpersonpointsreceive());

        String res = getFacadeMem().findLastpointsgiven();



   Members mmbb = getFacadeMem().findMember();



  if(res.equals("alreadyexists")  ){

   Lastpointsgiveperson lpp = getFacadeMem().findLastptsgivensingle();

                String jj = lpp.getDatelastptsgiven();




DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
Date date = new Date();
dateFormat.format(date);

                String mm = dateFormat.format(date).toString();


//******************************************************************************

        if(res.equals("alreadyexists") && (jj.equals(mm))){
            //check the date

             

 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resourcefive/Bundle").getString("PointsLimit"));

     return"/points/List.xhtml";



  
        }else {



            try {
      
     lpp.setPointsPhotos(current.getPointsPhotos());
     lpp.setPointsProfile(current.getPointsProfile());
     lpp.setPointsFirstmessage(current.getPointsFirstmessage());
     lpp.setPointsFunny(current.getPointsFunny());
     lpp.setPointsInteresting(current.getPointsInteresting());
     lpp.setPointsPersonality(current.getPointsPersonality());
     lpp.setPointsFirstdate(current.getPointsFirstdate());
     lpp.setPointsDateidea(current.getPointsDateidea());
     lpp.setPointsVerifyprofile(current.getPointsVerifyprofile());
     lpp.setDatelastptsgiven(mm);
     lpp.setBadge("none");
     lpp.setBadgeimageurl("none");
     lpp.setTotalpointsgivensofar(current.getTotalscore());
     
            getFacadeLastptsgive().edit(lpp);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resourcefive/Bundle").getString("LastpointsgivepersonUpdated"));

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resourcefive/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }




try {


    mmbb.setPointsPhotos(current.getPointsPhotos());
    mmbb.setPointsProfile(current.getPointsPhotos());
    mmbb.setPointsFirstmessage(current.getPointsFirstmessage());
    mmbb.setPointsFunny(current.getPointsFunny());
    mmbb.setPointsInteresting(current.getPointsInteresting());
    mmbb.setPointsPersonality(current.getPointsPersonality());
    mmbb.setPointsFirstdate(current.getPointsFirstdate());
    mmbb.setPointsDateidea(current.getPointsDateidea());
    mmbb.setPointsVerifyprofile(current.getPointsVerifyprofile());


            getFacadeMem().edit(mmbb);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("MembersUpdated"));

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }




 try {


            getFacade().edit(current);

            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resourcefive/Bundle").getString("PointsUpdated"));
           return"/points/List.xhtml";

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resourcefive/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }

 

        }



        }else {
            
        //create a new record for Lastpointsgiven

            currentLastptsgive = new Lastpointsgiveperson();

            currentLastptsgive.setIdpersonpointsgive(getInboxmanaged().getUsrid());

            currentLastptsgive.setIdpersonpointsreceive(current.getIdpersonpointsreceive());

            currentLastptsgive.setPointsPhotos(current.getPointsPhotos());

            currentLastptsgive.setPointsProfile(current.getPointsProfile());

            currentLastptsgive.setPointsFirstmessage(current.getPointsFirstmessage());

            currentLastptsgive.setPointsFunny(current.getPointsFunny());

            currentLastptsgive.setPointsInteresting(current.getPointsInteresting());

            currentLastptsgive.setPointsPersonality(current.getPointsPersonality());

            currentLastptsgive.setPointsFirstdate(current.getPointsFirstdate());

            currentLastptsgive.setPointsDateidea(current.getPointsDateidea());

            currentLastptsgive.setPointsVerifyprofile(current.getPointsVerifyprofile());

            currentLastptsgive.setDatelastptsgiven(SimpleDateFormatmethod());


            currentLastptsgive.setBadge("none");

            currentLastptsgive.setBadgeimageurl("none");

            currentLastptsgive.setTotalpointsgivensofar(0);

getFacadeLastptsgive().create(currentLastptsgive);


return"/points/View.xhtml";

        }







        
       
    }


    


     public void zipAutoFillListener(AjaxBehaviorEvent vce) {

       

         if(isIsonce()==false){

   current.setPointsPhotos(current.getPointsPhotos() + 1);

current.setTotalscore(current.getTotalscore() + 1);

            setIsonce(true);
         }
            


    }




     public void zipAutoFillListenerb(AjaxBehaviorEvent vce) {



         if(isIsonceb()==false){

   current.setPointsProfile(current.getPointsProfile() + 1);

   current.setTotalscore(current.getTotalscore() + 1);

            setIsonceb(true);
         }



    }



     public void zipAutoFillListenerc(AjaxBehaviorEvent vce) {



         if(isIsoncec()==false){

   current.setPointsFirstmessage(current.getPointsFirstmessage() + 1);

   current.setTotalscore(current.getTotalscore() + 1);
            setIsoncec(true);
         }



    }



     public void zipAutoFillListenerd(AjaxBehaviorEvent vce) {



         if(isIsonced()==false){

   current.setPointsFunny(current.getPointsFunny() + 1);

   current.setTotalscore(current.getTotalscore() + 1);

            setIsonced(true);
         }



    }



     public void zipAutoFillListenere(AjaxBehaviorEvent vce) {



         if(isIsoncee()==false){

   current.setPointsInteresting(current.getPointsInteresting() + 1);


   current.setTotalscore(current.getTotalscore() + 1);
            setIsoncee(true);
         }



    }



     public void zipAutoFillListenerf(AjaxBehaviorEvent vce) {



         if(isIsoncef()==false){

   current.setPointsPersonality(current.getPointsPersonality() + 1);

   current.setTotalscore(current.getTotalscore() + 1);

            setIsoncef(true);
         }



    }




     public void zipAutoFillListenerg(AjaxBehaviorEvent vce) {



         if(isIsonceg()==false){

   current.setPointsFirstdate(current.getPointsFirstdate() + 1);

   current.setTotalscore(current.getTotalscore() + 1);

            setIsonceg(true);
         }



    }






     public void zipAutoFillListenerh(AjaxBehaviorEvent vce) {



         if(isIsonceh()==false){

   current.setPointsDateidea(current.getPointsDateidea() + 1);

   current.setTotalscore(current.getTotalscore() + 1);

            setIsonceh(true);
         }



    }



     public void zipAutoFillListeneri(AjaxBehaviorEvent vce) {



         if(isIsoncei()==false){

   current.setPointsVerifyprofile(current.getPointsVerifyprofile() + 1);


   current.setTotalscore(current.getTotalscore() + 1);
   
            setIsoncei(true);
         }



    }








    public void addPoints(){
        
        
    }


    public String destroy() {
        current = (Points)getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resourcefive/Bundle").getString("PointsDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resourcefive/Bundle").getString("PersistenceErrorOccured"));
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


 public DataModel getItemstwo() {

        if (itemstwo == null) {


            itemstwo = getPaginationtwo().createPageDataModel();
        }
        return itemstwo;
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
     * @return the isonce
     */
    public boolean isIsonce() {
        return isonce;
    }

    /**
     * @param isonce the isonce to set
     */
    public void setIsonce(boolean isonce) {
        this.isonce = isonce;
    }


      public String SimpleDateFormatmethod() {


        //  Calendar date = Calendar.getInstance();
        // SimpleDateFormat dateformatter = new SimpleDateFormat(" MM/dd/yyyy");
        // return (dateformatter.format(date.getTime()));


DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
Date date = new Date();
return(dateFormat.format(date));




    }

    /**
     * @return the isonceb
     */
    public boolean isIsonceb() {
        return isonceb;
    }

    /**
     * @param isonceb the isonceb to set
     */
    public void setIsonceb(boolean isonceb) {
        this.isonceb = isonceb;
    }

    /**
     * @return the isoncec
     */
    public boolean isIsoncec() {
        return isoncec;
    }

    /**
     * @param isoncec the isoncec to set
     */
    public void setIsoncec(boolean isoncec) {
        this.isoncec = isoncec;
    }

    /**
     * @return the isonced
     */
    public boolean isIsonced() {
        return isonced;
    }

    /**
     * @param isonced the isonced to set
     */
    public void setIsonced(boolean isonced) {
        this.isonced = isonced;
    }

    /**
     * @return the isoncee
     */
    public boolean isIsoncee() {
        return isoncee;
    }

    /**
     * @param isoncee the isoncee to set
     */
    public void setIsoncee(boolean isoncee) {
        this.isoncee = isoncee;
    }

    /**
     * @return the isoncef
     */
    public boolean isIsoncef() {
        return isoncef;
    }

    /**
     * @param isoncef the isoncef to set
     */
    public void setIsoncef(boolean isoncef) {
        this.isoncef = isoncef;
    }

    /**
     * @return the isonceg
     */
    public boolean isIsonceg() {
        return isonceg;
    }

    /**
     * @param isonceg the isonceg to set
     */
    public void setIsonceg(boolean isonceg) {
        this.isonceg = isonceg;
    }

    /**
     * @return the isonceh
     */
    public boolean isIsonceh() {
        return isonceh;
    }

    /**
     * @param isonceh the isonceh to set
     */
    public void setIsonceh(boolean isonceh) {
        this.isonceh = isonceh;
    }

    /**
     * @return the isoncei
     */
    public boolean isIsoncei() {
        return isoncei;
    }

    /**
     * @param isoncei the isoncei to set
     */
    public void setIsoncei(boolean isoncei) {
        this.isoncei = isoncei;
    }

    



    @FacesConverter(forClass=Points.class)
    public static class PointsControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PointsController controller = (PointsController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pointsController");
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
            if (object instanceof Points) {
                Points o = (Points) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: "+PointsController.class.getName());
            }
        }

    }

}
