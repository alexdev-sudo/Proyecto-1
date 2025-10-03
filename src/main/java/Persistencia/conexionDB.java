package Persistencia;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class conexionDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "ezequielumg";
    private static final String PASS = "UMG[***]";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASS);

    }

}
