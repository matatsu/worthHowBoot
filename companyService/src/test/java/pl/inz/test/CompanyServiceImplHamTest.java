package pl.inz.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.inz.model.Company;
import pl.inz.repository.CompanyRepository;
import pl.inz.service.CompanyServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

/**
 * These tests contains hamcrest and junit cases.
 */
public class CompanyServiceImplHamTest {

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
        Company addCompany = companyService.addCompany(saveCompany);

        // Then
        // Hamcrest
        assertThat(saveCompany, is(addCompany));
    }
    @Test
    public void deleteCompanyTest(){
        // Given
        Company saveCompany = new Company("cc","cn","dc");
        saveCompany.setId(1);
        doNothing().when(companyRepository).delete(anyInt());
        // When
        companyService.deleteCompany(1);
        // Then
        verify(companyRepository).delete(1);
    }

    @Test
    public void findCompanyTest(){
        // Given
        Integer wrongTestID = 2;
        Company testCompany1 = new Company("cc","cn","dc");
        testCompany1.setId(1);
        Company testCompany2 = new Company("123","abc","www");
        testCompany2.setId(2);
        when(companyRepository.findOne(any(Integer.class))).thenReturn(testCompany1);
        // When
        Company whenCompanyIs = companyService.findCompany(1);
        // Them
        verify(companyRepository).findOne(1);
        // Hamcrest
        assertThat(whenCompanyIs.getId(), equalTo(1));
    }

    @Test
    public void getAllCompanyTest(){
        // Given
        Company testCompany1 = new Company("cc","cn","dc");
        testCompany1.setId(1);
        Company testCompany2 = new Company("123","abc","www");
        testCompany2.setId(2);
        Company testCompany3 = new Company("123","abc","www");
        testCompany3.setId(3);
        List<Company> listCompany = Arrays.asList(testCompany1,testCompany2,testCompany3);
        when(companyRepository.findAll()).thenReturn(listCompany);
        // When
        Iterable<Company> allCompany = companyService.getAllCompany();
        // Then
        verify(companyRepository).findAll();
        // Hamcrest
        assertThat(listCompany, is(allCompany));
    }

    @Test
    public void countCompanyTest(){
        // Given
        long sizeCompanyList;
        Company testCompany1 = new Company("cc","cn","dc");
        testCompany1.setId(1);
        Company testCompany2 = new Company("123","abc","www");
        testCompany2.setId(2);
        Company testCompany3 = new Company("123","abc","www");
        testCompany3.setId(3);
        List<Company> listCompany = Arrays.asList(testCompany1,testCompany2,testCompany3);
        sizeCompanyList = (long)listCompany.size();
        when(companyRepository.count()).thenReturn(sizeCompanyList);
        // When
        long numberCompany = companyService.countCompany();
        // Then
        verify(companyRepository).count();
        // Hamcrest
        assertThat(numberCompany, equalTo(sizeCompanyList));
    }

}
