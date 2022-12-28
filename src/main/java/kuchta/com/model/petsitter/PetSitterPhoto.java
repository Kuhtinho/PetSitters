package kuchta.com.model.petsitter;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet_sitter_photos")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetSitterPhoto {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "path")
    private String path;

}
