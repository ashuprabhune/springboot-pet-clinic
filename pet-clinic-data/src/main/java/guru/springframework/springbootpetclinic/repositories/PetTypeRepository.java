package guru.springframework.springbootpetclinic.repositories;

import guru.springframework.springbootpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
