package pl.zenoret.dealership.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.zenoret.dealership.entity.PartSellingPoint;
import pl.zenoret.dealership.repository.implementation.PartSellingPointsRepositoryImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PartSellingPointsServiceImplTest {

  @Autowired
  private EntityManager entityManager;

  private PartSellingPointsServiceImpl crudService;

  @Before
  public void init() {
    crudService = new PartSellingPointsServiceImpl(new PartSellingPointsRepositoryImpl(entityManager));
  }

  @Test
  public void testDeleteAllByCarPartId() {
    Iterable<PartSellingPoint> pandaPartSellingPoints = crudService.findAllByCarPartId(10L);

    assertNotNull(pandaPartSellingPoints);
    assertThat(pandaPartSellingPoints).isNotEmpty();

    crudService.deleteAllByCarPartId(10L);

    Iterable<PartSellingPoint> updatedPandaPartSellingPoints = crudService.findAllByCarPartId(10L);

    assertNotNull(updatedPandaPartSellingPoints);
    assertThat(updatedPandaPartSellingPoints).isEmpty();
  }
}
