package pl.zenoret.dealership.repository.implementation;

import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.zenoret.dealership.entity.PartServiceAction;
import pl.zenoret.dealership.repository.definition.PartServiceActionsRepository;

@Repository
@Transactional
public class PartServiceActionsRepositoryImpl implements PartServiceActionsRepository {

  private final EntityManager entityManager;

  @Autowired
  public PartServiceActionsRepositoryImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Iterable<PartServiceAction> findAllInDateRange(LocalDateTime startDate, LocalDateTime endDate) {
    String sql =
      "SELECT \n" +
        "  partServiceAction \n" +
        "FROM \n" +
        "  PartServiceAction partServiceAction \n" +
        "  LEFT OUTER JOIN \n" +
        "    CarPart carPart \n" +
        "    ON partServiceAction.part = carPart.id \n" +
        "  LEFT OUTER JOIN \n" +
        "    CarModel carModel \n" +
        "    ON carPart.model = carModel.id \n" +
        "  LEFT OUTER JOIN \n" +
        "    CarBrand carBrand \n" +
        "    ON carModel.brand = carBrand.id \n" +
        "WHERE \n" +
        "  partServiceAction.dateTimeRange.startDate >= :startDate \n" +
        "  AND partServiceAction.dateTimeRange.endDate <= :endDate";

    return entityManager.createQuery(sql, PartServiceAction.class)
      .setParameter("startDate", startDate)
      .setParameter("endDate", endDate)
      .getResultList();
  }

  @Override
  public PartServiceAction save(PartServiceAction partServiceAction) {
    return entityManager.merge(partServiceAction);
  }
}
