package kuchta.com.service.order;

import kuchta.com.controller.dto.OrderRequestDto;
import kuchta.com.controller.mapper.OrderRequestMapper;
import kuchta.com.exceptions.ResourceNotFoundException;
import kuchta.com.model.order.OrderRequest;
import kuchta.com.model.petsitter.PetSitter;
import kuchta.com.repository.OrderRequestRepository;
import kuchta.com.repository.PetSitterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderRequestService {

    private final OrderRequestRepository orderRequestRepository;
    private final PetSitterRepository petSitterRepository;

    public OrderRequestService(OrderRequestRepository orderRequestRepository, PetSitterRepository petSitterRepository) {
        this.orderRequestRepository = orderRequestRepository;
        this.petSitterRepository = petSitterRepository;
    }

    public OrderRequest createOrderRequest(OrderRequestDto orderRequestDto) {
        return orderRequestRepository.save(OrderRequestMapper.mapToOrderRequest(orderRequestDto));
    }

    public List<OrderRequestDto> getOrderRequests(Long petSitterId) {
        PetSitter petSitter = petSitterRepository.getPetSitterById(petSitterId);
        return OrderRequestMapper.mapToOrderRequestDtoList(petSitter.getOrderRequests());
    }

    public OrderRequestDto getOrderRequest(Long orderRequestId) {
        return OrderRequestMapper.mapToOrderRequestDto(
                orderRequestRepository.findById(orderRequestId)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("No such orders")
                        )
        );
    }

    public OrderRequest updateOrderRequest(Long orderRequestId, OrderRequestDto orderRequestDto) {
        return orderRequestRepository.findById(orderRequestId)
                .map(orderRequest -> {
                    orderRequest.setCost(orderRequestDto.cost());
                    orderRequest.setDealType(orderRequestDto.dealType());
                    orderRequest.setDays(orderRequestDto.days());
                    return orderRequestRepository.save(orderRequest);
                })
                .orElseThrow(
                        () -> new ResourceNotFoundException("Not found Order Request with id = " + orderRequestId)
                );
    }

    public void deleteOrderRequest(Long orderRequestId) {
        orderRequestRepository.deleteById(orderRequestId);
    }

}
