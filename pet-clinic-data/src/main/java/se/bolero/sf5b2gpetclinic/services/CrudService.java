package se.bolero.sf5b2gpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    public Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
