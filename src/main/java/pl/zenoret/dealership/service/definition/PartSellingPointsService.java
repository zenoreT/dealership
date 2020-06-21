package pl.zenoret.dealership.service.definition;

import pl.zenoret.dealership.entity.PartSellingPoint;

public interface PartSellingPointsService {

  Iterable<PartSellingPoint> findAllByCarPartId(Long partId);

  void deleteAllByCarPartId(Long partId);
}
