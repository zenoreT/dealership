package pl.zenoret.dealership.repository.implementation;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.zenoret.dealership.entity.PartSellingPoint;
import pl.zenoret.dealership.repository.definition.PartSellingPointsRepository;

@Repository
@Transactional
public class PartSellingPointsRepositoryImpl implements PartSellingPointsRepository {

  private final EntityManager entityManager;

  @Autowired
  public PartSellingPointsRepositoryImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Iterable<PartSellingPoint> findAllByCarPartId(Long partId) {
    String sql = "SELECT partSellingPoint FROM PartSellingPoint partSellingPoint WHERE partSellingPoint.part.id = :partId";
    return entityManager.createQuery(sql, PartSellingPoint.class).setParameter("partId", partId).getResultList();
  }

  @Override
  public void deleteAllByCarPartId(Long partId) {
    String sql = "DELETE FROM PartSellingPoint partSellingPoint WHERE partSellingPoint.part.id = :partId";
    entityManager.createQuery(sql).setParameter("partId", partId).executeUpdate();
  }
}
