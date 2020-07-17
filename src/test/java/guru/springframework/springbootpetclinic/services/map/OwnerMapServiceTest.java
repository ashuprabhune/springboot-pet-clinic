package guru.springframework.springbootpetclinic.services.map;

import guru.springframework.springbootpetclinic.model.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
    OwnerMapService ownerMapService;

    final Long ownerId = 1L;
    final String lastname = "Prabhune";
    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(),new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastname).build());

    }

    @org.junit.jupiter.api.Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1,ownerSet.size());
    }

    @org.junit.jupiter.api.Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @org.junit.jupiter.api.Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findById() {
        assertEquals(ownerId,ownerMapService.findById(ownerId).getId());
    }

    @Test
    void saveExistingId() {
        Owner o2 = Owner.builder().id(2L).build();
        Owner savedOwner = ownerMapService.save(o2);
        assertEquals(o2.getId(),savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findByLastName() {
        String ownerLastName = ownerMapService.findByLastName(lastname).getLastName();
        assertEquals(lastname,ownerLastName);

    }

    @Test
    void lastNameNotFound() {
        Owner owner = ownerMapService.findByLastName("foo");
        assertNull(owner);
    }
}