package guru.springframework.springbootpetclinic.services.map;

import guru.springframework.springbootpetclinic.model.Owner;
import guru.springframework.springbootpetclinic.services.OwnerService;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Owner findByLastName(Owner owner) {
        return null;
    }
}
