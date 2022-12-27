package kuchta.com.service.petsitter;

import kuchta.com.controller.dto.OrderDto;
import kuchta.com.controller.dto.OrderRequestDto;
import kuchta.com.controller.dto.PetSitterDto;
import kuchta.com.controller.mapper.OrderMapper;
import kuchta.com.controller.mapper.OrderRequestMapper;
import kuchta.com.controller.mapper.PetSitterMapper;
import kuchta.com.exceptions.ResourceNotFoundException;
import kuchta.com.model.orderrequest.Order;
import kuchta.com.model.petsitter.PetSitter;
import kuchta.com.repository.OrderRepository;
import kuchta.com.repository.OrderRequestRepository;
import kuchta.com.repository.PetSitterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetSitterService {

    private final PetSitterRepository petSitterRepository;

    private final OrderRepository orderRepository;
    private final OrderRequestRepository orderRequestRepository;

    public PetSitterService(PetSitterRepository petSitterRepository, OrderRepository orderRepository,
                            OrderRequestRepository orderRequestRepository) {
        this.petSitterRepository = petSitterRepository;
        this.orderRepository = orderRepository;
        this.orderRequestRepository = orderRequestRepository;
    }

    public PetSitter createPetSitter(PetSitterDto petSitterDto) {
        return petSitterRepository.save(PetSitterMapper.mapToPetSitter(petSitterDto));
    }

    public PetSitterDto getPetSitter(Long petSitterId) {
        return PetSitterMapper.mapToPetSitterDto(petSitterRepository.getPetSitterById(petSitterId));
    }

    public void updatePetSitter(Long petSitterId, PetSitterDto petSitterDto) {
        petSitterRepository.findById(petSitterId)
                .map(petSitter -> {
                    petSitter.setCity(petSitterDto.city());
                    petSitter.setUserDescription(petSitterDto.userDescription());
                    petSitter.setHomeDescription(petSitterDto.homeDescription());
                    petSitter.setCity(petSitterDto.city());
                    petSitter.setPostcode(petSitterDto.postcode());
                    petSitter.setStreetNumber(petSitterDto.streetNumber());
                    return petSitterRepository.save(petSitter);
                })
                .orElseThrow(
                        () -> new ResourceNotFoundException("Not found Pet Sitter with id = " + petSitterId)
                );
    }

    public void deletePetSitter(Long petSitterId) {
        petSitterRepository.deleteById(petSitterId);
    }

    public List<OrderRequestDto> getOrderRequests(Long petSitterId) {
        PetSitter petSitter = petSitterRepository.getPetSitterById(petSitterId);
        return OrderRequestMapper.mapOrderRequestToOrderRequestList(petSitter.getOrderRequests().stream().toList());
    }

    public OrderRequestDto getOrderRequest(Long orderRequestId) {
        return OrderRequestMapper.mapToOrderRequestDto(
                orderRequestRepository.findById(orderRequestId)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("No such orders")
                        )
        );
    }

    public void deleteOrderRequest(Long orderRequestId) {
        orderRequestRepository.deleteById(orderRequestId);
    }

    public Order newOrder(OrderDto orderDto) {
        return orderRepository.save(OrderMapper.mapToOrder(orderDto));
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
