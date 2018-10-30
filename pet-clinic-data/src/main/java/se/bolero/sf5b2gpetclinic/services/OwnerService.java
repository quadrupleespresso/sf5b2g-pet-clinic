package se.bolero.sf5b2gpetclinic.services;

import se.bolero.sf5b2gpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String name);

}
