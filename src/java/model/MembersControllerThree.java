/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.FavoritesFacade;
import controller.HasviewedprofileFacade;
import controller.HasviewedprofiletwoFacade;
import controller.InboxFacade;
import model.util.JsfUtil;
import model.util.PaginationHelper;
import controller.MembersFacade;
import controller.PhotosFacade;
import controller.SendhistoryintimateFacade;
import controller.SentFacade;
import controller.UmightlikeFacade;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author Chris Mitchell
 */
@ManagedBean(name="membersControllerThree")
@SessionScoped
public class MembersControllerThree {

    /** Creates a new instance of MembersControllerThree */
    public MembersControllerThree() {
    }


     //all the FL strings below are used for the radius search page to get
    //fields to limit  radius search query.

    private String yearnow;

   
//retph2 us used as a string to return  and to redirect to the right page
    //in the PrepareViewTwo function

    private String retph2;



    @EJB private controller.PhotosFacade ejbFacade4;


  //  @EJB private controller.SentFacade ejbFacadeSent;



 //   @EJB private controller.InboxFacade ejbFacadeIn;


     @EJB private controller.MembersFacade ejbFacade;


  //  @EJB private controller.FavoritesFacade ejbFacadeFavorites;


//   @EJB private controller.HasviewedprofileFacade ejbFacadeHasviewedprofile;


//  @EJB private controller.HasviewedprofiletwoFacade ejbFacadeHasviewedprofiletwo;


 // @EJB private controller.SendhistoryintimateFacade ejbFacadeSendhistoryintimate;


 // @EJB private controller.UmightlikeFacade ejbFacadeumightlike;



    //main datamodel of members/ListFl.

    //also used in main List in umightlike/List main datamodel.
    private DataModel items = null;


  //  private DataModel itemsdisplay = null;

     private DataModel itemszip = null;


    //main date model for send/List.xhtml page
    private DataModel itemssent = null;


    //umightlike/List main datamodel for List page.
//    private DataModel itemsumightlike = null;


// private DataModel itemsumightlikemain = null;


 private DataModel itemsmemhold = null;



//used for main ListFL page
    private PaginationHelper pagination;


   //  private PaginationHelper paginationdisplay;


    // used for List page in sent folder.
  //  private PaginationHelper paginationsent;


    private PaginationHelper paginationtwo;

//Used for List of umightlike
 //   private PaginationHelper paginationthree;

    

//Used for List of umightlike final ending function getumightlikemain.
     //  private PaginationHelper paginationfour;

    private int selectedItemIndex;



    //used for prepareViewTwo of umightlike/List
    private Members current;

//used for the new inbox object when you send a message in one of the VSt# pages.

 //   private Inbox currentin;
    // return oblect of get row function from the sent/List page
    //prepareviewsent is the function.

    //also used in View page of sent/view to display the specific row of sent items.
 //   private Sent senttwo;

//used in createFavorites function. in teh VSt1....VSt7 pages.
 //  private Favorites currentFavorites;

     //  private Hasviewedprofile currentHasviewedprofile;

 //used in prepareViewTwo of umightlike/List page.
 //  private Hasviewedprofiletwo currentHasviewedprofiletwo;


//  private Sendhistoryintimate currentSendhistoryintimate;

//used to hold members in prepareViewTwosent

      //used to show display in the VSt pages also.
 //   private Members currentmem;


    //used in prepareViewTwo of umightlike/List.
   //   private Umightlike currentumightlike;



 @ManagedProperty(value= "#{inboxControllerTwo}")


 private InboxControllerTwo inboxmanaged;




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

    public Members getSelected() {
        if (current == null) {
            current = new Members();
            selectedItemIndex = -1;
        }
        return current;
    }

  //  public Inbox getSelectedSndMsg() {
    //    if (currentin == null) {
     //       currentin = new Inbox();
     //       selectedItemIndex = -1;
    //    }
    //    return currentin;
  //  }




//  public Sent getSelectedSentMsg() {
   //     if (senttwo == null) {
     //       senttwo = new Sent();
      //      selectedItemIndex = -1;
      //  }
     //   return senttwo;
  //  }


  //   public Members getSelectedMem() {
   //     if (currentmem == null) {

         //   currentmem = new Mem();

