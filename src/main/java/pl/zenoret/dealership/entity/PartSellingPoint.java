package pl.zenoret.dealership.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
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

@Entity
@Table(name = "part_selling_points")
@Data
@EqualsAndHashCode(callSuper = true)
public class PartSellingPoint extends DateAuditable {

  private static final long serialVersionUID = -8289972380233546872L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 40)
  private String title;

  @Column(nullable = false, length = 5000)
  private String description;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "part_id", nullable = false)
  private CarPart part;
}
