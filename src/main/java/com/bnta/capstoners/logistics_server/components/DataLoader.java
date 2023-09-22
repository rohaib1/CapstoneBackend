package com.bnta.capstoners.logistics_server.components;

import com.bnta.capstoners.logistics_server.models.Order;
import com.bnta.capstoners.logistics_server.models.Route;
import com.bnta.capstoners.logistics_server.repositories.OrderRepository;
import com.bnta.capstoners.logistics_server.repositories.RouteRepository;
import com.bnta.capstoners.logistics_server.repositories.VanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public
class DataLoader implements ApplicationRunner {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    VanRepository vanRepository;

    public
    DataLoader(){

    }

    @Override
    public
    void run(ApplicationArguments args) throws Exception{
        List<Order> orders = Arrays.asList(
                new Order(51.501277, -0.140780, "Hairdryer", LocalDate.of(2023, 9, 8)),
                new Order(51.501307, -0.092973, "Toaster", LocalDate.of(2023, 9, 8)),
                new Order(51.513297, -0.159024, "Coffee Maker", LocalDate.of(2023, 9, 9)),
                new Order(51.536149, -0.154428, "Blender", LocalDate.of(2023, 9, 10)),
                new Order(51.529774, -0.128646, "Vacuum Cleaner", LocalDate.of(2023, 9, 11)),
                new Order(51.528213, -0.102621, "Hair Straightener", LocalDate.of(2023, 9, 12)),
                new Order(51.508376, -0.079401, "Microwave", LocalDate.of(2023, 9, 13)),
                new Order(51.498431, -0.061480, "Kettle", LocalDate.of(2023, 9, 14)),
                new Order(51.486531, -0.088410, "Iron", LocalDate.of(2023, 9, 15)),
                new Order(51.479693, -0.141626, "Toaster", LocalDate.of(2023, 9, 16))
        );
        orderRepository.saveAll(orders);

        List<Route> routes = Arrays.asList(
                new Route("Route 001", orders, 51.500832, -0.124638)
        );
        routeRepository.saveAll(routes);
    }
}
