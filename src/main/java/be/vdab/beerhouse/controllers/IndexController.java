package be.vdab.beerhouse.controllers;

import be.vdab.beerhouse.services.BeerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    private final BeerService beerService;

    public IndexController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("beerCount", beerService.count());
        return modelAndView;
    }

}
