package be.vdab.beerhouse.repositories;

import be.vdab.beerhouse.domain.Brewer;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JDBCBrewerRepository implements BrewerRepository{

    private final JdbcTemplate template;
    private final RowMapper<Brewer> brewerRowMapper =
            (result, rowNum) ->
                    new Brewer(result.getLong("id"),result.getString("naam"),
                            result.getString("straat"), result.getString("huisNr"),
                            result.getInt("postcode"), result.getString("gemeente"),
                            result.getLong("omzet"));

    public JDBCBrewerRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Brewer> findAll() {
        String sql = "select * from brouwers order by naam";
        return template.query(sql, brewerRowMapper);
    }

    @Override
    public Optional<Brewer> findById(long id) {

        try {
            String sql = "select id, naam, straat, huisNr,postcode, gemeente, omzet from brouwers where id=?";
            return Optional.of(template.queryForObject(sql, brewerRowMapper, id));
        }catch (IncorrectResultSizeDataAccessException ex){
            return Optional.empty();

        }
    }


}
