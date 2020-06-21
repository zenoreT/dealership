package pl.zenoret.dealership.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Data;

@Data
public class CarPartInfo {

  private final Long id;
  private final boolean available;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private final LocalDate deliveryDate;
  private final int deliveryTime;

  public CarPartInfo(Long id, boolean available, int deliveryTime) {
    this.id = id;
    this.available = available;
    this.deliveryDate = LocalDate.now()
      .plusDays(deliveryTime);
    this.deliveryTime = deliveryTime;
  }
}
