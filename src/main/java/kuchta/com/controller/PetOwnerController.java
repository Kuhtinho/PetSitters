package kuchta.com.controller;

import kuchta.com.controller.dto.OrderRequestDto;
import kuchta.com.controller.dto.PetOwnerDto;
import kuchta.com.controller.dto.PetSitterDto;
import kuchta.com.model.orderrequest.OrderRequest;
import kuchta.com.model.petowner.PetOwner;
import kuchta.com.model.petsitter.service.Service;
import kuchta.com.service.petowner.PetOwnerService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/petOwners")
public class PetOwnerController {

    private final PetOwnerService petOwnerService;

    public PetOwnerController(PetOwnerService petOwnerService) {
        this.petOwnerService = petOwnerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetOwner createPetOwner(@RequestBody @Valid PetOwnerDto petOwnerDto) {
        return petOwnerService.newPetSitter(petOwnerDto);
    }

    @PutMapping({"{petOwnerId}"})
    public PetOwner updatePetOwner(@PathVariable Long petOwnerId, @RequestBody @Valid PetOwnerDto petOwnerDto) {
        return petOwnerService.updatePetOwner(petOwnerId, petOwnerDto);
    }

    @GetMapping("/petSitters")
    public List<PetSitterDto> getPetSittersByProperties(@RequestParam(value = "address", required=false) String city,
                                                     @RequestParam(value = "services", required=false) Set<Service> services,
                                                     @RequestParam(value = "from", required=false)
                                                         @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fromDate,
                                                     @RequestParam(value = "till", required=false)
                                                         @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate tillDate) {
        return petOwnerService.getPetSittersByProperties(city, services, fromDate, tillDate);
    }

    @GetMapping("/{petOwnerId}")
    public PetOwnerDto getPetOwner(@PathVariable Long petOwnerId) {
        return petOwnerService.getPetOwner(petOwnerId);
    }

    @GetMapping("petSitters/{petSitterId}")
    public PetSitterDto getPetSitter(@PathVariable Long petSitterId) {
        return petOwnerService.getPetSitter(petSitterId);
    }

    @PostMapping("/orderRequests")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderRequest createOrderRequest(@RequestBody OrderRequestDto orderRequestDto) {
        return petOwnerService.createOrderRequest(orderRequestDto);
    }

    @PutMapping("/orderRequests{id}")
    public OrderRequest updateOrderRequest(@PathVariable Long id, @RequestBody @Valid OrderRequestDto orderRequestDto) {
        return petOwnerService.updateOrderRequest(id, orderRequestDto);
    }

}
