package kuchta.com.service.petowner;

import kuchta.com.controller.dto.OrderRequestDto;
import kuchta.com.controller.dto.PetOwnerDto;
import kuchta.com.controller.dto.PetSitterDto;
import kuchta.com.controller.mapper.OrderRequestMapper;
import kuchta.com.controller.mapper.PetOwnerMapper;
import kuchta.com.controller.mapper.PetSitterMapper;
import kuchta.com.exceptions.ResourceNotFoundException;
import kuchta.com.model.orderrequest.OrderRequest;
import kuchta.com.model.petowner.PetOwner;
import kuchta.com.model.petsitter.PetSitter;
import kuchta.com.repository.OrderRequestRepository;
import kuchta.com.repository.PetOwnerRepository;
import kuchta.com.repository.PetSitterRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class PetOwnerService {

    private final PetOwnerRepository petOwnerRepository;

    private final PetSitterRepository petSitterRepository;

    private final OrderRequestRepository orderRequestRepository;

    public PetOwnerService(PetOwnerRepository petOwnerRepository,
                           PetSitterRepository petSitterRepository,
                           OrderRequestRepository orderRequestRepository) {
        this.petOwnerRepository = petOwnerRepository;
        this.petSitterRepository = petSitterRepository;
        this.orderRequestRepository = orderRequestRepository;
    }

    public PetOwner newPetSitter(PetOwnerDto petOwnerDto) {
        return petOwnerRepository.save(PetOwnerMapper.mapToPetOwner(petOwnerDto));
    }

    public PetOwner updatePetOwner(Long id, PetOwnerDto petOwnerDto) {
        return petOwnerRepository.findById(id)
                .map(petOwner -> {
                    petOwner.setCity(petOwnerDto.city());
                    petOwner.setUserDescription(petOwnerDto.userDescription());
                    petOwner.setHomeDescription(petOwnerDto.homeDescription());
                    petOwner.setPetDescription(petOwnerDto.petDescription() );
                    petOwner.setCity(petOwnerDto.city());
                    petOwner.setPesel(petOwnerDto.pesel());
                    petOwner.setPostcode(petOwnerDto.postcode());
                    petOwner.setStreetNumber(petOwnerDto.streetNumber());
                    return petOwnerRepository.save(petOwner);
                })
                .orElseThrow(
                        () -> new ResourceNotFoundException("Not found Pet Owner with id = " + id)
                );
    }

    public List<PetSitterDto> getPetSittersByProperties(String city,
                                                        Set<kuchta.com.model.petsitter.service.Service> services,
                                                        LocalDate fromDate,
                                                        LocalDate tillDate) {
        List<PetSitter> petSitters = petSitterRepository.findAll();
        List<PetSitter> neededPetSitters = petSitters.stream()
                .filter(petSitter ->
                        petSitter.getCity().equals(city) &&
                                petSitter.getPetSitterServices().equals(services))
                .toList();
        return PetSitterMapper.mapPetSitterToPetSitterDtoList(neededPetSitters);
    }

    public PetOwnerDto getPetOwner(Long petOwnerId) { // get pet owner profile (when pet owner clicks 'home')
        return PetOwnerMapper.mapToPetOwnerDto(petOwnerRepository.getPetOwnerById(petOwnerId));
    }

    public PetSitterDto getPetSitter(Long petSitterId) { // get profile of suitable pet sitter from list
        return PetSitterMapper.mapToPetSitterDto(petSitterRepository.getPetSitterById(petSitterId));
    }

    public OrderRequest createOrderRequest(OrderRequestDto orderRequestDto) {
        return orderRequestRepository.save(OrderRequestMapper.mapToOrderRequest(orderRequestDto));
    }

    public OrderRequest updateOrderRequest(Long id, OrderRequestDto orderRequestDto) {
        return orderRequestRepository.findById(id)
                .map(orderRequest -> {
                    orderRequest.setCost(orderRequestDto.cost());
                    orderRequest.setDealType(orderRequestDto.dealType());
                    orderRequest.setDays(orderRequestDto.days());
                    return orderRequestRepository.save(orderRequest);
                })
                .orElseThrow(
                        () -> new ResourceNotFoundException("Not found Order Request with id = " + id)
                );
    }

}
