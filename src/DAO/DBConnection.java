package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{


    //JDBC URL PARTS
    private static final String protocal = "jdbc";
    private static final String vendorName = "mysql:";
    private static final String hostName = "192.168.5.162";
    //private static final String disableSSL = "?useSSL=false";
    private static final String dbName = "tasklistdb";
//mysql




    //Driver and connect Interface reference
    private static final String mySQLJDBCDriver = "com.mysql.cj.jdbc.Driver";
    private static Connection conn = null;

    private static final String userName = "remoteuser";
    private static final String password = "root";
    private static final String port = "3306";

    //JDBC URL
    private static final String jdbcURL =
            "jdbc:mysql://" + hostName + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;


    public static Connection getConnection()
    {
        try
        {


            Class.forName(mySQLJDBCDriver);


            conn = DriverManager.getConnection(jdbcURL);
            System.out.println("Connection Successful");



        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }

        catch (SQLException e)
        {
            System.out.println("SQL Exception " + e.getMessage());
        }



        return conn;
    }
    public static void closeConnection() throws SQLException {
        if(conn !=null)
        {
            conn.close();
            System.out.println("DB Connection closed");
        }
    }


}
