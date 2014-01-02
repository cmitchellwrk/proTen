/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apache.myfaces.examples.misc;


import java.lang.Integer;
import javax.faces.model.SelectItem;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;





/**
 *
 * @author chris mitchell
 */
@ManagedBean    (name = "MemberLoginBean")

@RequestScoped
public class MemberLoginBean {

    /** Creates a new instance of MemberLoginBean */
    public MemberLoginBean() {

    }

    
    private String username;

    private String Password;

    private String imageurl;

    private float lon;

    private float lat;

    private String email;

    private String birth_month;

    private String birth_day;

    private int birth_year;

    private String city;

    private String country;

    private String zipcode;

    private String gender;

    private String seeking_a;

    private String looking_for;

    private String sign;

    private String ethnicity;

    private String height;

    private String hair_color;

    private String body_type;

    private String car;

    private String education;

    private String has_children;

    private String wants_children;

    private String married;

    private String smoker;

    private String drink;

    private String drugs;

    private String religion;

    private String description;

    private String income;

    private String profession;

    private String headline;

    private String interests;




 private SelectItem  [] b_year = {

    new SelectItem("1992"),
    new SelectItem("1991"),
    new SelectItem("1990"),
    new SelectItem("1989"),
    new SelectItem("1988"),
    new SelectItem("1987"),
    new SelectItem("1986"),
    new SelectItem("1985"),
    new SelectItem("1984"),
    new SelectItem("1983"),
    new SelectItem("1982"),
    new SelectItem("1981"),
    new SelectItem("1980"),
    new SelectItem("1979"),
    new SelectItem("1978"),
    new SelectItem("1977"),
    new SelectItem("1976"),
    new SelectItem("1975"),
    new SelectItem("1974"),
    new SelectItem("1973"),
    new SelectItem("1972"),
    new SelectItem("1971"),
    new SelectItem("1970"),
    new SelectItem("1969"),
    new SelectItem("1968"),
    new SelectItem("1967"),
    new SelectItem("1966"),
    new SelectItem("1965"),
    new SelectItem("1964"),
    new SelectItem("1963"),
    new SelectItem("1962"),
    new SelectItem("1961"),
    new SelectItem("1960"),
    new SelectItem("1959"),
    new SelectItem("1958"),
    new SelectItem("1957"),
    new SelectItem("1956"),
    new SelectItem("1955"),
    new SelectItem("1954"),
    new SelectItem("1953"),
    new SelectItem("1952"),
    new SelectItem("1951"),
    new SelectItem("1950"),
    new SelectItem("1949"),
    new SelectItem("1948"),
    new SelectItem("1947"),
    new SelectItem("1946"),
    new SelectItem("1945"),
    new SelectItem("1944"),
    new SelectItem("1943"),
    new SelectItem("1942"),
    new SelectItem("1941"),
    new SelectItem("1940"),
    new SelectItem("1939"),
    new SelectItem("1938"),
    new SelectItem("1937"),
    new SelectItem("1936"),
    new SelectItem("1935"),
    new SelectItem("1934"),
    new SelectItem("1933"),
    new SelectItem("1932"),
    new SelectItem("1931"),
    new SelectItem("1930"),



};


public SelectItem[] getB_year() {
        return b_year;
    }

