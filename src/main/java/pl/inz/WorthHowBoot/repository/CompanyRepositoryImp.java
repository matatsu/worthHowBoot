package pl.inz.WorthHowBoot.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.inz.WorthHowBoot.model.Company;

//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import pl.inz.WorthHowBoot.model.Company;

@Repository("CompanyRepository")
public class CompanyRepositoryImp implements CompanyRepository {

	@Override
	public <S extends Company> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Company> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Company> findAll() {
		// TODO Auto-generated method stub
		return listOfCompany;
	}

	@Override
	public Iterable<Company> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return listOfCompany;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Company entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Company> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	private List<Company> listOfCompany = Arrays.asList(
		new Company(1, "Sony Corporation", "NYSE_SNE", "GOOG"),
		new Company(2, "Apple Corporation", "NASDAQ_AAPL", "GOOG"),
		new Company(3, "Microsoft Corporation", "NASDAQ_MSFT", "GOOG"),
		new Company(4, "Oracle Corporation", "NASDAQ_ORCL", "GOOG")
	);

//		Company sony = new Company(1, "Sony Corporation", "NYSE_SNE", "GOOG");
//		Company apple = new Company(2, "Apple Corporation", "NASDAQ_AAPL", "GOOG");
//		Company microsoft = new Company(3, "Microsoft Corporation", "NASDAQ_MSFT", "GOOG");
//		Company oracle = new Company(4, "Oracle Corporation", "NASDAQ_ORCL", "GOOG");
//		
//		listOfCompany.add(sony);
//		listOfCompany.add(apple);
//		listOfCompany.add(microsoft);
//		listOfCompany.add(oracle);
//	
//	public List<Company> getAllCompanies() {
//		return listOfCompany;
//	}
	
}

