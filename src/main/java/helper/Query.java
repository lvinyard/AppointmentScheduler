package helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This helper class formats the Queries to run successfully
 */
public class Query {
    private static String query;
    private static Statement stmt;
    private static ResultSet result;

    /**
     * Formats the query
     * @param q
     */
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

    /**
     * returns query result
     * @return
     */
    public static ResultSet getResult() {return result;}
}
