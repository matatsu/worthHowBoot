package pl.inz.WorthHowBoot.service;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.inz.WorthHowBoot.model.Company;
import pl.inz.WorthHowBoot.repository.CompanyRepository;

@Service("CompanyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	

	public Iterable<Company> findAll() {
		return companyRepository.findAll();
	}

	public Company save(Company newCompany) {
		return companyRepository.save(newCompany);
	}

	public void delete(Company company) {
	}

	public Company findOne(Integer id) {
		return companyRepository.findOne(id);
	}

}
