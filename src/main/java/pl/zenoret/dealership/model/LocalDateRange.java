package pl.zenoret.dealership.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LocalDateRange implements Iterable<LocalDate> {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate startDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate endDate;

  public LocalDateRange(LocalDate startDate, LocalDate endDate) {
    this.startDate = startDate;
    this.endDate = endDate;
  }

  @Override
  public Iterator<LocalDate> iterator() {
    return stream().iterator();
  }

  public Stream<LocalDate> stream() {
    return Stream.iterate(startDate, d -> d.plusDays(1))
      .limit(ChronoUnit.DAYS.between(startDate, endDate) + 1);
  }

  public List<LocalDate> toList() {
    return stream().collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return startDate + " - " + endDate;
  }
}