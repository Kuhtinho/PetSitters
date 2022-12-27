package kuchta.com.repository;

import kuchta.com.model.petowner.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {

    @Override
    List<PetOwner> findAll();

    PetOwner getPetOwnerById(long id);

}
