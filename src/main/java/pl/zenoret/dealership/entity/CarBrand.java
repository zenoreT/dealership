package pl.zenoret.dealership.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.zenoret.dealership.model.DateAuditable;

@Entity
@Table(name = "car_brands")
@Data
@EqualsAndHashCode(callSuper = true)
public class CarBrand extends DateAuditable {

  private static final long serialVersionUID = -6922238560289738269L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 40)
  private String name;

  @JsonManagedReference
  @OneToMany(mappedBy = "brand")
  private Set<CarModel> models;
}
