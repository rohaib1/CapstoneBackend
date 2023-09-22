package com.bnta.capstoners.logistics_server.models;

import java.util.List;

public
class RouteDTO {

    private String routeName;
    private List<Long> orderIds;
    private Long vanId;
    private double distance;
    private double startLocationLong;
    private double startLocationLat;

    public
    RouteDTO(String routeName, List<Long> orderIds, Long vanId, double distance, double startLocationLong, double startLocationLat){
        this.routeName = routeName;
        this.orderIds = orderIds;
        this.vanId = vanId;
        this.distance = distance;
        this.startLocationLong = startLocationLong;
        this.startLocationLat = startLocationLat;
    }

    public RouteDTO(){

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
    List<Long> getOrderIds(){
        return orderIds;
    }

    public
    void setOrderIds(List<Long> orderIds){
        this.orderIds = orderIds;
    }

    public
    Long getVanId(){
        return vanId;
    }

    public
    void setVanId(Long vanId){
        this.vanId = vanId;
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
