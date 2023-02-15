package kuchta.com.controller.mapper;

import kuchta.com.controller.dto.OrderDto;
import kuchta.com.controller.dto.OrderRequestDto;
import kuchta.com.model.order.Order;
import kuchta.com.model.order.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface OrderRequestMapper {
    OrderRequestMapper INSTANCE = Mappers.getMapper( OrderRequestMapper.class );
    @Mapping(target="petOwnerId", source="petOwnerId")
    @Mapping(target="petSitterId", source="petSitterId")
    @Mapping(target = "isApproved", source = "isApproved")
    @Mapping(target = "date", source = "date",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "days", source = "days")
    @Mapping(target = "cost", source = "cost")
    @Mapping(target = "dealType", source = "dealType")
    OrderRequestDto toOrderRequestDto(OrderRequest entity);

    @Mapping(target="petOwnerId", source="petOwnerId")
    @Mapping(target="petSitterId", source="petSitterId")
    @Mapping(target = "isApproved", source = "isApproved")
    @Mapping(target = "date", source = "date",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "days", source = "days")
    @Mapping(target = "cost", source = "cost")
    @Mapping(target = "dealType", source = "dealType")
    OrderRequest toOrderRequest(OrderRequestDto dto);

    List<OrderRequestDto> map(List<OrderRequest> orderRequests);

}
