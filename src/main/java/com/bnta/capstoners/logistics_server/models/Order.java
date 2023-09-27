package com.bnta.capstoners.logistics_server.models;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "route_id")
    @JsonIgnoreProperties({"orders"})
    private Route route;

    @Column
    private double lng;

    @Column
    private double lat;

    @Column
    private String description;

    @Column
    private LocalDate date;

    @Column
    private boolean delivered;

    @Column
    private String address;

    public Order( double lng, double lat, String description, LocalDate date, String address) {
        this.route = null;
        this.lng = lng;
        this.lat = lat;
        this.description = description;
        this.date = date;
        this.delivered = false;
        this.address = address;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public
    String getAddress(){
        return address;
    }

    public
    void setAddress(String address){
        this.address = address;
    }
}