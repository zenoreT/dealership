package pl.zenoret.dealership.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
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
import pl.zenoret.dealership.entity.PartServiceAction;
import pl.zenoret.dealership.model.LocalDateTimeRange;
import pl.zenoret.dealership.model.request.PartServiceActionSearchRequest;
import pl.zenoret.dealership.service.definition.PartServiceActionsService;

@RunWith(SpringRunner.class)
@WebMvcTest(PartServiceActionsController.class)
public class PartServiceActionsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private PartServiceActionsService crudService;

  @Test
  public void testFindAllInDateRange() throws Exception {
    PartServiceActionSearchRequest searchRequest = new PartServiceActionSearchRequest();
    searchRequest.setEndDate(LocalDateTime.now().minusHours(1));
    searchRequest.setStartDate(LocalDateTime.now());

    when(crudService.findAllInDateRange(searchRequest.getStartDate(), searchRequest.getEndDate()))
      .thenReturn(Collections.emptyList());

    MvcResult result =
      this.mockMvc.perform(post("/api/part-service-actions/find/range")
        .content(objectMapper.writeValueAsString(searchRequest))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON_VALUE))
        .andReturn();

    assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    assertThat(result.getResponse().getContentAsString()).isNotNull();

    Iterable<PartServiceAction> response = Arrays
      .asList(objectMapper.readValue(result.getResponse().getContentAsString(), PartServiceAction[].class));
    assertThat(response).isNotNull();
    assertThat(response).isEmpty();
  }

  @Test
  public void testSave() throws Exception {
    CarPart carPart = new CarPart();
    carPart.setId(1L);

    PartServiceAction serviceAction = new PartServiceAction();
    serviceAction.setTitle("testSave");
    serviceAction.setDescription("testSave");
    serviceAction.setDateTimeRange(new LocalDateTimeRange(LocalDateTime.now().minusHours(1), LocalDateTime.now()));
    serviceAction.setPart(carPart);
    serviceAction.setCreatedAt(Instant.now());
    serviceAction.setUpdatedAt(Instant.now());

    when(crudService.save(serviceAction)).thenReturn(serviceAction);

    MvcResult result =
      this.mockMvc.perform(post("/api/part-service-actions/new")
        .content(objectMapper.writeValueAsString(serviceAction))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON_VALUE))
        .andReturn();

    assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    assertThat(result.getResponse().getContentAsString()).isNotNull();

    PartServiceAction response = objectMapper
      .readValue(result.getResponse().getContentAsString(), PartServiceAction.class);
    assertThat(response.getTitle()).isEqualTo("testSave");
    assertThat(response.getPart()).isNull();
  }
}