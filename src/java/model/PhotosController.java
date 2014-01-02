/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;



import controller.MembersFacade;
import java.util.List;
import model.util.JsfUtil;
import model.util.PaginationHelper;
import controller.PhotosFacade;
import java.io.File;
import java.util.ArrayList;

import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import model.util.PaginationHelperTwo;

@ManagedBean (name="photosController")
@RequestScoped
public class PhotosController {



    private String retph;
    private Photos current;
    private Photos currentPh;
    private Photos subPhoto;
    private Members currentMem;
    private Members subMem;
    private DataModel items = null;
    private DataModel itemstwo = null;
    private DataModel itemsthree = null;
    private DataModel itemsfour = null;
    private DataModel itemsfive = null;
    private DataModel itemssix = null;
    private DataModel itemsseven = null;
    private DataModel itemseight = null;
    @EJB
    private controller.PhotosFacade ejbFacade;


    private PaginationHelperTwo pagination;


    private PaginationHelper paginationtwo;

    

    private int selectedItemIndex;
    @EJB
    private controller.MembersFacade ejbMemFacade;


    private boolean p4mL1 = true;


    private boolean p4mL8one;


    private boolean p4mL8two;
    private boolean p4mL8three;
    private boolean p4mL8four;
    private boolean p4mL8five;
    private boolean p4mL8six;
    private boolean p4mL8seven;
    private boolean p4mL8eight;

    public int submpl;





    public PhotosController() {
    }









    /**
     * @return the p4mL1
     */
    public boolean isP4mL1() {
        return p4mL1;
    }

    /**
     * @param p4mL1 the p4mL1 to set
     */
    public void setP4mL1(boolean p4mL1) {
        this.p4mL1 = p4mL1;
    }




    /**
     * @return the p4mL8one
     */
    public boolean isP4mL8one() {
        return p4mL8one;
    }

    /**
     * @param p4mL8one the p4mL8one to set
     */
    public void setP4mL8one(boolean p4mL8one) {
        this.p4mL8one = p4mL8one;
    }

    /**
     * @return the p4mL8two
     */
    public boolean isP4mL8two() {
        return p4mL8two;
    }

    /**
     * @param p4mL8two the p4mL8two to set
     */
    public void setP4mL8two(boolean p4mL8two) {
        this.p4mL8two = p4mL8two;
    }

    /**
     * @return the p4mL8three
     */
    public boolean isP4mL8three() {
        return p4mL8three;
    }

    /**
     * @param p4mL8three the p4mL8three to set
     */
    public void setP4mL8three(boolean p4mL8three) {
        this.p4mL8three = p4mL8three;
    }

    /**
     * @return the p4mL8four
     */
    public boolean isP4mL8four() {
        return p4mL8four;
    }

    /**
     * @param p4mL8four the p4mL8four to set
     */
    public void setP4mL8four(boolean p4mL8four) {
        this.p4mL8four = p4mL8four;
    }

    /**
     * @return the p4mL8five
     */
    public boolean isP4mL8five() {
        return p4mL8five;
    }

    /**
     * @param p4mL8five the p4mL8five to set
     */
    public void setP4mL8five(boolean p4mL8five) {
        this.p4mL8five = p4mL8five;
    }

    /**
     * @return the p4mL8six
     */
    public boolean isP4mL8six() {
        return p4mL8six;
    }

    /**
     * @param p4mL8six the p4mL8six to set
     */
    public void setP4mL8six(boolean p4mL8six) {
        this.p4mL8six = p4mL8six;
    }

    /**
     * @return the p4mL8seven
     */
    public boolean isP4mL8seven() {
        return p4mL8seven;
    }

    /**
     * @param p4mL8seven the p4mL8seven to set
     */
    public void setP4mL8seven(boolean p4mL8seven) {
        this.p4mL8seven = p4mL8seven;
    }

    /**
     * @return the p4mL8eight
     */
    public boolean isP4mL8eight() {
        return p4mL8eight;
    }

    /**
     * @param p4mL8eight the p4mL8eight to set
     */
    public void setP4mL8eight(boolean p4mL8eight) {
        this.p4mL8eight = p4mL8eight;
    }











    





    public Photos getSelected() {
        if (current == null) {
            current = new Photos();
            selectedItemIndex = -1;
        }
        return current;
    }

    private PhotosFacade getFacade() {
        return ejbFacade;
    }


     private MembersFacade getMemFacade() {
        return ejbMemFacade;
    }



