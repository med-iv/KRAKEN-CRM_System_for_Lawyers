package main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "Clients")
public class Client implements Serializable {

    @Id
    @Column(name = "Client_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_generator")
    @SequenceGenerator(name="client_id_generator", sequenceName = "Client_id_seq", allocationSize=1)
    private long client_id;

    @Column(name = "Name", length=50)
    private String name;

    @Column(name = "Middle_name", length=50)
    private String middle_name;

    @Column(name = "Last_name", nullable = false, length=50)
    private String last_name;

    @Column(name = "Phone_number", length=50)
    private String phone_number;

    @Column(name = "Address")
    private String address;

    @Column(name = "Email", length=50)
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<History> histories = new ArrayList<History>();



    public Client() {
    }

    public Client(/*long client_id,*/ String name, String middle_name, String last_name,
                          String phone_number, String address, String email) {
        //this.client_id = client_id;
        this.name = name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.address = address;
        this.email = email;

    }

    public long getClientId() {
        return client_id;
    }

    public String getName() {
        return name;
    }

    public void  setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middle_name;
    }

    public void setMiddleName(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }




    @Override
    public String toString() {
        return "ClientsDataSet{" +
                "Client_id=" + client_id +
                ", name='" + name + '\'' +
                '}';
    }
}