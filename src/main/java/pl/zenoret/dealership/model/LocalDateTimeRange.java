package pl.zenoret.dealership.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LocalDateTimeRange implements Iterable<LocalDateTime> {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime startDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime endDate;

  public LocalDateTimeRange(LocalDateTime startDate, LocalDateTime endDate) {
    this.startDate = startDate;
    this.endDate = endDate;
  }

  @Override
  public Iterator<LocalDateTime> iterator() {
    return stream().iterator();
  }

  public Stream<LocalDateTime> stream() {
    return Stream.iterate(startDate, d -> d.plusDays(1))
      .limit(ChronoUnit.DAYS.between(startDate, endDate) + 1);
  }

  public List<LocalDateTime> toList() {
    return stream().collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return startDate + " - " + endDate;
  }
}
