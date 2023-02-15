package kuchta.com.controller.mapper;

import kuchta.com.controller.dto.OrderDto;
import kuchta.com.model.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper( OrderMapper.class );
    @Mapping(target="orderRequestId", source="orderRequestId")
    @Mapping(target="petOwnerFeedback", source="petOwnerFeedback")
    @Mapping(target = "petSitterFeedback", source = "petSitterFeedback")
    @Mapping(target = "payed", source = "payed")
    OrderDto toOrderDto(Order entity);

    @Mapping(target="orderRequestId", source="orderRequestId")
    @Mapping(target="petOwnerFeedback", source="petOwnerFeedback")
    @Mapping(target = "petSitterFeedback", source = "petSitterFeedback")
    @Mapping(target = "payed", source = "payed")
    Order toOrder(OrderDto dto);

    List<OrderDto> map(List<Order> orders);
}
