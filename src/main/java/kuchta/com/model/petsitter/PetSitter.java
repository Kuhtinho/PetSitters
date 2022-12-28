package kuchta.com.model.petsitter;

import kuchta.com.model.order.OrderRequest;
import kuchta.com.model.petsitter.service.Service;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pet_sitters")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetSitter {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "email")
    private String email;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "city")
    private String city;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "street")
    private String street;

    @Column(name = "street_number")
    private int streetNumber;

    @Column(name = "user_description")
    private String userDescription;

    @Column(name = "home_description")
    private String homeDescription;

    @Column(name = "pet_sitter_photo_id")
    private Long petSitterPhotoId;

    @ManyToMany
    @JoinTable(
            name = "services_pet_sitters",
            joinColumns = @JoinColumn(name = "pet_sitter_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service> petSitterServices;

    @OneToMany(mappedBy = "petSitter")
    private List<OrderRequest> orderRequests;

}
