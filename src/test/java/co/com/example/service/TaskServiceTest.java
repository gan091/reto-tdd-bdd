package co.com.example.service;

import co.com.example.model.Task;
import co.com.example.repository.ITaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    private static final int TASK_ID = 1;
    private static final String TASK_TITLE = "Preparar presentación";
    private static final String TASK_DESCRIPTION = "Preparar la presentación para la reunión del lunes";

    @Mock
    private ITaskRepository taskRepository;
    @InjectMocks
    private TaskServiceImpl taskServiceImpl;

    @Test
    void testSaveTaskSuccessful() {
        Task taskRequest = Task
                .builder()
                .title(TASK_TITLE)
                .description(TASK_DESCRIPTION)
                .build();

        Task taskResponse = Task
                .builder()
                .id(TASK_ID)
                .title(TASK_TITLE)
                .description(TASK_DESCRIPTION)
                .completed(false)
                .build();

        when(taskRepository.save(taskRequest)).thenReturn(taskResponse);

        Task savedTask = taskServiceImpl.save(taskRequest);
        assertNotNull(savedTask);
        assertEquals(TASK_ID, savedTask.getId());
        assertEquals(TASK_TITLE, savedTask.getTitle());
        assertEquals(TASK_DESCRIPTION, savedTask.getDescription());
        assertFalse(savedTask.getCompleted());
    }
}