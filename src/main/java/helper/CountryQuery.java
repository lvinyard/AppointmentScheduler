package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;
import model.Countries;
import model.Divisions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CountryQuery {

    public static ObservableList<Countries> getAllCountries() throws SQLException, Exception{
        ObservableList<Countries> allCountries = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * from Countries";

        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while(result.next()){
            int resCountry_Id = result.getInt("Country_ID");
            String resCountry = result.getString("Country");
            Timestamp resCreate_Date = result.getTimestamp("Create_Date");
            String resCreated_by = result.getString("Created_By");
            Timestamp resLast_Update = result.getTimestamp("Last_Update");
            String resUpdatedBy = result.getString("Last_Updated_By");
            Countries countriesResult = new Countries(resCountry_Id, resCountry, resCreate_Date, resCreated_by, resLast_Update, resUpdatedBy);
            allCountries.add(countriesResult);
        }
        return allCountries;
    }
    public static ObservableList<String> getAllCountriesName() throws SQLException, Exception{
        ObservableList<String> allCountriesNames = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * from Countries";

        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while(result.next()){
            String resCountry = result.getString("Country");
            allCountriesNames.add(resCountry);
        }
        return allCountriesNames;
    }

    public static int findCountryId(int division_ID) throws SQLException, Exception{

        String sqlStatement = "SELECT Country_ID from first_level_divisions where Division_ID = '" + division_ID + "'";

        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        result.next();
        return result.getInt("Country_ID");
    }
    public static int findCountryId(String countryName) throws SQLException, Exception{

        String sqlStatement = "SELECT Country_ID from countries where Country = '" + countryName + "'";

        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        result.next();
        return result.getInt("Country_ID");
    }

    public static String findCountryName(int Country_ID) throws SQLException, Exception{

        String sqlStatement = "SELECT Country from countries where Country_ID = '" + Country_ID + "'";

        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        result.next();
        return result.getString("Country");
    }
}
