package pl.inz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.inz.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

    Iterable<Company> findAll();

    Company findOne(Integer id);

    Company save(Company newCompany);

    void delete(Integer id);

    long count();
}
