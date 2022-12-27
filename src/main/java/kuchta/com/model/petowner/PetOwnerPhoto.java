package kuchta.com.model.petowner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet_owner_photos")
public class PetOwnerPhoto {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "path")
    private String path;

}
