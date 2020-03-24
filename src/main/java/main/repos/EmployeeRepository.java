package main.repos;

import main.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Date;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findEmployeeByLogin(String login);
    List <Employee> findByHistories_EventId(Long eventId);
    List <Employee> findAllByHistories_EventIdIn(List<Long> eventIds);
}
