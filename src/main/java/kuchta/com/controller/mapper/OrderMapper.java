package kuchta.com.controller.mapper;

import kuchta.com.controller.dto.OrderDto;
import kuchta.com.model.orderrequest.Order;

public class OrderMapper {

    public static Order mapToOrder(OrderDto orderDto) {
        return Order.builder()
                .orderRequestId(orderDto.orderRequestId())
                .petOwnerFeedback(orderDto.petOwnerFeedback())
                .petSitterFeedback(orderDto.petSitterFeedback())
                .payed(orderDto.payed())
                .build();
    }
}
