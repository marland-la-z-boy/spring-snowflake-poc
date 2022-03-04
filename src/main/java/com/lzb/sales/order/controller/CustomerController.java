package com.lzb.sales.order.controller;

import com.lzb.sales.order.data.CustomerDAO;
import com.lzb.sales.order.data.OrderDAO;
import com.lzb.sales.order.model.Customer;
import com.lzb.sales.order.model.Order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    //Logger logger = Logger.getLogger

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") String id) {
        
        System.out.println("ID: "+id);
        CustomerDAO customerDao = new CustomerDAO();
        Customer customer = customerDao.getCustomerById(Integer.valueOf(id));
        OrderDAO oDao = new OrderDAO();
        Order[] orders = oDao.getOrdersByCustomer(customer);
        customer.setOrders(orders);

        return customer;
    }

    @GetMapping("/test")
    public String test(){
        return "TEST";
    }
}