    public PaginationHelperTwo getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelperTwo(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findSearchRadPhotos(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
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

                    return new ListDataModel(getFacade().findSearchViewPhotos(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));

                }
            };
        }
        return paginationtwo;
    }





    public PaginationHelper getPaginationThree() {
        if (paginationtwo == null) {
            paginationtwo = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {

                    return new ListDataModel(getFacade().findSearchViewPhotosUiRepeat(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));

                }
            };
        }
        return paginationtwo;
    }






 public PaginationHelperTwo getPaginationProfile() {
        if (pagination == null) {
            pagination = new PaginationHelperTwo(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findSearchViewPhotos(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
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
        current = (Photos)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Photos();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("PhotosCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }



 public String cropreturnindex() {

      subMem = getMemFacade().findMember();

           File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/Uploads/" +  subMem.getUsername() + "/" +  subMem.getUsername()  + getFacade().getUploadurlname() + ".jpg" );

           phottob.delete();

        return "/inbox/yourmessages.xhtml";

    }




    public String findPhotoPage() {



        subMem = getMemFacade().findMember();

           File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/Uploads/" +  subMem.getUsername() + "/" +  subMem.getUsername()  + getFacade().getUploadurlname() + ".jpg" );

          phottob.delete();

        subPhoto = getFacade().findSingPhoto();

        String suburl = subMem.getImageurl();



        if (suburl.equals(subPhoto.getImageurl1a())) {
            submpl = 1;

        } else if (suburl.equals(subPhoto.getImageurl2a())) {
            submpl = 2;

        } else if (suburl.equals(subPhoto.getImageurl3a())) {
            submpl = 3;

        } else if (suburl.equals(subPhoto.getImageurl4a())) {

            submpl = 4;
        } else if (suburl.equals(subPhoto.getImageurl5a())) {

            submpl = 5;
        } else if (suburl.equals(subPhoto.getImageurl6a())) {
            submpl = 6;

        } else if (suburl.equals(subPhoto.getImageurl7a())) {
            submpl = 7;

        } else if (suburl.equals(subPhoto.getImageurl8a())) {

            submpl = 8;
        }




        try {


            getFacade().findPgPh();

            int fbfb = getFacade().getFlumbeta();



            if (fbfb == 1) {


                setRetph("x1");




            } else if (fbfb == 2) {



 setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);


                setRetph("x2");


            } else if (fbfb == 3) {


                if (submpl == 1) {



 setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);


                } else {



 setP4mL1(false);

                setP4mL8two(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);


                }


                setRetph("x3");


            } else if (fbfb == 4) {



                if (submpl == 1) {


                     setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 2) {


                     setP4mL1(false);

                setP4mL8two(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);


                } else {

                     setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                }

                setRetph("x4");


            } else if (fbfb == 5) {

                if (submpl == 1) {

                     setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 2) {

                         setP4mL1(false);

                setP4mL8two(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 3) {

                         setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else {

                         setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                }

                setRetph("x5");


            } else if (fbfb == 6) {

                if (submpl == 1) {


 setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 2) {


 setP4mL1(false);

                setP4mL8two(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 3) {


 setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 4) {


 setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else {


 setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                }

                setRetph("x6");

            } else if (fbfb == 7) {


                if (submpl == 1) {

                         setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);


                } else if (submpl == 2) {

                      setP4mL1(false);

                setP4mL8two(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);


                } else if (submpl == 3) {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);


                } else if (submpl == 4) {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);


                } else if (submpl == 5) {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);


                } else {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);

                setP4mL8seven(false);

                 setP4mL8eight(false);


                }


                setRetph("x7");


            } else if (fbfb == 8) {

                if (submpl == 1) {

                      setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 2) {

                      setP4mL1(false);

                setP4mL8two(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 3) {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 4) {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 5) {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 6) {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(true);

                 setP4mL8eight(false);

                }


                setRetph("x8");


            } else if (fbfb == 9) {


                if (submpl == 1) {

                      setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 2) {

                      setP4mL1(false);

                setP4mL8two(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 3) {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 4) {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 5) {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 6) {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);

                setP4mL8seven(false);

                 setP4mL8eight(false);

                } else if (submpl == 7) {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(true);

                 setP4mL8eight(false);

                } else {

                      setP4mL1(false);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(true);

                }

                setRetph("x9");


            }

            //  JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosCreated"));

            return getRetph();

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }




    }







    public String setPhotos() {
        try {


            current = new Photos();

            current.setImageurl1a("*");
            current.setImageurl1b("*");

            current.setImageurl2a("*");
            current.setImageurl2b("*");

            current.setImageurl3a("*");
            current.setImageurl3b("*");

            current.setImageurl4a("*");
            current.setImageurl4b("*");

            current.setImageurl5a("*");
            current.setImageurl5b("*");

            current.setImageurl6a("*");
            current.setImageurl6b("*");

            current.setImageurl7a("*");
            current.setImageurl7b("*");

            current.setImageurl8a("*");
            current.setImageurl8b("*");

            current.setImageurl9a("*");
            current.setImageurl9b("*");

            current.setImageurl10a("*");
            current.setImageurl10b("*");

            current.setImageurl11a("*");
            current.setImageurl11b("*");

            current.setImageurl12a("*");
            current.setImageurl12b("*");

            current.setImageurl13a("*");
            current.setImageurl13b("*");

            current.setImageurl14a("*");
            current.setImageurl14b("*");

            current.setImageurl15a("*");
            current.setImageurl15b("*");

            current.setImageurl16a("*");
            current.setImageurl16b("*");




            Long lglg = getFacade().getCheckid();

            current.setPhotouserid(lglg);

            getFacade().create(current);


        //    JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosCreated"));
            return "addphotos";

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }






 public String deletePhoto4on4() {





        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
                //    JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);



                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);


                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
              //      JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

          //      JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);


                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
            //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
          //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);


       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }






        try {


            Photos phph = getFacade().findSingPhoto();

            currentPh = new Photos();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl4a() );
 File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl4b() );

             photto.delete();
phottob.delete();


            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a("*");
            currentPh.setImageurl4b("*");

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


   //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List3b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }








  public String deletePhoto3on4() {





        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);
//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();



                try {
                    getMemFacade().edit(currentMem);
          //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);


                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);




                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL8one == false & p4mL8two == false & p4mL8three == true & p4mL8four == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);



                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL8one == false & p4mL8two == false & p4mL8three == false & p4mL8four == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);


                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);


                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);


                 setP4mL8eight(false);



   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }











        try {


            Photos phph = getFacade().findSingPhoto();

            currentPh = new Photos();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl3a() );
 File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl3b() );

             photto.delete();
