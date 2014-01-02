/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;



import java.util.UUID;

import controller.MembersFacade;
import controller.PhotosFacade;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.persistence.Query;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
// import javax.management.Query;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.PersistenceContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import model.PhotosController;

/**
 *
 * @author Chris Mitchell
 */
@WebServlet(name = "CropImageTwo", urlPatterns = {"/faces/CropImageTwo"})
@PersistenceContext(name = "persistence/LogicalName", unitName = "proTenPU")
public class CropImageTwo extends HttpServlet {

    @Resource
    private javax.transaction.UserTransaction utx;
    public String username2;
    public int flan;
    @EJB
    private controller.MembersFacade ejbFacade;
    @EJB
    private controller.PhotosFacade ejbFacadePhotos;
    private String filename;
    private long llop;


     private String _named = "helloagain";
    private String _namedtwo;
    private int flum;
    private int flumtwo = 10;


    public String filenametwo;
    public boolean ismainempty = true;


public model.PhotosController subphotosController;




private PhotosController getPhotos(){


    return subphotosController;

}


    private MembersFacade getFacade() {
        return ejbFacade;
    }

    private PhotosFacade getFacadePhotos() {
        return ejbFacadePhotos;
    }

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


            username2 = getFacade().getUsernamelogin();

            if (username2 == null) {

                username2 = getFacade().getUsernamecreate();

            }


            //   flan = getFacade().getTrackflum();


            //   llop = getFacade().getLnguserid();


            llop = getFacadePhotos().getCheckid();



            findFlum();

//start adding from upload servlet 1/28/2012
 findFlumTwo();

                if (flum == 1) {

                    ismainempty = true;

                } else{

                    ismainempty=false;

                }


            String emptee = username2;

    String Id2 = UUID.randomUUID().toString();

   Id2 =  ejbFacadePhotos.getUploadurlname();
              //  getFacadePhotos().setUrltrack(flumtwo);


                String emptee2 = username2 + "/" + username2 + flumtwo;

                filename = emptee + Id2 + ".jpg";

                filenametwo = emptee + Id2 + "s" + ".jpg";

                _named = "/Cropped/" + username2 + "/" + filename;

                _namedtwo = "/Cropped/" + username2 + "/" + filenametwo;

             //   flumtwo = flumtwo + 1;



               if (ismainempty == true) {

                    persistPhotoIsempty();

getFacade().setInboxupdateimageurl(_named);
getFacade().updateInboxSent();

                } else {

                    persistPhoto();


                }







//   String dd = request.getParameter("x");
//  if (dd== null){

//   }






            //Set The Save Location
            String serverPath = this.getServletContext().getRealPath("/") + "/Cropped/" + username2 + "/";
            //Open The Session
            HttpSession s = request.getSession();
            //Set The Source File Using The Session Value

            // cm-  this is the location of the source file to crop.
            String sourceFile = this.getServletContext().getRealPath("/") + "/Uploads/" + s.getAttribute("photoid") + ".jpg";


            //Get The Image Into BufferedImage
            BufferedImage image = ImageIO.read(new File(sourceFile));

            BufferedImage imagetwo = ImageIO.read(new File(sourceFile));








            //Get The Crop Dimensions
            int x1 = Integer.parseInt(request.getParameter("x"));

            int y1 = Integer.parseInt(request.getParameter("y"));
            int x2 = Integer.parseInt(request.getParameter("x2"));
            int y2 = Integer.parseInt(request.getParameter("y2"));
            int w = Integer.parseInt(request.getParameter("w"));
            int h = Integer.parseInt(request.getParameter("h"));







            //Generate Cropped Image
            BufferedImage out2 = image.getSubimage(x1, y1, w, h);
            //Save Cropped Image Back To Disk

            BufferedImage out2two = imagetwo.getSubimage(x1, y1, w, h);

            BufferedImage out2three = resize(out2two, 450, 450);


            //cm- this is what the name of ths file will be.

         //   int uu = getFacadePhotos().getUrltrack();


            ImageIO.write(out2, "png", new File(serverPath + "" + username2 + Id2 + ".jpg"));

            ImageIO.write(out2three, "png", new File(serverPath + "" + username2 + Id2 + "s" + ".jpg"));




            //Show The Image To Client
            //  writer.println("<img src=\"" + this.getServletContext().getContextPath() + "/Cropped/" + s.getAttribute("photoid") + ".jpg" + "\" />");

        //    uu++;



  //      response.sendRedirect("index.xhtml");

            llop = getFacadePhotos().getCheckid();

            findFlum();

            int x = flan;


            response.sendRedirect("photos/yourphotos.xhtml");

