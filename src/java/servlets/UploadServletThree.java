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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;
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
import javax.persistence.Query;

/**
 *
 * @author Chris Mitchell
 */
@WebServlet(name = "UploadServletThree", urlPatterns = {"/faces/photos/UploadThree.html", "/faces/members/UploadThree.html", "/faces/UploadThree.html","/faces/inbox/UploadThree.html", "/faces/sent/UploadThree.html", "/faces/favorites/UploadThree.html", "/faces/umightlike/UploadThree.html", "/faces/hasviewedprofiletwo/UploadThree.html"})
@MultipartConfig
@PersistenceContext(name = "persistence/LogicalName", unitName = "proTenPU")
public class UploadServletThree extends HttpServlet {

    @Resource
    private javax.transaction.UserTransaction utx;
    public String username2;
    private String _named = "helloagain";
    private String _namedtwo;
    public int flum;

    @EJB
    private controller.MembersFacade ejbFacade;
    @EJB
    private controller.PhotosFacade ejbFacadePhotos;
    public long llop;
    public String filename;
    public String filenametwo;
    public boolean ismainempty = true;

    public static String SimpleDateFormatmethod() {
        Calendar date = Calendar.getInstance();
        SimpleDateFormat dateformatter = new SimpleDateFormat("hh:mm:ss");
        return (dateformatter.format(date.getTime()));

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

    private MembersFacade getFacade() {
        return ejbFacade;
    }

    private PhotosFacade getFacadePhotos() {
        return ejbFacadePhotos;
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

        String length = request.getHeader("content-length");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            //Get The File

            Part p1 = request.getPart("file");


            if (p1.getSize() == 0) {

                response.sendRedirect("/proTen/faces/photos/yourphotos.xhtml");
            } else {



                InputStream is = p1.getInputStream();
                //Generate New FileName

                


                username2 = getFacade().getUsernamelogin();

                if (username2 == null) {

                    username2 = getFacade().getUsernamecreate();

                }

                llop = getFacadePhotos().getCheckid();

                findFlum();

                if (flum == 1) {

                    ismainempty = true;

                } else{
                    
                    ismainempty=false;

                }


 String Id = UUID.randomUUID().toString();

 


             //       getFacadePhotos().setUploadurlname(Id);

                   ejbFacadePhotos.setUploadurlname(Id);

                //   getFacade().setTrackflum(flum);


                    String emptee = username2;



         //       getFacadePhotos().setUrltrack(flumtwo);

                String emptee2 = username2 + "/" + username2 + Id;

                filename = emptee + Id + ".jpg";

                filenametwo = emptee + Id + "s" + ".jpg";

                _named = "/Cropped/" + username2 + "/" + filename;

                _namedtwo = "/Cropped/" + username2 + "/" + filenametwo;

            //    flumtwo = flumtwo + 1;

                //Set The Physical Location
                //       String outputfile = getServletContext().getRealPath("") + "/Uploads/" + filename;



                //       File dir2 = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/projsix/build/web/Uploads/"   + emptee);

                //        boolean success2 = dir2.mkdirs();






                File fileOnServer = new File("C:/Users/Chris Mitchell/My Documents/NetbeansProjects/proTen/build/web/Uploads/" + emptee + "/" + filename);




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

                    BufferedImage wo = resize(bimg, 420, 320);
                    ImageIO.write(wo, "png", fileOnServer);


                } else if (hhh > www) {

                    BufferedImage wo = resize(bimg, 320, 420);
                    ImageIO.write(wo, "png", fileOnServer);


                } else if (www == hhh) {

                    BufferedImage wo = resize(bimg, 400, 400);
                    ImageIO.write(wo, "png", fileOnServer);

                }



             



         //       if (ismainempty == true) {

          //          persistPhotoIsempty();


         //       } else {

         //           persistPhoto();


         //       }



                // this was tested and worked -   persistPhoto();


                //Open a Session and Add New Session

                HttpSession session = request.getSession();
                session.setAttribute("photoid", emptee2);
                //Redirect It To Cropping Page

                String destination = "/proTen/faces/JCropTwo.jsp";

                response.sendRedirect(response.encodeRedirectURL(destination));


                // end brace for if else ismain empty.



                //below is end brace for the if /else statment on .size() check

            }

        } finally {
            out.close();
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

    protected void findFlum() {

        try {

            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            // utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");


            for (int j = 1; j < 9; j++) {

                Query q = em.createQuery("select o.imageurl" + j + "a" + " FROM Photos o " + " WHERE o.photouserid ='" + llop + "'");

                if (q.getSingleResult().toString().equals("*")) {

                    flum = j;

                    break;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
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
     * @return the _namedtwo
     */
    public String getNamedtwo() {
        return _namedtwo;
    }

    /**
     * @param namedtwo the _namedtwo to set
     */
    public void setNamedtwo(String namedtwo) {
        this._namedtwo = namedtwo;
    }
}
