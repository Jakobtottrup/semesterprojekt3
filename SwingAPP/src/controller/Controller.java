package controller;

import gui.FormEvent;
import model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Jakob on 06-11-2014.
 */
public class Controller {
    Database db = new Database();

    public List<Person> getPeople(){
        return db.getPeople();
    }

    public void removePerson(int index) {
        db.removePerson(index);
    }
    public void addPerson(FormEvent e) {

        String name = e.getName();
        String occupation = e.getOccupation();
        int ageCatId = e.getAgeCategory();
        String empCat = e.getEmpCat();
        boolean isUs = e.isUsCitizen();
        String taxId = e.getTaxId();
        String gender = e.getGender();

//        AgeCategory ageCategory = null;
//        switch (ageCatId) {
//            case (0):
//                ageCategory = AgeCategory.CHILD;
//                break;
//            case (1):
//                ageCategory = AgeCategory.ADULT;
//                break;
//            case (2):
//                ageCategory = AgeCategory.SENIOR;
//                break;
//
//
//        }
//
//        EmploymentCategory empCategory;
//        if (empCat.equals("Employed")) {
//            empCategory = EmploymentCategory.EMPLOYED;
//        } else if (empCat.equals("Self-employed")) {
//            empCategory = EmploymentCategory.SELFEMPLOYED;
//        } else if (empCat.equals("Unemployed")) {
//            empCategory = EmploymentCategory.UNEMPLOYED;
//        } else {
//            empCategory = EmploymentCategory.OTHER;
//            System.err.println(empCat);
//        }
//
//        Gender genderCat;
//
//        if (gender.equals("male")) {
//            genderCat = Gender.MALE;
//        } else {
//            genderCat = Gender.FEMALE;
//        }


        Person person = new Person(name, occupation, empCat, ageCatId, taxId, isUs, gender);

        db.addPerson(person);
    }

    public void saveToFile(File file) {
        db.saveToFile(file);

    }

    public void loadFromFile(File file) {
        try {
            db.loadFromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
