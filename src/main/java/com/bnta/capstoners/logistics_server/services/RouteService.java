package com.bnta.capstoners.logistics_server.services;

import com.bnta.capstoners.logistics_server.models.Order;
import com.bnta.capstoners.logistics_server.models.Route;
import com.bnta.capstoners.logistics_server.models.RouteDTO;
import com.bnta.capstoners.logistics_server.models.Van;
import com.bnta.capstoners.logistics_server.repositories.OrderRepository;
import com.bnta.capstoners.logistics_server.repositories.RouteRepository;
import com.bnta.capstoners.logistics_server.repositories.VanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteService{

        @Autowired
        RouteRepository routeRepository;

        @Autowired
        OrderRepository orderRepository;

        @Autowired
        VanRepository vanRepository;

        public List<Route> findRoutes(){
                return routeRepository.findAll();
        }

        public Optional<Route> findRouteById(Long id){
                return routeRepository.findById(id);
        }

        public Route saveRoute(RouteDTO routeDTO) {
                List<Order> orders = new ArrayList<>();

                for (Long orderId : routeDTO.getOrderIds()){
                        orders.add(orderRepository.findById(orderId).get());
                }

                Route route = new Route(
                        routeDTO.getRouteName(),
                        routeDTO.getStartLocationLong(),
                        routeDTO.getStartLocationLat()
                );

                return routeRepository.save(route);
        }

        public Route assignVanToRoute(Long routeId, Long vanId){
                Van vanToAssign = vanRepository.findById(vanId).get();
                Route routeToUpdate = routeRepository.findById(routeId).get();
                routeToUpdate.setVan(vanToAssign);
                routeRepository.save(routeToUpdate);
                return routeToUpdate;
        }

//        public void deleteRoute(Long id){
//                routeRepository.deleteById(id);
//        }
}