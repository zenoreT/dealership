package pl.zenoret.dealership.service.implementation;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zenoret.dealership.entity.PartServiceAction;
import pl.zenoret.dealership.repository.definition.PartServiceActionsRepository;
import pl.zenoret.dealership.service.definition.PartServiceActionsService;

@Service
public class PartServiceActionsServiceImpl implements PartServiceActionsService {

  private final PartServiceActionsRepository repository;

  @Autowired
  public PartServiceActionsServiceImpl(PartServiceActionsRepository repository) {
    this.repository = repository;
  }

  @Override
  public Iterable<PartServiceAction> findAllInDateRange(LocalDateTime startDate, LocalDateTime endDate) {
    return repository.findAllInDateRange(startDate, endDate);
  }

  @Override
  public PartServiceAction save(PartServiceAction partServiceAction) {
    return repository.save(partServiceAction);
  }
}
