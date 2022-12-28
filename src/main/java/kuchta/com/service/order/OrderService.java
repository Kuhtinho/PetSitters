package kuchta.com.service.order;

import kuchta.com.controller.dto.OrderDto;
import kuchta.com.controller.mapper.OrderMapper;
import kuchta.com.exceptions.ResourceNotFoundException;
import kuchta.com.model.order.Order;
import kuchta.com.model.petowner.PetOwner;
import kuchta.com.repository.OrderRepository;
import kuchta.com.repository.PetOwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PetOwnerRepository petOwnerRepository;

    public OrderService(OrderRepository orderRepository, PetOwnerRepository petOwnerRepository) {
        this.orderRepository = orderRepository;
        this.petOwnerRepository = petOwnerRepository;
    }

    public Order newOrder(OrderDto orderDto) {
        return orderRepository.save(OrderMapper.mapToOrder(orderDto));
    }

    public OrderDto getOrder(Long orderId) {
        return OrderMapper.mapToOrderDto(orderRepository.findById(orderId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("No such orders")
                )
        );
    }

    public List<OrderDto> getOrders(Long petSitterId) {
        PetOwner petOwner = petOwnerRepository.getPetOwnerById(petSitterId);
        return OrderMapper.mapToOrderDtoList(petOwner.getOrders());
    }

    public Order updateOrder(Long orderId, OrderDto orderDto) {
        return orderRepository.findById(orderId)
                .map(order -> {
                    order.setPetSitterFeedback(orderDto.petSitterFeedback());
                    order.setPayed(orderDto.payed());
                    return orderRepository.save(order);
                })
                .orElseThrow(
                        () -> new ResourceNotFoundException("Not found Order with id = " + orderId)
                );
    }

}

