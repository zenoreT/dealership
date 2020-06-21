package pl.zenoret.dealership.service.implementation;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zenoret.dealership.entity.CarBrand;
import pl.zenoret.dealership.repository.definition.CarBrandsRepository;
import pl.zenoret.dealership.service.definition.CarBrandsService;

@Service
public class CarBrandsServiceImpl implements CarBrandsService {

  private final CarBrandsRepository repository;

  @Autowired
  public CarBrandsServiceImpl(CarBrandsRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<CarBrand> findByNameIgnoreCase(String name) {
    return repository.findByNameIgnoreCase(name);
  }
}
