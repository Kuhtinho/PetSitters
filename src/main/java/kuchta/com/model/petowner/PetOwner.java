package kuchta.com.model.petowner;

import kuchta.com.model.order.Order;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pet_owners")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetOwner {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "city")
    private String city;

    @Column(name = "email")
    private String email;

    @Column(name = "pesel")
    private String pesel;

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

    @Column(name = "pet_description")
    private String petDescription;

    @Column(name = "pet_sitter_photo_id")
    private Long petOwnerPhotoId;

    @OneToMany(mappedBy = "petOwner")
    private List<Order> orders;

}
