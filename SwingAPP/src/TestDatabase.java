import model.*;

import java.sql.SQLException;

/**
 * Created by Jakob on 09-11-2014.
 */
public class TestDatabase {
    public static void main(String[] args) {
        System.out.println("Running database test");
        Database db = new Database();
        try {
            db.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }


        db.addPerson(new Person("Joe", "builder", "Employed", 1, "777", true, "Male"));
        db.addPerson(new Person("Sue", "artist", "SelfEmployed", 2, "777", true, "Female"));

        try {
            db.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }



                db.disconnect();
    }
}
