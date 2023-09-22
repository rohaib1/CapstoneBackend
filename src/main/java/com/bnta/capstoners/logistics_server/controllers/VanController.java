package com.bnta.capstoners.logistics_server.controllers;

import com.bnta.capstoners.logistics_server.models.Route;
import com.bnta.capstoners.logistics_server.models.Van;
import com.bnta.capstoners.logistics_server.services.RouteService;
import com.bnta.capstoners.logistics_server.services.VanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/vans")
public class VanController {

    @Autowired
    VanService vanService;

    @Autowired
    RouteService routeService;

    @GetMapping
    public ResponseEntity<List<Van>> getVans(){
        return new ResponseEntity<>(vanService.findAllVans(), HttpStatus.FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Van> getVanById(@PathVariable Long id){
        Optional<Van> van = vanService.findVanById(id);
        if(van.isPresent()){
            return new ResponseEntity<>(van.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

//    @PatchMapping(value = "/{vanId}/assign/{routeId}")
//    public ResponseEntity<Van> assignRouteToVan(@PathVariable Long vanId, @PathVariable Long routeId){
//        Optional<Van> van = vanService.findVanById(vanId);
//        Optional<Route> route = routeService.findRouteById(routeId);
//        if (van.isPresent() && route.isPresent()) {
//            return new ResponseEntity<>(vanService.updateVan(vanId, routeId), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }
}
