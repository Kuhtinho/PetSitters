package kuchta.com.model.petsitter.service;

import kuchta.com.model.petsitter.PetSitter;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "services")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Service {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "service_certificate_id")
    private Long serviceCertificateId;

    @ManyToMany(mappedBy = "petSitterServices")
    private Set<PetSitter> servicePetSitters;

}
