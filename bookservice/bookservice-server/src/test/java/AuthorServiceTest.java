import com.intexsoft.bookservice.dao.entity.Publisher;
import com.intexsoft.bookservice.service.api.PublisherService;
import com.intexsoft.bookservice.service.implementation.PublisherServiceImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthorServiceTest {


    @Test
    public void getPublishers_count_2() {

        List<Publisher> publishers = Arrays.asList(new Publisher("sss"),
                new Publisher("qqweqwe"));
        PublisherService publisherService = mock(PublisherServiceImpl.class);

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
