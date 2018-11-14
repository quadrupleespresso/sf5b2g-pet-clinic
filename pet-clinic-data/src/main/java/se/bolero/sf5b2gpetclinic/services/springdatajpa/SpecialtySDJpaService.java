package se.bolero.sf5b2gpetclinic.services.springdatajpa;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import se.bolero.sf5b2gpetclinic.model.Specialty;
import se.bolero.sf5b2gpetclinic.repositories.SpecialtyRepository;
import se.bolero.sf5b2gpetclinic.services.SpecialtiesService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtiesService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        HashSet<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
