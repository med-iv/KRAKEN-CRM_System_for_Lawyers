package main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "History")
public class History implements Serializable {

    @Id
    @Column(name = "Event_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_id_generator")
    @SequenceGenerator(name="history_id_generator", sequenceName = "History_id_seq", allocationSize=1)
    private long eventId;

    //@ManyToOne(targetEntity = Service.class)
    //@JoinColumn(name = "Service_id", referencedColumnName = "Service_id")
    @Column(name = "Service_id")
    private long serviceId;

    @Column(name = "Date")
    private LocalDate date;

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

    public History(long eventId, long serviceId, LocalDate date, String description,
                   String contract) {
        this.eventId = eventId;
        this.serviceId = serviceId;
        this.date = date;
        this.description = description;
        this.contract = contract;
    }

    public long getHistoryId() {
        return eventId;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void  setDate(LocalDate date) {
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