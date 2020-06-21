package pl.zenoret.dealership.service.definition;

import java.time.LocalDateTime;
import pl.zenoret.dealership.entity.PartServiceAction;

public interface PartServiceActionsService {

  Iterable<PartServiceAction> findAllInDateRange(LocalDateTime startDate, LocalDateTime endDate);

  PartServiceAction save(PartServiceAction partServiceAction);
}
