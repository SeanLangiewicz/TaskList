package DAO;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class statusImpl
    {

        public static ObservableList<String> statusList = FXCollections.observableArrayList();

        public static ObservableList<String> SelectAllStatus() throws SQLException
        {
            ObservableList<String> allStatus = FXCollections.observableArrayList();
            Connection conn = DBConnection.getConnection();

            try
            {
                String sql = "Select * from statustbl";
                DBQuery.setPreparedStatement(conn,sql);

                PreparedStatement ps = DBQuery.getPrepareStatement();

                ps.execute();

                ResultSet rs = ps.getResultSet();

                while (rs.next())
                {
                    int id = rs.getInt("ID");
                    String status = rs.getString("status");

                    status addedStatus = new status(id,status);
                    allStatus.add(String.valueOf(addedStatus));
                    statusList.addAll(String.valueOf(allStatus));
                }

            }
            catch (Exception e)
            {
                e.toString();
            }
            DBConnection.closeConnection();
            return allStatus;
        }
    }

