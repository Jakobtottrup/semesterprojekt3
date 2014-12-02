package model;

import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jakob on 06-11-2014.
 */
public class Database {

    private static String url = "jdbc:postgresql://localhost:5432/tutorials";
    private static String username = "postgres";
    private static String password = "1";
    private Connection con;


    private LinkedList<Person> people;

    public Database() {
        people = new LinkedList<Person>();
    }

    public void removePerson(int index) {
        people.remove(index);
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public void saveToFile(File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
            Person[] persons = people.toArray(new Person[people.size()]);
            oos.writeObject(persons);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Person[] persons = (Person[]) ois.readObject();
            people.clear();
            people.addAll(Arrays.asList(persons));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }

    public void connect() throws Exception {
        if (con != null) {
            return;
        }
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found!");
        }

        con = DriverManager.getConnection(url, username, password);
        System.out.println("Connected: " + con);
    }

    public void disconnect() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("can't close connection");
            }
        }
    }

    public void save() throws SQLException {
        String sql = "select count(*) as count from people where id=?";
        PreparedStatement checkStmt = con.prepareStatement(sql);
        String insertSql = "insert into people(id, name, age, employment_status, tax_id, us_citizen, gender, occupation) values(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStatement = con.prepareStatement(insertSql);
        for (Person person : people) {
            int id = person.getId();

            String tax = person.getTaxId();
            String emp = person.getEmpCat();
            int age = person.getAgeCategory();
            String name = person.getName();
            String occupation = person.getOccupation();
            boolean isUs = person.isUsCitizen();
            String gender = person.getGender();


            checkStmt.setInt(1, id);
            ResultSet checkResult = checkStmt.executeQuery();
            checkResult.next();
            int count = checkResult.getInt(1);
            if (count == 0) {
                System.out.println("Inserting person with ID: " + id);

                int col = 1;
                insertStatement.setInt(col++, id);
                insertStatement.setString(col++, name);
                insertStatement.setInt(col++, age);
                insertStatement.setString(col++, emp);
                insertStatement.setString(col++, tax);
                insertStatement.setBoolean(col++, isUs);
                insertStatement.setString(col++, gender);
                insertStatement.setString(col++, occupation);

                insertStatement.executeUpdate();
            } else {
                System.out.println("Updating person with ID: " + id);

            }

        }
        insertStatement.close();
        checkStmt.close();


    }


}






