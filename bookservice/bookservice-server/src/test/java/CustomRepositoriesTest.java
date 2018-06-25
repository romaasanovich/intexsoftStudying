import com.intexsoft.bookservice.config.AppConfig;
import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.service.api.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import utils.Converter;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class,
        loader = AnnotationConfigContextLoader.class)
public class CustomRepositoriesTest {

    @Autowired
    private BookService bookService;


    @Test
    public void getBestseller_CrBAndSpec_correct() {
        Converter<Book> converter = new Converter<>();
        List<Book> crBooks = bookService.getBestsellersCriteriaBuilder(4.5, 3, 3);
        List<Book> specBooks = bookService.getBestsellersSpecification(4.5, 3, 3);
        String crBookJson = converter.fromListToJson(crBooks);
        String specBookJson = converter.fromListToJson(specBooks);
        assertEquals(crBookJson, specBookJson);

    }

    @Test
    public void getBestseller_DslAndSpec_correct() {
        Converter<Book> converter = new Converter<>();
        List<Book> dslBooks = bookService.getBestsellersQueryDsl(4.5, 3, 3);
        List<Book> specBooks = bookService.getBestsellersSpecification(4.5, 3, 3);
        String dslBookJson = converter.fromListToJson(dslBooks);
        String specBookJson = converter.fromListToJson(specBooks);
        assertEquals(dslBookJson, specBookJson);

    }

    @Test
    public void getByPriceInterval_CrBAndSpec_minValueNull_correct() {
        Converter<Book> converter = new Converter<>();
        List<Book> crBooks = bookService.getByPriceIntervalCriteriaBuilder(null, 50.0, 3, 3);
        List<Book> specBooks = bookService.getByPriceIntervalSpecification(null, 50.0, 3, 3);
        String crBookJson = converter.fromListToJson(crBooks);
        String specBookJson = converter.fromListToJson(specBooks);
        assertEquals(crBookJson, specBookJson);

    }

    @Test
    public void getByPriceInterval_DslAndSpec_minValueNull_correct() {
        Converter<Book> converter = new Converter<>();
        List<Book> dslBooks = bookService.getByPriceIntervalQueryDsl(null, 50.0, 2, 2);
        List<Book> specBooks = bookService.getByPriceIntervalSpecification(null, 50.0, 2, 2);
        String dslBookJson = converter.fromListToJson(dslBooks);
        String specBookJson = converter.fromListToJson(specBooks);
        assertEquals(dslBookJson, specBookJson);

    }

    @Test
    public void getByPriceInterval_DslAndSpec_maxValueNull_correct() {
        Converter<Book> converter = new Converter<>();
        List<Book> dslBooks = bookService.getByPriceIntervalQueryDsl(45.0, null, 3, 3);
        List<Book> specBooks = bookService.getByPriceIntervalSpecification(45.0, null, 3, 3);
        String dslBookJson = converter.fromListToJson(dslBooks);
        String specBookJson = converter.fromListToJson(specBooks);
        assertEquals(dslBookJson, specBookJson);

    }

    @Test
    public void getByPriceInterval_CrBAndSpec_maxValueAndPublisherAndAuthorsUndefined_correct() {
        Converter<Book> converter = new Converter<>();
        List<Book> crBooks = bookService.getByPriceIntervalCriteriaBuilder(null, 50.0, -1, -1);
        List<Book> specBooks = bookService.getByPriceIntervalSpecification(null, 50.0, -1, -1);
        String crBookJson = converter.fromListToJson(crBooks);
        String specBookJson = converter.fromListToJson(specBooks);
        assertEquals(crBookJson, specBookJson);
    }
}
