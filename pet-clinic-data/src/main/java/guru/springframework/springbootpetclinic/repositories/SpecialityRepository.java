package guru.springframework.springbootpetclinic.repositories;

import guru.springframework.springbootpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Specialty,Long> {
}
