package helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
    private static String query;
    private static Statement stmt;
    private static ResultSet result;

    public static void makeQuery(String q){
        query = q;
        try{
            stmt = JDBC.connection.createStatement();

            if(query.toLowerCase().startsWith("select"))
                result=stmt.executeQuery(q);
            if(query.toLowerCase().startsWith("delete")||query.toLowerCase().startsWith("insert")||query.toLowerCase().startsWith("update"))
                stmt.executeUpdate(q);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static ResultSet getResult() {return result;}
}