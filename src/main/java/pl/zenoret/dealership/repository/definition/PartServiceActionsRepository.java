package pl.zenoret.dealership.repository.definition;

import java.time.LocalDateTime;
import pl.zenoret.dealership.entity.PartServiceAction;

public interface PartServiceActionsRepository {

  Iterable<PartServiceAction> findAllInDateRange(LocalDateTime startDate, LocalDateTime endDate);

  PartServiceAction save(PartServiceAction partServiceAction);
}
