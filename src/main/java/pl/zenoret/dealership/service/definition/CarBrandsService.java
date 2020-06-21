package pl.zenoret.dealership.service.definition;

import java.util.Optional;
import pl.zenoret.dealership.entity.CarBrand;

public interface CarBrandsService {

  Optional<CarBrand> findByNameIgnoreCase(String name);
}
