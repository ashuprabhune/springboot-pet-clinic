package guru.springframework.springbootpetclinic.services.springdatajpa;

import guru.springframework.springbootpetclinic.model.Owner;
import guru.springframework.springbootpetclinic.repositories.OwnerRepository;
import guru.springframework.springbootpetclinic.repositories.PetRepository;
import guru.springframework.springbootpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.management.ObjectName;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    public static final String LAST_NAME = "smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJPAService ownerJPAService;

    Owner owner;
    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner smith = ownerJPAService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME,smith.getLastName());
        verify(ownerRepository).findByLastName(any());

    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);
        Set<Owner> owners = ownerJPAService.findAll();
        assertNotNull(owners);
        assertEquals(2,owners.size());
        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));
        Owner returnedOwner =  ownerJPAService.findById(1L);
        assertNotNull(returnedOwner);
        assertEquals(1L,returnedOwner.getId());

        verify(ownerRepository).findById(any());
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(owner);

        Owner savedOwner = ownerJPAService.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerJPAService.delete(owner);

        //default is 1 times
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerJPAService.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}