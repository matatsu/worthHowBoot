package pl.inz.WorthHowBoot.service;

import org.springframework.beans.factory.annotation.Autowired;

import pl.inz.WorthHowBoot.model.Company;
import pl.inz.WorthHowBoot.repository.CompanyRepository;

public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Iterable<Company> findAll() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

}
