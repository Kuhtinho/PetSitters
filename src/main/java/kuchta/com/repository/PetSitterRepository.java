package kuchta.com.repository;

import kuchta.com.model.petsitter.PetSitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetSitterRepository extends JpaRepository<PetSitter, Long> {

    @Override
    List<PetSitter> findAll();

    PetSitter getPetSitterById(Long petSitterId);

    List<PetSitter> findPetSittersByServiceId(Long serviceId);
}
