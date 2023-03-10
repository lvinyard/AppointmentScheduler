package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Countries;
import model.Divisions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * This class is to deal with the SQL methods for the Division Model
 */
public abstract class DivisionQuery {
    /**
     * This method retrieves all Divisions in a provided Country Id
     * @param CountryId
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Divisions> getDivisions(int CountryId) throws SQLException, Exception{
        ObservableList<Divisions> allDivisions = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * from first_level_divisions where Country_ID = '" + CountryId + "'";

        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while(result.next()){
            int resDivision_Id = result.getInt("Division_ID");
            String resDivision = result.getString("Division");
            Timestamp resCreate_Date = result.getTimestamp("Create_Date");
            String resCreated_by = result.getString("Created_By");
            Timestamp resLast_Update = result.getTimestamp("Last_Update");
            String resUpdatedBy = result.getString("Last_Updated_By");
            int resCountry_Id = result.getInt("Country_ID");
            Divisions divisionsResult = new Divisions(resDivision_Id, resDivision, resCreate_Date, resCreated_by, resLast_Update, resUpdatedBy, resCountry_Id);
            allDivisions.add(divisionsResult);
        }
        return allDivisions;
    }

    /**
     * This method retrieves all Divisions names in a provided Country Id
     * @param CountryId
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<String> getDivisionsNames(int CountryId) throws SQLException, Exception{
        ObservableList<String> allDivisionsNames = FXCollections.observableArrayList();
        String sqlStatement = "SELECT Division from first_level_divisions where Country_ID = '" + CountryId + "'";

        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while(result.next()){
            String resDivision = result.getString("Division");
            allDivisionsNames.add(resDivision);
        }
        return allDivisionsNames;
    }

    /**
     * This method returns the division name from a division id
     * @param division_ID
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static String getDivisionName(int division_ID) throws SQLException, Exception{

        String sqlStatement = "SELECT Division from first_level_divisions where Division_ID = '" + division_ID + "'";

        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        result.next();
        return result.getString("Division");
    }

    /**
     * This method returns the Division Id for a provided division Name
     * @param division_Name
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static int getDivisionId(String division_Name) throws SQLException, Exception{

        String sqlStatement = "SELECT Division_ID from first_level_divisions where Division = '" + division_Name + "'";

        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        result.next();
        return result.getInt("Division_ID");
    }

}
