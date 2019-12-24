package guru.springframework.springbootpetclinic.services.map;

import guru.springframework.springbootpetclinic.model.Pet;
import guru.springframework.springbootpetclinic.services.PetService;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet, Long>  implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }
}
