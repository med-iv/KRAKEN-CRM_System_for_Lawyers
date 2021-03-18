package main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Services")
public class CompanyService implements Serializable {

    @Id
    @Column(name = "Service_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_id_generator")
    @SequenceGenerator(name="service_id_generator", sequenceName = "Service_id_seq", allocationSize=1)
    private long serviceId;

    @Column(name = "Service_name")
    private String serviceName;

    @Column(name = "Description")
    private String description;

    @OneToMany
    @JoinColumn(name = "service_id")
    private List<History> histories = new ArrayList<>();;




    public CompanyService() {
    }

    public CompanyService(long serviceId, String serviceName, String description) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}