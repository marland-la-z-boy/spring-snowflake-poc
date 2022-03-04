package com.lzb.sales.order.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lzb.sales.order.data.connections.SnowflakeConnection;

public class DataDAO {

    static ResultSet getData(String sql) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = SnowflakeConnection.getInstance().getConnection();
            ps = con.prepareStatement(sql);
            return ps.executeQuery();
        
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
       
    }

}