package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.mainTasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.SortedMap;
import until.booleanConvert;


public class mainTaskListImpl
{

    public static ObservableList<mainTasks> mainTaskList = FXCollections.observableArrayList();
    public static ObservableList<mainTasks> selectAllTasks() throws SQLException
    {
        ObservableList<mainTasks> allMainTasks = FXCollections.observableArrayList();

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


            mainTasks addTasks = new mainTasks(id,name,description,note,isComplete);

            allMainTasks.add(addTasks);
            mainTaskList.addAll(allMainTasks);


        }

        DBConnection.closeConnection();
        return allMainTasks;

    }

}

