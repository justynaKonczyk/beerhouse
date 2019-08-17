package be.vdab.beerhouse.repositories;

import be.vdab.beerhouse.domain.OrderItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class JDBCOrderItemRepository implements OrderItemRepository {

    private final SimpleJdbcInsert insert;
    private final JdbcTemplate template;

    public JDBCOrderItemRepository(JdbcTemplate template) {
        this.template = template;
        this.insert = new SimpleJdbcInsert(template);
        insert.withTableName("bestelbonlijnen");
    }

    @Override
    public void save(OrderItem orderItem) {
        Map<String, Object> params = new HashMap<>();
        params.put("bestelbonid", orderItem.getOrderId());
        params.put("bierid", orderItem.getBeerId());
        params.put("aantal", orderItem.getAmount());
        params.put("prijs", orderItem.getPrice());
        insert.execute(params);
    }

}
