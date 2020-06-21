package pl.zenoret.dealership.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zenoret.dealership.entity.PartSellingPoint;
import pl.zenoret.dealership.repository.definition.PartSellingPointsRepository;
import pl.zenoret.dealership.service.definition.PartSellingPointsService;

@Service
public class PartSellingPointsServiceImpl implements PartSellingPointsService {

  private final PartSellingPointsRepository repository;

  @Autowired
  public PartSellingPointsServiceImpl(PartSellingPointsRepository repository) {
    this.repository = repository;
  }

  @Override
  public Iterable<PartSellingPoint> findAllByCarPartId(Long partId) {
    return repository.findAllByCarPartId(partId);
  }

  @Override
  public void deleteAllByCarPartId(Long partId) {
    repository.deleteAllByCarPartId(partId);
  }
}
