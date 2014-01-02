<%--
    Document   : JCrop
    Created on : Sep 10, 2010, 4:58:15 PM
    Author     : Jesse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>




    <html>
        <head>
            <title>Crop Image | Cloud9Cupid</title>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <script src="Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
            <script src="Scripts/jquery.Jcrop.min.js" type="text/javascript"></script>

            <link href="Styles/jquery.Jcrop.css" rel="stylesheet" type="text/css" />
            <link href="resources/css/style.css" rel="stylesheet" type="text/css" />


            <script language="Javascript" type="text/javascript">
                jQuery(document).ready(function () {
                    jQuery('#cropbox').Jcrop({
                        setSelect:[80,200,200,80],
                        onChange: showCoords,
                        bgColor:'white',
                        onSelect: showCoords,
                        minSize:[150,150]





                    });

                });
                function showCoords(c) {
                    jQuery('#x').val(c.x);
                    jQuery('#y').val(c.y);
                    jQuery('#x2').val(c.x2);
                    jQuery('#y2').val(c.y2);
                    jQuery('#w').val(c.w);
                    jQuery('#h').val(c.h);
                };


                function checkCoords()
                {
                    if (parseInt($('#w').val())) return true;
                    alert('Please select a crop region then press submit.');
                    return false;
                };


            </script>
        </head>




        <body>





            <h:form>

                <h:commandLink action= "#{membersController.logout}"  style=" padding: 5px 20px 5px 20px; font-weight: 600; font-size:15px;    color:#2681fc ; text-shadow: 0 1px 1px rgba(0,0,0, .3);
                               margin-left:10px; text-decoration:none;"  value="Logout" />



                <h:commandLink action= "#{membersControllerThree.prepareViewThree}" style="padding: 5px 20px 5px 20px; font-weight: 600;  font-size:15px;     color:#2681fc   ; text-shadow: 0 1px 1px rgba(0,0,0, .3);
                               margin-left:10px; text-decoration:none;"  value="My Profile" />



                <h:commandLink  action= "#{membersController.prepareEditTwo}"  style="padding: 5px 20px 5px 20px;  font-size:15px; font-weight: 600;  color:#2681fc  ; text-shadow: 0 1px 1px rgba(0,0,0, .3);
                                margin-left:10px; text-decoration:none;"  value="Edit My Profile" />




                <h:commandLink  action="/indexthree" style=" padding: 5px 20px 5px 20px;  font-size:15px; font-weight: 600;   color:#2681fc; text-shadow: 0 1px 1px rgba(0,0,0, .3);
                                margin-left:10px; text-decoration:none;"  value="Help" />

            </h:form>









            <!-- WRAPPER -->
            <div id="wrapperten">


                <!-- HEADER -->
                <div id="headerten">

                    <h1 style="margin: 0px; font-weight:bolder;" >Chemispark.com</h1>
                    <p style="margin: 0px; font-weight: bolder; font-size: larger;"  > Chemispark.com is a 100% free dating site. There are no subscriptions or charges for anything at all.</p>



                    <div id="navmenu">

                        <ul>

                            <li>
                                <h:form>

                                    <h:commandLink style=" font-weight: 600"    action ="#{inboxControllerTwo.resetinbox}" value="Inbox"/>

                                </h:form>


                            </li>

                            <li>
                                <h:form>

                                    <h:commandLink  style=" font-weight: 600"    action= "#{inboxControllerTwo.resetsent}" value="Sent"/>

                                </h:form>
                            </li>

                            <li>

                                <h:form>
                                    <h:commandLink  style=" font-weight: 600"    action="#{photosControllerTwo.findPhotoPage}" value="Photos"/>
                                </h:form>

                            </li>


                            <li>
                                <h:form>

                                    <h:commandLink style=" font-weight: 600"    action="#{membersControllerFive.resetsearchrad}" value="Search"/>

                                </h:form>

                            </li>




                            <li>

                                <h:form>
                                    <h:commandLink  style=" font-weight: 600"   action="#{membersControllerFive.resetfavorites}" value="Favorites"/>
                                </h:form>

                            </li>



                            <li>
                                <h:form>
                                    <h:commandLink  style=" font-weight: 600"   action="#{membersControllerFive.resetvisitors}" value="Visitors"/>
                                </h:form>

                            </li>


                            <li>
                                <h:form>
                                    <h:commandLink  style=" font-weight: 600"   action="#{membersControllerFive.umightlikepage}" value="You Might Like"/>
                                </h:form>

                            </li>


                            <li>
                                <h:form>

                                    <h:commandLink action= "#{membersControllerThree.prepareViewThree}" style=" font-weight: 600"   value="My Profile" />

                                </h:form>

                            </li>


                            <li>
                                <h:form>

                                    <h:commandLink  action= "#{membersController.prepareEditTwo}"  style="font-weight: 600"  value="Edit My Profile" />

                                </h:form>

                            </li>


                        </ul>
                        <!-- ends nav menu -->
                    </div>


                    <br />

                </div>
                <!-- ENDS HEADERten -->








                <br />

                <br />



                <br />

                <br />





                <!-- MAIN -->
                <div id="mainten">

                    <!-- content -->
                    <div id="contentten">



                        <%
                                    HttpSession s = request.getSession();
                        %>


                        <h:form>

                            <h:outputText style="color:#2681fc;font-weight: bold; text-align:center;  " value=" Drag the mouse pointer over your photo below to crop your image." />
                            <br/>
                            <h:outputText style="color:#2681fc;font-weight: bold; text-align:center;  " value=" Click the submit button below when you are finished." />
                            <br/>
                            <h:outputText style="color:#2681fc;font-weight: bold;text-align:center;  " value=" If you want to upload a different photo then click the link below." />
                            <br/>

                            <br/>
                            <br/>

                          
                            <br/>

                        </h:form>

                              <h:form>

                                <h:commandLink action="#{photosControllerTwo.findPhotoPage}"  style="color:#2681fc;font-weight: bold;text-align:center; "    value="Upload a different photo instead"/>

                            </h:form>




                        <form action="CropImage" style=" margin-left:310px; margin-top:50px;" method="POST" onsubmit="return checkCoords();"  >
                            <img id="cropbox" src='Uploads/<%=s.getAttribute("photoid")%>.jpg' alt="Crop Image Two" />
                            <input type="hidden" id="x" name="x" />
                            <input type="hidden" id="y" name="y" />
                            <input type="hidden" id="x2" name="x2" />
                            <input type="hidden" id="y2" name="y2" />
                            <input type="hidden" id="w" name="w" />
                            <input type="hidden" id="h" name="h" />
                            <br/>
                            <input class="buttontwo"  type="submit" value="Submit" />
                        </form>


                        <!-- TABS -->
                        <!-- the tabs -->

                        <!-- tab "panes" -->

                        <!-- ENDS TABS -->


                    </div>
                    <!-- ENDS content -->

                    <!-- Twitter -->

                    <!-- ENDS Twitter -->


                </div>
                <!-- ENDS MAIN -->


           


                <!-- FOOTER -->
                <div id="footer">


                    <!-- Bottom -->
                    <div id="bottom">

                        <ul id="navlist">

                            <li>
                                <h:form>

                                    <h:commandLink style=" color:#2681fc; " value="about" action="/footerpages/about.xhtml" ></h:commandLink>

                                </h:form>
                            </li>
                            <li>

                                <h:form>

                                    <h:commandLink style=" color:#2681fc; " value="terms" action="/footerpages/terms.xhtml"></h:commandLink>

                                </h:form>

                            </li>

                            <li>
                                <h:form>

                                    <h:commandLink style=" color:#2681fc; " value="contact" action="/footerpages/contact.xhtml"></h:commandLink>

                                </h:form>

                            </li>

                            <li>
                                <h:form>

                                    <h:commandLink style=" color:#2681fc; " value="online safety" action="/footerpages/safety.xhtml"></h:commandLink>

                                </h:form>

                            </li>

                            <li>
                                <h:form>

                                    <h:commandLink style=" color:#2681fc; " value="privacy policy" action="/footerpages/privacy.xhtml"></h:commandLink>

                                </h:form>
                            </li>

                        </ul>


                        <br/>

                        <br/>


                        <h:outputText style="color:#2681fc;  " value=" Copyright 2012 Chemispark.com  "/>

                        <!--bottom-->
                    </div>

                </div>
                <!-- ENDS FOOTER -->



            </div>
            <!-- ENDS WRAPPER -->






        </body>
    </html>

</f:view>
