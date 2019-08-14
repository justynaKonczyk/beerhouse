package be.vdab.beerhouse.services;

import be.vdab.beerhouse.domain.Brewer;

import java.util.List;
import java.util.Optional;

public interface BreweryService {

    Optional<Brewer> findById(long id);
    List<Brewer> findAll();

}
