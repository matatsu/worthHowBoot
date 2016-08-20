package pl.inz.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.inz.Application;
import pl.inz.model.Company;
import pl.inz.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;


/**
 * Created by matat on 18.08.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class CompanyRepositoryITest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void testFindAll() {
        Iterable<Company> companies = companyRepository.findAll();
        Iterator<Company> companyIterator = companies.iterator();
        List<Company> companyList = new ArrayList<>();

        while (companyIterator.hasNext()){
            companyList.add(companyIterator.next());
        }

        assertThat(companyList.size(), is(greaterThanOrEqualTo(0)));
    }


}
