package pl.zenoret.dealership.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;
import javax.persistence.Column;
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

@Entity
@Table(name = "car_parts")
@Data
@EqualsAndHashCode(callSuper = true)
public class CarPart extends DateAuditable {

  private static final long serialVersionUID = -7536999965484437580L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false, length = 5000)
  private String description;

  @Column(nullable = false)
  private Double price;

  @Column(nullable = false)
  private boolean available;

  @Column(nullable = false)
  private int deliveryTime;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "model_id", nullable = false)
  private CarModel model;

  @JsonManagedReference
  @OneToMany(mappedBy = "part")
  private Set<PartSellingPoint> partSellingPoints;

  @JsonManagedReference
  @OneToMany(mappedBy = "part")
  private Set<PartServiceAction> partServiceActions;
}
