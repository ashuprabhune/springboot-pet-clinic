package guru.springframework.springbootpetclinic.repositories;

import guru.springframework.springbootpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRespository extends CrudRepository<Vet, Long> {
}
