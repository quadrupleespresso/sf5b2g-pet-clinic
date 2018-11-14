package se.bolero.sf5b2gpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.bolero.sf5b2gpetclinic.model.*;
import se.bolero.sf5b2gpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtiesService specialtiesService,
                      VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setSpecialty("Radiology");
        radiology = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setSpecialty("Surgery");
        surgery =  specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setSpecialty("Dentistry");
        dentistry = specialtiesService.save(dentistry);


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

        Visit catVisit = new Visit();
        catVisit.setPet(pet2);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet = new Vet();
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vet.getSpecialties().add(radiology);
        vet.getSpecialties().add(dentistry);
        vetService.save(vet);

        vet = new Vet();
        vet.setFirstName("Jessie");
        vet.setLastName("Porter");
        vet.getSpecialties().add(surgery);
        vet.getSpecialties().add(radiology);
        vetService.save(vet);

        System.out.println("Loaded vets...");
    }
}
