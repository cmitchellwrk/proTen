/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.myfaces.examples.misc;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Chris Mitchell
 */
@ManagedBean(name = "MemberSettingsBean")
@RequestScoped
public class MemberMailSettingsBean {

    /** Creates a new instance of MemberMailSettingsBean */
    public MemberMailSettingsBean() {
    }



    private String gender;



    private String country;



    private String firstcontactmessagesize;



    private int agefrom;



    private int ageto;



    private String within;


    private String email;




    private boolean hangout;



    private boolean friendship;


    private boolean activitypartner;


    private boolean dating;


    private boolean longterm;


    private boolean intimateencounter;


    private boolean talkemail;


    private boolean otherrelationship;


    private boolean usedrugs;


    private boolean smoke;


    private boolean havmessageintenct;



   

    private boolean email1;


    private boolean email2;


    private boolean email3;


    private boolean email4;


    private boolean email5;


 





    private SelectItem[] gend = {
    new SelectItem("Either"),
    new SelectItem("Female"),
    new SelectItem("Male"),

};

    /**
     * @return the gend
     */
    public SelectItem[] getGend() {
        return gend;
    }

    /**
     * @param gend the gend to set
     */
    public void setGend(SelectItem[] gend) {
        this.gend = gend;
    }

   


     private SelectItem[] countries = {
    new SelectItem("United States"),
    new SelectItem("Afghanistan"),
    new SelectItem("Algeria"),
    new SelectItem("Argentina"),
    new SelectItem("Australia"),
    new SelectItem("Austria"),
    new SelectItem("Bahamas"),
    new SelectItem("Bangladesh"),
    new SelectItem("Barbados"),
    new SelectItem("Belgium"),
    new SelectItem("Belize"),
    new SelectItem("Bermuda"),
    new SelectItem("Bolivia"),
    new SelectItem("Brazil"),
    new SelectItem("Brunei Darussalam"),
    new SelectItem("Bulgaria"),
    new SelectItem("Canada"),
    new SelectItem("Czech Republic"),
    new SelectItem("Chile"),
    new SelectItem("China"),

};

    public SelectItem[] getCountries() {
        return countries;
    }

    public void setCountries(SelectItem[] countries) {
        this.countries = countries;
    }



    private SelectItem[] firstcontactmsgsze = {
    new SelectItem("Any size"),
    new SelectItem("50 characters +"),
    new SelectItem("100 characters +"),
    new SelectItem("200 characters +"),
    new SelectItem("300 characters +"),
    
};


      /**
     * @return the firstcontactmsgsze
     */
    public SelectItem[] getFirstcontactmsgsze() {
        return firstcontactmsgsze;
    }

    /**
     * @param firstcontactmsgsze the firstcontactmsgsze to set
     */
    public void setFirstcontactmsgsze(SelectItem[] firstcontactmsgsze) {
        this.firstcontactmsgsze = firstcontactmsgsze;
    }


    




private SelectItem[] age_from = {
    new SelectItem("18"),
    new SelectItem("19"),
    new SelectItem("20"),
    new SelectItem("21"),
    new SelectItem("22"),
    new SelectItem("23"),
    new SelectItem("24"),
    new SelectItem("25"),
    new SelectItem("26"),
    new SelectItem("27"),
    new SelectItem("28"),
    new SelectItem("29"),
    new SelectItem("30"),
    new SelectItem("31"),
    new SelectItem("32"),
    new SelectItem("33"),
    new SelectItem("34"),
    new SelectItem("35"),
    new SelectItem("36"),
    new SelectItem("37"),
    new SelectItem("38"),
    new SelectItem("39"),
    new SelectItem("40"),
    new SelectItem("41"),
    new SelectItem("42"),
    new SelectItem("43"),
    new SelectItem("44"),
    new SelectItem("45"),
    new SelectItem("46"),
    new SelectItem("47"),
    new SelectItem("48"),
    new SelectItem("49"),
    new SelectItem("50"),
    new SelectItem("51"),
    new SelectItem("52"),
    new SelectItem("53"),
    new SelectItem("54"),
    new SelectItem("55"),
    new SelectItem("56"),
    new SelectItem("57"),
    new SelectItem("58"),
    new SelectItem("59"),
    new SelectItem("60"),
    new SelectItem("61"),
    new SelectItem("62"),
    new SelectItem("63"),
    new SelectItem("64"),
    new SelectItem("65"),
    new SelectItem("66"),
    new SelectItem("67"),
    new SelectItem("68"),
    new SelectItem("69"),
    new SelectItem("70"),
    new SelectItem("71"),
    new SelectItem("72"),
    new SelectItem("73"),
    new SelectItem("74"),
    new SelectItem("75"),
    new SelectItem("76"),
    new SelectItem("77"),
    new SelectItem("78"),
    new SelectItem("79"),
    new SelectItem("80"),
    new SelectItem("81"),
    new SelectItem("82"),
    new SelectItem("83"),
    new SelectItem("84"),
    new SelectItem("85"),
    new SelectItem("86"),
    new SelectItem("87"),
    new SelectItem("88"),
    new SelectItem("89"),
    new SelectItem("90"),
    new SelectItem("91"),
    new SelectItem("92"),
    new SelectItem("93"),
    new SelectItem("94"),
    new SelectItem("95"),
    new SelectItem("96"),
    new SelectItem("97"),
    new SelectItem("98"),
    new SelectItem("99"),

};

/**
     * @return the age_from
     */
    public SelectItem[] getAge_from() {
        return age_from;
    }

