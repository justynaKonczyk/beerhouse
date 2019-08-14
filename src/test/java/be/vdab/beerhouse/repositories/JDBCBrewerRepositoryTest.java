package be.vdab.beerhouse.repositories;


import be.vdab.beerhouse.domain.Brewer;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@JdbcTest
@RunWith(SpringRunner.class)
@Import(JDBCBrewerRepository.class)
@Sql("/insertBrewer.sql")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JDBCBrewerRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

//    private static final String BREWER = "brewer";

    @Autowired
    private BrewerRepository repository;

    @Test
    public void findById(){
        long id = idOfTestBrewer();
        Brewer brewer = repository.findById(id).orElseThrow(RuntimeException::new);
        assertThat(brewer.getName()).isEqualTo("test");
    }

    @Test
    public void findNonExistingId(){
        assertThat(repository.findById(-1)).isEmpty();
    }

    private long idOfTestBrewer(){
        return jdbcTemplate.queryForObject("select id from brouwers where naam = 'test' ", Long.class);
    }


}
