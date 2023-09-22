package com.bnta.capstoners.logistics_server.controllers;

import com.bnta.capstoners.logistics_server.models.Route;
import com.bnta.capstoners.logistics_server.models.RouteDTO;
import com.bnta.capstoners.logistics_server.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/routes")
public class RouteController {
    @Autowired
    RouteService routeService;

    @GetMapping
    public ResponseEntity<List<Route>> getRoutes(){
        List<Route> allRoutes = routeService.findRoutes();
        return new ResponseEntity<List<Route>>(allRoutes, HttpStatus.FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable("id") Long id) {
        Optional<Route> route = routeService.findRouteById(id);

        if (route.isPresent()) {
            return new ResponseEntity<>(route.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody RouteDTO routeDTO){
        Route newRoute = routeService.saveRoute(routeDTO);
        return new ResponseEntity<>(newRoute, HttpStatus.CREATED);
    }

//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Long> deleteRoute(@PathVariable Long id){
//        Optional<Route> route = routeService.findRouteById(id);
//        if (route.isPresent()) {
//            routeService.deleteRoute(id);
//            return new ResponseEntity<>(id, HttpStatus.OK);
//        }
//
//        else{
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
}
