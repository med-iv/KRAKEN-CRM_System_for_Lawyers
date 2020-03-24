package main.repos;

import main.model.CompanyService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyServiceRepository extends CrudRepository<CompanyService, Long> {

}
