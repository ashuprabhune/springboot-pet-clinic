package guru.springframework.springbootpetclinic.services;

import guru.springframework.springbootpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById();
    Pet save(Pet pet);
    Set<Pet> findAll();



}
