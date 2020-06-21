package pl.zenoret.dealership.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.zenoret.dealership.entity.CarBrand;
import pl.zenoret.dealership.repository.implementation.CarBrandsRepositoryImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarBrandsServiceImplTest {

  @Autowired
  private EntityManager entityManager;

  private CarBrandsServiceImpl crudService;

  @Before
  public void init() {
    crudService = new CarBrandsServiceImpl(new CarBrandsRepositoryImpl(entityManager));
  }

  @Test
  public void testFindByNameIgnoreCase() {
    Optional<CarBrand> fiatBrand = crudService.findByNameIgnoreCase("fiat");
    Optional<CarBrand> bmwBrand = crudService.findByNameIgnoreCase("bmw");

    assertNotNull(fiatBrand);
    assertThat(fiatBrand).isNotEmpty();

    assertNotNull(bmwBrand);
    assertThat(bmwBrand).isEmpty();
  }
}
