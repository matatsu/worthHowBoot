package pl.inz.service;

import pl.inz.model.Company;


public interface CompanyService {

    Iterable<Company> getAllCompany();

    Company findCompany(Long id);

    Company addCompany(Company newCompany);

    void deleteCompany(Long id);

    long countCompany();
}
