package be.vdab.beerhouse.controllers;

import be.vdab.beerhouse.domain.Beer;
import be.vdab.beerhouse.forms.BeerForm;
import be.vdab.beerhouse.services.BeerService;
import be.vdab.beerhouse.sessions.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping("beers")
public class BeerController {

    private final BeerService service;
    private final Cart cart;

    public BeerController(BeerService service, Cart cart) {
        this.service = service;
        this.cart = cart;
    }

    @GetMapping
    //   /beers?breweryId=14
    public ModelAndView beers(@RequestParam("breweryId") long breweryId){
        return new ModelAndView("beers", "beers", service.findAllByBreweryId(breweryId));
    }


    @GetMapping ("{id}")
    public ModelAndView beer(@PathVariable("id") long beerId){

        ModelAndView modelAndView = new ModelAndView("beer");
        Beer beer = service.findByBeerId(beerId);
        modelAndView.addObject("beer", beer);
        modelAndView.addObject(new BeerForm(BigDecimal.ZERO));
        return modelAndView;

    }

    @PostMapping("add")
    public String add(@RequestBody MultiValueMap<String, String> formData){
        Long id = Long.valueOf(formData.getFirst("id"));
        BigDecimal amount = new BigDecimal(formData.getFirst("amount"));
        cart.add(id, amount);
        return "redirect:/cart";
    }


}
