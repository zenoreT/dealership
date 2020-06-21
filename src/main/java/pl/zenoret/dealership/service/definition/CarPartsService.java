package pl.zenoret.dealership.service.definition;

import java.util.Optional;
import pl.zenoret.dealership.entity.CarPart;
import pl.zenoret.dealership.model.CarPartInfo;

public interface CarPartsService {

  Optional<CarPart> findById(Long id);

  Iterable<CarPart> findAllByBrandAndModel(String carBrand, String carModel);

  Iterable<CarPart> findAllByBrandAndModelAndPartNameOrDescription(String carBrand, String carModel,
    String partName,
    String partDescription);

  Optional<CarPartInfo> checkAvailabilityAndShipping(Long id);

  void updateDescriptionById(Long id, String description);
}
