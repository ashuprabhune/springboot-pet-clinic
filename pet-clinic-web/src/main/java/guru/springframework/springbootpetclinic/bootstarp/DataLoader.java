package guru.springframework.springbootpetclinic.bootstarp;

import guru.springframework.springbootpetclinic.model.Owner;
import guru.springframework.springbootpetclinic.model.Vet;
import guru.springframework.springbootpetclinic.services.OwnerService;
import guru.springframework.springbootpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired //No need to do that
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("Ashish");
        owner.setLastName("Prabhune");

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Girish");
        owner1.setLastName("Surve");

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
