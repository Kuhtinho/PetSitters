package kuchta.com.controller;

import kuchta.com.controller.dto.OrderDto;
import kuchta.com.controller.dto.OrderRequestDto;
import kuchta.com.controller.dto.PetOwnerDto;
import kuchta.com.controller.dto.PetSitterDto;
import kuchta.com.controller.mapper.OrderMapper;
import kuchta.com.controller.mapper.OrderRequestMapper;
import kuchta.com.controller.mapper.PetOwnerMapper;
import kuchta.com.controller.mapper.PetSitterMapper;
import kuchta.com.model.order.Order;
import kuchta.com.model.order.OrderRequest;
import kuchta.com.model.petowner.PetOwner;
import kuchta.com.model.petsitter.PetSitter;
import kuchta.com.model.petsitter.service.Service;
import kuchta.com.service.order.OrderRequestService;
import kuchta.com.service.order.OrderService;
import kuchta.com.service.petowner.PetOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/petOwners")
@RequiredArgsConstructor
public class PetOwnerController {

    private final PetOwnerService petOwnerService;
    private final OrderService orderService;
    private final OrderRequestService orderRequestService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPetOwner(@RequestBody @Valid PetOwnerDto petOwnerDto) {
        PetOwner petOwner = PetOwnerMapper.INSTANCE.toPetOwner(petOwnerDto);
        petOwnerService.createPetOwner(petOwner);
    }

    @GetMapping("/{petOwnerId}")
    public PetOwnerDto getPetOwner(@PathVariable Long petOwnerId) {
        PetOwner petOwner = petOwnerService.getPetOwner(petOwnerId);
        return PetOwnerMapper.INSTANCE.toPetOwnerDto(petOwner);
    }

    @PutMapping({"/{petOwnerId}"})
    @ResponseStatus(HttpStatus.OK)
    public void updatePetOwner(@PathVariable Long petOwnerId, @RequestBody @Valid PetOwnerDto petOwnerDto) {
        PetOwner petOwner = PetOwnerMapper.INSTANCE.toPetOwner(petOwnerDto);
        petOwnerService.updatePetOwner(petOwnerId, petOwner);
    }

    @DeleteMapping("/{petOwnerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePetOwner(@PathVariable Long petOwnerId) {
        petOwnerService.deletePetOwner(petOwnerId);
    }

    @GetMapping("/petSitters")
    public List<PetSitterDto> getPetSittersByProperties(@RequestParam(value = "address", required=false) String city,
                                                     @RequestParam(value = "services", required=false) Set<Service> services,
                                                     @RequestParam(value = "from", required=false)
                                                         @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fromDate,
                                                     @RequestParam(value = "till", required=false)
                                                         @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate tillDate) {
        List<PetSitter> petSitters = petOwnerService.getPetSittersByProperties(city, services, fromDate, tillDate);
        return PetSitterMapper.INSTANCE.map(petSitters);
    }

    @GetMapping("/petSitters/{petSitterId}")
    public PetSitterDto getPetSitter(@PathVariable Long petSitterId) {
        PetSitter petSitter = petOwnerService.getPetSitter(petSitterId);
        return PetSitterMapper.INSTANCE.toPetSitterDto(petSitter);
    }

    @PostMapping("/orderRequests")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrderRequest(@RequestBody OrderRequestDto orderRequestDto) {
        OrderRequest orderRequest = OrderRequestMapper.INSTANCE.toOrderRequest(orderRequestDto);
        orderRequestService.createOrderRequest(orderRequest);
    }

    @PutMapping("/orderRequests{orderRequestId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrderRequest(@PathVariable Long orderRequestId, @RequestBody @Valid OrderRequestDto orderRequestDto) {
        OrderRequest orderRequest = OrderRequestMapper.INSTANCE.toOrderRequest(orderRequestDto);
        orderRequestService.updateOrderRequest(orderRequestId, orderRequest);
    }

    @GetMapping("/{petOwnerId}/orders")
    public List<OrderDto> getOrders(@PathVariable Long petOwnerId) {
        List<Order> orders = orderService.getOrders(petOwnerId);
        return OrderMapper.INSTANCE.map(orders);
    }

}
