package pl.zenoret.dealership.repository.implementation;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.zenoret.dealership.entity.CarPart;
import pl.zenoret.dealership.model.CarPartInfo;
import pl.zenoret.dealership.repository.definition.CarPartsRepository;

@Repository
@Transactional
public class CarPartsRepositoryImpl implements CarPartsRepository {

  private final EntityManager entityManager;

  @Autowired
  public CarPartsRepositoryImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }


  @Override
  public Optional<CarPart> findById(Long id) {
    String sql =
      "SELECT carPart \n" +
        "FROM \n" +
        "  CarPart carPart \n" +
        "WHERE \n" +
        "  carPart.id = :id";

    return entityManager.createQuery(sql, CarPart.class)
      .setParameter("id", id)
      .getResultList()
      .stream()
      .findFirst();
  }

  @Override
  public Iterable<CarPart> findAllByBrandAndModel(String carBrand, String carModel) {
    String sql =
      "SELECT \n" +
        "  carPart \n" +
        "FROM \n" +
        "  CarPart carPart \n" +
        "  LEFT OUTER JOIN \n" +
        "    CarModel carModel \n" +
        "    ON carPart.model = carModel.id \n" +
        "  LEFT OUTER JOIN \n" +
        "    CarBrand carBrand \n" +
        "    ON carModel.brand = carBrand.id \n" +
        "WHERE \n" +
        "  UPPER(carBrand.name) = UPPER(:carBrand) \n" +
        "  AND UPPER(carModel.name) = UPPER(:carModel)";

    return entityManager.createQuery(sql, CarPart.class)
      .setParameter("carBrand", carBrand)
      .setParameter("carModel", carModel)
      .getResultList();
  }

  @Override
  public Iterable<CarPart> findAllByBrandAndModelAndPartNameOrDescription(String carBrand, String carModel,
    String partName,
    String partDescription) {
    String sql =
      "SELECT\n" +
        "  carPart \n" +
        "FROM \n" +
        "  CarPart carPart \n" +
        "  LEFT OUTER JOIN \n" +
        "    CarModel carModel \n" +
        "    ON carPart.model = carModel.id \n" +
        "  LEFT OUTER JOIN \n" +
        "    CarBrand carBrand \n" +
        "    ON carModel.brand = carBrand.id \n" +
        "WHERE \n" +
        "  ( \n" +
        "    UPPER(carBrand.name) = UPPER(:carBrand) \n" +
        "    AND UPPER(carModel.name) = UPPER(:carModel) \n" +
        "  ) \n" +
        "  AND \n" +
        "  ( \n" +
        "    ( \n " +
        "       :partName IS NOT NULL \n" +
        "       AND UPPER(carPart.name) LIKE UPPER(concat('%', COALESCE(:partName, ''), '%')) \n" +
        "    ) \n" +
        "    OR \n" +
        "    ( \n" +
        "      :partDescription IS NOT NULL \n" +
        "      AND UPPER(carPart.description) LIKE UPPER(concat('%', COALESCE(:partDescription, ''), '%')) \n" +
        "    ) \n" +
        ")";

    return entityManager.createQuery(sql, CarPart.class)
      .setParameter("carBrand", carBrand)
      .setParameter("carModel", carModel)
      .setParameter("partName", partName)
      .setParameter("partDescription", partDescription)
      .getResultList();
  }

  @Override
  public Optional<CarPartInfo> checkAvailabilityAndShipping(Long id) {
    String sql =
      "SELECT new pl.zenoret.dealership.model.CarPartInfo( \n" +
        "    carPart.id, carPart.available, carPart.deliveryTime \n" +
        "  ) \n" +
        "FROM \n" +
        "  CarPart carPart \n" +
        "WHERE \n" +
        "  carPart.id = :id";

    return entityManager.createQuery(sql, CarPartInfo.class)
      .setParameter("id", id)
      .getResultList()
      .stream()
      .findFirst();
  }

  @Override
  public void updateDescriptionById(Long id, String description) {
    String sql = "UPDATE CarPart carPart SET carPart.description = :description WHERE carPart.id = :id";
    entityManager.createQuery(sql)
      .setParameter("description", description)
      .setParameter("id", id)
      .executeUpdate();
  }
}
