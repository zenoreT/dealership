package pl.zenoret.dealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zenoret.dealership.entity.PartServiceAction;
import pl.zenoret.dealership.model.request.PartServiceActionSearchRequest;
import pl.zenoret.dealership.service.definition.PartServiceActionsService;

@RestController
@RequestMapping("/api/part-service-actions")
public class PartServiceActionsController {

  private final PartServiceActionsService service;

  @Autowired
  protected PartServiceActionsController(PartServiceActionsService service) {
    this.service = service;
  }

  @PostMapping("/find/range")
  public ResponseEntity<?> findAllInDateRange(
    @RequestBody PartServiceActionSearchRequest searchRequest) {
    return ResponseEntity.ok(service.findAllInDateRange(searchRequest.getStartDate(), searchRequest.getEndDate()));
  }

  @PostMapping("/new")
  public ResponseEntity<PartServiceAction> save(@RequestBody PartServiceAction partServiceAction) {
    return ResponseEntity.ok(service.save(partServiceAction));
  }
}
