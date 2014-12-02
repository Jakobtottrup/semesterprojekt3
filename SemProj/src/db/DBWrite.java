package db;

import model.Project;
import model.Task;
import model.Team;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBWrite {

    private Connection getConnection() {
        Connection con = null;

        try {
            con = DBConnecter.getConnection();
        } catch (SQLException f) {
            f.printStackTrace();
        }
        try {
            if (con.isValid(30)) {
                return con;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public Boolean newProject(Project project) {
        int rows = 0;

        String sqlString = "INSERT INTO project (description, name) VALUES (?,?)";

        PreparedStatement statementReadings = null;

        Connection conn = this.getConnection();

        try {
            statementReadings = conn.prepareStatement(sqlString);

            statementReadings.setString(1, project.getProjectDescription());
            statementReadings.setString(2, project.getProjectName());

            rows = statementReadings.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (statementReadings != null) {
                try {
                    statementReadings.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return rows > 0;
    }

    public Boolean newUser(User user) {
        int rows = 0;

        String sqlString = "INSERT INTO User (name, username, email) VALUES (?,?,?)";

        PreparedStatement statementReadings = null;

        Connection conn = this.getConnection();

        try {
            statementReadings = conn.prepareStatement(sqlString);

            statementReadings.setString(1, user.getFullName());
            statementReadings.setString(2, user.getUsername());
            statementReadings.setString(3, user.getMail());

            rows = statementReadings.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (statementReadings != null) {
                try {
                    statementReadings.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return rows > 0;
    }

    public Boolean newTeam(Team team, int projectID) {
        for (int i = 0; i <= team.getLength(); i++) {
            addMemberToTeam(team, projectID, i);
        }
        return null;
    }

    public Boolean addMemberToTeam(Team team, int projectID, int index) {

        int rows = 0;

        String sqlString = "INSERT INTO team (projectid, teammember) VALUES (?,?)";

        PreparedStatement statementReadings = null;

        Connection conn = this.getConnection();

        try {
            statementReadings = conn.prepareStatement(sqlString);

            statementReadings.setInt(1, projectID);
            statementReadings.setString(2, team.getUser(index).getFullName());

            rows = statementReadings.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (statementReadings != null) {
                try {
                    statementReadings.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return rows > 0;

    }

    public Boolean newTask(Task task) {
        int rows = 0;

        String sqlString = "INSERT INTO task (name, projectid) VALUES (?,?)";

        PreparedStatement statementReadings = null;

        Connection conn = this.getConnection();

        try {
            statementReadings = conn.prepareStatement(sqlString);

            statementReadings.setString(1, task.getTaskName());
            statementReadings.setInt(2, task.getCurrentProject());

            rows = statementReadings.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (statementReadings != null) {
                try {
                    statementReadings.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return rows > 0;
    }

    public Boolean removeTask(Task task) {
        int rows = 0;

        String sqlString = "DELETE FROM task WHERE name=?";

        PreparedStatement statementReadings = null;

        Connection conn = this.getConnection();

        try {
            statementReadings = conn.prepareStatement(sqlString);
            statementReadings.setString(1, task.getTaskName());
            rows = statementReadings.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (statementReadings != null) {
                try {
                    statementReadings.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return rows > 0;
    }

//    public Boolean newFile(FileToDB file)
//    {
//        int rows = 0;
//
//        String sqlString = "INSERT INTO files (filename, taskid) VALUES (?,?)";
//
//        PreparedStatement statementReadings = null;
//
//        Connection conn = this.getConnection();
//
//        try {
//            statementReadings = conn.prepareStatement(sqlString);
//
//            statementReadings.setString(1, file.getFileName());
//            statementReadings.setInt(2, file.getCurrentTask());
//
//            rows = statementReadings.executeUpdate();
//
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            if (statementReadings != null) {
//                try {
//                    statementReadings.close();
//                } catch (SQLException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }
//        return  rows > 0;
//    }

}
