package be.vdab.beerhouse.controllers;


import be.vdab.beerhouse.domain.Beer;
import be.vdab.beerhouse.services.BeerService;
import be.vdab.beerhouse.services.BreweryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("breweries")
public class BrewerController {

    private final BeerService beerService;
    private final BreweryService breweryService;

    public BrewerController(BreweryService breweryService, BeerService beerService) {
        this.breweryService = breweryService;
        this.beerService = beerService;
    }

   @GetMapping
   public ModelAndView brewery(){
        return new ModelAndView("breweries", "breweries", breweryService.findAll());
   }


    @GetMapping ("{id}")
    public ModelAndView brewer(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("brewer");
        List<Beer> beers = beerService.findAllByBreweryId(id);
        modelAndView.addObject("beers", beers);
        breweryService.findById(id).ifPresent(modelAndView::addObject);
        return modelAndView;

    }


}
