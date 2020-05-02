package guru.springframework.springbootpetclinic.services.springdatajpa;

import guru.springframework.springbootpetclinic.model.Vet;
import guru.springframework.springbootpetclinic.repositories.VetRespository;
import guru.springframework.springbootpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJPAService implements VetService {
    private final VetRespository vetRespository;

    public VetJPAService(VetRespository vetRespository) {
        this.vetRespository = vetRespository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRespository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRespository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRespository.save(object);
    }

    @Override
    public void delete(Vet object) {
            vetRespository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
            vetRespository.deleteById(aLong);
    }
}
