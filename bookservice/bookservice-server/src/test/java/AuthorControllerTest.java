import com.intexsoft.bookservice.dao.entity.Publisher;
import com.intexsoft.bookservice.service.api.PublisherService;
import com.intexsoft.bookservice.service.implementation.PublisherServiceImpl;
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
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
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
        List<Publisher> publishers = Arrays.asList(new Publisher("sss"),
                new Publisher("qqweqwe"), new Publisher("test"));

        when(publisherService.getAllPublishers()).thenReturn(publishers);
        mockMvc.perform(get("/api/publishers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].name", is("sss")))
                .andExpect(jsonPath("$[1].name", is("qqweqwe")))
                .andExpect(jsonPath("$[2].name", is("test")));
        verify(publisherService, times(1)).getAllPublishers();
        verifyNoMoreInteractions(publisherService);

    }


    @Test
    public void getPublishers_count_2() {

        List<Publisher> publishers = Arrays.asList(new Publisher("sss"),
                new Publisher("qqweqwe"));

        when(publisherService.getAllPublishers()).thenReturn(publishers);

        int count = publisherService.getAllPublishers().size();

        assertThat(count, is(2));
    }


    @Test
    public void getPublisher_byId2_nameTest() {

        List<Publisher> publishers = Arrays.asList(new Publisher("sss"),
                new Publisher("qqweqwe"), new Publisher("test"));

        publishers.get(0).setId(0);
        publishers.get(1).setId(1);
        publishers.get(2).setId(2);

        Optional<Publisher> optPubl = Optional.of(publishers.get(2));

        PublisherService publisherService = mock(PublisherServiceImpl.class);

        when(publisherService.getPublisherByID(2)).thenReturn(optPubl);

        String name = publisherService.getPublisherByID(2).get().getName();

        assertThat(name, is("test"));
    }
}
