package pl.zenoret.dealership.service.implementation;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zenoret.dealership.entity.CarPart;
import pl.zenoret.dealership.model.CarPartInfo;
import pl.zenoret.dealership.repository.definition.CarPartsRepository;
import pl.zenoret.dealership.service.definition.CarPartsService;

@Service
public class CarPartsServiceImpl implements CarPartsService {

  private final CarPartsRepository repository;

  @Autowired
  public CarPartsServiceImpl(CarPartsRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<CarPart> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public Iterable<CarPart> findAllByBrandAndModel(String carBrand, String carModel) {
    return repository.findAllByBrandAndModel(carBrand, carModel);
  }

  @Override
  public Iterable<CarPart> findAllByBrandAndModelAndPartNameOrDescription(String carBrand, String carModel,
    String partName,
    String partDescription) {
    return repository.findAllByBrandAndModelAndPartNameOrDescription(carBrand, carModel, partName, partDescription);
  }

  @Override
  public Optional<CarPartInfo> checkAvailabilityAndShipping(Long id) {
    return repository.checkAvailabilityAndShipping(id);
  }

  @Override
  public void updateDescriptionById(Long id, String description) {
    repository.updateDescriptionById(id, description);
  }
}
