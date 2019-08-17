package be.vdab.beerhouse.services;

import be.vdab.beerhouse.domain.Beer;
import be.vdab.beerhouse.repositories.BeerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultBeerService implements BeerService {

    private final BeerRepository repository;

    public DefaultBeerService(BeerRepository beerRepository) {
        this.repository = beerRepository;
    }


    @Override
    public List<Beer> findAllByBreweryId(long breweryId) {
        return repository.findAllByBreweryId(breweryId);
    }

    @Override
    public Beer findByBeerId(long beerId) {
        return repository.findBeerById(beerId);
    }

    @Override
    public List<Beer> findAll() {
        return repository.findAll();
    }

}




