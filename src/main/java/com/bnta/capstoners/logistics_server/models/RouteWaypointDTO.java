package com.bnta.capstoners.logistics_server.models;

import java.util.List;

public class RouteWaypointDTO {

    private Long routeId;
    private Double startLat;
    private Double startLong;

    private List<Double> orderWaypoints;

    //FOR LOOP THROUGH A SINGLE LIST
    //IF INDEX IS EVEN APPEND ELEMENT AND ADD COMMA
    //IF INDEX IS ODD APPEND ELEMENT AND ADD SEMI COLON


    public RouteWaypointDTO(Route route, List<Double> orderWaypoints){
        this.routeId = route.getId();
        this.startLat = route.getStartLocationLat();
        this.startLong = route.getStartLocationLong();
        this.orderWaypoints = orderWaypoints;
    }

    public RouteWaypointDTO(){

    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public
    Double getStartLat(){
        return startLat;
    }

    public
    void setStartLat(Double startLat){
        this.startLat = startLat;
    }

    public
    Double getStartLong(){
        return startLong;
    }

    public
    void setStartLong(Double startLong){
        this.startLong = startLong;
    }

    public
    List<Double> getOrderWaypoints(){
        return orderWaypoints;
    }

    public
    void setOrderWaypoints(List<Double> orderWaypoints){
        this.orderWaypoints = orderWaypoints;
    }
}
