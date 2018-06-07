import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;
import com.intexsoft.bookservice.importer.executor.ImportExecutor;
import com.intexsoft.bookservice.importer.executor.ImportExecutorImpl;
import com.intexsoft.bookservice.importer.importer.Importer;
import com.intexsoft.bookservice.importer.importer.ImporterJsonImpl;
import com.intexsoft.bookservice.importer.importer.ImporterXmlImpl;
import com.intexsoft.bookservice.importer.importer.TypeImport;
import com.intexsoft.bookservice.web.controller.ImportController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.mockpolicies.Slf4jMockPolicy;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(ConcurrentTestRunner.class)
@MockPolicy(Slf4jMockPolicy.class)
public class ImportControllerTest {

    private static ReentrantLock reentrantLock = new ReentrantLock();
    private final ImportExecutor importExecutor = new ImportExecutorImpl();
    private MockMvc mockMvc;

    @Mock
    private ImporterJsonImpl importerJson;

    @Mock
    private ImporterXmlImpl importerXml;

    @InjectMocks
    private ImportController importController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(importerJson.getType()).thenReturn(TypeImport.json);
        when(importerXml.getType()).thenReturn(TypeImport.xml);
        List<Importer> importers = Arrays.asList(importerXml, importerJson);
        importExecutor.setLock(reentrantLock);
        importExecutor.setImporters(importers);
        mockMvc = MockMvcBuilders
                .standaloneSetup(importController)
                .build();

    }

    @Test
    public void callImport_json_true() {
        when(importerJson.importToDb()).thenReturn(true);
        try {
            mockMvc.perform(post("/api/import/json"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
        verify(importerJson, times(1)).importToDb();
    }

    @Test
    public void callImport_xml_true() throws InterruptedException {
        Thread.sleep(2500);
        when(importerXml.importToDb()).thenReturn(true);
        try {
            mockMvc.perform(post("/api/import/xml"))
                    .andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
        verify(importerXml, times(0)).importToDb();
    }
}
