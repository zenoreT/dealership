package pl.zenoret.dealership.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.zenoret.dealership.entity.CarBrand;
import pl.zenoret.dealership.service.definition.CarBrandsService;

@RunWith(SpringRunner.class)
@WebMvcTest(CarBrandsController.class)
public class CarBrandsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private CarBrandsService crudService;

  @Test
  public void testFindByNameIgnoreCase() throws Exception {
    CarBrand carBrand = new CarBrand();
    carBrand.setId(1L);
    carBrand.setName("Fiat");
    when(crudService.findByNameIgnoreCase(anyString())).thenReturn(Optional.of(carBrand));

    MvcResult result = this.mockMvc.perform(get("/api/car-brands/find/{carBrand}", "fiat")
      .accept(MediaType.APPLICATION_JSON_VALUE))
      .andReturn();

    assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    assertThat(result.getResponse().getContentAsString()).isNotNull();

    CarBrand response = objectMapper.readValue(result.getResponse().getContentAsString(), CarBrand.class);
    assertThat(response.getId()).isEqualTo(1L);
    assertThat(response.getName()).isEqualTo("Fiat");
  }
}