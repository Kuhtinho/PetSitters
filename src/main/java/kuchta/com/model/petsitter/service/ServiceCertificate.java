package kuchta.com.model.petsitter.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_certificates")
public class ServiceCertificate {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "path")
    private String path;
}