phottob.delete();



            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a("*");
            currentPh.setImageurl4b("*");

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


   //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List3b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

        public String deletePhoto2on4() {



        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);


                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL8one == false & p4mL8two == true & p4mL8three == false & p4mL8four == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);



                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);


                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);


                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);



                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();





                try {
                    getMemFacade().edit(currentMem);
  //                  JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);



                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);


   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }








        try {


            Photos phph = getFacade().findSingPhoto();

            currentPh = new Photos();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2a() );
 File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2b() );

             photto.delete();
phottob.delete();



            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl3a());
            currentPh.setImageurl2b(phph.getImageurl3b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a("*");
            currentPh.setImageurl4b("*");

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


  //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List3b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }









    public String deletePhoto3on5() {





        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);





                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));


                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
                    JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

  //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);



                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }



        } else {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);





                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }










        try {


            Photos phph = getFacade().findSingPhoto();


              File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl3a() );
                File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl3b() );


             photto.delete();
            phottob.delete();


            

            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


    //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List4b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }






     public String deletePhoto4on5() {




        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);



                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);






    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));


                }

  //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1  == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);



                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }



        } else {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);



                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }






        try {


            Photos phph = getFacade().findSingPhoto();



              File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl4a() );
                File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl4b() );


             photto.delete();
            phottob.delete();



            

            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


   //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List4b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }





     public String deletePhoto5on5() {




        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));


                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);



                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }



        } else {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }






        try {


            Photos phph = getFacade().findSingPhoto();


              File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl5a() );
                File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl5b() );


             photto.delete();
            phottob.delete();


            

            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl4a());
            currentPh.setImageurl4b(phph.getImageurl4b());

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


   //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List4b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }







      public String deletePhoto2on5() {



        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);
//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);



                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));


                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
  //                  JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();






                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }



        } else {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();





                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);



                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);






        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }








        try {


            Photos phph = getFacade().findSingPhoto();


              File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2a() );
                File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2b() );


             photto.delete();
            phottob.delete();





            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl3a());
            currentPh.setImageurl2b(phph.getImageurl3b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


  //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List4b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }







     public String deletePhoto1on5() {



        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);
//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);


                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);


                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));


                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();





                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);



                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);



                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);




                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }



        } else {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();






                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);



                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }








        try {


            Photos phph = getFacade().findSingPhoto();


              File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1a() );
                File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1b() );


             photto.delete();
            phottob.delete();


            


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl2a());
            currentPh.setImageurl1b(phph.getImageurl2b());

            currentPh.setImageurl2a(phph.getImageurl3a());
            currentPh.setImageurl2b(phph.getImageurl3b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


     //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List4b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }







      public String deletePhoto6on6() {




        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false)   {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);


                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);


//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);


                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                

                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);




                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }








        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl6a());
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl6b());

             photto.delete();
phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl4a());
            currentPh.setImageurl4b(phph.getImageurl4b());

            currentPh.setImageurl5a(phph.getImageurl5a());
            currentPh.setImageurl5b(phph.getImageurl5b());

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


  //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List5b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }







        public String deletePhoto5on6() {







        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false)   {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();





                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();




                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);




                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);




                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
  //                  JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);



                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);




                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();


                


                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }











        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl5a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl5b() );

             photto.delete();
phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl4a());
            currentPh.setImageurl4b(phph.getImageurl4b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


   //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List5b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }






         public String deletePhoto4on6() {





        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false)   {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);




                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




  //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();




                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

  //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);



                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
  //                  JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);



                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();



                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);




                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }









        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl4a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl4b() );

             photto.delete();
phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


  //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List5b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }






          public String deletePhoto3on6() {





        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false)   {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);




                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);




                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);




                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);




                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
  //                  JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);




                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }





        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl3a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl3b() );

             photto.delete();
phottob.delete();



            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


     //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List5b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }







           public String deletePhoto2on6() {





        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false)   {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();



                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();


                

                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }







        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2b() );

             photto.delete();
phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl3a());
            currentPh.setImageurl2b(phph.getImageurl3b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


     //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List5b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }








 public String deletePhoto7on7() {


         if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);




    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();




                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven== false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);



                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);


                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

  //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }

        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();


                

                try {
                    getMemFacade().edit(currentMem);
                    JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);





     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }









        try {


            Photos phph = getFacade().findSingPhoto();


               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl7a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl7b() );

             photto.delete();
phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl4a());
            currentPh.setImageurl4b(phph.getImageurl4b());

            currentPh.setImageurl5a(phph.getImageurl5a());
            currentPh.setImageurl5b(phph.getImageurl5b());

            currentPh.setImageurl6a(phph.getImageurl6a());
            currentPh.setImageurl6b(phph.getImageurl6b());

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


     //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List6b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }





  public String deletePhoto6on7() {



         if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);



   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();




                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);




                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

  //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);




                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);




                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }

        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();





                try {
                    getMemFacade().edit(currentMem);
  //                  JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }











        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl6a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl6b() );

             photto.delete();
phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl4a());
            currentPh.setImageurl4b(phph.getImageurl4b());

            currentPh.setImageurl5a(phph.getImageurl5a());
            currentPh.setImageurl5b(phph.getImageurl5b());

            currentPh.setImageurl6a(phph.getImageurl7a());
            currentPh.setImageurl6b(phph.getImageurl7b());

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


   //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List6b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }





   public String deletePhoto5on7() {







         if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();





                try {
                    getMemFacade().edit(currentMem);
  //                  JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);




   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();





                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);




                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
  //                  JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }

        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }











        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl5a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl5b() );

             photto.delete();
phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl4a());
            currentPh.setImageurl4b(phph.getImageurl4b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a(phph.getImageurl7a());
            currentPh.setImageurl6b(phph.getImageurl7b());

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


     //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List6b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }





    public String deletePhoto4on7() {








         if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();





                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);






       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();





                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);



                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();






                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);


                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }

        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);





   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }











        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl4a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl4b() );

             photto.delete();
phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a(phph.getImageurl7a());
            currentPh.setImageurl6b(phph.getImageurl7b());

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


  //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List6b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }






     public String deletePhoto3on7() {








         if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);





     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();




                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }

        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }








        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl3a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl3b() );

             photto.delete();
phottob.delete();



            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a(phph.getImageurl7a());
            currentPh.setImageurl6b(phph.getImageurl7b());

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


    //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List6b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }







       public String deletePhoto2on7() {





         if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);




        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }

        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }







        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2b() );

             photto.delete();
phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl3a());
            currentPh.setImageurl2b(phph.getImageurl3b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a(phph.getImageurl7a());
            currentPh.setImageurl6b(phph.getImageurl7b());

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


        //    JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List6b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }





        public String deletePhoto8on8() {



        if (p4mL1 == true & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false  ) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();





                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true & p4mL8eight == false) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(true);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }





        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }


        }









        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl8a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl8b() );

             photto.delete();
phottob.delete();



            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl4a());
            currentPh.setImageurl4b(phph.getImageurl4b());

            currentPh.setImageurl5a(phph.getImageurl5a());
            currentPh.setImageurl5b(phph.getImageurl5b());

            currentPh.setImageurl6a(phph.getImageurl6a());
            currentPh.setImageurl6b(phph.getImageurl6b());

            currentPh.setImageurl7a(phph.getImageurl7a());
            currentPh.setImageurl7b(phph.getImageurl7b());

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


     //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List7b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }





         public String deletePhoto7on8() {





        if (p4mL1 == true & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false  ) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();





                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);
//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();




                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();






                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
         //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true & p4mL8eight == false) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl8 = phph.getImageurl8a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl8);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl8);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(true);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }





        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
         //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }


        }










        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl7a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl7b() );

             photto.delete();
phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl4a());
            currentPh.setImageurl4b(phph.getImageurl4b());

            currentPh.setImageurl5a(phph.getImageurl5a());
            currentPh.setImageurl5b(phph.getImageurl5b());

            currentPh.setImageurl6a(phph.getImageurl6a());
            currentPh.setImageurl6b(phph.getImageurl6b());

            currentPh.setImageurl7a(phph.getImageurl8a());
            currentPh.setImageurl7b(phph.getImageurl8b());

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


    //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List7b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }





          public String deletePhoto6on8() {






        if (p4mL1 == true & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false  ) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();




                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true & p4mL8eight == false) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

         //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl8 = phph.getImageurl8a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl8);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl8);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(true);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }





        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




         //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }


        }








        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl6a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl6b() );

             photto.delete();
phottob.delete();



            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl4a());
            currentPh.setImageurl4b(phph.getImageurl4b());

            currentPh.setImageurl5a(phph.getImageurl5a());
            currentPh.setImageurl5b(phph.getImageurl5b());

            currentPh.setImageurl6a(phph.getImageurl7a());
            currentPh.setImageurl6b(phph.getImageurl7b());

            currentPh.setImageurl7a(phph.getImageurl8a());
            currentPh.setImageurl7b(phph.getImageurl8b());

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


  //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List7b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }






           public String deletePhoto5on8() {




        if (p4mL1 == true & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false  ) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();



                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




         //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();





                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true & p4mL8eight == false) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);

                setP4mL8seven(false);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl8 = phph.getImageurl8a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl8);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl8);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(true);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }





        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }


        }









        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl5a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl5b() );

             photto.delete();
phottob.delete();



            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl4a());
            currentPh.setImageurl4b(phph.getImageurl4b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a(phph.getImageurl7a());
            currentPh.setImageurl6b(phph.getImageurl7b());

            currentPh.setImageurl7a(phph.getImageurl8a());
            currentPh.setImageurl7b(phph.getImageurl8b());

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


     //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List7b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }





            public String deletePhoto4on8() {





        if (p4mL1 == true & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false  ) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
           //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);





                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true & p4mL8eight == false) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);

                setP4mL8seven(false);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl8 = phph.getImageurl8a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl8);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl8);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(true);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }


        }












        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl4a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl4b() );

             photto.delete();
phottob.delete();



            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl3a());
            currentPh.setImageurl3b(phph.getImageurl3b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a(phph.getImageurl7a());
            currentPh.setImageurl6b(phph.getImageurl7b());

            currentPh.setImageurl7a(phph.getImageurl8a());
            currentPh.setImageurl7b(phph.getImageurl8b());

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


  //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List7b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }







             public String deletePhoto3on8() {




        if (p4mL1 == true & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false  ) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();





                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);



                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);



                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true & p4mL8eight == false) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl8 = phph.getImageurl8a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl8);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl8);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(true);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }





        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }


        }







        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl3a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl3b() );

             photto.delete();
phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a(phph.getImageurl7a());
            currentPh.setImageurl6b(phph.getImageurl7b());

            currentPh.setImageurl7a(phph.getImageurl8a());
            currentPh.setImageurl7b(phph.getImageurl8b());

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


     //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List7b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }





              public String deletePhoto2on8() {




        if (p4mL1 == true & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false  ) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);
//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();



                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);
//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true & p4mL8eight == false) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);



                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);

                setP4mL8seven(false);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl8 = phph.getImageurl8a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl8);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl8);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(true);



                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }





        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }


        }











        try {


            Photos phph = getFacade().findSingPhoto();

            currentPh = new Photos();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2b() );

             photto.delete();