    /**
     * @param age_from the age_from to set
     */
    public void setAge_from(SelectItem[] age_from) {
        this.age_from = age_from;
    }



private SelectItem[] age_to = {

    new SelectItem("18"),
    new SelectItem("19"),
    new SelectItem("20"),
    new SelectItem("21"),
    new SelectItem("22"),
    new SelectItem("23"),
    new SelectItem("24"),
    new SelectItem("25"),
    new SelectItem("26"),
    new SelectItem("27"),
    new SelectItem("28"),
    new SelectItem("29"),
    new SelectItem("30"),
    new SelectItem("31"),
    new SelectItem("32"),
    new SelectItem("33"),
    new SelectItem("34"),
    new SelectItem("35"),
    new SelectItem("36"),
    new SelectItem("37"),
    new SelectItem("38"),
    new SelectItem("39"),
    new SelectItem("40"),
    new SelectItem("41"),
    new SelectItem("42"),
    new SelectItem("43"),
    new SelectItem("44"),
    new SelectItem("45"),
    new SelectItem("46"),
    new SelectItem("47"),
    new SelectItem("48"),
    new SelectItem("49"),
    new SelectItem("50"),
    new SelectItem("51"),
    new SelectItem("52"),
    new SelectItem("53"),
    new SelectItem("54"),
    new SelectItem("55"),
    new SelectItem("56"),
    new SelectItem("57"),
    new SelectItem("58"),
    new SelectItem("59"),
    new SelectItem("60"),
    new SelectItem("61"),
    new SelectItem("62"),
    new SelectItem("63"),
    new SelectItem("64"),
    new SelectItem("65"),
    new SelectItem("66"),
    new SelectItem("67"),
    new SelectItem("68"),
    new SelectItem("69"),
    new SelectItem("70"),
    new SelectItem("71"),
    new SelectItem("72"),
    new SelectItem("73"),
    new SelectItem("74"),
    new SelectItem("75"),
    new SelectItem("76"),
    new SelectItem("77"),
    new SelectItem("78"),
    new SelectItem("79"),
    new SelectItem("80"),
    new SelectItem("81"),
    new SelectItem("82"),
    new SelectItem("83"),
    new SelectItem("84"),
    new SelectItem("85"),
    new SelectItem("86"),
    new SelectItem("87"),
    new SelectItem("88"),
    new SelectItem("89"),
    new SelectItem("90"),
    new SelectItem("91"),
    new SelectItem("92"),
    new SelectItem("93"),
    new SelectItem("94"),
    new SelectItem("95"),
    new SelectItem("96"),
    new SelectItem("97"),
    new SelectItem("98"),
    new SelectItem("99"),

};

   


   /**
     * @return the age_to
     */
    public SelectItem[] getAge_to() {
        return age_to;
    }

    /**
     * @param age_to the age_to to set
     */
    public void setAge_to(SelectItem[] age_to) {
        this.age_to = age_to;
    }



    





