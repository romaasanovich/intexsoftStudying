import com.intexsoft.bookservice.service.api.PublisherService;
import com.intexsoft.bookservice.web.controller.PublisherController;
import com.intexsoft.bookservice.web.dto.entity.PublisherDto;
import com.intexsoft.bookservice.web.dto.mapper.PublisherDtoMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import utils.Converter;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PublisherControllerTest {

    private MockMvc mockMvc;
    @Mock
    private PublisherDtoMapper publisherDtoMapper;

    @Mock
    private PublisherService publisherService;

    @InjectMocks
    private PublisherController publisherController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(publisherController)
                .build();
    }

    @Test
    public void getPublishers_Controller() throws Exception {
        List<PublisherDto> publishers = Arrays.asList(new PublisherDto(),
                new PublisherDto(), new PublisherDto());
        publishers.get(0).setName("publisher1");
        publishers.get(1).setName("publisher2");
        publishers.get(2).setName("publisher3");
        when(publisherService.getPublishers(1, 3)).thenReturn(null);
        when(publisherDtoMapper.toPageDto(null)).thenReturn(new PageImpl<>(publishers));
        mockMvc.perform(get("/api/publishers/0/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(Converter.fromListToJson(publishers)))
                .andExpect(status().isOk());
        verify(publisherDtoMapper, times(1)).toPageDto(null);
        verifyNoMoreInteractions(publisherDtoMapper);
    }

}
