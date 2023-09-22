package com.bnta.capstoners.logistics_server.repositories;


import com.bnta.capstoners.logistics_server.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long>{
}
