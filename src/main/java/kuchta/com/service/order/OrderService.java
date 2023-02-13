package kuchta.com.service.order;

import kuchta.com.exceptions.ResourceNotFoundException;
import kuchta.com.model.order.Order;
import kuchta.com.model.petowner.PetOwner;
import kuchta.com.repository.OrderRepository;
import kuchta.com.repository.PetOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final PetOwnerRepository petOwnerRepository;

    public void createOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("No such orders")
                );
    }

    public List<Order> getOrders(Long petSitterId) {
        PetOwner petOwner = petOwnerRepository.getPetOwnerById(petSitterId);
        return petOwner.getOrders();
    }

    public void updateOrder(Long orderId, Order newOrder) {
        orderRepository.findById(orderId)
                .map(order -> {
                    order.setPetSitterFeedback(newOrder.getPetSitterFeedback());
                    order.setPayed(newOrder.getPayed());
                    return orderRepository.save(order);
                })
                .orElseThrow(
                        () -> new ResourceNotFoundException("Not found Order with id = " + orderId));
    }

}

