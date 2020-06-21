package pl.zenoret.dealership.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.zenoret.dealership.entity.CarPart;
import pl.zenoret.dealership.model.CarPartInfo;
import pl.zenoret.dealership.repository.implementation.CarPartsRepositoryImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarPartsServiceImplTest {

  @Autowired
  private EntityManager entityManager;

  private CarPartsServiceImpl crudService;

  @Before
  public void init() {
    crudService = new CarPartsServiceImpl(new CarPartsRepositoryImpl(entityManager));
  }

  @Test
  public void testFindAllByBrandAndModel() {
    Iterable<CarPart> pandaParts = crudService.findAllByBrandAndModel("fiat", "panda");
    Iterable<CarPart> puntoParts = crudService.findAllByBrandAndModel("fiat", "punto");
    Iterable<CarPart> e46Parts = crudService.findAllByBrandAndModel("bmw", "e46");
    Iterable<CarPart> panda2Parts = crudService.findAllByBrandAndModel("bmw", "panda");

    assertNotNull(pandaParts);
    assertThat(pandaParts).isNotEmpty();

    assertNotNull(puntoParts);
    assertThat(puntoParts).isEmpty();

    assertNotNull(e46Parts);
    assertThat(e46Parts).isEmpty();

    assertNotNull(panda2Parts);
    assertThat(panda2Parts).isEmpty();
  }

  @Test
  public void testFindAllByBrandAndModelAndPartNameOrDescription() {
    Iterable<CarPart> accordParts = crudService.findAllByBrandAndModelAndPartNameOrDescription("honda",
      "accord",
      "ło",
      "ło");

    Iterable<CarPart> accordParts2 = crudService.findAllByBrandAndModelAndPartNameOrDescription("honda",
      "accord",
      "ło",
      null);

    Iterable<CarPart> accordParts3 = crudService.findAllByBrandAndModelAndPartNameOrDescription("honda",
      "accord",
      null,
      "ło");

    Iterable<CarPart> accordParts4 = crudService.findAllByBrandAndModelAndPartNameOrDescription("honda",
      "accord",
      "brakdanych",
      "brakdanych");

    assertNotNull(accordParts);
    assertThat(accordParts).isNotEmpty();
    assertThat(accordParts).hasSize(5);

    assertNotNull(accordParts2);
    assertThat(accordParts2).isNotEmpty();
    assertThat(accordParts2).hasSize(4);

    assertNotNull(accordParts3);
    assertThat(accordParts3).isNotEmpty();
    assertThat(accordParts3).hasSize(5);

    assertNotNull(accordParts4);
    assertThat(accordParts4).isEmpty();
  }

  @Test
  public void testCheckAvailabilityAndShipping() {
    Optional<CarPartInfo> first = crudService.checkAvailabilityAndShipping(1L);
    Optional<CarPartInfo> eighth = crudService.checkAvailabilityAndShipping(8L);
    Optional<CarPartInfo> thirteenth = crudService.checkAvailabilityAndShipping(13L);

    assertNotNull(first);
    assertThat(first).isNotEmpty();
    assertThat(first.get().isAvailable()).isEqualTo(true);
    assertThat(first.get().getDeliveryDate()).isEqualTo(LocalDate.now().plusDays(first.get().getDeliveryTime()));

    assertNotNull(eighth);
    assertThat(eighth).isNotEmpty();
    assertThat(eighth.get().isAvailable()).isEqualTo(false);
    assertThat(eighth.get().getDeliveryDate()).isEqualTo(LocalDate.now().plusDays(first.get().getDeliveryTime()));

    assertNotNull(thirteenth);
    assertThat(thirteenth).isEmpty();
  }

  @Test
  public void testUpdateDescriptionById() {
    crudService.updateDescriptionById(1L, "testUpdateDescriptionById");
    Optional<CarPart> firstUpdated = crudService.findById(1L);

    assertNotNull(firstUpdated);
    assertThat(firstUpdated).isNotEmpty();
    assertThat(firstUpdated.get().getDescription()).isEqualTo("testUpdateDescriptionById");
  }
}
