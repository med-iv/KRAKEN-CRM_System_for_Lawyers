package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "History")
public class History implements Serializable {

    @Id
    @Column(name = "Event_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_id_generator")
    @SequenceGenerator(name="history_id_generator", sequenceName = "History_id_seq", allocationSize=1)
    private long event_id;

    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "Service_id", referencedColumnName = "Service_id")
    private long service_id;

    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "Description")
    private String description;

    @Column(name = "Contract")
    private String contract;

    @ManyToMany(mappedBy = "histories", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private List<Client> clients = new ArrayList<Client>();

    @ManyToMany(mappedBy = "histories", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private List<Employee> employees = new ArrayList<Employee>();



    public History() {
    }

    public History(long event_id, long service_id, Date date, String description,
                   String contract) {
        this.event_id = event_id;
        this.service_id = service_id;
        this.date = date;
        this.description = description;
        this.contract = contract;
    }

    public long getHistoryId() {
        return event_id;
    }

    public void setHistoryId(long event_id) {
        this.event_id = event_id;
    }

    public long getServiceId() {
        return service_id;
    }

    public void setServiceId(long service_id) {
        this.service_id = service_id;
    }

    public Date getDate() {
        return date;
    }

    public void  setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

}