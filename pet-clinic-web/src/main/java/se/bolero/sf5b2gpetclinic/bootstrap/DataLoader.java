package se.bolero.sf5b2gpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.bolero.sf5b2gpetclinic.model.Owner;
import se.bolero.sf5b2gpetclinic.model.Pet;
import se.bolero.sf5b2gpetclinic.model.PetType;
import se.bolero.sf5b2gpetclinic.model.Vet;
import se.bolero.sf5b2gpetclinic.services.OwnerService;
import se.bolero.sf5b2gpetclinic.services.PetTypeService;
import se.bolero.sf5b2gpetclinic.services.VetService;

import java.time.LocalDate;

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

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);


        Owner owner1= new Owner();
        owner1.setFirstName("Kalle");
        owner1.setLastName("Kula");
        owner1.setAddress("Foo Street");
        owner1.setCity("Bar City");
        owner1.setTelephone("0123456789");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Rosco");
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setFirstName("Maja");
        owner2.setLastName("Graddnos");
        owner2.setAddress("No Such Street");
        owner2.setCity("No Such City");
        owner2.setTelephone("0987654321");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Sotis");
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

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
