package pl.zenoret.dealership.repository.definition;

import pl.zenoret.dealership.entity.PartSellingPoint;

public interface PartSellingPointsRepository {

  Iterable<PartSellingPoint> findAllByCarPartId(Long partId);

  void deleteAllByCarPartId(Long partId);
}
