package kuchta.com.service.petsitter;

import kuchta.com.controller.dto.PetSitterDto;
import kuchta.com.controller.mapper.PetSitterMapper;
import kuchta.com.exceptions.ResourceNotFoundException;
import kuchta.com.model.petsitter.PetSitter;
import kuchta.com.repository.PetSitterRepository;
import org.springframework.stereotype.Service;

@Service
public class PetSitterService {

    private final PetSitterRepository petSitterRepository;

    public PetSitterService(PetSitterRepository petSitterRepository) {
        this.petSitterRepository = petSitterRepository;
    }

    public PetSitter createPetSitter(PetSitterDto petSitterDto) {
        return petSitterRepository.save(PetSitterMapper.mapToPetSitter(petSitterDto));
    }

    public PetSitterDto getPetSitter(Long petSitterId) {
        return PetSitterMapper.mapToPetSitterDto(petSitterRepository.getPetSitterById(petSitterId));
    }

    public void updatePetSitter(Long petSitterId, PetSitterDto petSitterDto) {
        petSitterRepository.findById(petSitterId)
                .map(petSitter -> {
                    petSitter.setCity(petSitterDto.city());
                    petSitter.setUserDescription(petSitterDto.userDescription());
                    petSitter.setHomeDescription(petSitterDto.homeDescription());
                    petSitter.setCity(petSitterDto.city());
                    petSitter.setPostcode(petSitterDto.postcode());
                    petSitter.setStreetNumber(petSitterDto.streetNumber());
                    return petSitterRepository.save(petSitter);
                })
                .orElseThrow(
                        () -> new ResourceNotFoundException("Not found Pet Sitter with id = " + petSitterId)
                );
    }

    public void deletePetSitter(Long petSitterId) {
        petSitterRepository.deleteById(petSitterId);
    }

}
