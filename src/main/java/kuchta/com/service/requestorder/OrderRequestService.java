package kuchta.com.service.requestorder;

import kuchta.com.model.OrderRequest;
import kuchta.com.repository.OrderRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderRequestService {

    @Autowired
    private OrderRequestRepository orderRequestRepository;

    public OrderRequest getOrderRequest(int petSitterId) {
        return orderRequestRepository.getOrderRequest(petSitterId);
    }

    public void deleteOrderRequest(int orderRequestId) {
        orderRequestRepository.deleteById(orderRequestId);
    }

}
