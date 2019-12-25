package com.rob.petclinic.services;

import com.rob.petclinic.model.Owner;
import com.rob.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
