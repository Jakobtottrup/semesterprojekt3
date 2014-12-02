package model;

import db.DBWrite;

/**
 * Created by Jakob on 10-11-2014.
 */
public class Project
{
    private int projectID;
    private String projectDescription;
    private String projectName;

    public Project(String name, String description) {
        this.projectName = name;
        this.projectDescription = description;
    }

    public Project() {

    }

    public Project(int projectID, String projectDescription, String projectName) {
        this.projectID = projectID;
        this.projectDescription = projectDescription;
        this.projectName = projectName;
    }

    public int getProjectID() {
        return projectID;
    }
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
    public String getProjectDescription() {
        return projectDescription;
    }
    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void addProject(Project project) {
        DBWrite writer = new DBWrite();
        writer.newProject(project);

    }
}