package co.com.example.controller;

import co.com.example.model.Task;
import co.com.example.service.ITaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ITaskService taskService;

    @Test
    void testGuardarTask() throws Exception {
        final int TASK_ID = 1;
        final String TITTLE = "Redactar informe";
        final String DESCRIPTION = "Redactar el informe mensual de ventas";

        Task task = new Task(TASK_ID, TITTLE, DESCRIPTION, false);

        Mockito.when(taskService.save(Mockito.any(Task.class))).thenReturn(task);

        mockMvc.perform(post("/task")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Preparar presentación\",\"description\":\"Preparar la presentación para la reunión del lunes\"}"))
                .andExpect(status().is(201))
                .andExpect(jsonPath("$.id").value(TASK_ID))
                .andExpect(jsonPath("$.title").value(TITTLE))
                .andExpect(jsonPath("$.description").value(DESCRIPTION))
                .andExpect(jsonPath("$.completed").value(false));
    }
}