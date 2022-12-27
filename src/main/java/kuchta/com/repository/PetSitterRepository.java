package kuchta.com.repository;

import kuchta.com.model.petsitter.PetSitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetSitterRepository extends JpaRepository<PetSitter, Long> {

    PetSitter getPetSitterById(Long petSitterId);

}
