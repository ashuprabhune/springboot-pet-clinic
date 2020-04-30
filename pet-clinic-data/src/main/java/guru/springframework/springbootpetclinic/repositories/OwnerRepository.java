package guru.springframework.springbootpetclinic.repositories;

import guru.springframework.springbootpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByLastName(String lastName);
}
