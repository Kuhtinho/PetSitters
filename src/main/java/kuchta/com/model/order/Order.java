package kuchta.com.model.order;

import kuchta.com.model.petowner.PetOwner;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "order_request_id")
    private Long orderRequestId;

    @Column(name = "pet_owner_feedback")
    private String petOwnerFeedback;

    @Column(name = "pet_sitter_feedback")
    private String petSitterFeedback;

    @Column(name = "payed")
    private Integer payed;

    @ManyToOne
    @JoinColumn(name="pet_owner_id", nullable=false)
    private PetOwner petOwner;
}
