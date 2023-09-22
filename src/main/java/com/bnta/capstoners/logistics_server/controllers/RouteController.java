package com.bnta.capstoners.logistics_server.controllers;

import com.bnta.capstoners.logistics_server.models.Route;
import com.bnta.capstoners.logistics_server.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/routes")
public class RouteController {
    @Autowired
    RouteService routeService;

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes(){
        List<Route> allRoutes = routeService.findAllRoutes();
        return new ResponseEntity<List<Route>>(allRoutes, HttpStatus.FOUND);
    }
}
