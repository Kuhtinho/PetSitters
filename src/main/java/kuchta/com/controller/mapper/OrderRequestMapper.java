package kuchta.com.controller.mapper;

import kuchta.com.controller.dto.OrderRequestDto;
import kuchta.com.model.order.OrderRequest;

import java.util.List;
import java.util.stream.Collectors;

public class OrderRequestMapper {

    public static List<OrderRequestDto> mapOrderRequestToOrderRequestDtoList(List<OrderRequest> orderRequests) {
        return orderRequests.stream()
                .map(OrderRequestMapper::mapToOrderRequestDto)
                .collect(Collectors.toList());
    }

    public static OrderRequestDto mapToOrderRequestDto(OrderRequest orderRequest) {
        return OrderRequestDto.builder()
                .petOwnerId(orderRequest.getPetOwnerId())
                .petSitterId(orderRequest.getPetSitterId())
                .isApproved(orderRequest.getIsApproved())
                .date(orderRequest.getDate())
                .days(orderRequest.getDays())
                .cost(orderRequest.getCost())
                .dealType(orderRequest.getDealType())
                .build();
    }

    public static OrderRequest mapToOrderRequest(OrderRequestDto orderRequestDto) {
        return OrderRequest.builder()
                .petOwnerId(orderRequestDto.petOwnerId())
                .petSitterId(orderRequestDto.petSitterId())
                .isApproved(orderRequestDto.isApproved())
                .date(orderRequestDto.date())
                .days(orderRequestDto.days())
                .cost(orderRequestDto.cost())
                .dealType(orderRequestDto.dealType())
                .build();
    }
}
