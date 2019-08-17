package be.vdab.beerhouse.repositories;

import be.vdab.beerhouse.domain.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Repository
public class JDBCOrderRepository implements OrderRepository {


    private final SimpleJdbcInsert insert;
    private final JdbcTemplate template;


    public JDBCOrderRepository(JdbcTemplate template) {
        this.template = template;
        this.insert = new SimpleJdbcInsert(template);
        insert.withTableName("bestelbonnen");
        insert.usingGeneratedKeyColumns("id");
    }


    @Override
    public long save(Order order) {
        Map<String, Object> params = new HashMap<>();
        params.put("naam", order.getName());
        params.put("straat", order.getStreet());
        params.put("huisNr", order.getHouseNr());
        params.put("postcode", order.getPostcode());
        params.put("gemeente", order.getMunicipality());

        Number id = insert.executeAndReturnKey(params);
        return id.longValue();

    }
}
