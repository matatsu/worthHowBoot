import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.inz.model.Company;
import pl.inz.repository.CompanyRepository;
import pl.inz.service.CompanyServiceImpl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

/**
 * Created by matat on 17.08.2016.
 */
public class CompanyServiceImplTest {

    @InjectMocks
    private CompanyServiceImpl companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addCompanyTest(){
        // Given
        Company saveCompany = new Company("cc","cn","dc");
        when(companyRepository.save(any(Company.class))).thenReturn(saveCompany);

        // When
        Company comp = companyService.addCompany(saveCompany);

        // Then
        assertEquals(saveCompany, comp);
    }
    @Test
    public void deleteCompanyTest(){
        // Given
        Company saveCompany = new Company("cc","cn","dc");
        saveCompany.setId(1);
        doNothing().when(companyRepository).delete(any(Integer.class));
        // When
        companyService.deleteCompany(1);
        // Then
        verify(companyRepository).delete(1);
    }

    @Test
    public void findCompanyTest(){
        // Given
        Company testCompany1 = new Company("cc","cn","dc");
        testCompany1.setId(1);
        Company testCompany2 = new Company("123","abc","www");
        testCompany2.setId(2);
        when(companyRepository.findOne(any(Integer.class))).thenReturn(testCompany1);
        // When
        Company whenCompanyIs = companyService.findCompany(1);
        // Them
        verify(companyRepository).findOne(1);
        assertThat(whenCompanyIs.getId(), is(1));
        assertNotEquals(whenCompanyIs.getId(), is(2));
    }

//    @Test
//    public void findAllCompanyTest(){
        // Given

        // When

        // Then
//    }

}
