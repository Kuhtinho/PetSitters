package kuchta.com.model.petsitter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "pet_sitters")
public class PetSitter {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(
            name = "services_pet_sitters",
            joinColumns = @JoinColumn(name = "pet_sitter_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service> petSitterServices;

    @Column(name = "username")
    private String username;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "city")
    private String city;

    @Column(name = "email")
    private String email;

    @Column(name = "pesel")
    private int pesel;

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
    private int petSitterPhotoId;
}
