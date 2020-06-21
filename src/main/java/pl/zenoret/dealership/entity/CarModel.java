package pl.zenoret.dealership.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.zenoret.dealership.model.DateAuditable;
import pl.zenoret.dealership.model.LocalDateRange;

@Entity
@Table(name = "car_models")
@Data
@EqualsAndHashCode(callSuper = true)
public class CarModel extends DateAuditable {

  private static final long serialVersionUID = 4020042663149414298L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 40)
  private String name;

  @Embedded
  @Column(nullable = false)
  private LocalDateRange productionRange;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "brand_id", nullable = false)
  private CarBrand brand;

  @JsonManagedReference
  @OneToMany(mappedBy = "model")
  private Set<CarPart> parts;
}
