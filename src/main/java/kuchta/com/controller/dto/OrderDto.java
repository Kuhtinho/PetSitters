package kuchta.com.controller.dto;

import lombok.Builder;

@Builder
public record OrderDto (
        Long orderRequestId,
        String petOwnerFeedback,
        String petSitterFeedback,
        Integer payed
){
}
