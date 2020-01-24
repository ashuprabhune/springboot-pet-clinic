package guru.springframework.springbootpetclinic.bootstarp;

import guru.springframework.springbootpetclinic.model.*;
import guru.springframework.springbootpetclinic.services.OwnerService;
import guru.springframework.springbootpetclinic.services.PetTypeService;
import guru.springframework.springbootpetclinic.services.SpecialtiesService;
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
    private final SpecialtiesService specialtiesService;


    @Autowired //No need to do that
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count  = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }



    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType  = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");

        Specialty savedRadiology = specialtiesService.save(radiology);
        Specialty savedSurgery = specialtiesService.save(surgery);
        Specialty savedDentistry = specialtiesService.save(dentistry);

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
        vet.getSpecialties().add(savedRadiology);
        vet.getSpecialties().add(savedDentistry);
        vet.getSpecialties().add(savedDentistry);
        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Ajit");
        vet1.setLastName("Busnaik");
        vet1.getSpecialties().add(savedDentistry);

        vetService.save(vet1);
    }
}
