package pl.zenoret.dealership.repository.implementation;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.zenoret.dealership.entity.CarBrand;
import pl.zenoret.dealership.repository.definition.CarBrandsRepository;

@Repository
@Transactional
public class CarBrandsRepositoryImpl implements CarBrandsRepository {

  private final EntityManager entityManager;

  @Autowired
  public CarBrandsRepositoryImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Optional<CarBrand> findByName(String name) {
    String sql = "SELECT carBrand FROM CarBrand carBrand WHERE UPPER(carBrand.name) = UPPER(:name)";
    return entityManager.createQuery(sql, CarBrand.class)
      .setParameter("name", name)
      .getResultList()
      .stream()
      .findFirst();
  }
}
