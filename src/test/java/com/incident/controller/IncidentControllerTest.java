// test/java/com/incident/controller/IncidentControllerTest.java
package com.incident.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.incident.model.Incident;
import com.incident.service.IncidentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest  // 启动完整的 Spring Boot 应用上下文
@AutoConfigureMockMvc  // 自动配置 MockMvc
class IncidentControllerTest {

    @Autowired
    private MockMvc mockMvc;  // 注入 MockMvc

    @MockBean
    private IncidentService incidentService;  // Mock Service


    private Incident testIncident;

    @BeforeEach
    void setUp() {
        testIncident = new Incident();
        testIncident.setId(1);  // 设置一个 ID
        testIncident.setTitle("Test Incident");
        testIncident.setDescription("Test Description");
        testIncident.setStatus("OPEN");
        testIncident.setPriority("HIGH");
    }


    @Test
    void whenGetAllIncidents_thenReturnIncidentsList() throws Exception {
        when(incidentService.getAllIncidents())
                .thenReturn(Arrays.asList(testIncident));

        mockMvc.perform(get("/api/incidents"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Test Incident"))
                .andExpect(jsonPath("$[0].description").value("Test Description"));
    }

    @Test
    void whenGetIncidentById_thenReturnIncident() throws Exception {
        when(incidentService.getIncidentById(1))  // 使用正确的 ID
                .thenReturn(testIncident);

        mockMvc.perform(get("/api/incidents/" + testIncident.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Incident"))
                .andExpect(jsonPath("$.description").value("Test Description"));
    }


}