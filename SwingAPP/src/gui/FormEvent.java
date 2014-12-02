package gui;

import java.util.EventObject;

/**
 * Created by Jakob on 03-11-2014.
 */
public class FormEvent extends EventObject {
    private String name;
    private String occupation;
    private String empCat;
    private int ageCategory;
    private String taxId;
    private boolean usCitizen;
    private String gender;


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

    public int getAgeCategory() {
        return ageCategory;
    }

    public String getEmpCat() {
        return empCat;
    }

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public FormEvent(Object source) {
        super(source);

    }

    public String getTaxId() {
        return taxId;
    }

    public boolean isUsCitizen() {
        return usCitizen;
    }

    public String getGender() {
        return gender;
    }

    public FormEvent(Object source, String name, String occupation, int ageCat, String empCat, String taxId, boolean usCitizen, String gender) {

        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCat;
        this.empCat = empCat;
        this.taxId = taxId;
        this.usCitizen = usCitizen;
        this.gender = gender;


    }
}
