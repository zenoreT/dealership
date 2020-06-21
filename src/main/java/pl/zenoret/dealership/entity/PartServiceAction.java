package pl.zenoret.dealership.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.zenoret.dealership.model.DateAuditable;
import pl.zenoret.dealership.model.LocalDateTimeRange;

@Entity
@Table(name = "part_service_actions")
@Data
@EqualsAndHashCode(callSuper = true)
public class PartServiceAction extends DateAuditable {

  private static final long serialVersionUID = -37849645184529747L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 40)
  private String title;

  @Column(nullable = false, length = 5000)
  private String description;

  @Embedded
  @Column(nullable = false)
  private LocalDateTimeRange dateTimeRange;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "part_id", nullable = false)
  private CarPart part;
}
