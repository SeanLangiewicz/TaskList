package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class taskImpl
{

    public static ObservableList<Task> taskList = FXCollections.observableArrayList();

    public static ObservableList<Task> selectAllTasks() throws SQLException
    {
        ObservableList<Task> allTasks = FXCollections.observableArrayList();

        String sqlStatement = "Select * from tasktbl";

        Connection conn = DBConnection.getConnection();
        DBQuery.setPreparedStatement(conn, sqlStatement);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String description = rs.getString("description");
            String status = rs.getString("status");

            Task addTask = new Task(id, description, status);

            allTasks.add(addTask);
            taskList.addAll(allTasks);


        }

        DBConnection.closeConnection();
        return allTasks;

    }
    public static void updateTask(String description, String status,int id)
    {
        String sql = "UPDATE tasktbl set Description=?, Status=? WHERE id=?";

        try
        {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

            Connection conn = DBConnection.getConnection();

            ps.setString(1,description);
            ps.setString(2,status);
            ps.setInt(3,id);

            ps.execute();

            ResultSet rs = ps.executeQuery();
            rs.next();
        }
        catch (Exception e)
        {
            e.toString();
        }
    }
    public static void addTask(String description, String status)
    {
        String sql = "INSERT INTO tasktbl (Description, Status) Values (?,?)";

        try
        {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            Connection conn = DBConnection.getConnection();

            ps.setString(1,description);
            ps.setString(2,status);

            ps.execute();

            ResultSet rs = ps.executeQuery();

            rs.next();
        }
        catch (Exception e)
        {
            e.toString();
        }
    }
}
