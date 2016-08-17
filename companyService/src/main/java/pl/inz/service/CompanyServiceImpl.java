package pl.inz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.inz.model.Company;
import pl.inz.repository.CompanyRepository;

import javax.transaction.Transactional;

@Service("CompanyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Iterable<Company> findAllCompany() {
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
