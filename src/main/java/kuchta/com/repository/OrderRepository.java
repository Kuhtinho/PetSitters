package kuchta.com.repository;

import kuchta.com.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order save(Order newOrder);

    Order submitOrder(int orderId);

    Order getOrder(int orderId);
}