     //       selectedItemIndex = -1;
     //   }
    //    return currentmem;
 //   }




    private MembersFacade getFacade() {
        return ejbFacade;
    }

    private PhotosFacade getFacade4() {
        return ejbFacade4;
    }

//    private InboxFacade getFacadeIn() {
 //       return ejbFacadeIn;
 //   }


    
  //  private SentFacade getFacadeSent() {

  //      return ejbFacadeSent;

//    }



 //private FavoritesFacade getFacadeFavorites() {

    //    return ejbFacadeFavorites;

  //  }





 //private HasviewedprofileFacade getFacadeHasviewedprofile() {

     //   return ejbFacadeHasviewedprofile;


  //  }




 // private HasviewedprofiletwoFacade getFacadeHasviewedprofiletwo() {

   //     return ejbFacadeHasviewedprofiletwo;


//    }



 //  private SendhistoryintimateFacade getFacadeSendhistoryintimate() {
 //       return ejbFacadeSendhistoryintimate;
 //   }



 //   private UmightlikeFacade getFacadeumightlike() {

   //     return ejbFacadeumightlike;

//    }




    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRangeFl(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
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
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findcitytwo(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return paginationtwo;
    }











    public String prepareList() {
        recreateModel();
        return "List";
    }

  //  public String prepareListFl() {
  //      recreateModelTwo();
  //      return "ListFl";

 //   }

    public String prepareView() {
        current = (Members) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Members();
        selectedItemIndex = -1;
        return "Create";
    }













//shoe my profile 
public String prepareViewThree(){


     getFacade().setLnguserid(getInboxmanaged().getUsrid());

    current = getFacade().findMember();

getFacade4().setCheckidphoto( getInboxmanaged().getUsrid());

getFacade4().setNophotousername(current.getUsername());

getFacade4().setViewid( getInboxmanaged().getUsrid());

      getFacade4().findPgPhFour();

        int fbfb = getFacade4().getFlumbeta();

   //     if (fbfb == 1) {
   //         setRetph2("pp1");
    //    } else if (fbfb == 2) {
   //         setRetph2("pp1");
   //     } else if (fbfb == 3) {
   //         setRetph2("pp2");
    //    } else if (fbfb == 4) {
     //       setRetph2("pp3");
     //   } else if (fbfb == 5) {
     //       setRetph2("pp4");
     //   } else if (fbfb == 6) {
     //       setRetph2("pp5");
     //   } else if (fbfb == 7) {
     //       setRetph2("pp6");
     //   } else if (fbfb == 8) {
     //       setRetph2("pp7");
      //  } else if (fbfb == 9) {
      //      setRetph2("pp8");
     //   }else if (fbfb == 20) {
     //       setRetph2("pp9");
     //   }


        
        return "/members/datingprofile.xhtml";




}










public String prepareResetIndex() {
        recreateModel();

        return "/index";
    }











    public String prepareEdit() {
        current = (Members) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("MembersUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Members) getItems().getRowData();
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
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }









    public DataModel getItemszip() {
        if (itemszip == null) {
           itemszip = getPaginationTwo().createPageDataModel();
       }
        return itemszip;
   }








 private void recreateModel() {
        items = null;
    }



    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "/members/List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "/members/List";
    }


   private void recreateModelFour() {
        items = null;
    }


   








    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }





   //   private void recreateModeldisplay() {
   //     itemsdisplay = null;
 //   }



 //  private void recreateModelTwo() {
//        itemstwo = null;
 //   }

    private void recreateModelSent() {
        itemssent = null;
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

   





public String prepareResetSent() {
        recreateModelSent();

        return "/index";
    }








    

    /**
     * @return the yearnow
     */
    public String getYearnow() {

      Calendar cal=Calendar.getInstance();
   int year=cal.get(Calendar.YEAR);
        yearnow = Integer.toString(year);

        return yearnow;
    }

    /**
     * @param yearnow the yearnow to set
     */
    public void setYearnow(String yearnow) {
        this.yearnow = yearnow;
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





    @FacesConverter(forClass = Members.class)
    public static class MembersControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MembersControllerThree controller = (MembersControllerThree) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "membersControllerThree");
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
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + MembersController.class.getName());
            }
        }
    }
}
