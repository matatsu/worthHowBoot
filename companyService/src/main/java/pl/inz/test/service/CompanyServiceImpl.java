package pl.inz.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.inz.test.model.Company;
import pl.inz.test.repository.CompanyRepository;

import javax.transaction.Transactional;

@Service("CompanyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Iterable<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    public Company addCompany(Company newCompany) {
        return companyRepository.save(newCompany);
    }

    public Company findCompany(Integer id) {
        return companyRepository.findOne(id);
    }

    public void deleteCompany(Integer id) {
        companyRepository.delete(id);
    }

    public long countCompany() {
        return companyRepository.count();
    }

}
