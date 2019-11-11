package me.fabricionogueira.sqlgen.modules.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleController.class)
@AutoConfigureMockMvc
public class SampleControllerTest {

    @Autowired
    private SampleController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_load_the_controller() {
        assertThat(this.controller).isNotNull();
    }

    @Test
    public void it_should_return_sample_data_when_requests_sample_index() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(
                        content().string(containsString(
                                "<h1>Fabricio Nogueira</h1>" +
                                        "<h2>The Instruction</h2>" +
                                        "<pre>new Sql().select(\"pessoa\", \"pes\").columns(\"pes\", \"vei.placa\").join(\"veiculo\", \"vei\", \"rg\").build()</pre>" +
                                        "<h2>Results the string</h2>" +
                                        "<pre>select pes.*, vei.placa from pessoa as pes inner join veiculo as vei on pes.rg = vei.rg</pre>"
                        ))
                )
        ;
    }

}