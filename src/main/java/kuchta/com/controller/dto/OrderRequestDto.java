package kuchta.com.controller.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record OrderRequestDto (
        Long petOwnerId,
        Long petSitterId,
        Integer isApproved,
        LocalDate date,
        Integer days,
        Double cost,
        String dealType
){
}
