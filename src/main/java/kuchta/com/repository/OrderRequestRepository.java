package kuchta.com.repository;

import kuchta.com.model.orderrequest.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRequestRepository extends JpaRepository<OrderRequest, Long> {

}
