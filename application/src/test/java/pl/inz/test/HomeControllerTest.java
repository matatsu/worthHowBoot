package pl.inz.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import pl.inz.controller.HomeController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by matat on 22.08.2016.
 */
public class HomeControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(new HomeController()).build();
    }

    @Test
    public void homeIndexTest() throws Exception {
        mockMvc.perform(patch("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(forwardedUrl("index"));
    }

    @Test
    public void homeView2Test() throws Exception {
        mockMvc.perform(patch("/blackscholes"))
                .andExpect(status().isOk())
                .andExpect(view().name("view/BlackScholesView"))
                .andExpect(forwardedUrl("view/BlackScholesView"));
    }

    @Test
    public void helloViewTest() throws Exception {
        String testString = "testValue";
        mockMvc.perform(get("/hello").param("name","testValue"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"))
                .andExpect(forwardedUrl("greeting"))
                .andExpect(model().attribute("name", testString));
    }
}
