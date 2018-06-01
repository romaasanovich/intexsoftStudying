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
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(PowerMockRunner.class)
@MockPolicy(Slf4jMockPolicy.class)
public class ImportControllerTest {

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
        List<Importer> importers = Arrays.asList(importerXml, importerJson);
        when(importerJson.getType()).thenReturn(TypeImport.json);
        when(importerXml.getType()).thenReturn(TypeImport.xml);
        importController.setImporters(importers);
        mockStatic(Importer.class);
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
    public void callImport_xml_true() {
        when(importerXml.importToDb()).thenReturn(true);
        try {
            mockMvc.perform(post("/api/import/xml"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
        verify(importerXml, times(1)).importToDb();
    }
}
