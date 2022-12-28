package kuchta.com.controller;

import kuchta.com.controller.dto.OrderDto;
import kuchta.com.controller.dto.OrderRequestDto;

import kuchta.com.controller.dto.PetSitterDto;
import kuchta.com.model.order.Order;
import kuchta.com.model.petsitter.PetSitter;
import kuchta.com.service.order.OrderRequestService;
import kuchta.com.service.order.OrderService;
import kuchta.com.service.petsitter.PetSitterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/petSitters")
public class PetSitterController {

    private final PetSitterService petSitterService;
    private final OrderService orderService;
    private final OrderRequestService orderRequestService;

    public PetSitterController(PetSitterService petSitterService, OrderService orderService, OrderRequestService orderRequestService) {
        this.petSitterService = petSitterService;
        this.orderService = orderService;
        this.orderRequestService = orderRequestService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetSitter createPetSitter(@RequestBody @Valid PetSitterDto petSitterDto) {
        return petSitterService.createPetSitter(petSitterDto);
    }

    @GetMapping("/{petSitterId}")
    public PetSitterDto getPetSitter(@PathVariable Long petSitterId) {
        return petSitterService.getPetSitter(petSitterId);
    }

    @PutMapping({"/{petSitterId}"})
    @ResponseStatus(HttpStatus.OK)
    public void updatePetSitter(@PathVariable Long petSitterId, @RequestBody @Valid PetSitterDto petSitterDto) {
        petSitterService.updatePetSitter(petSitterId, petSitterDto);
    }

    @DeleteMapping("/{petSitterId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePetSitter(@PathVariable Long petSitterId) {
        petSitterService.deletePetSitter(petSitterId);
    }

    @GetMapping("/{petSitterId}/orderRequests")
    public List<OrderRequestDto> getOrderRequests(@PathVariable Long petSitterId) {
        return orderRequestService.getOrderRequests(petSitterId);
    }

    @GetMapping("/{orderRequestId}")
    public OrderRequestDto getOrderRequest(@PathVariable Long orderRequestId) {
        return orderRequestService.getOrderRequest(orderRequestId);
    }

    @DeleteMapping("/{orderRequestId}")//after declining order request by pet sitter
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrderRequest(@PathVariable Long orderRequestId ) {
        orderRequestService.deleteOrderRequest(orderRequestId);
    }

    @PostMapping("/orders/")//after submitting order request by pet sitter
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody OrderDto orderDto) {
        return orderService.newOrder(orderDto);
    }

    @GetMapping("/orders/{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

    @PutMapping("/orders/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public Order updateOrder(@PathVariable Long orderId, @RequestBody @Valid OrderDto orderDto) {
        return orderService.updateOrder(orderId, orderDto);
    }

}
