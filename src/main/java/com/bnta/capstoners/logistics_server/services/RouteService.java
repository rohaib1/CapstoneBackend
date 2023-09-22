package com.bnta.capstoners.logistics_server.services;

import com.bnta.capstoners.logistics_server.models.Route;
import com.bnta.capstoners.logistics_server.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService{

        @Autowired
        RouteRepository routeRepository;

        public List<Route> findAllRoutes(){
                return routeRepository.findAll();
        }
}
