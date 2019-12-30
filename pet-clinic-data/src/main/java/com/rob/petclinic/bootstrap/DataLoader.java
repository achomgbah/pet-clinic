package com.rob.petclinic.bootstrap;

import com.rob.petclinic.model.Owner;
import com.rob.petclinic.model.Pet;
import com.rob.petclinic.model.PetType;
import com.rob.petclinic.model.Vet;
import com.rob.petclinic.services.OwnerService;
import com.rob.petclinic.services.PetTypeService;
import com.rob.petclinic.services.VetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        logger.info("added new dog pet type");

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);
        logger.info("added new cat pet type");


        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123467234");
        logger.info("added owner:{}", owner1.getFirstName());


        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        logger.info("Connected petType/name:'{}/{}' to user:{}", mikesPet.getPetType().getName(),mikesPet.getName(),owner1.getFirstName());



        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("234389544");
        logger.info("added owner:{}", owner2.getFirstName());


        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatType);
        fionasPet.setOwner(owner1);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Simba");
        owner2.getPets().add(fionasPet);
        logger.info("Connected petType/name:'{}/{}' to user:{}", fionasPet.getPetType().getName(),fionasPet.getName(),owner2.getFirstName());


        ownerService.save(owner2);
        logger.info("loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");


        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Kayla");
        vet2.setLastName("Hermansson");

        vetService.save(vet2);
        logger.info("loaded Vets...");
    }
}
