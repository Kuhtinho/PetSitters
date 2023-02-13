package kuchta.com.service.petowner;

import kuchta.com.exceptions.ResourceNotFoundException;
import kuchta.com.model.petowner.PetOwner;
import kuchta.com.model.petsitter.PetSitter;
import kuchta.com.repository.PetOwnerRepository;
import kuchta.com.repository.PetSitterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PetOwnerService {

    private final PetOwnerRepository petOwnerRepository;
    private final PetSitterRepository petSitterRepository;

    public void createPetOwner(PetOwner petOwner) {
        petOwnerRepository.save(petOwner);
    }

    public PetOwner getPetOwner(Long petOwnerId) { // get pet owner profile (when pet owner clicks 'home')
        return petOwnerRepository.findById(petOwnerId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Pet Owner with id = " + petOwnerId));
    }

    public void updatePetOwner(Long id, PetOwner newPetOwner) {
        petOwnerRepository.findById(id)
                .map(petOwner -> {
                    petOwner.setCity(newPetOwner.getCity());
                    petOwner.setPostcode(newPetOwner.getPostcode());
                    petOwner.setStreetNumber(newPetOwner.getStreetNumber());
                    petOwner.setUserDescription(newPetOwner.getUserDescription());
                    petOwner.setHomeDescription(newPetOwner.getHomeDescription());
                    petOwner.setPetDescription(newPetOwner.getPetDescription());
                    petOwner.setPesel(newPetOwner.getPesel());

                    return petOwnerRepository.save(petOwner);
                })
                .orElseThrow(
                        () -> new ResourceNotFoundException("Not found Pet Owner with id = " + id)
                );
    }

    public void deletePetOwner(Long id) {
        petOwnerRepository.deleteById(id);
    }

    public List<PetSitter> getPetSittersByProperties(String city,
                                                        Set<kuchta.com.model.petsitter.service.Service> services,
                                                        LocalDate fromDate,
                                                        LocalDate tillDate) {
        List<PetSitter> petSitters = petSitterRepository.findAll();
        return petSitters.stream()
                .filter(petSitter ->
                        petSitter.getCity().equals(city) &&
                                petSitter.getPetSitterServices().equals(services))
                .toList();
    }

    public PetSitter getPetSitter(Long petSitterId) { // get profile of suitable pet sitter from list
        return petSitterRepository.getPetSitterById(petSitterId);
    }

}