phottob.delete();



            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl3a());
            currentPh.setImageurl2b(phph.getImageurl3b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a(phph.getImageurl7a());
            currentPh.setImageurl6b(phph.getImageurl7b());

            currentPh.setImageurl7a(phph.getImageurl8a());
            currentPh.setImageurl7b(phph.getImageurl8b());

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


       //     JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List7b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }


    }






                public String deletePhoto1on8() {



        if (p4mL1 == true & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false  ) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);





     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();




                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true & p4mL8eight == false) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);

                setP4mL8seven(false);




                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl8 = phph.getImageurl8a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl8);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl8);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(true);

                 setP4mL8eight(false);

                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }








        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();


                
                try {
                    getMemFacade().edit(currentMem);
          //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);



                 setP4mL8eight(false);




     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }


        }






        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1b() );

             photto.delete();
phottob.delete();



            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl2a());
            currentPh.setImageurl1b(phph.getImageurl2b());

            currentPh.setImageurl2a(phph.getImageurl3a());
            currentPh.setImageurl2b(phph.getImageurl3b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a(phph.getImageurl7a());
            currentPh.setImageurl6b(phph.getImageurl7b());

            currentPh.setImageurl7a(phph.getImageurl8a());
            currentPh.setImageurl7b(phph.getImageurl8b());

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


       //     JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List7b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }







    public String deletePhoto1on7() {



         if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();


                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);





      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven== false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl7);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);



                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }

        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                setP4mL8seven(false);

                 setP4mL8eight(false);





      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }






        try {


            Photos phph = getFacade().findSingPhoto();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1b() );

             photto.delete();
phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl2a());
            currentPh.setImageurl1b(phph.getImageurl2b());

            currentPh.setImageurl2a(phph.getImageurl3a());
            currentPh.setImageurl2b(phph.getImageurl3b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a(phph.getImageurl7a());
            currentPh.setImageurl6b(phph.getImageurl7b());

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


     //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List6b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String deletePhoto1on6() {





        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false)   {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




         //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);


                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);


                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);


                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl6);
getMemFacade().updateInboxSent();


                

                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);



                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);



     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }










        try {


            Photos phph = getFacade().findSingPhoto();

            currentPh = new Photos();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1b() );

             photto.delete();
phottob.delete();


            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl2a());
            currentPh.setImageurl1b(phph.getImageurl2b());

            currentPh.setImageurl2a(phph.getImageurl3a());
            currentPh.setImageurl2b(phph.getImageurl3b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a(phph.getImageurl5a());
            currentPh.setImageurl4b(phph.getImageurl5b());

            currentPh.setImageurl5a(phph.getImageurl6a());
            currentPh.setImageurl5b(phph.getImageurl6b());

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


  //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List5b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String deletePhoto1on4() {



        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();


                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);



                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);






    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);

                setP4mL8three(false);



                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);




                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);




                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);





                try {
                    getMemFacade().edit(currentMem);
          //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

         //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);




                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }




        try {


            Photos phph = getFacade().findSingPhoto();

            currentPh = new Photos();

               File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1a() );
 File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1b() );

             photto.delete();
phottob.delete();



            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl2a());
            currentPh.setImageurl1b(phph.getImageurl2b());

            currentPh.setImageurl2a(phph.getImageurl3a());
            currentPh.setImageurl2b(phph.getImageurl3b());

            currentPh.setImageurl3a(phph.getImageurl4a());
            currentPh.setImageurl3b(phph.getImageurl4b());

            currentPh.setImageurl4a("*");
            currentPh.setImageurl4b("*");

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

            //     getFacade().persist();


     //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "List3b";


        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String deletePhoto1on3() {




        if (p4mL1 == true & p4mL8two == false & p4mL8three == false) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

  //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();


                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

 setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);

 setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();



                setP4mL8two(true);

                setP4mL1(false);

 setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }
        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);
  //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();



                try {
                    getMemFacade().edit(currentMem);
         //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

 setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }







        try {


            Photos phph = getFacade().findSingPhoto();

             File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1a() );
            File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1b() );

             photto.delete();
            phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl2a());
            currentPh.setImageurl1b(phph.getImageurl2b());

            currentPh.setImageurl2a(phph.getImageurl3a());
            currentPh.setImageurl2b(phph.getImageurl3b());

            currentPh.setImageurl3a("*");
            currentPh.setImageurl3b("*");

            currentPh.setImageurl4a("*");
            currentPh.setImageurl4b("*");

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);





   //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "ListTwo";

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }






      public String deletePhoto2on3() {



        if (p4mL1 == true & p4mL8two == false & p4mL8three == false) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);





    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);





                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

   //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();



                setP4mL8two(true);

                setP4mL1(false);





                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }
        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();





                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);





       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }










        try {


            Photos phph = getFacade().findSingPhoto();

            currentPh = new Photos();

             File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2a() );
  File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2b() );

             photto.delete();
phottob.delete();



            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl3a());
            currentPh.setImageurl2b(phph.getImageurl3b());

            currentPh.setImageurl3a("*");
            currentPh.setImageurl3b("*");

            currentPh.setImageurl4a("*");
            currentPh.setImageurl4b("*");

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

    //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "ListTwo";

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String deletePhoto3on3() {



        if (p4mL1 == true & p4mL8two == false & p4mL8three == false) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);
