package com.rob.petclinic.services.springdatajpa;

import com.rob.petclinic.model.Owner;
import com.rob.petclinic.repositories.OwnerRepository;
import com.rob.petclinic.repositories.PetRepository;
import com.rob.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;
    String LAST_NAME = "Smith";

    @BeforeEach
    void setUp() {

    }

    @Test
    void findByLastName() {

        Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, smith.getLastName());
        verify(ownerRepository, atLeastOnce()).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);
        assertEquals(2, service.findAll().size());
        verify(ownerRepository, atLeastOnce()).findAll();
    }

    @Test
    void findById() {
        Owner owner = Owner.builder().id(1L).build();
        when(ownerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(owner));
        assertNotNull(service.findById(1L));
        assertEquals(1L, service.findById(1L).getId());
        verify(ownerRepository, times(2)).findById(any());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(1L).lastName(LAST_NAME).build();
        when(ownerRepository.save(any())).thenReturn(owner);
        assertEquals(1L, service.save(owner).getId());
    }

    @Test
    void delete() {
        service.delete(Owner.builder().id(1L).build());
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository, times(1)).deleteById(any());
    }
}