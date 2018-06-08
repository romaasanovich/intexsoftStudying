import com.intexsoft.bookservice.dao.entity.Publisher;
import com.intexsoft.bookservice.service.api.PublisherService;
import com.intexsoft.bookservice.service.implementation.PublisherServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PublisherServiceTest {

    @Mock
    private PublisherService publisherService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getPublishers_count_2() {

        List<Publisher> publishers = Arrays.asList(new Publisher(),
                new Publisher());
        publishers.get(0).setName("publisher1");
        publishers.get(1).setName("publisher2");

        when(publisherService.getAllPublishers()).thenReturn(publishers);

        int count = publisherService.getAllPublishers().size();

        assertEquals(count, 2);
    }


    @Test
    public void getPublisher_byId2_nameTest() {

        List<Publisher> publishers = Arrays.asList(new Publisher(),
                new Publisher(), new Publisher());
        publishers.get(0).setName("publisher1");
        publishers.get(1).setName("publisher2");
        publishers.get(2).setName("publisher3");

        publishers.get(0).setId(0);
        publishers.get(1).setId(1);
        publishers.get(2).setId(2);

        Optional<Publisher> publisher = Optional.of(publishers.get(2));
        when(publisherService.getPublisherByID(2)).thenReturn(publisher);
        String name = publisherService.getPublisherByID(2).get().getName();
        
        assertEquals(name, "publisher3");
    }
}
