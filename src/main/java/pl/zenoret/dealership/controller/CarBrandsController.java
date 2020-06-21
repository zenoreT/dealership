package pl.zenoret.dealership.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zenoret.dealership.entity.CarBrand;
import pl.zenoret.dealership.service.definition.CarBrandsService;

@RestController
@RequestMapping("/api/car-brands")
public class CarBrandsController {

  private final CarBrandsService crudService;

  @Autowired
  protected CarBrandsController(CarBrandsService crudService) {
    this.crudService = crudService;
  }

  @GetMapping("/find/{carBrand}")
  public ResponseEntity<Optional<CarBrand>> findByName(@PathVariable String carBrand) {
    return ResponseEntity.ok(crudService.findByName(carBrand));
  }
}
