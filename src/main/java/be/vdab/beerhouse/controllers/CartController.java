package be.vdab.beerhouse.controllers;

import be.vdab.beerhouse.domain.Beer;
import be.vdab.beerhouse.forms.CartForm;
import be.vdab.beerhouse.services.BeerService;
import be.vdab.beerhouse.services.OrderItemCreateCommand;
import be.vdab.beerhouse.services.OrderSaveCommand;
import be.vdab.beerhouse.services.OrderService;
import be.vdab.beerhouse.sessions.Cart;
import be.vdab.beerhouse.sessions.CartItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("cart")
public class CartController {

    private final Cart cart;
    private final BeerService beerService;
    private final OrderService orderService;

    public CartController(BeerService beerService, Cart cart, OrderService orderService) {
        this.orderService = orderService;
        this.beerService = beerService;
        this.cart = cart;
    }

    @GetMapping
    public ModelAndView showCart() {
        Map<Long, BigDecimal> amountsByBeerId = cart.getAmountsByBeerId();

        List<CartItem> cartItems = amountsByBeerId.keySet().stream()
                .map(beerId -> createCartItem(amountsByBeerId, beerId))
                .collect(Collectors.toList());

        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("cartItems", cartItems);
        modelAndView.addObject("total", calculateTotal(cartItems));
        modelAndView.addObject("cartForm", new CartForm());
        return modelAndView;
    }

    @PostMapping
    public String confirm(@Valid CartForm cartForm) {
        orderService.save(OrderSaveCommand.builder()
                .houseNr(cartForm.getHouseNr())
                .name(cartForm.getName())
                .street(cartForm.getStreet())
                .postcode(cartForm.getPostcode())
                .municipality(cartForm.getGemeente())
                .items(cart.getAmountsByBeerId().keySet().stream()
                        .map(item -> OrderItemCreateCommand.builder()
                                .amount(cart.getAmountsByBeerId().get(item).longValue())
                                .beerId(item)
                                .price(beerService.findByBeerId(item).getPrice())
                                .build())
                        .collect(Collectors.toList()))
                .build());
        return "redirect:/success";
    }

    private BigDecimal calculateTotal(List<CartItem> cartItems) {
        return cartItems.stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private CartItem createCartItem(Map<Long, BigDecimal> amountsByBeerId, Long beerId) {
        BigDecimal amount = amountsByBeerId.get(beerId);
        Beer beer = beerService.findByBeerId(beerId);
        BigDecimal subtotal = amount.multiply(beer.getPrice());
        return new CartItem(beer, amount, subtotal);
    }


}

