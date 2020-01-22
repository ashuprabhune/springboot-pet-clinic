package guru.springframework.springbootpetclinic.bootstarp;

import guru.springframework.springbootpetclinic.model.Owner;
import guru.springframework.springbootpetclinic.model.Pet;
import guru.springframework.springbootpetclinic.model.PetType;
import guru.springframework.springbootpetclinic.model.Vet;
import guru.springframework.springbootpetclinic.services.OwnerService;
import guru.springframework.springbootpetclinic.services.PetTypeService;
import guru.springframework.springbootpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class  DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired //No need to do that
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType  = petTypeService.save(dog);


        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner = new Owner();
        owner.setFirstName("Ashish");
        owner.setLastName("Prabhune");
        owner.setAddress("India");
        owner.setCity("Dom");
        owner.setTelephone("12312312312");


        Pet ashishPet =  new Pet();
        ashishPet.setName("Boski");
        ashishPet.setPetType(savedDogPetType);
        ashishPet.setBirthDate(LocalDate.now());
        ashishPet.setOwner(owner);
        owner.getPets().add(ashishPet);

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Girish");
        owner1.setLastName("Surve");
        owner.setAddress("India");
        owner.setCity("Dom");
        owner.setTelephone("12312312312");

        Pet girishPet = new Pet();
        girishPet.setOwner(owner1);
        girishPet.setPetType(savedDogPetType);
        girishPet.setBirthDate(LocalDate.now());
        girishPet.setName("Shwetudi");
        owner1.getPets().add(girishPet);
        ownerService.save(owner1);

        Vet vet = new Vet();
        vet.setFirstName("Pushkar");
        vet.setLastName("Datar");

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Ajit");
        vet1.setLastName("Busnaik");

        vetService.save(vet1);


    }
}
