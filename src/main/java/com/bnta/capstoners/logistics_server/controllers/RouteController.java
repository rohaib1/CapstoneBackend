package com.bnta.capstoners.logistics_server.controllers;

import com.bnta.capstoners.logistics_server.models.Route;
import com.bnta.capstoners.logistics_server.models.RouteDTO;
import com.bnta.capstoners.logistics_server.models.RouteWaypointDTO;
import com.bnta.capstoners.logistics_server.models.Van;
import com.bnta.capstoners.logistics_server.services.RouteService;
import com.bnta.capstoners.logistics_server.services.VanService;
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

    @Autowired
    VanService vanService;

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

    @GetMapping(value = "/all/waypoints")
     public ResponseEntity<List<RouteWaypointDTO>> getRouteWaypoints() {
        List<RouteWaypointDTO> allRouteWaypoints = routeService.getRouteWaypoints();
        return new ResponseEntity<List<RouteWaypointDTO>>(allRouteWaypoints, HttpStatus.FOUND);
    }


    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody RouteDTO routeDTO){
        Route newRoute = routeService.saveRoute(routeDTO);
        return new ResponseEntity<>(newRoute, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{routeId}/assign/{vanId}")
    public ResponseEntity<Route> assignVanToRoute(@PathVariable Long routeId, @PathVariable Long vanId){
        Optional<Van> van = vanService.findVanById(vanId);
        Optional<Route> route = routeService.findRouteById(routeId);
        if (van.isPresent() && route.isPresent()) {
            return new ResponseEntity<>(routeService.assignVanToRoute(route, van), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Route> updateRouteDistance(@PathVariable Long id, @RequestParam(required = true) double distance){
        Optional<Route> route = routeService.findRouteById(id);
        if(route.isPresent()){
            return new ResponseEntity<>(routeService.updateRouteDistance(route, distance), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
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
