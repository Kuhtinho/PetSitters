package kuchta.com.service.requestorder;

import kuchta.com.model.Order;
import kuchta.com.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order addNewOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    }

    public Order submitOrder(int orderId) {
        return orderRepository.submitOrder(orderId);
    }

    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }
}
