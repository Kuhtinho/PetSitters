package kuchta.com.service.petsitter;

import kuchta.com.model.petsitter.PetSitter;
import kuchta.com.repository.PetSitterRepository;
import org.springframework.stereotype.Service;

@Service
public class PetSitterService {

    private PetSitterRepository petSitterRepository;

    public PetSitter getPetSitter(long petSitterId) {
        return petSitterRepository.getPetSitterById(petSitterId);
    }
}
