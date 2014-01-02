/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chris Mitchell
 */
@ManagedBean(name = "jcropbean")
@RequestScoped
public class jcropbean {

    /** Creates a new instance of jcropbean */
    public jcropbean() {
    }

    public void sendcrop() {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        ExternalContext externalContext = facesContext.getExternalContext();

        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

        try {

            FacesContext.getCurrentInstance().responseComplete();

            response.sendRedirect("index.jsp");

            FacesContext.getCurrentInstance().responseComplete();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }





    }



     public void sendcroptwo() {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        ExternalContext externalContext = facesContext.getExternalContext();

        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

        try {

            FacesContext.getCurrentInstance().responseComplete();

            response.sendRedirect("indexadditional.xhtml");

            FacesContext.getCurrentInstance().responseComplete();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }





    }





}




