package com.rob.petclinic.services;

import com.rob.petclinic.model.Owner;
import com.rob.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
