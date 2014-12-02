package db;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBRead
{

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




    public TaskList getTasks()
    {
        String sql = "SELECT projectid,name FROM task";

        ResultSet results = null;
        TaskList taskList = new TaskList();

        Connection conn = null;
        PreparedStatement ps = null;

        conn = this.getConnection();


        try {
            ps = conn.prepareStatement(sql);

            results = ps.executeQuery();

            if(results.next())
            {
                Task task = new Task();

                task.setCurrentProject(results.getInt(1));
                task.setTaskName(results.getString(2));

                taskList.addTask(task);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
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

        return taskList;
    }

    public Project lastCreatedProject()
    {
        Project project = new Project();
        String sql = "SELECT projectid FROM project ORDER BY projectid DESC LIMIT 1";

        ResultSet results = null;
        TaskList taskList = new TaskList();

        Connection conn = null;
        PreparedStatement ps = null;

        conn = this.getConnection();


        try {
            ps = conn.prepareStatement(sql);

            results = ps.executeQuery();

            while(!results.isLast())
            {
                results.next();

                project.setProjectID(results.getInt(1));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
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

        return project;
    }

    public FileList getFiles()
    {
        String sql = "SELECT taskid,filename FROM files";

        ResultSet results = null;
        FileList fileList = new FileList();

        Connection conn = null;
        PreparedStatement ps = null;

        conn = this.getConnection();


        try {
            ps = conn.prepareStatement(sql);

            results = ps.executeQuery();

            while(!results.isLast())
            {
                FileToDB file = new FileToDB();
                results.next();

                file.setCurrentTask(results.getInt(1));
                file.setFileName(results.getString(2));
                fileList.addFile(file);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
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

        return fileList;
    }


    public UserList getUsers()
    {
        String sql = "SELECT name,rights FROM users";

        ResultSet results = null;
        UserList userList = new UserList();

        Connection conn = null;
        PreparedStatement ps = null;

        conn = this.getConnection();


        try {
            ps = conn.prepareStatement(sql);

            results = ps.executeQuery();

            while(!results.isLast())
            {
                User user = new User();
                results.next();

                user.setFullName(results.getString(1));
                user.setTitle(results.getInt(2));
                userList.setUser(user);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
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

        return userList;
    }


//    public UserList getTeamListDB()
//    {
//        String sql = "SELECT name,rights FROM users WHERE tea";
//
//        ResultSet results = null;
//        UserList userList = new UserList();
//
//        Connection conn = null;
//        PreparedStatement ps = null;
//
//        conn = this.getConnection();
//
//
//        try {
//            ps = conn.prepareStatement(sql);
//
//            results = ps.executeQuery();
//
//            while(!results.isLast())
//            {
//                User user = new User();
//                results.next();
//
//                user.setFullName(results.getString(1));
//                user.setTitle(results.getInt(2));
//                userList.setUser(user);
//            }
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            if (ps != null) {
//                try {
//                    ps.close();
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
//
//        return userList;
//    }
}
