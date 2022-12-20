package kuchta.com.repository;

import kuchta.com.model.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRequestRepository extends JpaRepository<OrderRequest, Integer> {

    OrderRequest getOrderRequest(int orderRequestId);

}
