package kuchta.com.model.orderrequest;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_request_id")
    private Long orderRequestId;

    @Column(name = "pet_owner_feedback")
    private String petOwnerFeedback;

    @Column(name = "pet_sitter_feedback")
    private String petSitterFeedback;

    @Column(name = "payed")
    private Integer payed;
}
