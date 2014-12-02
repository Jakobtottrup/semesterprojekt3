package model;

import db.DBWrite;

import java.io.Serializable;

/**
 * Created by Jakob on 10-11-2014.
 */
public class Task implements Serializable{
    private static int count = 1;

    private int projectId;
    private int currentProject;
    private String taskName;
    private String taskDescription;
    private int team;
    private int status;
    private int taskId;


    // =============== CONSTRUCTORS ======================= //
    public Task() {
    }
    public Task(String name, String description) {
        this.taskName = name;
        this.taskDescription = description;
    }
    public Task(int projectId, int currentProject, String taskName, int team, int status, int taskId) {
        this.projectId = projectId;
        this.currentProject = currentProject;
        this.taskName = taskName;
        this.team = team;
        this.status = status;
        this.taskId = count;
        count++;




    }




    public void addTask(Task task) {
        DBWrite writer = new DBWrite();
        writer.newTask(task);
    }

    public void removeTask(Task task) {
        DBWrite writer = new DBWrite();
        writer.removeTask(task);
    }



    //============ GETTERS & SETTERS ====================== //

    public String getTaskDescription() {
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public int getProjectId() {
        return projectId;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public int getCurrentProject() {
        return currentProject;
    }
    public void setCurrentProject(int currentProject) {
        this.currentProject = currentProject;
    }
    public int getTeam() {
        return team;
    }
    public void setTeam(int team) {
        this.team = team;
    }
}