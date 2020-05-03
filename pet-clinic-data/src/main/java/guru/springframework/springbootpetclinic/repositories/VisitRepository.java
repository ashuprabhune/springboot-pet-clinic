package guru.springframework.springbootpetclinic.repositories;

import guru.springframework.springbootpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
