package pl.inz.WorthHowBoot.service;

import org.springframework.stereotype.Service;

import pl.inz.WorthHowBoot.model.Company;

@Service
public interface CompanyService {
	
	Iterable<Company> findAll();
	
	Company findOne(Integer id);

	Company save(Company newCompany);
	
	void delete (Company company);
}
