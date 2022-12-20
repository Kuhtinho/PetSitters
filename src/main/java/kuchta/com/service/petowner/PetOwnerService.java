package kuchta.com.service.petowner;

import kuchta.com.model.petsitter.PetSitter;
import kuchta.com.repository.PetOwnerRepository;
import kuchta.com.repository.PetSitterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetOwnerService {

    private final PetOwnerRepository petOwnerRepository;

    private final PetSitterRepository petSitterRepository;

    public PetOwnerService(PetOwnerRepository petOwnerRepository, PetSitterRepository petSitterRepository) {
        this.petOwnerRepository = petOwnerRepository;
        this.petSitterRepository = petSitterRepository;
    }

    public List<PetSitter> findPetSitters() {
        return petSitterRepository.findAll();
    }

    public List<PetSitter> findPetSittersByServiceId(long serviceId) {
        return petSitterRepository.findPetSittersByServiceId(serviceId);
    }

    public List<PetSitter> findPetSittersByAddress() {
        return null;
    }

    public List<PetSitter> findPetSittersByDate() {
        return null;
    }

    public List<PetSitter> findPetSitterByPrice() {
        return null;
    }
}
