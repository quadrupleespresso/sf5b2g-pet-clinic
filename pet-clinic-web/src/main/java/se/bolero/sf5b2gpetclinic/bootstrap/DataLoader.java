package se.bolero.sf5b2gpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.bolero.sf5b2gpetclinic.model.Owner;
import se.bolero.sf5b2gpetclinic.model.PetType;
import se.bolero.sf5b2gpetclinic.model.Vet;
import se.bolero.sf5b2gpetclinic.services.OwnerService;
import se.bolero.sf5b2gpetclinic.services.PetTypeService;
import se.bolero.sf5b2gpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType petType = new PetType();
        petType.setName("Dog");
        PetType savedPetType = petTypeService.save(petType);

        petType = new PetType();
        petType.setName("Cat");
        savedPetType = petTypeService.save(petType);

        petType = new PetType();
        petType.setName("Snake");
        savedPetType = petTypeService.save(petType);


        Owner owner= new Owner();
        owner.setFirstName("Kalle");
        owner.setLastName("Kula");
        ownerService.save(owner);

        owner= new Owner();
        owner.setFirstName("Maja");
        owner.setLastName("Graddnos");
        ownerService.save(owner);

        owner= new Owner();
        owner.setFirstName("Pelle");
        owner.setLastName("Pettersson");
        ownerService.save(owner);

        System.out.println("Loaded Owners...." + ownerService.findAll() );

        Vet vet = new Vet();
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vetService.save(vet);

        vet = new Vet();
        vet.setFirstName("Jessie");
        vet.setLastName("Porter");
        vetService.save(vet);

        System.out.println("Loaded vets..." + vetService.findAll() );
    }
}