     private SelectItem[] withinn = {
    new SelectItem("75 miles"),
    new SelectItem("Any"),

};

   
 /**
     * @return the withinn
     */
    public SelectItem[] getWithinn() {
        return withinn;
    }

    /**
     * @param withinn the withinn to set
     */
    public void setWithinn(SelectItem[] withinn) {
        this.withinn = withinn;
    }
    


    /**
     * @return the hangout
     */
    public boolean isHangout() {
        return hangout;
    }

    /**
     * @param hangout the hangout to set
     */
    public void setHangout(boolean hangout) {
        this.hangout = hangout;
    }

   

    /**
     * @return the friendship
     */
    public boolean isFriendship() {
        return friendship;
    }

    /**
     * @param friendship the friendship to set
     */
    public void setFriendship(boolean friendship) {
        this.friendship = friendship;
    }

    /**
     * @return the activitypartner
     */
    public boolean isActivitypartner() {
        return activitypartner;
    }

    /**
     * @param activitypartner the activitypartner to set
     */
    public void setActivitypartner(boolean activitypartner) {
        this.activitypartner = activitypartner;
    }

    /**
     * @return the dating
     */
    public boolean isDating() {
        return dating;
    }

    /**
     * @param dating the dating to set
     */
    public void setDating(boolean dating) {
        this.dating = dating;
    }

    /**
     * @return the longterm
     */
    public boolean isLongterm() {
        return longterm;
    }

    /**
     * @param longterm the longterm to set
     */
    public void setLongterm(boolean longterm) {
        this.longterm = longterm;
    }

    /**
     * @return the intimateencounter
     */
    public boolean isIntimateencounter() {
        return intimateencounter;
    }

    /**
     * @param intimateencounter the intimateencounter to set
     */
    public void setIntimateencounter(boolean intimateencounter) {
        this.intimateencounter = intimateencounter;
    }

    /**
     * @return the talkemail
     */
    public boolean isTalkemail() {
        return talkemail;
    }

    /**
     * @param talkemail the talkemail to set
     */
    public void setTalkemail(boolean talkemail) {
        this.talkemail = talkemail;
    }

    /**
     * @return the otherrelationship
     */
    public boolean isOtherrelationship() {
        return otherrelationship;
    }

    /**
     * @param otherrelationship the otherrelationship to set
     */
    public void setOtherrelationship(boolean otherrelationship) {
        this.otherrelationship = otherrelationship;
    }

    /**
     * @return the usedrugs
     */
    public boolean isUsedrugs() {
        return usedrugs;
    }

    /**
     * @param usedrugs the usedrugs to set
     */
    public void setUsedrugs(boolean usedrugs) {
        this.usedrugs = usedrugs;
    }

    /**
     * @return the smoke
     */
    public boolean isSmoke() {
        return smoke;
    }

    /**
     * @param smoke the smoke to set
     */
    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }

    /**
     * @return the havmessageintenct
     */
    public boolean isHavmessageintenct() {
        return havmessageintenct;
    }

    /**
     * @param havmessageintenct the havmessageintenct to set
     */
    public void setHavmessageintenct(boolean havmessageintenct) {
        this.havmessageintenct = havmessageintenct;
    }

    /**
     * @return the email1
     */
    public boolean isEmail1() {
        return email1;
    }

    /**
     * @param email1 the email1 to set
     */
    public void setEmail1(boolean email1) {
        this.email1 = email1;
    }

    /**
     * @return the email2
     */
    public boolean isEmail2() {
        return email2;
    }

    /**
     * @param email2 the email2 to set
     */
    public void setEmail2(boolean email2) {
        this.email2 = email2;
    }

    /**
     * @return the email3
     */
    public boolean isEmail3() {
        return email3;
    }

    /**
     * @param email3 the email3 to set
     */
    public void setEmail3(boolean email3) {
        this.email3 = email3;
    }

    /**
     * @return the email4
     */
    public boolean isEmail4() {
        return email4;
    }

    /**
     * @param email4 the email4 to set
     */
    public void setEmail4(boolean email4) {
        this.email4 = email4;
    }

    /**
     * @return the email5
     */
    public boolean isEmail5() {
        return email5;
    }

    /**
     * @param email5 the email5 to set
     */
    public void setEmail5(boolean email5) {
        this.email5 = email5;
    }

 

     
















}
