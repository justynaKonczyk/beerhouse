package be.vdab.beerhouse.controllers;

import be.vdab.beerhouse.domain.Beer;
import be.vdab.beerhouse.services.BeerService;
import be.vdab.beerhouse.sessions.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("cart")
public class CartController {

    private final BeerService service;
    private final Cart cart;

    public CartController(BeerService service, Cart cart) {
        this.service = service;
        this.cart = cart;
    }

    public Map<Beer, BigDecimal> inCart() {
        List<Beer> allBeers = service.findAll();
        Map<Beer, BigDecimal> shoppingCart = new LinkedHashMap<>();

        allBeers.forEach(beer -> {
            if (cart.getProductsAndAmount().containsKey(beer.getId())) {
                shoppingCart.put(beer, cart.getProductsAndAmount()
                        .get(beer.getId()));
            }
        });
        return shoppingCart;
    }

    @GetMapping
    public ModelAndView showCart() {
        ModelAndView modelAndView = new ModelAndView("cart");

//    modelAndView.addObject("shoppingcart", inCart());
//    modelAndView.addObject(new OrderDetails(0L, 0L, 0L, null));
//        modelAndView.addObject(new Order(0L, null, null, null, 0, null));
        return modelAndView;

    }

}

