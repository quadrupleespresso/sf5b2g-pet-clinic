package se.bolero.sf5b2gpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import se.bolero.sf5b2gpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
