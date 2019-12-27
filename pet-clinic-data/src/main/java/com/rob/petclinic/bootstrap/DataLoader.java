package com.rob.petclinic.bootstrap;

import com.rob.petclinic.model.Owner;
import com.rob.petclinic.model.Vet;
import com.rob.petclinic.services.OwnerService;
import com.rob.petclinic.services.VetService;
import com.rob.petclinic.services.map.OwnerServiceMap;
import com.rob.petclinic.services.map.VetServiceMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private Logger logger = LoggerFactory.getLogger(DataLoader.class);

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(1L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);
        logger.info("loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");


        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Kayla");
        vet2.setLastName("Hermansson");

        vetService.save(vet2);
        logger.info("loaded Vets...");
    }
}
