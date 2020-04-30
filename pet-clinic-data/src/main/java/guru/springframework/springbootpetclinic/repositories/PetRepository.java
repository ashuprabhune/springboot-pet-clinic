package guru.springframework.springbootpetclinic.repositories;

import guru.springframework.springbootpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
