package guru.springframework.springbootpetclinic.services;

import guru.springframework.springbootpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById();
    Vet save(Vet vet);
    Set<Vet> findAll();
}
