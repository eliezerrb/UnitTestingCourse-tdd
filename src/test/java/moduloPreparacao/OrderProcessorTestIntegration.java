package moduloPreparacao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = Application.class)
@ExtendWith(SpringExtension.class)
public class OrderProcessorTestIntegration {

    @Autowired
    private WebApplicationContext context;

    WireMockServer wireMockServer = new WireMockServer(8082);

    @Autowired
    protected ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @AfterEach
    protected void dispose() {
        this.wireMockServer.stop();
    }

    @BeforeEach
    protected void warmup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context).build();
        this.wireMockServer.start();
    }

    @Test
    public void test() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test"))
                .andExpect(
                        MockMvcResultMatchers.status().isOk());
    }
}
