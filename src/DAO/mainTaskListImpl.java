package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class mainTaskListImpl
{

    public static ObservableList<Tasks> mainTaskList = FXCollections.observableArrayList();
    public static ObservableList<Tasks> selectAllTasks() throws SQLException
    {
        ObservableList<Tasks> allTasks = FXCollections.observableArrayList();

        String sqlStatement = "Select * from primarytbl";

        Connection conn = DBConnection.getConnection();
        DBQuery.setPreparedStatement(conn,sqlStatement);

        PreparedStatement ps = DBQuery.getPrepareStatement();
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            String note = rs.getString("note");
            boolean isComplete = rs.getBoolean("isComplete");


            Tasks addTasks = new Tasks(id,name,description,note,isComplete);

            allTasks.add(addTasks);
            mainTaskList.addAll(allTasks);


        }

        DBConnection.closeConnection();
        return allTasks;

    }

}

