package main.repos;

import main.model.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {
    List <History> findByDateBetween(LocalDate date1, LocalDate date2);
}
