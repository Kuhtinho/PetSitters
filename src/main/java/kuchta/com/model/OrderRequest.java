package kuchta.com.model;

import javax.persistence.*;

@Entity
public class OrderRequest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
