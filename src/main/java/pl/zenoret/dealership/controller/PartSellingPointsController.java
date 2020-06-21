package pl.zenoret.dealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zenoret.dealership.service.definition.PartSellingPointsService;

@RestController
@RequestMapping("/api/part-selling-points")
public class PartSellingPointsController {

  private final PartSellingPointsService service;

  @Autowired
  protected PartSellingPointsController(PartSellingPointsService service) {
    this.service = service;
  }

  @DeleteMapping("/delete/part/{id}")
  public ResponseEntity<?> deleteAllByCarPartId(@PathVariable Long id) {
    service.deleteAllByCarPartId(id);
    return ResponseEntity.ok()
      .build();
  }
}
