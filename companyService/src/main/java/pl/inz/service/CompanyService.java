package pl.inz.service;

import pl.inz.model.Company;


public interface CompanyService {

    Iterable<Company> findAllCompany();

    Company findCompany(Integer id);

    Company addCompany(Company newCompany);

    void deleteCompany(Integer id);

    long countCompany();
}