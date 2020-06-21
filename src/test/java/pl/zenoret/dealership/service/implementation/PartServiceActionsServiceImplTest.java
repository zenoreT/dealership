package pl.zenoret.dealership.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.zenoret.dealership.entity.CarPart;
import pl.zenoret.dealership.entity.PartServiceAction;
import pl.zenoret.dealership.model.LocalDateTimeRange;
import pl.zenoret.dealership.repository.implementation.PartServiceActionsRepositoryImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PartServiceActionsServiceImplTest {

  @Autowired
  private EntityManager entityManager;

  private PartServiceActionsServiceImpl crudService;

  @Before
  public void init() {
    crudService = new PartServiceActionsServiceImpl(new PartServiceActionsRepositoryImpl(entityManager));
  }

  @Test
  public void testFindAllInDateRange() {
    Iterable<PartServiceAction> serviceActions =
      crudService.findAllInDateRange(
        LocalDateTime.of(2020, 1, 1, 0, 0, 0),
        LocalDateTime.of(2020, 12, 31, 23, 59, 59));

    Iterable<PartServiceAction> serviceActions2 =
      crudService.findAllInDateRange(
        LocalDateTime.of(2020, 1, 1, 0, 0, 0),
        LocalDateTime.of(2020, 1, 31, 23, 59, 59));

    Iterable<PartServiceAction> serviceActions3 =
      crudService.findAllInDateRange(
        LocalDateTime.of(2020, 12, 31, 23, 59, 59),
        LocalDateTime.of(2020, 1, 1, 0, 0, 0));

    assertNotNull(serviceActions);
    assertThat(serviceActions).isNotEmpty();
    assertThat(serviceActions).hasSize(7);

    assertNotNull(serviceActions2);
    assertThat(serviceActions2).isNotEmpty();
    assertThat(serviceActions2).hasSize(2);

    assertNotNull(serviceActions3);
    assertThat(serviceActions3).isEmpty();
  }

  @Test
  public void testSave() {
    CarPart carPart = new CarPart();
    carPart.setId(1L);

    PartServiceAction serviceAction = new PartServiceAction();
    serviceAction.setTitle("testSave");
    serviceAction.setDescription("testSave");
    serviceAction.setDateTimeRange(new LocalDateTimeRange(LocalDateTime.now().minusHours(1), LocalDateTime.now()));
    serviceAction.setPart(carPart);
    serviceAction.setCreatedAt(Instant.now());
    serviceAction.setUpdatedAt(Instant.now());

    PartServiceAction updatedServiceAction = crudService.save(serviceAction);

    assertNotNull(updatedServiceAction);
    assertThat(updatedServiceAction.getId()).isNotNull();
    assertThat(updatedServiceAction.getTitle()).isEqualTo("testSave");
    assertThat(updatedServiceAction.getPart().getId()).isEqualTo(1L);
    assertThat(updatedServiceAction.getPart().getName()).isNotNull();
  }
}
