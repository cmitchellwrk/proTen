package model;

import model.Inbox;
import model.util.JsfUtil;
import model.util.PaginationHelper;
import controller.InboxFacade;
import controller.MembersFacade;
import controller.SentFacade;
import java.awt.event.ActionEvent;
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

@ManagedBean (name="inboxController")
@SessionScoped
public class InboxController {





    private Inbox current;
    private DataModel items = null;
    @EJB private controller.InboxFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;





    @EJB
    private controller.MembersFacade ejbFacademem;



     @EJB
    private controller.SentFacade ejbFacadesent;


         public Sent currentsent;









    public InboxController() {
    }

    public Inbox getSelected() {
        if (current == null) {
            current = new Inbox();
            selectedItemIndex = -1;
        }
        return current;
    }

    private InboxFacade getFacade() {
        return ejbFacade;
    }



     private SentFacade getFacadesent() {
        return ejbFacadesent;
    }

  private MembersFacade getFacademem() {
        return ejbFacademem;
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
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
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
        current = (Inbox)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Inbox();
        selectedItemIndex = -1;
        return "Create";
    }






    public String prepareCreateTwo() {
        current = new Inbox();
        selectedItemIndex = -1;
        return "CreateSndMsg";

    }



    

   public String create() {
        try {
           getFacade().create(current);

           

              currentsent = new Sent();

             currentsent.setRemovesntmsg(false);

            currentsent.setId(current.getId());

          currentsent.setReplyToId(current.getReplyToId());

          //currentsent.setSendFromid(ssdd);

           currentsent.setImageurl("test");



              Members mmbr = getFacademem().findMember();

              Long sfrid =  mmbr.getUserid();


              currentsent.setSendfromid(sfrid);


           currentsent.setSendtoid(current.getSendtoid());


            currentsent.setSentFrom(current.getSentFrom());


            currentsent.setSentTo(current.getSentTo());


            currentsent.setSubject(current.getSubject());


            currentsent.setMessageDate(current.getMessageDate());


            currentsent.setMsgText(current.getMsgText());


            currentsent.setStatus(current.getStatus());

            currentsent.setNow("offline");


     

            getFacadesent().create(currentsent);





           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("InboxCreated"));
           return prepareCreate();
        } catch (Exception e) {
           JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
       }
   }




  public String prepareUnblock(ActionEvent event ) {

       //   int itemrows = getItems().getRowCount();

         items = getItems();

         List<Inbox> blitems = (List<Inbox>)items.getWrappedData();



         for( Inbox curblock : blitems ){

             if( curblock.getRemoveinmsg()){


                 try {
            getFacade().remove(curblock);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("BlockedtwoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
        }



         }

          }
       // selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
       recreateModel();
        return "List";

    }







    public String prepareEdit() {
        current = (Inbox)getItems().getRowData();
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
        return "messages";
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
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
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

    @FacesConverter(forClass=Inbox.class)
    public static class InboxControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InboxController controller = (InboxController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "inboxController");
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
