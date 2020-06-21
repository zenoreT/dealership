package pl.zenoret.dealership.repository.definition;

import java.util.Optional;
import pl.zenoret.dealership.entity.CarBrand;

public interface CarBrandsRepository {

  Optional<CarBrand> findByNameIgnoreCase(String name);
}
