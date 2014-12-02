package model;

import java.io.Serializable;

/**
 * Created by Jakob on 06-11-2014.
 */
public class Person implements Serializable {
    private static int count = 1;
    private int id;
    private String name;
    private String occupation;
    private String empCat;
    private int ageCategory;
    private String taxId;
    private boolean usCitizen;
    private String gender;


    public Person(String name, String occupation, String empCat,
                  int ageCategory, String taxId, boolean usCitizen, String gender) {
        this.name = name;
        this.occupation = occupation;
        this.empCat = empCat;
        this.ageCategory = ageCategory;
        this.taxId = taxId;
        this.usCitizen = usCitizen;
        this.gender = gender;

        this.id = count;
        count++;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmpCat() {
        return empCat;
    }

    public void setEmpCat(String empCat) {
        this.empCat = empCat;
    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public boolean isUsCitizen() {
        return usCitizen;
    }

    public void setUsCitizen(boolean usCitizen) {
        this.usCitizen = usCitizen;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
