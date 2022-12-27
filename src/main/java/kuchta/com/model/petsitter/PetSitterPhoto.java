package kuchta.com.model.petsitter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet_sitter_photos")
public class PetSitterPhoto {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "path")
    private String path;
}
