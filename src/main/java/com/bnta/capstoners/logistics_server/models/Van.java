package com.bnta.capstoners.logistics_server.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="vans")
public class Van {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "van")
    @JsonIgnoreProperties({"van"})
    private List<Route> routes;

    @Column
    private String driverName;

    @Column
    private int capacity;

    @Column
    private String model;

    public Van( String driverName, int capacity, String model) {

        this.routes = new ArrayList<>();
        this.driverName = driverName;
        this.capacity = capacity;
        this.model = model;
    }

    public Van() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
