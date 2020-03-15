/*package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;

public class History_clientPK implements Serializable {
    private long client_id;
    private long event_id;

    public History_clientPK() {
    }

    public History_clientPK(long client_id, long event_id;) {
        this.client_id = client_id;
        this.event_id = event_id;
    }
}


@Entity
@Table(name = "History_client")

@IdClass(History_clientPK.class)
public class History_client implements Serializable {

    @Id
    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name = "Client_id", referencedColumnName = "Client_id")
    private long client_id;

    @Id
    @Column(name = "Event_id")
    private long event_id;


    public History_client() {
    }

    public Client(long id, String name, String middle_name, String last_name,
                  String phone_number, String address, String email) {
        this.id = id;
        this.name = name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.address = address;
        this.email = email;

    }
}*/