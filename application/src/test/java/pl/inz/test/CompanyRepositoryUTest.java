package pl.inz.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.inz.model.Company;
import pl.inz.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by matat on 23.08.2016.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyRepositoryUTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findOneTest(){
        // Given
        entityManager.persist(new Company("cn","cc","dc"));
        // When
        Company companyTest1 = companyRepository.findOne(1);
        // Then
        assertEquals("cc", companyRepository.findOne(1));
        entityManager.flush();
    }

    @Test
    public void findAllTest() {
        // Given
        entityManager.persist(new Company("cn","cc","dc"));
        entityManager.persist(new Company("cn2","cc2","dc2"));

        // When
        Iterable<Company> companies = companyRepository.findAll();
        Iterator<Company> companyIterator = companies.iterator();
        List<Company> companyList = new ArrayList<>();

        while (companyIterator.hasNext()){
            companyList.add(companyIterator.next());
        }

        // Then
        assertEquals(2, companyList.size());
        entityManager.flush();
    }

    @Test
    public void deleteTest(){
        // Given
        entityManager.persist(new Company("cn","cc","dc"));
        // When
        companyRepository.delete(1);
        // Then
        assertNull(companyRepository.findOne(1));
        entityManager.flush();
    }

    @Test
    public void saveTest(){
        //Given
        Company testCompany1 = new Company("cn","cc","dc");
        //When
        companyRepository.save(testCompany1);
        //Then
        assertEquals(testCompany1,companyRepository.findOne(1));
        entityManager.flush();
    }
}
