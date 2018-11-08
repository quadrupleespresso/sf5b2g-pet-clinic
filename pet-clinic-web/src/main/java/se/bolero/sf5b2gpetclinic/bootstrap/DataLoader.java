package se.bolero.sf5b2gpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.bolero.sf5b2gpetclinic.model.Owner;
import se.bolero.sf5b2gpetclinic.model.Vet;
import se.bolero.sf5b2gpetclinic.services.OwnerService;
import se.bolero.sf5b2gpetclinic.services.VetService;
import se.bolero.sf5b2gpetclinic.services.map.OwnerServiceMap;
import se.bolero.sf5b2gpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner= new Owner();
        owner.setId(1L);
        owner.setFirstName("Kalle");
        owner.setLastName("Kula");
        ownerService.save(owner);

        owner= new Owner();
        owner.setId(2L);
        owner.setFirstName("Maja");
        owner.setLastName("Graddnos");
        ownerService.save(owner);

        owner= new Owner();
        owner.setId(3L);
        owner.setFirstName("Pelle");
        owner.setLastName("Pettersson");
        ownerService.save(owner);

        System.out.println("Loaded Owners....");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vetService.save(vet);

        vet = new Vet();
        vet.setId(2L);
        vet.setFirstName("Jessie");
        vet.setLastName("Porter");
        vetService.save(vet);

        System.out.println("Loaded vets...");
    }
}
