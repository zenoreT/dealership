package pl.zenoret.dealership.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zenoret.dealership.entity.CarPart;
import pl.zenoret.dealership.model.CarPartInfo;
import pl.zenoret.dealership.model.request.CarPartSerachRequest;
import pl.zenoret.dealership.service.definition.CarPartsService;

@RestController
@RequestMapping("/api/car-parts")
public class CarPartsController {

  private final CarPartsService service;

  @Autowired
  protected CarPartsController(CarPartsService service) {
    this.service = service;
  }

  @GetMapping("/find/{carBrand}/{carModel}")
  public ResponseEntity<Iterable<CarPart>> findAllByBrandAndModel(@PathVariable String carBrand,
    @PathVariable String carModel) {
    return ResponseEntity.ok(service.findAllByBrandAndModel(carBrand, carModel));
  }

  @PostMapping("/find/{carBrand}/{carModel}")
  public ResponseEntity<Iterable<CarPart>>
  findAllByBrandAndModelAndPartNameOrDescription(@PathVariable String carBrand, @PathVariable String carModel,
    @RequestBody CarPartSerachRequest searchRequest) {
    return ResponseEntity.ok(service.findAllByBrandAndModelAndPartNameOrDescription(carBrand, carModel,
      searchRequest.getName(),
      searchRequest
        .getDescription()));
  }

  @GetMapping("/shipping-availability/{id}")
  public ResponseEntity<Optional<CarPartInfo>> checkAvailabilityAndShipping(@PathVariable Long id) {
    return ResponseEntity.ok(service.checkAvailabilityAndShipping(id));
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateDescriptionById(@PathVariable Long id,
    @RequestBody CarPartSerachRequest searchRequest) {
    service.updateDescriptionById(id, searchRequest.getDescription());
    return ResponseEntity.ok()
      .build();
  }
}
