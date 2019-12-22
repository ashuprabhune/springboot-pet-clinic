package guru.springframework.springbootpetclinic.services;

import guru.springframework.springbootpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(Owner owner);
    Owner finById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
