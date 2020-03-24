package main.repos;

import main.model.Client;
import main.model.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByHistories_EventId(Long eventId);
    List <Client> findAllByHistories_EventIdIn(List<Long> eventIds);
}
