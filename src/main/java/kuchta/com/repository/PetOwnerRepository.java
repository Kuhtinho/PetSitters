package kuchta.com.repository;

import kuchta.com.model.petowner.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {

    PetOwner getPetOwnerById(long id);

}
