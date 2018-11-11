package se.bolero.sf5b2gpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import se.bolero.sf5b2gpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
