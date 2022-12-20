package kuchta.com.model;

import kuchta.com.model.petowner.PetOwner;
import kuchta.com.model.petsitter.PetSitter;

import javax.persistence.*;

@Entity
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long petSitterId;
    private long petOwnerId;

}
