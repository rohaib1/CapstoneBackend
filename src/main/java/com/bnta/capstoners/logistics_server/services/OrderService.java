package com.bnta.capstoners.logistics_server.services;

import com.bnta.capstoners.logistics_server.models.Order;
import com.bnta.capstoners.logistics_server.models.Route;
import com.bnta.capstoners.logistics_server.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order> findOrderById(Long id){
        return orderRepository.findById(id);
    }

    public Order updateOrderStatus(Long id, boolean status){
        Order orderToUpdate = orderRepository.findById(id).get();
        orderToUpdate.setDelivered(status);
        orderRepository.save(orderToUpdate);
        return orderToUpdate;
    }

    public String assignOrdersARoute(List<Long> orderIds, Route route){
        for (Long id : orderIds) {
            Order orderToUpdate = orderRepository.findById(id).get();
            orderToUpdate.setRoute(route);
            orderRepository.save(orderToUpdate);
        }
        return "Orders updated";
    }

}
