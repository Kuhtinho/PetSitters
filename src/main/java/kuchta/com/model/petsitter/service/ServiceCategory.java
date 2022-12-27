package kuchta.com.model.petsitter.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_categories")
public class ServiceCategory {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

}
