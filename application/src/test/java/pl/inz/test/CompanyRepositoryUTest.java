package pl.inz.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.inz.model.Company;
import pl.inz.repository.CompanyRepository;

import static org.junit.Assert.assertEquals;

/**
 * Created by matat on 23.08.2016.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyRepositoryUTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void findOneTest(){
        // Given
        entityManager.persist(new Company("cn","cc","dc"));
        // When
        Company companyTest1 = companyRepository.findOne(1);
        // Then
        assertEquals("cc", companyTest1.getCompanyCode());
    }
}
