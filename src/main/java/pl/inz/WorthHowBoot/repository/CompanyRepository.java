package pl.inz.WorthHowBoot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.inz.WorthHowBoot.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer>{
	
}
