package com.lzb.sales.order.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.lzb.sales.order.data.connections.SnowflakeConnection;
import com.lzb.sales.order.model.Address;
import com.lzb.sales.order.model.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerDAO {

    private static Logger logger = LoggerFactory.getLogger(CustomerDAO.class);

    public Customer getCustomerById(Integer id){
        String sql = "select customer_id, firstname, lastname, email, phone from poc.customers where customer_id="+id;
        logger.info(sql);
        Customer customer = new Customer();
      
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = SnowflakeConnection.getInstance().getConnection();
            ps = con.prepareStatement(sql);
        
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Long customerId = rs.getLong(1);               
                customer.setId(customerId);
                customer.setFirstName(rs.getString(2));
                customer.setLastName(rs.getString(3));
                customer.setEmail(rs.getString(4));
                customer.setPhone(rs.getLong(5));
                customer.setAddresses(getAddressesByCustomerId(customerId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
        }

        return customer;
    }

    public Address[] getAddressesByCustomerId(Long customerId){
        
        String sql = "select address_id, name, addressline, city, state, zipcode, type from addresses where customer_id="+customerId;
        logger.info(sql);
        
        ArrayList<Address> addressList = new ArrayList<Address>();
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = SnowflakeConnection.getInstance().getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                Address address = new Address();
                address.setAddressId(rs.getLong(1));
                address.setName(rs.getString(2));
                address.setAddressLine(rs.getString(3));
                address.setCity( rs.getString(4));
                address.setZipCode(rs.getString(5));
                //String addr_type_db = rs.getString(6);
               
                address.setAddressType(Address.Type.BILLING_SHIPPING);
                addressList.add(address);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
        Address[] addresses = addressList.toArray(new Address[addressList.size()]);

        return addresses;
    }

    public Address getAddressById(Long addressId){
        
        String sql = "select address_id, name, addressline, city, state, zipcode, type from addresses where address_id="+addressId;
        logger.info(sql);
        
        Connection con = null;
        PreparedStatement ps = null;
        Address address = new Address();
        try{
            con = SnowflakeConnection.getInstance().getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                
                address.setAddressId(rs.getLong(1));
                address.setName(rs.getString(2));
                address.setAddressLine(rs.getString(3));
                address.setCity( rs.getString(4));
                address.setZipCode(rs.getString(5));
                //String addr_type_db = rs.getString(6);
               
                address.setAddressType(Address.Type.BILLING_SHIPPING);
               
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
       
        return address;
    }

   
}
