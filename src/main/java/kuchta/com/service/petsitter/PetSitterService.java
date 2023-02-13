package kuchta.com.service.petsitter;

import kuchta.com.exceptions.ResourceNotFoundException;
import kuchta.com.model.petsitter.PetSitter;
import kuchta.com.repository.PetSitterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetSitterService {

    private final PetSitterRepository petSitterRepository;

    public void createPetSitter(PetSitter petSitter) {
        petSitterRepository.save(petSitter);
    }

    public PetSitter getPetSitter(Long petSitterId) {
        return petSitterRepository.findById(petSitterId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Pet Sitter with id = " + petSitterId));
    }

    public void updatePetSitter(Long petSitterId, PetSitter newPetSitter) {
        petSitterRepository.findById(petSitterId)
                .map(petSitter -> {
                    petSitter.setCity(newPetSitter.getCity());
                    petSitter.setPostcode(newPetSitter.getPostcode());
                    petSitter.setStreetNumber(newPetSitter.getStreetNumber());
                    petSitter.setUserDescription(newPetSitter.getUserDescription());
                    petSitter.setHomeDescription(newPetSitter.getHomeDescription());
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