       //     if (x == 8) {
        //        response.sendRedirect("photos/ListEight.xhtml");
        //    } else if (x == 7) {
        //        response.sendRedirect("photos/ListSeven.xhtml");
        //    } else if (x == 6) {
       //         response.sendRedirect("photos/ListSix.xhtml");
       //     } else if (x == 5) {
      //          response.sendRedirect("photos/ListFive.xhtml");
       //     } else if (x == 4) {
       //         response.sendRedirect("photos/ListFour.xhtml");
       //     } else if (x == 3) {
        //        response.sendRedirect("photos/ListThree.xhtml");
       //     } else if (x == 1) {
       //         response.sendRedirect("photos/ListOne.xhtml");
      //      } else if (x == 2) {
      //          response.sendRedirect("photos/ListTwo.xhtml");
      //      } else if (x == 0) {
      //          response.sendRedirect("indexadditional.xhtml");
      //      }






         





            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CropImageTwo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CropImageTwo at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            //   out.close();
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

    protected void persist(Object object) {
        try {
            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");


            //  String sssend = " UPDATE Photos o " + " SET o.imageurl1a"   + _namec + "'" + " WHERE o.photouserid ='" + "23" + "'";
            String sssend = " UPDATE Photos o " + " SET o.imageurl" + flan + "a" + " = '" + "yy" + "'" + " WHERE o.photouserid ='" + llop + "'";


            Query q = em.createQuery(sssend);


            q.executeUpdate();


            utx.commit();


            //   em.persist(object);




            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    protected void findFlum() {

        try {

            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            // utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");


            for (int j = 1; j < 17; j++) {

                Query q = em.createQuery("select o.imageurl" + j + "a" + " FROM Photos o " + " WHERE o.photouserid ='" + llop + "'");

                if (q.getSingleResult().toString().equals("*")) {

                    flan = j - 1;

                    break;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }



     protected void findFlumTwo() {

        try {

            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            // utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");


            for (int j = 1; j < 9; j++) {

                Query q = em.createQuery("select o.imageurl" + j + "a" + " FROM Photos o " + " WHERE o.photouserid ='" + llop + "'");

                if (q.getSingleResult().toString().equals("*")) {

                    setFlum(j);

                    break;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }




 //this below was tested and worked.
    public void persistPhoto() {
        try {

            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");

            //  String sssend = " UPDATE Photos o " + " SET o.imageurl1a"   + _namec + "'" + " WHERE o.photouserid ='" + "23" + "'";
            String sssend = " UPDATE Photos o " + " SET o.imageurl" + flum + "a" + " = '" + _named + "'" + " WHERE o.photouserid ='" + llop + "'";


            String sssendtwo = " UPDATE Photos o " + " SET o.imageurl" + flum + "b" + " = '" + _namedtwo + "'" + " WHERE o.photouserid ='" + llop + "'";



            Query q = em.createQuery(sssend);

            Query qq = em.createQuery(sssendtwo);



            q.executeUpdate();

            qq.executeUpdate();

            utx.commit();

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    public void persistPhotoIsempty() {
        try {

            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");

            //  String sssend = " UPDATE Photos o " + " SET o.imageurl1a"   + _namec + "'" + " WHERE o.photouserid ='" + "23" + "'";
            String sssend = " UPDATE Photos o " + " SET o.imageurl" + flum + "a" + " = '" + _named + "'" + " WHERE o.photouserid ='" + llop + "'";

            String sssendtwo = " UPDATE Photos o " + " SET o.imageurl" + flum + "b" + " = '" + _namedtwo + "'" + " WHERE o.photouserid ='" + llop + "'";

            String sssendthree = " UPDATE Members o " + " SET o.imageurl" + " = '" + _named + "'" + " WHERE o.userid ='" + llop + "'";


            Query q = em.createQuery(sssend);

            Query qq = em.createQuery(sssendtwo);

            Query qqq = em.createQuery(sssendthree);



            q.executeUpdate();

            qq.executeUpdate();

            qqq.executeUpdate();

            utx.commit();


            ismainempty = false;

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }







    /**
     * @return the llop
     */
    public long getLlop() {
        return llop;
    }

    /**
     * @param llop the llop to set
     */
    public void setLlop(long llop) {
        this.llop = llop;
    }

    /**
     * @return the flan
     */
    public int getFlan() {
        return flan;
    }

    /**
     * @param flan the flan to set
     */
    public void setFlan(int flan) {
        this.flan = flan;
    }

    /**
     * @return the flum
     */
    public int getFlum() {
        return flum;
    }

    /**
     * @param flum the flum to set
     */
    public void setFlum(int flum) {
        this.flum = flum;
    }
}
