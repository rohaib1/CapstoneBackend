package com.bnta.capstoners.logistics_server.services;

import com.bnta.capstoners.logistics_server.models.*;
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

        public List<RouteWaypointDTO> getRouteWaypoints(){
                List<Route> allRoutes = routeRepository.findAll();
                List<RouteWaypointDTO> routeWaypoints = new ArrayList<>(); //[ [RouteWaypointDTO], [RouteWaypointDTO] ...]
                for(Route route : allRoutes){
                        List<Double> waypoints = new ArrayList<>();
                        List<Order> orders = route.getOrders();
                        for(int i = 0; i<orders.size(); i++){
                                waypoints.add(orders.get(i).getLat());
                                waypoints.add(orders.get(i).getLng());
                        }
                        routeWaypoints.add(new RouteWaypointDTO(route, waypoints));
                }
                return routeWaypoints;
        }

        //FOR LOOP THROUGH A SINGLE LIST
        //IF INDEX IS EVEN APPEND ELEMENT AND ADD COMMA
        //IF INDEX IS ODD APPEND ELEMENT AND ADD SEMI COLON

//        routeList = [[RouteWaypointDTO],[Route]]
//
//        List<RouteWayPointDTO>
//
//        List<Route> allRoutes = routeRep.findall();
//        List<RouteWayPointDTO> = new one;
//            for (Route route : allRoutes)
//
//        {
//                List<double> waypoints
//                for () {
//                        RouteWaypointDTO routeWaypoint = new RouteWaypointDTO(route.getLat, route.getlng, waypoints)
//                }
//        }

//        public void deleteRoute(Long id){
//                routeRepository.deleteById(id);
//        }
}