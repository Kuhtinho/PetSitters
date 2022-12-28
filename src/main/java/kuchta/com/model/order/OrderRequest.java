package kuchta.com.model.order;

import kuchta.com.model.petsitter.PetSitter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "order_requests")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "pet_owner_id")
    private Long petOwnerId;

    @Column(name = "pet_sitter_id")
    private Long petSitterId;

    @Column(name = "is_approved")
    private Integer isApproved;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "days")
    private Integer days;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "deal_type")
    private String dealType;

    @ManyToOne
    @JoinColumn(name="pet_sitter_id", nullable=false)
    private PetSitter petSitter;

}
