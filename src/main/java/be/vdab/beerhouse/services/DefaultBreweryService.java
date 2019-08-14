package be.vdab.beerhouse.services;

import be.vdab.beerhouse.domain.Brewer;
import be.vdab.beerhouse.repositories.BrewerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultBreweryService implements BreweryService{

    private final BrewerRepository brewerRepository;

    public DefaultBreweryService(BrewerRepository brewerRepository) {
        this.brewerRepository = brewerRepository;
    }


    @Override
    public Optional<Brewer> findById(long id) {
        return brewerRepository.findById(id);
    }

    @Override
    public List<Brewer> findAll() {
        return brewerRepository.findAll();
    }
}
