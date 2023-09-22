package com.bnta.capstoners.logistics_server.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "routes")

public class Route {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String routeName;

    @OneToMany(mappedBy = "route")
    @JsonIgnoreProperties({"route"})
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "van_id")
    @JsonIgnoreProperties({"routes"})
    private Van van;

    @Column
    private double distance;

    @Column(name = "start_location_long")
    private double startLocationLong;

    @Column(name = "start_location_lat")
    private double startLocationLat;

    public Route(String routeName, List<Order> orders, double startLocationLong, double startLocationLat){
        this.routeName = routeName;
        this.orders = orders;
        this.van = null;
        this.distance = 0;
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
    String getRouteName(){
        return routeName;
    }

    public
    void setRouteName(String routeName){
        this.routeName = routeName;
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
