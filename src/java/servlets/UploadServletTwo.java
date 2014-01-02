/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;







import controller.MembersFacade;
import controller.PhotosFacade;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
// import javax.management.Query;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.PersistenceContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

/**
 *
 * @author Chris Mitchell
 */
@WebServlet(name = "UploadServletTwo", urlPatterns = {"/faces/UploadTwo.html"})
@MultipartConfig
@PersistenceContext(name = "persistence/LogicalName", unitName = "proTenPU")
public class UploadServletTwo extends HttpServlet {

    @Resource
    private javax.transaction.UserTransaction utx;
    public String username2;
    private String _named = "helloagain";
    public int flum;
    private String _namec = "";
    private String _namebb = "";


    public  Long llnngg;

     @EJB
    private controller.PhotosFacade ejbFacadePhoto;



    @EJB
    private controller.MembersFacade ejbFacade;
    private String filename;




    
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }

    private MembersFacade getFacade() {
        return ejbFacade;
    }


     private PhotosFacade getFacadePhoto() {
        return ejbFacadePhoto;
    }




    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadServletTwo</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadServletTwo at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */


            //Get The File
            Part p1 = request.getPart("file");
            InputStream is = p1.getInputStream();
            //Generate New FileName

           llnngg =  getFacadePhoto().getCheckid();


           

findFlum();


            username2 = getFacade().getUsernamelogin();

            String emptee = username2;

            String filename = emptee + "5" + ".jpg";



            _named = "yes";

            //Set The Physical Location
            //       String outputfile = getServletContext().getRealPath("") + "/Uploads/" + filename;



            File fileOnServer = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/projsix/build/web/Uploads/"  + emptee + "/" + filename);



        //    File fileOnServerb = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/projsix/build/web/Uploads/" + filename);



             _namec = "/Uploads/" + username2 + "/" + filename;
            _namebb = "/Uploads/" + username2 + "/" + filename;




            BufferedOutputStream oss = new BufferedOutputStream(new FileOutputStream(fileOnServer));

            BufferedInputStream iss = new BufferedInputStream(p1.getInputStream());

            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = is.read(buffer)) != -1) {
                oss.write(buffer, 0, count);
            }

            oss.close();
            iss.close();







            //   String outputfile = getServletContext().getRealPath("") + "/Uploads/" + filename;


            //  FileOutputStream os = new FileOutputStream(outputfile);
            //Store The File On The Disk
            //  int ch = is.read();
            //  while (ch != -1) {
            //     os.write(ch);
            //    ch = is.read();
            //  }
            //   os.close();





            BufferedImage bimg = null;
            bimg = ImageIO.read(fileOnServer);

            int www = bimg.getWidth();

            int hhh = bimg.getHeight();



            if (www > hhh) {

                BufferedImage wo = resize(bimg, 320, 220);
                ImageIO.write(wo, "png", fileOnServer);


            } else if (hhh > www) {

                BufferedImage wo = resize(bimg, 220, 320);
                ImageIO.write(wo, "png", fileOnServer);


            } else if (www == hhh) {

                BufferedImage wo = resize(bimg, 300, 300);
                ImageIO.write(wo, "png", fileOnServer);

            }



            persistPhoto();





            //Open a Session and Add New Session

            HttpSession session = request.getSession();
            session.setAttribute("photoid", emptee);
            //Redirect It To Cropping Page
            response.sendRedirect("JCrop.jsp");






        } finally {
            out.close();
        }
    }

    /**
     * @return the username2
     */
    public String getUsername2() {
        return username2;
    }

    /**
     * @param username2 the username2 to set
     */
    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the _named
     */
    public String getNamed() {
        return _named;
    }

    /**
     * @param named the _named to set
     */
    public void setNamed(String named) {
        this._named = named;
    }

    protected void persist() {
        try {


            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");


            Query q = em.createQuery(" UPDATE Members o " + " SET o.imageurl = '" + _named + "'" + " WHERE o.username ='" + username2 + "'");
            q.executeUpdate();

            utx.commit();


        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    protected void persistPhoto() {
        try {

            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");

           llnngg =  getFacade().getLnguserid();


            try {


                String sssend = " UPDATE Photos o " + " SET o.imageurl" + flum + "a" + "='" + getNamec() + "'" + " WHERE o.photouserid ='" + llnngg + "'";
                String sssendb = " UPDATE Photos o " + " SET o.imageurl" + flum + "b" + "='" + getNamebb() + "'" + " WHERE o.username ='" + username2 + "'";

                Query q = em.createQuery(sssend);
               //  Query qb = em.createQuery(sssendb);

                q.executeUpdate();
              //   qb.executeUpdate();
            } catch (EntityNotFoundException enfe) {
            }

            utx.commit();


            try {
                utx.rollback();
            } catch (Exception e) {
                throw new Exception("An error occurred attempting to roll back the transaction.", e);
            }



        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    protected void findFlum() {

        try {

            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");


            for (int j = 1; j < 17; j++) {

                Query q = em.createQuery("select o.imageurl" + j + " a " +  " FROM Photos o " + " WHERE o.username ='" + username2 + "'");

                if (q.getSingleResult().toString().equals("**")) {

                    flum = j;

                    break;

                }

            }





        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
     * @return the _namec
     */
    public String getNamec() {
        return _namec;
    }

    /**
     * @param namec the _namec to set
     */
    public void setNamec(String namec) {
        this._namec = namec;
    }

    /**
     * @return the _namebb
     */
    public String getNamebb() {
        return _namebb;
    }

    /**
     * @param namebb the _namebb to set
     */
    public void setNamebb(String namebb) {
        this._namebb = namebb;
    }

    /**
     * @return the llnngg
     */
    public Long getLlnngg() {
        return llnngg;
    }

    /**
     * @param llnngg the llnngg to set
     */
    public void setLlnngg(Long llnngg) {
        this.llnngg = llnngg;
    }
}
