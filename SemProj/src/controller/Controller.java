package controller;


import db.DBRead;
import db.DBWrite;
import gui.MainGui;
import model.Project;
import model.Task;
import model.Team;
import model.UserList;

import java.sql.SQLException;

/**
 * Created by Jakob on 11-11-2014.
 */
public class Controller {
    public int currentProjectID;

    public void addTask(Task task) throws SQLException {
        task.addTask(task);
        MainGui
    }
    public void addProject(Project project) throws SQLException {
        project.addProject(project);
    }
    public void removeTask(Task task) {
        DBWrite db = new DBWrite();
        db.removeTask(task);

    }
    public UserList getUserList() {
        UserList userList = new UserList();
        return userList.getUserList();
        }
    public void addTeam(Team team)
    {
        team.saveToDB(currentProjectID);
    }

}
