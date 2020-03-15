
package dbService.dao;

import dbService.dataSets.Client;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class ClientsDAO {

    private Session session;

    public ClientsDAO(Session session) {
        this.session = session;
    }

    public Client get(long id) throws HibernateException {
        return (Client) session.get(Client.class, id);
    }

    public long getClientId(String last_name) throws HibernateException {
        Criteria criteria = session.createCriteria(Client.class);
        return ((Client) criteria.add(Restrictions.eq("Last_name", last_name)).uniqueResult()).getClientId();
    }

    public long insertClient(String name, String middle_name, String last_name,
                             String phone_number, String address, String email) throws HibernateException {
        return (Long) session.save(new Client(name, middle_name, last_name,
                                   phone_number, address, email));
    }
}
