package kuchta.com.service.order;

import kuchta.com.exceptions.ResourceNotFoundException;
import kuchta.com.model.order.OrderRequest;
import kuchta.com.model.petsitter.PetSitter;
import kuchta.com.repository.OrderRequestRepository;
import kuchta.com.repository.PetSitterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderRequestService {

    private final OrderRequestRepository orderRequestRepository;
    private final PetSitterRepository petSitterRepository;

    public void createOrderRequest(OrderRequest orderRequest) {
        orderRequestRepository.save(orderRequest);
    }

    public OrderRequest getOrderRequest(Long orderRequestId) {
        return orderRequestRepository.findById(orderRequestId)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("No such order requests")
        );
    }

    public List<OrderRequest> getOrderRequests(Long petSitterId) {
        PetSitter petSitter = petSitterRepository.findById(petSitterId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Pet Sitter with id = " + petSitterId));
        return petSitter.getOrderRequests();
    }

    public void updateOrderRequest(Long orderRequestId, OrderRequest newOrderRequest) {
        orderRequestRepository.findById(orderRequestId)
                .map(orderRequest -> {
                    orderRequest.setCost(newOrderRequest.getCost());
                    orderRequest.setDealType(newOrderRequest.getDealType());
                    orderRequest.setDays(newOrderRequest.getDays());
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
