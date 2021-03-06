package pl.inz.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.inz.controller.CompanyController;
import pl.inz.model.Company;
import pl.inz.service.CompanyService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by matat on 22.08.2016.
 * Made in SpringBoot 1.4.0
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CompanyController.class)
public class CompanyCotrollerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CompanyService companyService;

//    @Before
//    public void setup() {
//        this.mockMvc = standaloneSetup(new CompanyController()).build();
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void companyIndexTest() throws Exception {
        // Given
        Company testCompany1 = new Company("cc","cn","dc");
        testCompany1.setId((long) 1);
        Company testCompany2 = new Company("123","abc","www");
        testCompany2.setId((long) 2);
        List<Company> companyList =  Arrays.asList(testCompany1,testCompany2);
        // When
        when(companyService.getAllCompany()).thenReturn(companyList);
        // Then
        mockMvc.perform(get("/company"))
                .andExpect(status().isOk())
                .andExpect(view().name("view/CompanyView"))
                .andExpect(forwardedUrl("view/CompanyView"))
                .andExpect(model().attribute("companies",hasSize(2)))
                .andExpect(model().attribute("companies", hasItem(
                        allOf(
                                hasProperty("id", is(1)),
                                hasProperty("companyCode", is("cc")),
                                hasProperty("companyName", is("cn")),
                                hasProperty("databaseCode", is("dc"))
                        )
                )))
                .andExpect(model().attribute("companies", hasItem(
                        allOf(
                                hasProperty("id", is(2)),
                                hasProperty("companyCode", is("123")),
                                hasProperty("companyName", is("abc")),
                                hasProperty("databaseCode", is("www"))
                        )
                )));
        verify(companyService, times(1)).getAllCompany();
        verifyNoMoreInteractions(companyService);
    }


}
