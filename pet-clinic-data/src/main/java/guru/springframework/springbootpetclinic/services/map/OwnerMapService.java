package guru.springframework.springbootpetclinic.services.map;

import guru.springframework.springbootpetclinic.model.Owner;
import guru.springframework.springbootpetclinic.model.Pet;
import guru.springframework.springbootpetclinic.model.PetType;
import guru.springframework.springbootpetclinic.services.OwnerService;
import guru.springframework.springbootpetclinic.services.PetService;
import guru.springframework.springbootpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

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
        if(object!=null){
            if(object.getPets() !=null){
                object.getPets().forEach(pet -> {
                   if(pet.getPetType() !=null){
                        if(pet.getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                   }else{
                       throw new RuntimeException("Pet Type required");
                   }

                   if(pet.getId() == null){
                       Pet savedPet  = petService.save(pet);
                       pet.setId(savedPet.getId());
                   }
                });
            }
            return super.save(object);
        }
        else{
            return null;
        }


    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).findFirst().orElse(null);
    }

}