    public void setB_year(SelectItem[] b_year) {
        this.b_year = b_year;
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





    private SelectItem[] state = {

    new SelectItem("Alabama"),
    new SelectItem("Alaska"),
    new SelectItem("American Samoa"),
    new SelectItem("Arizona"),
    new SelectItem("Arkansas"),
    new SelectItem("California"),
    new SelectItem("Colorado"),
    new SelectItem("Connecticut"),
    new SelectItem("Delaware"),
    new SelectItem("District of Columbia"),
    new SelectItem("Florida"),
    new SelectItem("Georgia"),
    new SelectItem("Guam"),
    new SelectItem("Hawaii"),
    new SelectItem("Idaho"),
    new SelectItem("Illinois"),
    new SelectItem("Indiana"),
    new SelectItem("Iowa"),
    new SelectItem("Kansas"),
    new SelectItem("Kentucky"),
    new SelectItem("Louisiana"),
    new SelectItem("Maine"),
    new SelectItem("Maryland"),
    new SelectItem("Minnesota"),
    new SelectItem("Michigan"),
    new SelectItem("Minnesota"),
    new SelectItem("Massachusetts"),
    new SelectItem("Mississippi"),
    new SelectItem("Missouri"),
    new SelectItem("Montana"),
    new SelectItem("Nebraska"),
    new SelectItem("Nevada"),
    new SelectItem("New Hampshire"),
    new SelectItem("New Jersey"),
    new SelectItem("New Mexico"),
    new SelectItem("New York"),
    new SelectItem("North Carolina"),
    new SelectItem("North Dakota"),
    new SelectItem("Northern Marianas Islands"),
    new SelectItem("Ohio"),
    new SelectItem("Oklahoma"),
    new SelectItem("Oregon"),
    new SelectItem("Pennsylvania"),
    new SelectItem("Puerto Rico"),
    new SelectItem("Rhode Island"),
    new SelectItem("South Carolina"),
    new SelectItem("South Dakota"),
    new SelectItem("Tennessee"),
    new SelectItem("Texas"),
    new SelectItem("Utah"),
    new SelectItem("Vermont") ,
    new SelectItem("Virginia"),
    new SelectItem("Virgin Islands"),
    new SelectItem("Washington"),
    new SelectItem("West Virginia"),
    new SelectItem("Wisconsin"),
    new SelectItem("Wyoming"),

    };


 /**
     * @return the state
     */
    public SelectItem[] getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(SelectItem[] state) {
        this.state = state;
    }









private SelectItem[] miles = {
    
    new SelectItem("5"),
    new SelectItem("10"),
    new SelectItem("15"),
    new SelectItem("25"),
    new SelectItem("35"),
    new SelectItem("50"),
    new SelectItem("75"),
    new SelectItem("100"),
    new SelectItem("150"),
    new SelectItem("200"),
    new SelectItem("300"),

};

 /**
     * @return the miles
     */
    public SelectItem[] getMiles() {
        return miles;
    }

    /**
     * @param miles the miles to set
     */
    public void setMiles(SelectItem[] miles) {
        this.miles = miles;
    }






private SelectItem[] pointssearch = {
    new SelectItem("0"),
    new SelectItem("5"),
    new SelectItem("10"),
    new SelectItem("15"),
    new SelectItem("20"),
    new SelectItem("30"),
    new SelectItem("50"),

};


 /**
     * @return the pointssearch
     */
    public SelectItem[] getPointssearch() {
        return pointssearch;
    }

    /**
     * @param pointssearch the pointssearch to set
     */
    public void setPointssearch(SelectItem[] pointssearch) {
        this.pointssearch = pointssearch;
    }



    


 private SelectItem[] b_day = {
    new SelectItem("1"),
    new SelectItem("2"),
    new SelectItem("3"),
    new SelectItem("4"),
    new SelectItem("5"),
    new SelectItem("6"),
    new SelectItem("7"),
    new SelectItem("8"),
    new SelectItem("9"),
    new SelectItem("10"),
    new SelectItem("11"),
    new SelectItem("12"),
    new SelectItem("13"),
    new SelectItem("14"),
    new SelectItem("15"),
    new SelectItem("16"),
    new SelectItem("17"),
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
};


 public SelectItem[] getB_day() {
        return b_day;
    }

    public void setB_day(SelectItem[] b_day) {
        this.b_day = b_day;
    }


 private SelectItem[] b_month = {
    new SelectItem("january"),
    new SelectItem("february"),
    new SelectItem("march"),
    new SelectItem("april"),
    new SelectItem("may"),
    new SelectItem("june"),
    new SelectItem("july"),
    new SelectItem("august"),
    new SelectItem("april"),
    new SelectItem("may"),
    new SelectItem("june"),
    new SelectItem("july"),
    new SelectItem("august"),
    new SelectItem("september"),
    new SelectItem("october"),
    new SelectItem("november"),
    new SelectItem("december"),

};

    public SelectItem[] getB_month() {
        return b_month;
    }

    public void setB_month(SelectItem[] b_month) {
        this.b_month = b_month;
    }











 private SelectItem[] income_level = {
    new SelectItem("less than 25,000"),
    new SelectItem("25,001-35,000"),
    new SelectItem("35,001-50,000"),
    new SelectItem("50,001-75,000"),
    new SelectItem("75,001-100,000"),
    new SelectItem("100,001-150,000"),
    new SelectItem("over 150,000"),

};

    public SelectItem[] getIncome_level() {
        return income_level;
    }

    public void setIncome_level(SelectItem[] income_level) {
        this.income_level = income_level;
    }



     private SelectItem[] aim = {
    new SelectItem("I am looking for casual dating/No commitment"),
    new SelectItem("I want to date but nothing serious"),
    new SelectItem("I want a relationship"),
    new SelectItem("I am putting serious effort onto finding someone"),
    new SelectItem("I am serious and I want to find someone to marry"),

};

      /**
     * @return the aim
     */
    public SelectItem[] getAim() {
        return aim;
    }

    /**
     * @param aim the aim to set
     */
    public void setAim(SelectItem[] aim) {
        this.aim = aim;
    }


     

     private SelectItem[] datecatagory = {
    new SelectItem("Eat"),
    new SelectItem("Drink-cafe"),
    new SelectItem("Drink-bar"),
    new SelectItem("Listen/Watch"),
    new SelectItem("Play"),
    new SelectItem("Explore"),
    new SelectItem("Volunteer"),
    new SelectItem("Shop"),
    new SelectItem("Other"),
};




      /**
     * @return the datecatagory
     */
    public SelectItem[] getDatecatagory() {
        return datecatagory;
    }

    /**
     * @param datecatagory the datecatagory to set
     */
    public void setDatecatagory(SelectItem[] datecatagory) {
        this.datecatagory = datecatagory;
    }





    private SelectItem[] religions = {
    new SelectItem("non-religious"),
    new SelectItem("new age"),
    new SelectItem("islamic"),
    new SelectItem("jewish"),
    new SelectItem("catholic"),
    new SelectItem("buddhist"),
    new SelectItem("hindu"),
    new SelectItem("anglican"),
    new SelectItem("sikh"),
    new SelectItem("methodist"),
    new SelectItem("christian-other"),
    new SelectItem("baptist"),
    new SelectItem("lutheran"),
    new SelectItem("presbyterian"),
    new SelectItem("other"),

};

    public SelectItem[] getReligions() {
        return religions;
    }

    public void setReligions(SelectItem[] religions) {
        this.religions = religions;
    }


     private SelectItem[] drink_habit = {
    new SelectItem("Prefer Not To Say"),
    new SelectItem("No"),
    new SelectItem("Often"),
    new SelectItem("Socially"),



};

    public SelectItem[] getDrink_habit() {
        return drink_habit;
    }

    public void setDrink_habit(SelectItem[] drink_habit) {
        this.drink_habit = drink_habit;
    }


     private SelectItem[] drug_use = {
    new SelectItem("Prefer Not To Say"),
    new SelectItem("No"),
    new SelectItem("Socially"),
    new SelectItem("Often"),

};

    public SelectItem[] getDrug_use() {
        return drug_use;
    }

    public void setDrug_use(SelectItem[] drug_use) {
        this.drug_use = drug_use;
    }



     private SelectItem[] smoking = {
    new SelectItem("Prefer Not To Say"),
    new SelectItem("No"),
    new SelectItem("Occassionally"),
    new SelectItem("Often"),

};

    public SelectItem[] getSmoking() {
        return smoking;
    }

    public void setSmoking(SelectItem[] smoking) {
        this.smoking = smoking;
    }



    private SelectItem[] marital_status = {
    new SelectItem("Single"),
    new SelectItem("Married"),
    new SelectItem("Living Together"),
    new SelectItem("Divorced"),
    new SelectItem("Widowed"),
    new SelectItem("Not Single/Not Looking"),
};

    public SelectItem[] getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(SelectItem[] marital_status) {
        this.marital_status = marital_status;
    }



    private SelectItem[] wants_kids = {
    new SelectItem("Prefer Not To Say"),
    new SelectItem("Wants Children"),
    new SelectItem("Does Not Want Children"),
    new SelectItem("Undecided/Open"),

};

    public SelectItem[] getWants_kids() {
        return wants_kids;
    }

    public void setWants_kids(SelectItem[] wants_kids) {
        this.wants_kids = wants_kids;
    }



    private SelectItem[] kids = {
    new SelectItem("Yes"),
    new SelectItem("No"),
    new SelectItem("All My Kids Are Grown/Over 18+"),

};

    public SelectItem[] getKids() {
        return kids;
    }

    public void setKids(SelectItem[] kids) {
        this.kids = kids;
    }


    private SelectItem[] education_levels = {
    new SelectItem("High School"),
    new SelectItem("Some College"),
    new SelectItem("Some University"),
    new SelectItem("Associates Degree"),
    new SelectItem("Graduate Degree"),
    new SelectItem("Phd/Post Doctoral"),
    new SelectItem("Bachelors Degree"),
    new SelectItem("Master Degree"),
};

    public SelectItem[] getEducation_levels() {
        return education_levels;
    }

    public void setEducation_levels(SelectItem[] education_levels) {
        this.education_levels = education_levels;
    }



     private SelectItem[] ynp = {
    new SelectItem("Prefer Not To Say"),
    new SelectItem("Yes"),
    new SelectItem("No"),

};

    public SelectItem[] getYnp() {
        return ynp;
    }

    public void setYnp(SelectItem[] ynp) {
        this.ynp = ynp;
    }

 private SelectItem[] body_types = {
    new SelectItem("Prefer Not To Say"),
    new SelectItem("Thin"),
    new SelectItem("Fit"),
    new SelectItem("Athletic"),
    new SelectItem("Average"),
    new SelectItem("A Few Pounds"),
    new SelectItem("Big and Tall/BBW"),

};

    public SelectItem[] getBody_types() {
        return body_types;
    }

    public void setBody_types(SelectItem[] body_types) {
        this.body_types = body_types;
    }


    private SelectItem[] hair = {
    new SelectItem("Brown"),
    new SelectItem("Blond"),
    new SelectItem("Black"),
    new SelectItem("Red"),
    new SelectItem("Gray"),
    new SelectItem("Bald"),
    new SelectItem("Mixed Color"),
};

    public SelectItem[] getHair() {
        return hair;
    }

    public void setHair(SelectItem[] hair) {
        this.hair = hair;
    }


    private SelectItem[] heights = {

    new SelectItem("< 5'(<152cm)"),
    new SelectItem("5'0(152cm)"),
    new SelectItem("5'1(155cm)"),
    new SelectItem("5'2(157cm)"),
    new SelectItem("5'3(160cm)"),
    new SelectItem("5'4(163cm)"),
    new SelectItem("5'5(165cm)"),
    new SelectItem("5'6(168cm)"),
    new SelectItem("5'7(170cm)"),
    new SelectItem("5'8(173cm)"),
    new SelectItem("5'9(175cm)"),
    new SelectItem("5'10(175cm)"),
    new SelectItem("5'11(180cm)"),
    new SelectItem("6'0(183cm)"),
    new SelectItem("6'1(185cm)"),
    new SelectItem("6'2(188cm)"),
    new SelectItem("6'3(191cm)"),
    new SelectItem("6'4(193cm)"),
    new SelectItem("6'5(196cm)"),
};

    public SelectItem[] getHeights() {
        return heights;
    }

    public void setHeights(SelectItem[] heights) {
        this.heights = heights;
    }


    private SelectItem[] wants = {
    new SelectItem("Hang Out"),
    new SelectItem("Friends"),
    new SelectItem("Activity Partner"),
    new SelectItem("Dating"),
    new SelectItem("Long-term"),
    new SelectItem("Intimate Encounter"),
    new SelectItem("Talk/E-mail"),   
    new SelectItem("Other Relationship"),
    
    

};

    public SelectItem[] getWants() {
        return wants;
    }

    public void setWants(SelectItem[] wants) {
        this.wants = wants;
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



   private SelectItem[] gend = {
    new SelectItem("Female"),
    new SelectItem("Male"),

};

    public SelectItem[] getGend() {
        return gend;
    }

    public void setGend(SelectItem[] gend) {
        this.gend = gend;
    }

    private SelectItem[] ethnic = {

    new SelectItem("All Ethnicities"),
    new SelectItem("Caucasian"),
    new SelectItem("Black"),
    new SelectItem("European"),
    new SelectItem("Hispanic"),
    new SelectItem("Indian"),
    new SelectItem("Middle Eastern"),
    new SelectItem("Native American"),
    new SelectItem("Asian"),
    new SelectItem("Mixed Race"),
    new SelectItem("Other Ethnicity"),

};


    public SelectItem[] getEthnic() {
        return ethnic;
    }

    public void setEthnic(SelectItem[] ethnic) {
        this.ethnic = ethnic;
    }



   private SelectItem[] signs = {
    new SelectItem("Aries"),
    new SelectItem("Taurus"),
    new SelectItem("Gemini"),
    new SelectItem("Cancer"),
    new SelectItem("Leo"),
    new SelectItem("Virgo"),
    new SelectItem("Libra"),
    new SelectItem("Scorpio"),
    new SelectItem("Sagittarius"),
    new SelectItem("Capricorn"),
    new SelectItem("Aquarius"),
    new SelectItem("Pisces"),
};

    public SelectItem[] getSigns() {
        return signs;
    }

    public void setSigns(SelectItem[] signs) {
        this.signs = signs;
    }

   



 private SelectItem[] reasondelete = {
    new SelectItem("Didn't find anyone I liked."),
    new SelectItem("I'd rather use another site"),
    new SelectItem("Too many jerks, rude and/or mean people"),
    new SelectItem("Found someone offline"),
    new SelectItem("Found someone on another site"),
    new SelectItem("I found someon on Chemispark"),
    new SelectItem("Not enough good matches for me"),


};

    /**
     * @return the reasondelete
     */
    public SelectItem[] getReasondelete() {
        return reasondelete;
    }

    /**
     * @param reasondelete the reasondelete to set
     */
    public void setReasondelete(SelectItem[] reasondelete) {
        this.reasondelete = reasondelete;
    }

    



 private SelectItem[] numofdates = {
    new SelectItem("1"),
    new SelectItem("2"),
    new SelectItem("3"),
    new SelectItem("4"),
    new SelectItem("5"),
    new SelectItem("6"),
    new SelectItem("7"),
    new SelectItem("8"),
    new SelectItem("8+"),
   

};

    /**
     * @return the numofdates
     */
    public SelectItem[] getNumofdates() {
        return numofdates;
    }

    /**
     * @param numofdates the numofdates to set
     */
    public void setNumofdates(SelectItem[] numofdates) {
        this.numofdates = numofdates;
    }





 private SelectItem[] recomendation = {
    new SelectItem("yes"),
    new SelectItem("no"),
   
};

    /**
     * @return the recomendation
     */
    public SelectItem[] getRecomendation() {
        return recomendation;
    }

    /**
     * @param recomendation the recomendation to set
     */
    public void setRecomendation(SelectItem[] recomendation) {
        this.recomendation = recomendation;
    }

   





}
