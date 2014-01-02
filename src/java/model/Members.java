/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Chris Mitchell
 */
@Entity
@Table(name = "members")

@NamedQueries({

    @NamedQuery(name = "Members.findAll", query = "SELECT m FROM Members m"),
    @NamedQuery(name = "Members.findByUserid", query = "SELECT m FROM Members m WHERE m.userid = :userid"),
    @NamedQuery(name = "Members.findByUsername", query = "SELECT m FROM Members m WHERE m.username = :username"),
    @NamedQuery(name = "Members.findByPassword", query = "SELECT m FROM Members m WHERE m.password = :password"),
    @NamedQuery(name = "Members.findByNow", query = "SELECT m FROM Members m WHERE m.now = :now"),
    @NamedQuery(name = "Members.findByEmail", query = "SELECT m FROM Members m WHERE m.email = :email"),
    @NamedQuery(name = "Members.findByImageurl", query = "SELECT m FROM Members m WHERE m.imageurl = :imageurl"),
    @NamedQuery(name = "Members.findByBirthMonth", query = "SELECT m FROM Members m WHERE m.birthMonth = :birthMonth"),
    @NamedQuery(name = "Members.findByBirthDay", query = "SELECT m FROM Members m WHERE m.birthDay = :birthDay"),
    @NamedQuery(name = "Members.findByBirthYear", query = "SELECT m FROM Members m WHERE m.birthYear = :birthYear"),
    @NamedQuery(name = "Members.findByCity", query = "SELECT m FROM Members m WHERE m.city = :city"),
    @NamedQuery(name = "Members.findByStates", query = "SELECT m FROM Members m WHERE m.states = :states"),
    @NamedQuery(name = "Members.findByCountry", query = "SELECT m FROM Members m WHERE m.country = :country"),
    @NamedQuery(name = "Members.findByZipcode", query = "SELECT m FROM Members m WHERE m.zipcode = :zipcode"),
    @NamedQuery(name = "Members.findByLat", query = "SELECT m FROM Members m WHERE m.lat = :lat"),
    @NamedQuery(name = "Members.findByLon", query = "SELECT m FROM Members m WHERE m.lon = :lon"),
    @NamedQuery(name = "Members.findByGender", query = "SELECT m FROM Members m WHERE m.gender = :gender"),
    @NamedQuery(name = "Members.findBySeekingA", query = "SELECT m FROM Members m WHERE m.seekingA = :seekingA"),
    @NamedQuery(name = "Members.findByLookingFor", query = "SELECT m FROM Members m WHERE m.lookingFor = :lookingFor"),
    @NamedQuery(name = "Members.findByAim", query = "SELECT m FROM Members m WHERE m.aim = :aim"),
    @NamedQuery(name = "Members.findBySign", query = "SELECT m FROM Members m WHERE m.sign = :sign"),
    @NamedQuery(name = "Members.findByEthnicity", query = "SELECT m FROM Members m WHERE m.ethnicity = :ethnicity"),
    @NamedQuery(name = "Members.findByHeight", query = "SELECT m FROM Members m WHERE m.height = :height"),
    @NamedQuery(name = "Members.findByHairColor", query = "SELECT m FROM Members m WHERE m.hairColor = :hairColor"),
    @NamedQuery(name = "Members.findByBodyType", query = "SELECT m FROM Members m WHERE m.bodyType = :bodyType"),
    @NamedQuery(name = "Members.findByCar", query = "SELECT m FROM Members m WHERE m.car = :car"),
    @NamedQuery(name = "Members.findByEducation", query = "SELECT m FROM Members m WHERE m.education = :education"),
    @NamedQuery(name = "Members.findByHasChildren", query = "SELECT m FROM Members m WHERE m.hasChildren = :hasChildren"),
    @NamedQuery(name = "Members.findByWantsChildren", query = "SELECT m FROM Members m WHERE m.wantsChildren = :wantsChildren"),
    @NamedQuery(name = "Members.findByMarried", query = "SELECT m FROM Members m WHERE m.married = :married"),
    @NamedQuery(name = "Members.findBySmoker", query = "SELECT m FROM Members m WHERE m.smoker = :smoker"),
    @NamedQuery(name = "Members.findByDrink", query = "SELECT m FROM Members m WHERE m.drink = :drink"),
    @NamedQuery(name = "Members.findByDrugs", query = "SELECT m FROM Members m WHERE m.drugs = :drugs"),
    @NamedQuery(name = "Members.findByReligion", query = "SELECT m FROM Members m WHERE m.religion = :religion"),
    @NamedQuery(name = "Members.findByIncome", query = "SELECT m FROM Members m WHERE m.income = :income"),
    @NamedQuery(name = "Members.findByProfession", query = "SELECT m FROM Members m WHERE m.profession = :profession"),
    @NamedQuery(name = "Members.findByHeadline", query = "SELECT m FROM Members m WHERE m.headline = :headline"),
    @NamedQuery(name = "Members.findBySearchrankscore", query = "SELECT m FROM Members m WHERE m.searchrankscore = :searchrankscore"),
    @NamedQuery(name = "Members.findByPercent1", query = "SELECT m FROM Members m WHERE m.percent1 = :percent1"),
    @NamedQuery(name = "Members.findByPercent2", query = "SELECT m FROM Members m WHERE m.percent2 = :percent2"),
    @NamedQuery(name = "Members.findByPercent3", query = "SELECT m FROM Members m WHERE m.percent3 = :percent3"),

  @NamedQuery(name = "Members.findByPointsPhotos", query = "SELECT m FROM Members m WHERE m.pointsPhotos = :pointsPhotos"),
    @NamedQuery(name = "Members.findByPointsProfile", query = "SELECT m FROM Members m WHERE m.pointsProfile = :pointsProfile"),
    @NamedQuery(name = "Members.findByPointsFirstmessage", query = "SELECT m FROM Members m WHERE m.pointsFirstmessage = :pointsFirstmessage"),
    @NamedQuery(name = "Members.findByPointsFunny", query = "SELECT m FROM Members m WHERE m.pointsFunny = :pointsFunny"),
    @NamedQuery(name = "Members.findByPointsInteresting", query = "SELECT m FROM Members m WHERE m.pointsInteresting = :pointsInteresting"),
    @NamedQuery(name = "Members.findByPointsPersonality", query = "SELECT m FROM Members m WHERE m.pointsPersonality = :pointsPersonality"),
    @NamedQuery(name = "Members.findByPointsFirstdate", query = "SELECT m FROM Members m WHERE m.pointsFirstdate = :pointsFirstdate"),
    @NamedQuery(name = "Members.findByPointsDateidea", query = "SELECT m FROM Members m WHERE m.pointsDateidea = :pointsDateidea"),
    @NamedQuery(name = "Members.findByPointsVerifyprofile", query = "SELECT m FROM Members m WHERE m.pointsVerifyprofile = :pointsVerifyprofile")})



        public class Members implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Long userid =112321321L;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "now")
    private String now ="offline";
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "imageurl")
    private String imageurl ="yes";
    @Basic(optional = false)
    @Column(name = "birth_month")
    private String birthMonth;
    @Basic(optional = false)
    @Column(name = "birth_day")
    private String birthDay;
    @Basic(optional = false)
    @Column(name = "birth_year")
    private String birthYear;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "states")
    private String states;
    @Basic(optional = false)
    @Column(name = "country")
    private String country ="United States";
    @Basic(optional = false)
    @Column(name = "zipcode")
    private String zipcode;
    @Basic(optional = false)
    @Column(name = "lat")
    private float lat;
    @Basic(optional = false)
    @Column(name = "lon")
    private float lon;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "seeking_a")
    private String seekingA;
    @Basic(optional = false)
    @Column(name = "looking_for")
    private String lookingFor;
    @Basic(optional = false)
    @Column(name = "aim")
    private String aim="";
    @Basic(optional = false)
    @Column(name = "sign")
    private String sign  ="";
    @Basic(optional = false)
    @Column(name = "ethnicity")
    private String ethnicity  ="";
    @Basic(optional = false)
    @Column(name = "height")
    private String height  ="";
    @Basic(optional = false)
    @Column(name = "hair_color")
    private String hairColor  ="";
    @Basic(optional = false)
    @Column(name = "body_type")
    private String bodyType  ="";
    @Basic(optional = false)
    @Column(name = "car")
    private String car  ="";
    @Basic(optional = false)
    @Column(name = "education")
    private String education  ="";
    @Basic(optional = false)
    @Column(name = "has_children")
    private String hasChildren  ="";
    @Basic(optional = false)
    @Column(name = "wants_children")
    private String wantsChildren  ="";
    @Basic(optional = false)
    @Column(name = "married")
    private String married  ="";
    @Basic(optional = false)
    @Column(name = "smoker")
    private String smoker  ="";
    @Basic(optional = false)
    @Column(name = "drink")
    private String drink  ="";
    @Basic(optional = false)
    @Column(name = "drugs")
    private String drugs  ="";
    @Basic(optional = false)
    @Column(name = "religion")
    private String religion  ="";
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description  ="";
    @Basic(optional = false)
    @Column(name = "income")
    private String income  ="";
    @Basic(optional = false)
    @Column(name = "profession")
    private String profession  ="";
    @Basic(optional = false)
    @Column(name = "headline")
    private String headline;
    @Basic(optional = false)
    @Lob
    @Column(name = "interests")
    private String interests  ="";
    @Basic(optional = false)
    @Column(name = "searchrankscore")
    private int searchrankscore =0;
    @Basic(optional = false)
    @Column(name = "percent1")
    private String percent1 ="";
    @Basic(optional = false)
    @Column(name = "percent2")
    private String percent2 = "";
    @Basic(optional = false)
    @Column(name = "percent3")
    private String percent3 ="";

    @Basic(optional = false)
    @Column(name = "points_photos")
    private int pointsPhotos =0;

    @Basic(optional = false)
    @Column(name = "points_profile")
    private int pointsProfile =0;

    @Basic(optional = false)
    @Column(name = "points_firstmessage")
    private int pointsFirstmessage =0;

    @Basic(optional = false)
    @Column(name = "points_funny")
    private int pointsFunny =0;

    @Basic(optional = false)
    @Column(name = "points_interesting")
    private int pointsInteresting =0;

    @Basic(optional = false)
    @Column(name = "points_personality")
    private int pointsPersonality =0;

    @Basic(optional = false)
    @Column(name = "points_firstdate")
    private int pointsFirstdate =0;

    @Basic(optional = false)
    @Column(name = "points_dateidea")
    private int pointsDateidea =0;

    @Basic(optional = false)
    @Column(name = "points_verifyprofile")
    private int pointsVerifyprofile =0;



    public Members() {
    }

    public Members(Long userid) {
        this.userid = userid;
    }

    public Members(Long userid, String username, String password, String now, String email, String imageurl, String birthMonth, String birthDay, String birthYear, String city, String states, String country, String zipcode, float lat, float lon, String gender, String seekingA, String lookingFor, String aim, String sign, String ethnicity, String height, String hairColor, String bodyType, String car, String education, String hasChildren, String wantsChildren, String married, String smoker, String drink, String drugs, String religion, String description, String income, String profession, String headline, String interests, int searchrankscore, String percent1, String percent2, String percent3, int pointPhotos, int pointsProfile, int pointsFirstmessage, int pointsFunny, int pointsInteresting, int pointsPersonality, int pointsFirstdate, int pointsDateidea, int pointsVerifyprofile) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.now = now;
        this.email = email;
        this.imageurl = imageurl;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
        this.city = city;
        this.states = states;
        this.country = country;
        this.zipcode = zipcode;
        this.lat = lat;
        this.lon = lon;
        this.gender = gender;
        this.seekingA = seekingA;
        this.lookingFor = lookingFor;
        this.aim = aim;
        this.sign = sign;
        this.ethnicity = ethnicity;
        this.height = height;
        this.hairColor = hairColor;
        this.bodyType = bodyType;
        this.car = car;
        this.education = education;
        this.hasChildren = hasChildren;
        this.wantsChildren = wantsChildren;
        this.married = married;
        this.smoker = smoker;
        this.drink = drink;
        this.drugs = drugs;
        this.religion = religion;
        this.description = description;
        this.income = income;
        this.profession = profession;
        this.headline = headline;
        this.interests = interests;
        this.searchrankscore = searchrankscore;
        this.percent1 = percent1;
        this.percent2 = percent2;
        this.percent3 = percent3;

        this.pointsPhotos = pointsPhotos;
        this.pointsProfile = pointsProfile;
        this.pointsFirstmessage = pointsFirstmessage;
        this.pointsFunny = pointsFunny;
        this.pointsInteresting = pointsInteresting;
        this.pointsPersonality = pointsPersonality;
        this.pointsFirstdate = pointsFirstdate;
        this.pointsDateidea = pointsDateidea;
        this.pointsVerifyprofile = pointsVerifyprofile;


    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSeekingA() {
        return seekingA;
    }

    public void setSeekingA(String seekingA) {
        this.seekingA = seekingA;
    }

    public String getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor) {
        this.lookingFor = lookingFor;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(String hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getWantsChildren() {
        return wantsChildren;
    }

    public void setWantsChildren(String wantsChildren) {
        this.wantsChildren = wantsChildren;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getSmoker() {
        return smoker;
    }

    public void setSmoker(String smoker) {
        this.smoker = smoker;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public int getSearchrankscore() {
        return searchrankscore;
    }

    public void setSearchrankscore(int searchrankscore) {
        this.searchrankscore = searchrankscore;
    }

    public String getPercent1() {
        return percent1;
    }

    public void setPercent1(String percent1) {
        this.percent1 = percent1;
    }

    public String getPercent2() {
        return percent2;
    }

    public void setPercent2(String percent2) {
        this.percent2 = percent2;
    }

    public String getPercent3() {
        return percent3;
    }

    public void setPercent3(String percent3) {
        this.percent3 = percent3;
    }








    /**
     * @return the pointsPhotos
     */
    public int getPointsPhotos() {
        return pointsPhotos;
    }

    /**
     * @param pointsPhotos the pointsPhotos to set
     */
    public void setPointsPhotos(int pointsPhotos) {
        this.pointsPhotos = pointsPhotos;
    }

    /**
     * @return the pointsProfile
     */
    public int getPointsProfile() {
        return pointsProfile;
    }

    /**
     * @param pointsProfile the pointsProfile to set
     */
    public void setPointsProfile(int pointsProfile) {
        this.pointsProfile = pointsProfile;
    }

    /**
     * @return the pointsFirstmessage
     */
    public int getPointsFirstmessage() {
        return pointsFirstmessage;
    }

    /**
     * @param pointsFirstmessage the pointsFirstmessage to set
     */
    public void setPointsFirstmessage(int pointsFirstmessage) {
        this.pointsFirstmessage = pointsFirstmessage;
    }

    /**
     * @return the pointsFunny
     */
    public int getPointsFunny() {
        return pointsFunny;
    }

    /**
     * @param pointsFunny the pointsFunny to set
     */
    public void setPointsFunny(int pointsFunny) {
        this.pointsFunny = pointsFunny;
    }

    /**
     * @return the pointsInteresting
     */
    public int getPointsInteresting() {
        return pointsInteresting;
    }

    /**
     * @param pointsInteresting the pointsInteresting to set
     */
    public void setPointsInteresting(int pointsInteresting) {
        this.pointsInteresting = pointsInteresting;
    }

    /**
     * @return the pointsPersonality
     */
    public int getPointsPersonality() {
        return pointsPersonality;
    }

    /**
     * @param pointsPersonality the pointsPersonality to set
     */
    public void setPointsPersonality(int pointsPersonality) {
        this.pointsPersonality = pointsPersonality;
    }

    /**
     * @return the pointsFirstdate
     */
    public int getPointsFirstdate() {
        return pointsFirstdate;
    }

    /**
     * @param pointsFirstdate the pointsFirstdate to set
     */
    public void setPointsFirstdate(int pointsFirstdate) {
        this.pointsFirstdate = pointsFirstdate;
    }

    /**
     * @return the pointsDateidea
     */
    public int getPointsDateidea() {
        return pointsDateidea;
    }

    /**
     * @param pointsDateidea the pointsDateidea to set
     */
    public void setPointsDateidea(int pointsDateidea) {
        this.pointsDateidea = pointsDateidea;
    }

    /**
     * @return the pointsVerifyprofile
     */
    public int getPointsVerifyprofile() {
        return pointsVerifyprofile;
    }

    /**
     * @param pointsVerifyprofile the pointsVerifyprofile to set
     */
    public void setPointsVerifyprofile(int pointsVerifyprofile) {
        this.pointsVerifyprofile = pointsVerifyprofile;
    }








    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Members)) {
            return false;
        }
        Members other = (Members) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Members[userid=" + userid + "]";
    }








}
