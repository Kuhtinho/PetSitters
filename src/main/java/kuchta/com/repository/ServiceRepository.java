package kuchta.com.repository;

import kuchta.com.model.petsitter.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

    List<Service> findServicesByName(String name);

    List<Service> findServicesByCategoryId(Long categoryId);

    List<Service> findServicesByPetSittersId(Long petSitterId);

}