//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);





     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(true);

                setP4mL1(false);





                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);





                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }
        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();





                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);





     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }




        try {


            Photos phph = getFacade().findSingPhoto();

             File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl3a() );
                File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl3b() );

             
             photto.delete();
            phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a(phph.getImageurl2a());
            currentPh.setImageurl2b(phph.getImageurl2b());

            currentPh.setImageurl3a("*");
            currentPh.setImageurl3b("*");

            currentPh.setImageurl4a("*");
            currentPh.setImageurl4b("*");

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

     //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "ListTwo";

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }


 public String chimgset2() {


        if (p4mL1 == true  & p4mL8two == false) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

          getMemFacade().setInboxupdateimageurl(imgurl1);
          getMemFacade().updateInboxSent();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }








                setP4mL1(true);

                setP4mL8two(false);



    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListTwo";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                 getMemFacade().setInboxupdateimageurl(imgurl2);
                 getMemFacade().updateInboxSent();



                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

                setP4mL8two(true);

                setP4mL1(false);


                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListTwo";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();


                getMemFacade().setInboxupdateimageurl(imgurl1);
                getMemFacade().updateInboxSent();



                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }



                setP4mL1(true);

                setP4mL8two(false);



      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListTwo";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }




        }




    }




      public String chimgset1() {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

          getMemFacade().setInboxupdateimageurl(imgurl1);
          getMemFacade().updateInboxSent();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

         

                setP4mL1(true);

            


    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListOne";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }


        } 









        public String chimgset3() {


        if (p4mL1 == true & p4mL8two == false & p4mL8three == false) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                  getMemFacade().setInboxupdateimageurl(imgurl1);
          getMemFacade().updateInboxSent();



                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);



       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListThree";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();


                  getMemFacade().setInboxupdateimageurl(imgurl2);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);



                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListThree";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();


                  getMemFacade().setInboxupdateimageurl(imgurl3);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);



                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListThree";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }
        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                  getMemFacade().setInboxupdateimageurl(imgurl1);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);



    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListThree";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }



    }








         public String chimgset4() {


        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                  getMemFacade().setInboxupdateimageurl(imgurl1);
          getMemFacade().updateInboxSent();



                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);


      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListFour";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                  getMemFacade().setInboxupdateimageurl(imgurl2);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);



                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListFour";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                  getMemFacade().setInboxupdateimageurl(imgurl3);
          getMemFacade().updateInboxSent();



                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListFour";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();


                  getMemFacade().setInboxupdateimageurl(imgurl4);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListFour";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                  getMemFacade().setInboxupdateimageurl(imgurl1);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);


      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListFour";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }




    }

    public String chimgset8() {


        if (p4mL1 == true & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false  ) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                  getMemFacade().setInboxupdateimageurl(imgurl1);
          getMemFacade().updateInboxSent();



                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                setP4mL8eight(false);


      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListEight";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                  getMemFacade().setInboxupdateimageurl(imgurl2);
          getMemFacade().updateInboxSent();



                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                setP4mL8eight(false);


                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

 //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListEight";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                  getMemFacade().setInboxupdateimageurl(imgurl3);
          getMemFacade().updateInboxSent();



                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                setP4mL8eight(false);


                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListEight";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                  getMemFacade().setInboxupdateimageurl(imgurl4);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                setP4mL8seven(false);



                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListEight";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();


                  getMemFacade().setInboxupdateimageurl(imgurl5);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);

                setP4mL8seven(false);



                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListEight";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false & p4mL8eight == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();


                  getMemFacade().setInboxupdateimageurl(imgurl6);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);

                setP4mL8seven(false);

                setP4mL8seven(false);


                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListEight";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true & p4mL8eight == false) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();


                  getMemFacade().setInboxupdateimageurl(imgurl7);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(true);

                setP4mL8eight(false);


                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListEight";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false & p4mL8eight == true) {




            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl8 = phph.getImageurl8a();


                  getMemFacade().setInboxupdateimageurl(imgurl8);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl8);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                setP4mL8eight(true);


                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListEight";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }



        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                   getMemFacade().setInboxupdateimageurl(imgurl1);
          getMemFacade().updateInboxSent();



                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                setP4mL8eight(false);


     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListEight";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }


        }




    }

    public String chimgset7() {


        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();


                  getMemFacade().setInboxupdateimageurl(imgurl1);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
         //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


         //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSeven";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();


                  getMemFacade().setInboxupdateimageurl(imgurl2);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSeven";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven== false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();


                  getMemFacade().setInboxupdateimageurl(imgurl3);
          getMemFacade().updateInboxSent();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);


                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSeven";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();


                  getMemFacade().setInboxupdateimageurl(imgurl4);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                try {
                    getMemFacade().edit(currentMem);
          //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

         //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSeven";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false & p4mL8seven) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();


                  getMemFacade().setInboxupdateimageurl(imgurl5);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);

                setP4mL8seven(false);


                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSeven";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true & p4mL8seven == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();


                  getMemFacade().setInboxupdateimageurl(imgurl6);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);

                setP4mL8seven(false);


                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSeven";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false & p4mL8seven == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl7 = phph.getImageurl7a();


                  getMemFacade().setInboxupdateimageurl(imgurl7);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl7);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(true);


                try {
                    getMemFacade().edit(currentMem);
          //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

         //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSeven";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }

        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();


                  getMemFacade().setInboxupdateimageurl(imgurl1);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
         //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


         //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSeven";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }




    }





     public String chimgset6() {


        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true)   {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                  getMemFacade().setInboxupdateimageurl(imgurl1);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
          //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


           //     JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSix";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                  getMemFacade().setInboxupdateimageurl(imgurl2);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);



                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                try {
                    getMemFacade().edit(currentMem);
          //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSix";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false & p4mL8six == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                  getMemFacade().setInboxupdateimageurl(imgurl3);
          getMemFacade().updateInboxSent();



                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);



                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


                try {
                    getMemFacade().edit(currentMem);
         //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSix";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                  getMemFacade().setInboxupdateimageurl(imgurl4);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);

                setP4mL8six(false);

                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSix";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true & p4mL8six == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                  getMemFacade().setInboxupdateimageurl(imgurl5);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);

                setP4mL8six(false);


                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

         //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSix";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false & p4mL8six == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl6 = phph.getImageurl6a();


                  getMemFacade().setInboxupdateimageurl(imgurl6);
          getMemFacade().updateInboxSent();


                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl6);


                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(true);


                try {
                    getMemFacade().edit(currentMem);
          //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

         //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSix";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }


        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);


        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListSix";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }




    }

    public String chimgset5() {


        if (p4mL1 == true  & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == false)  {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);
//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();




                try {
                    getMemFacade().edit(currentMem);
           //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);




       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListFive";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true & p4mL8three == false & p4mL8four == false & p4mL8five == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();




                setP4mL8two(true);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                try {
                    getMemFacade().edit(currentMem);
           //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListFive";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == true & p4mL8four == false & p4mL8five == false) {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl3 = phph.getImageurl3a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl3);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl3);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(true);

                setP4mL8four(false);

                setP4mL8four(false);


                try {
                    getMemFacade().edit(currentMem);
         //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

        //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListFive";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == true & p4mL8five == false) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl4 = phph.getImageurl4a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl4);

//updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl4);
getMemFacade().updateInboxSent();





                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(true);

                setP4mL8five(false);


                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListFive";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }




        } else if (p4mL1 == false & p4mL8two == false & p4mL8three == false & p4mL8four == false & p4mL8five == true) {


            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl5 = phph.getImageurl5a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl5);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl5);
getMemFacade().updateInboxSent();




                setP4mL8two(false);

                setP4mL1(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(true);


                try {
                    getMemFacade().edit(currentMem);
     //               JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListFive";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;

            }



        } else {


            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();






                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }


                setP4mL1(true);

                setP4mL8two(false);

                setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);




     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
                return "ListFive";

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        }


    }





     public String deletePhoto1on2() {




        if (p4mL1 == true  & p4mL8two == false) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);

                //below 2 lines updates inbox and sentbox.
                getMemFacade().setInboxupdateimageurl(imgurl1);
                getMemFacade().updateInboxSent();



                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }



                setP4mL1(true);
                setP4mL8two(false);

                 setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();



                setP4mL8two(false);

                setP4mL1(true);

                 setP4mL8three(false);

                setP4mL8four(false);

                setP4mL8five(false);

                setP4mL8six(false);

                setP4mL8seven(false);

                 setP4mL8eight(false);




                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

       //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl2a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


 //below 2 lines updates inbox and sentbox.
                getMemFacade().setInboxupdateimageurl(imgurl1);
                getMemFacade().updateInboxSent();


                try {
                    getMemFacade().edit(currentMem);
       //             JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }



                setP4mL1(true);





      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }




        }








        try {


            Photos phph = getFacade().findSingPhoto();


             File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1a() );

             File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1b() );



             photto.delete();
             phottob.delete();


            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl2a());
            currentPh.setImageurl1b(phph.getImageurl2b());

            currentPh.setImageurl2a("*");
            currentPh.setImageurl2b("*");

            currentPh.setImageurl3a("*");
            currentPh.setImageurl3b("*");

            currentPh.setImageurl4a("*");
            currentPh.setImageurl4b("*");

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);


            String imgurl2 = phph.getImageurl2a();

            currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

            currentMem.setImageurl(imgurl2);

            try {
                getMemFacade().edit(currentMem);
      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

            }

     //       JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "ListOneb";

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String deletePhoto2on2() {



        if (p4mL1 == true  & p4mL8two == false) {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);


                try {
                    getMemFacade().edit(currentMem);
        //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }



                setP4mL1(true);





      //          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else if (p4mL1 == false & p4mL8two == true) {



            try {


                Photos phph = getFacade().findSingPhoto();


                String imgurl2 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl2);


                //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl2);
getMemFacade().updateInboxSent();


                setP4mL8two(false);

                setP4mL1(true);


                try {
                    getMemFacade().edit(currentMem);
      //              JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }

     //           JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }



        } else {

            try {

                Photos phph = getFacade().findSingPhoto();


                String imgurl1 = phph.getImageurl1a();

                currentMem = getMemFacade().findMemberParam(phph.getPhotouserid());

                currentMem.setImageurl(imgurl1);
                
  //updates all inbox  and sent
              getMemFacade().setInboxupdateimageurl(imgurl1);
getMemFacade().updateInboxSent();



                try {
                    getMemFacade().edit(currentMem);
   //                 JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }



                setP4mL1(true);





    //            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));


            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }


        }


        try {


            Photos phph = getFacade().findSingPhoto();

             File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2a() );

              File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl2b() );

             
             photto.delete();
              phottob.delete();



            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a(phph.getImageurl1a());
            currentPh.setImageurl1b(phph.getImageurl1b());

            currentPh.setImageurl2a("*");
            currentPh.setImageurl2b("*");

            currentPh.setImageurl3a("*");
            currentPh.setImageurl3b("*");

            currentPh.setImageurl4a("*");
            currentPh.setImageurl4b("*");

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");


            getFacade().edit(currentPh);

    //        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "ListOneb";

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }




    public String deletePhoto1on1() {
        try {

              getMemFacade().setInboxupdateimageurl("");
          getMemFacade().updateInboxSent();


            Members mmm = getMemFacade().findMember();
            mmm.setImageurl("");
            
             try {
                    getMemFacade().edit(mmm);
    //                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("MembersUpdated"));

                } catch (Exception e) {
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));

                }


            Photos phph = getFacade().findSingPhoto();

             File photto = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1a() );

              File phottob = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/" + phph.getImageurl1b() );

             photto.delete();
             phottob.delete();

            currentPh = new Photos();

            currentPh.setPhotouserid(phph.getPhotouserid());

            currentPh.setImageurl1a("*");
            currentPh.setImageurl1b("*");

            currentPh.setImageurl2a("*");
            currentPh.setImageurl2b("*");

            currentPh.setImageurl3a("*");
            currentPh.setImageurl3b("*");

            currentPh.setImageurl4a("*");
            currentPh.setImageurl4b("*");

            currentPh.setImageurl5a("*");
            currentPh.setImageurl5b("*");

            currentPh.setImageurl6a("*");
            currentPh.setImageurl6b("*");

            currentPh.setImageurl7a("*");
            currentPh.setImageurl7b("*");

            currentPh.setImageurl8a("*");
            currentPh.setImageurl8b("*");

            currentPh.setImageurl9a("*");
            currentPh.setImageurl9b("*");

            currentPh.setImageurl10a("*");
            currentPh.setImageurl10b("*");

            currentPh.setImageurl11a("*");
            currentPh.setImageurl11b("*");

            currentPh.setImageurl12a("*");
            currentPh.setImageurl12b("*");

            currentPh.setImageurl13a("*");
            currentPh.setImageurl13b("*");

            currentPh.setImageurl14a("*");
            currentPh.setImageurl14b("*");

            currentPh.setImageurl15a("*");
            currentPh.setImageurl15b("*");

            currentPh.setImageurl16a("*");
            currentPh.setImageurl16b("*");



            getFacade().edit(currentPh);

   //         JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resources/Bundle").getString("PhotosUpdated"));
            return "indexother";

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }













     












    public String prepareEdit() {
        current = (Photos)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("PhotosUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("Resource/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Photos)getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("Resource/Bundle").getString("PhotosDeleted"));
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

