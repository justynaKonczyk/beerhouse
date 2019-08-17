package be.vdab.beerhouse.controllers;

import be.vdab.beerhouse.domain.Beer;
import be.vdab.beerhouse.forms.BeerForm;
import be.vdab.beerhouse.services.BeerService;
import be.vdab.beerhouse.services.OrderService;
import be.vdab.beerhouse.sessions.Cart;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;

@Slf4j
@Controller
@RequestMapping("beers")
public class BeerController {

    private final Cart cart;
    private final BeerService beerService;

    public BeerController(BeerService beerService, Cart cart) {
        this.beerService = beerService;
        this.cart = cart;
    }

    @GetMapping
    //   /beers?breweryId=14
    public ModelAndView beers(@RequestParam("breweryId") long breweryId){
        return new ModelAndView("beers", "beers", beerService.findAllByBreweryId(breweryId));
    }


    @GetMapping ("{id}")
    public ModelAndView beer(@PathVariable("id") long beerId){

        ModelAndView modelAndView = new ModelAndView("beer");
        Beer beer = beerService.findByBeerId(beerId);
        modelAndView.addObject("beer", beer);
        modelAndView.addObject(new BeerForm(BigDecimal.ZERO));
        return modelAndView;

    }

    @PostMapping("{id}/add")
    public String add(@PathVariable("id") long beerId, @Valid BeerForm form){
        BigDecimal amount = form.getAmount();
        cart.add(beerId, amount);
        log.info(cart.toString());
        return "redirect:/cart";
    }


}
