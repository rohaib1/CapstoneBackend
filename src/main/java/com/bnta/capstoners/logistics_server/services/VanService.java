package com.bnta.capstoners.logistics_server.services;

import com.bnta.capstoners.logistics_server.models.Route;
import com.bnta.capstoners.logistics_server.models.Van;
import com.bnta.capstoners.logistics_server.repositories.RouteRepository;
import com.bnta.capstoners.logistics_server.repositories.VanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VanService {

    @Autowired
    VanRepository vanRepository;

    @Autowired
    RouteRepository routeRepository;

    public List<Van> findAllVans(){
        return vanRepository.findAll();
    }

    public Optional<Van> findVanById(Long id){
        return vanRepository.findById(id);
    }

//    public Van updateVan(Long vanId, Long routeId){
//        Van vanToUpdate = vanRepository.findById(vanId).get();
//        Route routeToAdd = routeRepository.findById(routeId).get();
//        vanToUpdate.addRoute(routeToAdd);
//        vanRepository.save(vanToUpdate);
//        return vanToUpdate;
//    }
}
