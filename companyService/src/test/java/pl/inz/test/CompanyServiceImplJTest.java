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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

public class CompanyServiceImplJTest {

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
        assertEquals(saveCompany, addCompany);
    }
    @Test
    public void deleteCompanyTest(){
        // Given
        Company saveCompany = new Company("cc","cn","dc");
        saveCompany.setId((long) 1);
        doNothing().when(companyRepository).delete(anyLong());
        // When
        companyService.deleteCompany((long) 1);
        // Then
        verify(companyRepository).delete((long) 1);
    }

    @Test
    public void findCompanyTest(){
        // Given
        Integer wrongTestID = 2;
        Company testCompany1 = new Company("cc","cn","dc");
        testCompany1.setId((long) 1);
        Company testCompany2 = new Company("123","abc","www");
        testCompany2.setId((long) 2);
        when(companyRepository.findOne(any(Long.class))).thenReturn(testCompany1);
        // When
        Company whenCompanyIs = companyService.findCompany((long) 1);
        // Them
        verify(companyRepository).findOne((long) 1);
        // JUnit
        assertNotEquals(whenCompanyIs.getId(), wrongTestID);
    }

    @Test
    public void getAllCompanyTest(){
        // Given
        Company testCompany1 = new Company("cc","cn","dc");
        testCompany1.setId((long) 1);
        Company testCompany2 = new Company("123","abc","www");
        testCompany2.setId((long) 2);
        Company testCompany3 = new Company("123","abc","www");
        testCompany3.setId((long) 3);
        List<Company> listCompany = Arrays.asList(testCompany1,testCompany2,testCompany3);
        when(companyRepository.findAll()).thenReturn(listCompany);
        // When
        Iterable<Company> allCompany = companyService.getAllCompany();
        // Then
        verify(companyRepository).findAll();
        // JUnit
        assertEquals(allCompany,listCompany);
    }

    @Test
    public void countCompanyTest(){
        // Given
        long sizeCompanyList;
        Company testCompany1 = new Company("cc","cn","dc");
        testCompany1.setId((long) 1);
        Company testCompany2 = new Company("123","abc","www");
        testCompany2.setId((long) 2);
        Company testCompany3 = new Company("123","abc","www");
        testCompany3.setId((long) 3);
        List<Company> listCompany = Arrays.asList(testCompany1,testCompany2,testCompany3);
        sizeCompanyList = (long)listCompany.size();
        when(companyRepository.count()).thenReturn(sizeCompanyList);
        // When
        long numberCompany = companyService.countCompany();
        // Then
        verify(companyRepository).count();
        // JUnit
        assertEquals(sizeCompanyList, numberCompany);
    }

}
