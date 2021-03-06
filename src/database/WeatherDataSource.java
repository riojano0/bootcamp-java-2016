package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Daniel on 11/01/2017.
 */
public class WeatherDataSource {
    private static final String TABLE_NAME = "Weather";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_STATES_ID = "States_id";
    private static final String COLUMN_FORECAST_TODAY_ID = "forecast_today_id";
    private static final String COLUMN_FORECAST_EXTENDED_ID = "forecast_extended_id";
    private static final String COLUMN_WINDS_ID = "Winds_id";
    private static final String COLUMN_ATMOSPHERES_ID = "Atmospheres_id";
    private static final String COLUMN_DESCRIPTION = "Description";
    private DatabaseHelper dbHelper= new DatabaseHelper();
    private Connection con = dbHelper.getCon();

    public void insertWeather(int stateId,int forecastTodayId, int forecastExtendedId, int windId, int atmId,
                              String descrip) throws SQLException {

        String sqlInsert = String.format("Insert into %s(%s,%s, %s, %s, %s, %s) values (?,?,?,?,?,?)",
                TABLE_NAME,COLUMN_STATES_ID,COLUMN_FORECAST_TODAY_ID,COLUMN_FORECAST_EXTENDED_ID,COLUMN_WINDS_ID,
                COLUMN_ATMOSPHERES_ID, COLUMN_DESCRIPTION);
        PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
        preparedStmt.setInt(1,stateId);
        preparedStmt.setInt(2,forecastTodayId);
        preparedStmt.setInt(3,forecastExtendedId);
        preparedStmt.setInt(4,windId);
        preparedStmt.setInt(5,atmId);
        preparedStmt.setString(6,descrip);

        preparedStmt.execute();

    }

    public ResultSet getWeatherById(int id) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setInt(1,id);
        return preparedStmt.executeQuery();
    }

    public ResultSet getWeatherByStateName(String stateName) throws SQLException {
        String tableForeign = "states";
        String valueForeign = "State";
        String sqlSelect = String.format("Select W.* from %s W join %s W.%s on S.id where S.%s like ?",
                TABLE_NAME,tableForeign,COLUMN_STATES_ID, valueForeign);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setString(1,stateName);
        return preparedStmt.executeQuery();
    }

    public ResultSet getWeatherByStateId(int stateId) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_STATES_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setInt(1,stateId);
        return preparedStmt.executeQuery();
    }

    public ResultSet getAllWeathers() throws SQLException {
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        return preparedStmt.executeQuery();
    }

    public WeatherDataSource() throws SQLException, ClassNotFoundException {
    }
}
