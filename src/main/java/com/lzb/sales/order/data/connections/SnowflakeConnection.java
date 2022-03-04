package com.lzb.sales.order.data.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SnowflakeConnection {
    

    public SnowflakeConnection connection;

    private String host = "lazboyinc-lazboy.snowflakecomputing.com";
    private String username = "";
    private String databaseName = "POC_SALES_ORDER";
    private String schema = "POC";
    private String warehouse = "marland_test_wh";
    private String password = "";

    private static SnowflakeConnection instance = null;

    private SnowflakeConnection() {

    }

    public static SnowflakeConnection getInstance() {
        if (instance == null) {
            instance = new SnowflakeConnection();
        }

        return instance;

    }

    public Connection getConnection() throws SQLException {
        String url =  "jdbc:snowflake://"+host+"?user=marlmoore&warehouse="+warehouse+"&db="+databaseName+"&schema="+schema;

        System.out.println("jdbc url: " + url);
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }


}
