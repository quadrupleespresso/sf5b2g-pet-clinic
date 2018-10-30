package se.bolero.sf5b2gpetclinic.services;

import se.bolero.sf5b2gpetclinic.model.Pet;

import java.util.Set;

public interface PetService {


    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
