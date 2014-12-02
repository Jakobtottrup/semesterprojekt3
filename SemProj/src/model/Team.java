package model;


import db.DBRead;
import db.DBWrite;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jakob on 24-11-2014.
 */
public class Team {
    private List<User> teamList = new LinkedList<>();

    public void addUser(User user){
        teamList.add(user);
    }

    public void removeUser(User user){
        teamList.remove(user);
    }

//    public List<User> getTeamListFromDB(){
//        DBRead reader = new DBRead();
//        teamList = reader.getTeamListDB();
//    }

    public User getUser(int index)
    {
        return teamList.get(index);
    }

    public List<User> getTeamList() {
        return teamList;
    }

    public int getLength()
    {
        return teamList.size();
    }

    public void saveToDB(int proID){
        DBWrite writer = new DBWrite();
        writer.newTeam(this, proID);
    }
}
