package com.montivero.bootcamp2017.Config;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 13/01/2017.
 */
public class DatabaseHelperTest {

    @Test
    public void getCon() throws Exception {
        DatabaseHelper dbHelper = DatabaseHelper.getInstance();
        Connection con = dbHelper.getCon();

        assertEquals(true,con != null);
    }

    @Test
    public void testSameInstance() throws Exception{
        DatabaseHelper dbHelper = DatabaseHelper.getInstance();
        Connection con = dbHelper.getCon();

        DatabaseHelper dbHelper2 = DatabaseHelper.getInstance();
        Connection con2 = dbHelper2.getCon();

        DatabaseHelper dbHelper3 = DatabaseHelper.getInstance();
        Connection con3 = dbHelper3.getCon();

        assertEquals(dbHelper,dbHelper2);
        assertEquals(dbHelper,dbHelper3);
        assertEquals(dbHelper2,dbHelper3);

        assertEquals(con,con2);
        assertEquals(con,con3);
        assertEquals(con2,con3);
    }

    @Test
    public void testSelect() throws SQLException, ClassNotFoundException {

        DatabaseHelper dbHelper = DatabaseHelper.getInstance();
        Connection con = dbHelper.getCon();
        Statement stmt = con.createStatement();
        String sqlQuery = "Select \"Test Database\" from Dual";
        ResultSet result = stmt.executeQuery(sqlQuery);
        String resultOut="";
        while(result.next()) {
            resultOut=result.getString(1);
        }
        assertEquals("Test Database",resultOut);
    }

}