package guru.springframework.springbootpetclinic.services;

import guru.springframework.springbootpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
