package com.bnta.capstoners.logistics_server.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "routes")

public class Route {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @OneToMany
    private List<Order> orders;

    @Column
    private Van van;

    @Column
    private double distance;

    @Column(name = "start_location_long")
    private double startLocationLong;

    @Column(name = "start_location_lat")
    private double startLocationLat;

    public
    Route(String name, List<Order> orders, Van van, double distance, double startLocationLong, double startLocationLat){
        this.name = name;
        this.orders = orders;
        this.van = van;
        this.distance = distance;
        this.startLocationLong = startLocationLong;
        this.startLocationLat = startLocationLat;
    }

    public Route (){

    }

    public
    Long getId(){
        return id;
    }

    public
    void setId(Long id){
        this.id = id;
    }

    public
    String getName(){
        return name;
    }

    public
    void setName(String name){
        this.name = name;
    }

    public
    List<Order> getOrders(){
        return orders;
    }

    public
    void setOrders(List<Order> orders){
        this.orders = orders;
    }

    public
    Van getVan(){
        return van;
    }

    public
    void setVan(Van van){
        this.van = van;
    }

    public
    double getDistance(){
        return distance;
    }

    public
    void setDistance(double distance){
        this.distance = distance;
    }

    public
    double getStartLocationLong(){
        return startLocationLong;
    }

    public
    void setStartLocationLong(double startLocationLong){
        this.startLocationLong = startLocationLong;
    }

    public
    double getStartLocationLat(){
        return startLocationLat;
    }

    public
    void setStartLocationLat(double startLocationLat){
        this.startLocationLat = startLocationLat;
    }
}
