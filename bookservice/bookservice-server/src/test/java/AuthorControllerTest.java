import com.intexsoft.bookservice.dao.entity.Publisher;
import com.intexsoft.bookservice.service.api.PublisherService;
import com.intexsoft.bookservice.web.controller.PublisherController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.mockpolicies.Slf4jMockPolicy;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(PowerMockRunner.class)
@MockPolicy(Slf4jMockPolicy.class)
public class AuthorControllerTest {

    private MockMvc mockMvc;
    @Mock
    PublisherService publisherService;
    @InjectMocks
    PublisherController publisherController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(publisherController)
                .build();
    }

    @Test
    public void getPubl_Controller() throws Exception {
        List<Publisher> publishers = Arrays.asList(new Publisher(),
                new Publisher(), new Publisher());
        publishers.get(0).setName("publisher1");
        publishers.get(1).setName("publisher2");
        publishers.get(2).setName("publisher3");

        when(publisherService.getAllPublishers()).thenReturn(publishers);
        mockMvc.perform(get("/api/publishers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].name", is("publisher1")))
                .andExpect(jsonPath("$[1].name", is("publisher2")))
                .andExpect(jsonPath("$[2].name", is("publisher3")));
        verify(publisherService, times(1)).getAllPublishers();
        verifyNoMoreInteractions(publisherService);

    }

}
