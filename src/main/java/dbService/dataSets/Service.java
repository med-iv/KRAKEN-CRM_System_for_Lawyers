package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Services")
public class Service implements Serializable {

    @Id
    @Column(name = "Service_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_id_generator")
    @SequenceGenerator(name="service_id_generator", sequenceName = "Service_id_seq", allocationSize=1)
    private long service_id;

    @Column(name = "Service_name")
    private String service_name;

    @Column(name = "Description")
    private String description;



    public Service() {
    }

    public Service(long service_id, String service_name, String description) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.description = description;
    }

    public long getServiceId() {
        return service_id;
    }

    public void setServiceId(long service_id) {
        this.service_id = service_id;
    }

    public String getServiceName() {
        return service_name;
    }

    public void setServiceName(String service_name) {
        this.service_name = service_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}