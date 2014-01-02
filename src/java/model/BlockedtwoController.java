package model;

import model.Blockedtwo;
import model.util.JsfUtil;
import model.util.PaginationHelper;
import controller.BlockedtwoFacade;
import java.util.List;

import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;


@ManagedBean (name="blockedtwoController")
@SessionScoped
public class BlockedtwoController {

    private Blockedtwo current;
    private DataModel items = null;
    @EJB private controller.BlockedtwoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;




 @ManagedProperty(value= "#{inboxControllerTwo}")


 private InboxControllerTwo inboxmanaged;



    

    private boolean checkallboolblock = false;
    

    public BlockedtwoController() {
    }

    public Blockedtwo getSelected() {
        if (current == null) {
            current = new Blockedtwo();
            selectedItemIndex = -1;
        }
        return current;
    }

    private BlockedtwoFacade getFacade() {
        return ejbFacade;
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
                    return new ListDataModel(getFacade().findBlockedmembers(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

     public String prepareResetIndex() {
        recreateModel();

        return "/index";
    }





    public String prepareView() {
        current = (Blockedtwo)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Blockedtwo();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("ResourceTwo/Bundle").getString("BlockedtwoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("ResourceTwo/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Blockedtwo)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("ResourceTwo/Bundle").getString("BlockedtwoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("ResourceTwo/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Blockedtwo)getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("ResourceTwo/Bundle").getString("BlockedtwoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("ResourceTwo/Bundle").getString("PersistenceErrorOccured"));
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

        getFacade().setCheckblockid(getInboxmanaged().getUsrid());
   
        if (items == null) {
            items = getPagination().createPageDataModel();
        }

        return items;
    }



      public String prepareUnblock(ActionEvent event ) {

       //   int itemrows = getItems().getRowCount();

         items = getItems();

         List<Blockedtwo> blitems = (List<Blockedtwo>)items.getWrappedData();



         for( Blockedtwo curblock : blitems ){

             if( curblock.getUnblock()){


                 try {
            getFacade().remove(curblock);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("ResourceTwo/Bundle").getString("BlockedtwoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("ResourceTwo/Bundle").getString("PersistenceErrorOccured"));
        }

             

         }

          }
       // selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
       recreateModel();
        return "List";

    }




    private void recreateModel() {
        items = null;
        checkallboolblock = false;
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

   

    public void selectallcheckbox( AjaxBehaviorEvent vce  ){

       

    items = getItems();

  //   List<Blockedtwo> blitems = (List<Blockedtwo>)items.getWrappedData();


 //   List<Blockedtwo> tenblitems;
 List<Blockedtwo> blitems = (List<Blockedtwo>)items.getWrappedData();



     for( Blockedtwo curblock : blitems ){

           curblock.setUnblock(true);

          }
       // selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();

       


    }



    /**
     * @return the checkallboolblock
     */
    public boolean isCheckallboolblock() {
        return checkallboolblock;
    }

    /**
     * @param checkallboolblock the checkallboolblock to set
     */
    public void setCheckallboolblock(boolean checkallboolblock) {
        this.checkallboolblock = checkallboolblock;
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





    @FacesConverter(forClass=Blockedtwo.class)
    public static class BlockedtwoControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BlockedtwoController controller = (BlockedtwoController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "blockedtwoController");
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
            if (object instanceof Blockedtwo) {
                Blockedtwo o = (Blockedtwo) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: "+BlockedtwoController.class.getName());
            }
        }

    }

}
