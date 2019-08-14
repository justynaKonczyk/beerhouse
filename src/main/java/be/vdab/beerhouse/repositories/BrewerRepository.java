package be.vdab.beerhouse.repositories;

import be.vdab.beerhouse.domain.Brewer;

import java.util.List;
import java.util.Optional;

public interface BrewerRepository {

    List<Brewer> findAll();
    Optional<Brewer> findById(long id);


}
