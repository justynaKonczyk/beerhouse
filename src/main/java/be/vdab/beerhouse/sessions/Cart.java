package be.vdab.beerhouse.sessions;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Component
@SessionScope
public class Cart implements Serializable {

    private final static long serialVersionUID = 1L;
    private final Map<Long, BigDecimal> productsAndAmount = new LinkedHashMap<>();

    public void add(long id, BigDecimal amount){
        if (productsAndAmount.containsKey(id)){
            productsAndAmount.put(id, productsAndAmount.get(id)
            .add(amount));

        }else{
            productsAndAmount.put(id, amount);
        }
    }

    public Map<Long, BigDecimal> getProductsAndAmount(){
        return productsAndAmount;
    }

}
