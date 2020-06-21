package pl.zenoret.dealership.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import pl.zenoret.dealership.service.definition.PartSellingPointsService;

@RunWith(SpringRunner.class)
@WebMvcTest(PartSellingPointsController.class)
public class PartSellingPointsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private PartSellingPointsService crudService;

  @Test
  public void testDeleteAllByCarPartId() throws Exception {
    doNothing().when(crudService).deleteAllByCarPartId(1L);

    MvcResult result =
      this.mockMvc.perform(delete("/api/part-selling-points/delete/part/{id}", 1L)
        .accept(MediaType.APPLICATION_JSON_VALUE))
        .andReturn();

    assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
  }
}