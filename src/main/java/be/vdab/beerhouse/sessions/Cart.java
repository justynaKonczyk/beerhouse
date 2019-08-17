package be.vdab.beerhouse.sessions;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Component
@SessionScope
public class Cart implements Serializable {

    private final static long serialVersionUID = 1L;

    private Long orderId;
    private final Map<Long, BigDecimal> amountsByBeerId = new LinkedHashMap<>();

    public void add(long beerId, BigDecimal amount) {
        if (amountsByBeerId.containsKey(beerId)) {
            BigDecimal currentAmount = amountsByBeerId.get(beerId);
            BigDecimal updatedAmount = currentAmount.add(amount);
            amountsByBeerId.put(beerId, updatedAmount);
        } else {
            amountsByBeerId.put(beerId, amount);
        }
    }

    public Map<Long, BigDecimal> getAmountsByBeerId() {
        return amountsByBeerId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "amountsByBeerId=" + amountsByBeerId +
                '}';
    }
}
