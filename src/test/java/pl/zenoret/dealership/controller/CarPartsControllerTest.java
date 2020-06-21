package pl.zenoret.dealership.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Arrays;
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
import pl.zenoret.dealership.entity.CarPart;
import pl.zenoret.dealership.model.CarPartInfo;
import pl.zenoret.dealership.model.request.CarPartSerachRequest;
import pl.zenoret.dealership.service.definition.CarPartsService;

@RunWith(SpringRunner.class)
@WebMvcTest(CarPartsController.class)
public class CarPartsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private CarPartsService crudService;

  @Test
  public void testFindAllByBrandAndModel() throws Exception {
    CarPart carPart = new CarPart();
    carPart.setId(1L);
    carPart.setName("part#1");

    CarPart carPart2 = new CarPart();
    carPart2.setId(1L);
    carPart2.setName("part#2");
    Iterable<CarPart> carParts = Arrays.asList(carPart, carPart2);

    when(crudService.findAllByBrandAndModel("fiat", "panda")).thenReturn(carParts);

    MvcResult result =
      this.mockMvc.perform(get("/api/car-parts/find/{carBrand}/{carModel}", "fiat", "panda")
        .accept(MediaType.APPLICATION_JSON_VALUE))
        .andReturn();

    assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    assertThat(result.getResponse().getContentAsString()).isNotNull();

    Iterable<CarPart> response = Arrays
      .asList(objectMapper.readValue(result.getResponse().getContentAsString(), CarPart[].class));
    assertThat(response).isNotNull();
    assertThat(response).isNotEmpty();
    assertThat(response).hasSize(2);
  }

  @Test
  public void testFindAllByBrandAndModelAndPartNameOrDescription() throws Exception {
    CarPart carPart = new CarPart();
    carPart.setId(1L);
    carPart.setName("part#1");

    CarPart carPart2 = new CarPart();
    carPart2.setId(1L);
    carPart2.setName("part#2");
    Iterable<CarPart> carParts = Arrays.asList(carPart, carPart2);

    CarPartSerachRequest searchRequest = new CarPartSerachRequest();
    searchRequest.setName("#1");

    when(crudService.findAllByBrandAndModelAndPartNameOrDescription("fiat", "panda", searchRequest.getName(), null))
      .thenReturn(carParts);

    MvcResult result =
      this.mockMvc.perform(post("/api/car-parts/find/{carBrand}/{carModel}", "fiat", "panda")
        .content(objectMapper.writeValueAsString(searchRequest))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON_VALUE))
        .andReturn();

    assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    assertThat(result.getResponse().getContentAsString()).isNotNull();

    Iterable<CarPart> response = Arrays
      .asList(objectMapper.readValue(result.getResponse().getContentAsString(), CarPart[].class));

    assertThat(response).isNotNull();
    assertThat(response).isNotEmpty();
    assertThat(response).hasSize(2);
  }

  @Test
  public void testCheckAvailabilityAndShipping() throws Exception {
    CarPartInfo info = new CarPartInfo(1L, true, 7);

    when(crudService.checkAvailabilityAndShipping(1L)).thenReturn(Optional.of(info));

    MvcResult result =
      this.mockMvc.perform(get("/api/car-parts/shipping-availability/{id}", 1L)
        .accept(MediaType.APPLICATION_JSON_VALUE))
        .andReturn();

    assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    assertThat(result.getResponse().getContentAsString()).isNotNull();

    CarPartInfo response = objectMapper.readValue(result.getResponse().getContentAsString(), CarPartInfo.class);
    assertThat(response).isNotNull();
    assertThat(response.getId()).isEqualTo(1L);
    assertThat(response.isAvailable()).isEqualTo(true);
    assertThat(response.getDeliveryDate()).isEqualTo(LocalDate.now().plusDays(response.getDeliveryTime()));
  }

  @Test
  public void testUpdateDescriptionById() throws Exception {
    CarPartSerachRequest searchRequest = new CarPartSerachRequest();
    searchRequest.setDescription("testFindAllByBrandAndModelAndPartNameOrDescription");

    doNothing().when(crudService).updateDescriptionById(1L, searchRequest.getDescription());

    MvcResult result =
      this.mockMvc.perform(put("/api/car-parts/update/{id}", 1L)
        .content(objectMapper.writeValueAsString(searchRequest))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON_VALUE))
        .andReturn();

    assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
  }
}