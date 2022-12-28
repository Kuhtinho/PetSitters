package kuchta.com.model.petowner;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet_owner_photos")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetOwnerPhoto {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "path")
    private String path;

}
