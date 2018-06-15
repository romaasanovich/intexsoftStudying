import com.intexsoft.bookservice.importer.executor.ImportExecutor;
import com.intexsoft.bookservice.importer.executor.ImportExecutorImpl;
import com.intexsoft.bookservice.importer.importer.ImportType;
import com.intexsoft.bookservice.importer.importer.Importer;
import com.intexsoft.bookservice.importer.importer.ImporterJsonImpl;
import com.intexsoft.bookservice.importer.importer.ImporterXmlImpl;
import com.intexsoft.bookservice.web.controller.ImportController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ImportControllerTest {
    private static final ImportExecutor importExecutor = new ImportExecutorImpl();
    private static ReentrantLock reentrantLock = new ReentrantLock();
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
        when(importerJson.getType()).thenReturn(ImportType.JSON);
        when(importerXml.getType()).thenReturn(ImportType.XML);
        List<Importer> importers = Arrays.asList(importerXml, importerJson);
        importExecutor.setLock(reentrantLock);
        importExecutor.setImporters(importers);
        importController.setImportExecutor(importExecutor);
        mockMvc = MockMvcBuilders
                .standaloneSetup(importController)
                .build();

    }

    @Test
    public void callTwoImports_twoThreads() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            when(importerJson.importToDb()).thenReturn(true);
            try {
                mockMvc.perform(post("/api/import/JSON"))
                        .andExpect(status().isOk());
            } catch (Exception e) {
                return;
            }
        });
        Thread t2 = new Thread(() -> {
            when(importerXml.importToDb()).thenReturn(true);
            try {
                mockMvc.perform(post("/api/import/XML"))
                        .andExpect(status().is4xxClientError());
            } catch (Exception e) {
                return;
            }
        });
        t1.start();
        Thread.sleep(150);
        t2.start();
        t1.join();
        t2.join();
        verify(importerJson, times(1)).importToDb();
        verify(importerXml, times(0)).importToDb();
    }
}