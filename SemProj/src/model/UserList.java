package model;

import db.DBRead;
import model.User;

import java.util.ArrayList;

public class UserList {
    ArrayList<User> userList = new ArrayList<>();

    public void setUser(User user)
    {
        userList.add(user);
    }
    public User getUser(int next)
    {
        return userList.get(next);
    }
    public User getUserbyString(String nameString){
        for(int i = 0; i <= userList.size(); i++) {
            if (nameString == userList.get(i).getFullName()) {
                return userList.get(i);
            }
        }
        return null;
    }
    public int getLength()
    {
        return userList.size();
    }
    public UserList getUserList(){
        DBRead reader = new DBRead();
        return reader.getUsers();
    }

}
