package kuchta.com.controller;

import kuchta.com.controller.dto.OrderDto;
import kuchta.com.controller.dto.OrderRequestDto;

import kuchta.com.controller.dto.PetSitterDto;
import kuchta.com.controller.mapper.OrderMapper;
import kuchta.com.controller.mapper.OrderRequestMapper;
import kuchta.com.controller.mapper.PetSitterMapper;
import kuchta.com.model.order.Order;
import kuchta.com.model.order.OrderRequest;
import kuchta.com.model.petsitter.PetSitter;
import kuchta.com.service.order.OrderRequestService;
import kuchta.com.service.order.OrderService;
import kuchta.com.service.petsitter.PetSitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/petSitters")
@RequiredArgsConstructor
public class PetSitterController {

    private final PetSitterService petSitterService;
    private final OrderService orderService;
    private final OrderRequestService orderRequestService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPetSitter(@RequestBody @Valid PetSitterDto petSitterDto) {
        PetSitter petSitter = PetSitterMapper.mapToPetSitter(petSitterDto);
        petSitterService.createPetSitter(petSitter);
    }

    @GetMapping("/{petSitterId}")
    public PetSitterDto getPetSitter(@PathVariable Long petSitterId) {
        PetSitter petSitter = petSitterService.getPetSitter(petSitterId);
        return PetSitterMapper.mapToPetSitterDto(petSitter);
    }

    @PutMapping({"/{petSitterId}"})
    @ResponseStatus(HttpStatus.OK)
    public void updatePetSitter(@PathVariable Long petSitterId, @RequestBody @Valid PetSitterDto petSitterDto) {
        PetSitter petSitter = PetSitterMapper.mapToPetSitter(petSitterDto);
        petSitterService.updatePetSitter(petSitterId, petSitter);
    }

    @DeleteMapping("/{petSitterId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePetSitter(@PathVariable Long petSitterId) {
        petSitterService.deletePetSitter(petSitterId);
    }

    @GetMapping("/{petSitterId}/orderRequests")
    public List<OrderRequestDto> getOrderRequests(@PathVariable Long petSitterId) {
        List<OrderRequest> orderRequests = orderRequestService.getOrderRequests(petSitterId);
        return OrderRequestMapper.mapToOrderRequestDtoList(orderRequests);
    }

    @GetMapping("/{orderRequestId}")
    public OrderRequestDto getOrderRequest(@PathVariable Long orderRequestId) {
        OrderRequest orderRequest = orderRequestService.getOrderRequest(orderRequestId);
        return OrderRequestMapper.mapToOrderRequestDto(orderRequest);
    }

    @DeleteMapping("/{orderRequestId}")//after declining order request by pet sitter
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrderRequest(@PathVariable Long orderRequestId ) {
        orderRequestService.deleteOrderRequest(orderRequestId);
    }

    @PostMapping("/orders/")//after submitting order request by pet sitter
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        orderService.createOrder(order);
    }

    @GetMapping("/orders/{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId) {
        Order order = orderService.getOrder(orderId);
        return OrderMapper.mapToOrderDto(order);
    }

    @PutMapping("/orders/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrder(@PathVariable Long orderId, @RequestBody @Valid OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        orderService.updateOrder(orderId, order);
    }

}
