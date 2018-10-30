package se.bolero.sf5b2gpetclinic.services;

import se.bolero.sf5b2gpetclinic.model.Vet;

import java.util.Set;

public interface VetService {


    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
