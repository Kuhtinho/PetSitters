package kuchta.com.controller.mapper;

import kuchta.com.controller.dto.OrderDto;
import kuchta.com.model.order.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static List<OrderDto> mapOrderToOrderDtoList(List<Order> orders) {
        return orders.stream()
                .map(OrderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    public static OrderDto mapToOrderDto(Order orderDto) {
        return OrderDto.builder()
                .orderRequestId(orderDto.getOrderRequestId())
                .petOwnerFeedback(orderDto.getPetOwnerFeedback())
                .petSitterFeedback(orderDto.getPetSitterFeedback())
                .payed(orderDto.getPayed())
                .build();
    }

    public static Order mapToOrder(OrderDto orderDto) {
        return Order.builder()
                .orderRequestId(orderDto.orderRequestId())
                .petOwnerFeedback(orderDto.petOwnerFeedback())
                .petSitterFeedback(orderDto.petSitterFeedback())
                .payed(orderDto.payed())
                .build();
    }
}