//

        if (items == null) {
            
          
            items = getPagination().createPageDataModel();
        }
        return items;
    }




     public DataModel getItemstwo() {


        if (itemstwo == null) {
            itemstwo = getPaginationTwo().createPageDataModel();
        }
        return itemstwo  ;
    }




       public List<Photos> getItemsthree() {



   //     if (itemstwo == null) {
   //         itemstwo = getPaginationThree().createPageDataModel();
   //     }
 
        Photos bb = getFacade().findSearchViewPhotosUiRepeatTwo();


List<String> products = new ArrayList<String>();


List<Photos> productstwo = new ArrayList<Photos>();





     if(bb.getImageurl1a().length() > 3){



 products.add(bb.getImageurl1a());

 Photos i = new Photos();
i.setImageurl1a(bb.getImageurl1a());
i.setImageurl1b(bb.getImageurl1b());
 productstwo.add(i);


      }

        if(bb.getImageurl2a().length() > 3){

products.add(bb.getImageurl2a());


 Photos iii = new Photos();
iii.setImageurl1a(bb.getImageurl2a());
iii.setImageurl1b(bb.getImageurl2b());
 productstwo.add(iii);


      }
        if(bb.getImageurl3a().length() > 3){



products.add(bb.getImageurl3a());


Photos ii = new Photos();
ii.setImageurl1a(bb.getImageurl3a());
ii.setImageurl1b(bb.getImageurl3b());
 productstwo.add(ii);



      }
         if(bb.getImageurl4a().length() > 3){



products.add(bb.getImageurl4a());


 Photos ii3 = new Photos();
ii3.setImageurl1a(bb.getImageurl4a());
ii3.setImageurl1b(bb.getImageurl4b());
 productstwo.add(ii3);


      }

          if(bb.getImageurl5a().length() > 3){



products.add(bb.getImageurl5a());


 Photos ii4 = new Photos();
ii4.setImageurl1a(bb.getImageurl5a());
ii4.setImageurl1b(bb.getImageurl5b());
 productstwo.add(ii4);


      }

         if(bb.getImageurl6a().length() > 3){



products.add(bb.getImageurl6a());



 Photos ii5 = new Photos();
ii5.setImageurl1a(bb.getImageurl6a());
ii5.setImageurl1b(bb.getImageurl6b());
 productstwo.add(ii5);
 

      }

          if(bb.getImageurl7a().length() > 3){

products.add(bb.getImageurl7a());

Photos ii6 = new Photos();
ii6.setImageurl1a(bb.getImageurl7a());
ii6.setImageurl1b(bb.getImageurl7b());
 productstwo.add(ii6);
 

     }

          if(bb.getImageurl8a().length() > 3){



products.add(bb.getImageurl8a());


Photos ii7 = new Photos();
ii7.setImageurl1a(bb.getImageurl8a());
ii7.setImageurl1b(bb.getImageurl8b());
 productstwo.add(ii7);


      }


        return productstwo;

    }

        


    




 public DataModel getItemsProfile() {
        if (items == null) {
            items = getPaginationProfile().createPageDataModel();
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

    /**
     * @return the retph
     */
    public String getRetph() {
        return retph;
    }

    /**
     * @param retph the retph to set
     */
    public void setRetph(String retph) {
        this.retph = retph;
    }

   

    @FacesConverter(forClass=Photos.class)
    public static class PhotosControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PhotosController controller = (PhotosController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "photosController");
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
            if (object instanceof Photos) {
                Photos o = (Photos) object;
                return getStringKey(o.getPhotouserid());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: "+PhotosController.class.getName());
            }
        }

    }

}
