package com.lzb.sales.order.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lzb.sales.order.model.Customer;
import com.lzb.sales.order.model.Order;
import com.lzb.sales.order.data.connections.SnowflakeConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderDAO {
    
    private static Logger logger = LoggerFactory.getLogger(OrderDAO.class);

    public Order[]  getOrdersByCustomer(Customer customer){
        String sql = "select order_id, customer_id, address_id, order_date, description, status from orders where customer_id="+customer.getId();
        logger.info(sql);
        
        ArrayList<Order> orderList = new ArrayList<Order>();
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = SnowflakeConnection.getInstance().getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //CustomerDAO cDao = new CustomerDAO();
            while(rs.next()){
                Order order = new Order();
                order.setOrderId(rs.getLong(1));
                //order.setCustomer(customer);

                //order.setAddress(cDao.getAddressById(rs.getLong(3)));
                order.setOrderDate(rs.getTimestamp(4));
                order.setStatus(Order.Status.IN_PROGRESS);
                order.setDescription(rs.getString(6));
                
                orderList.add(order);
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

        Order[] orders = orderList.toArray(new Order[orderList.size()]);
        return orders;
    }
}
