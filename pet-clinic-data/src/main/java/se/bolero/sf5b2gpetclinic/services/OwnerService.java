package se.bolero.sf5b2gpetclinic.services;

import se.bolero.sf5b2gpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String name);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
