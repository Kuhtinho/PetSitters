package kuchta.com.controller;

import kuchta.com.model.Order;
import kuchta.com.model.OrderRequest;
import kuchta.com.model.petsitter.PetSitter;
import kuchta.com.service.requestorder.OrderRequestService;
import kuchta.com.service.requestorder.OrderService;
import kuchta.com.service.petsitter.PetSitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/petsitters")
public class PetSitterController {

    @Autowired
    PetSitterService petSitterService;
    @Autowired
    OrderRequestService orderRequestService;
    @Autowired
    OrderService orderService;


    @GetMapping("/{petSitterId}")
    PetSitter getPetSitter(@PathVariable int petSitterId) {
        return petSitterService.getPetSitter(petSitterId);
/*          return json with all information about petsitter
            (name, surname, address, mail, phone number, description, attachments)*/
    }

    @GetMapping("/order-request/{petSitterId}")
    OrderRequest getOrderRequest(@PathVariable int petSitterId) {
        return orderRequestService.getOrderRequest(petSitterId);
/*           return list of services,
             type of contract (call/meet or sign the document),
             date of service*/
    }

    @DeleteMapping("/order-request/{orderRequest}") //after declining order request by pet sitter
    void deleteOrderRequest(@PathVariable int orderRequest) {
        orderRequestService.deleteOrderRequest(orderRequest);
    }

    @PostMapping("orders/") //after submitting order request by pet sitter
    Order newOrder(@RequestBody Order newOrder) {
        return orderService.addNewOrder(newOrder);
    }

    @PutMapping("orders/{orderId}") //after submitting order by pet sitter
    Order submitOrder(@PathVariable int orderId) {
        return orderService.submitOrder(orderId);
    }

    @DeleteMapping("/orders/{orderId}") //after declining order request by pet sitter
    void deleteOrder(@PathVariable int orderId) {
        orderService.deleteOrder(orderId);
    }
}
