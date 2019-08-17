package be.vdab.beerhouse.repositories;

import be.vdab.beerhouse.domain.Beer;
import be.vdab.beerhouse.exeptions.BeerNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCBeerRepository implements BeerRepository {


    private final JdbcTemplate template;
    private final RowMapper<Beer> beerRowMapper =
            (result, rowNum) ->
            {
                int id = result.getInt("id");
                return new Beer(id, result.getString("naam"),
                        result.getInt("brouwerid"), result.getInt("soortid"),
                        result.getBigDecimal("prijs"), result.getBigDecimal("alcohol"),
                        result.getInt("besteld"));
            };


    public JDBCBeerRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Beer> findAllByBreweryId(long breweryId) {
        String sql = "select * from bieren where brouwerid = ? order by naam";
        return template.query(sql, beerRowMapper, breweryId);
    }

    @Override
    public Beer findBeerById(long beerId) {
        String sql = "select * from bieren where id = ?";
        return template.queryForObject(sql, beerRowMapper, beerId);
    }

    @Override
    public List<Beer> findAll() {
        String sql = "select * from bieren";
        return (List<Beer>) template.queryForObject(sql, beerRowMapper);
    }


//
//    @Override
//    public void update(Beer beer) {
//        String sql = "update bieren set naam=? where id=?";
//
//        if (template.update(sql, beer.getName(),beer.getName(), beer.getId() ) == 0);{
//            throw new BeerNotFoundException();
//        }
//
//    }
//
//    @Override
//    public void delete(int besteld) {
//        template.update("delete from bieren where besteld=?", besteld);
//
}

