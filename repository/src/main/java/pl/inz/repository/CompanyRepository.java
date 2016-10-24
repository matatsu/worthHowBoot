package pl.inz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.inz.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    Iterable<Company> findAll();

    Company findOne(Long id);

    Company save(Company newCompany);

    void delete(Long id);

    long count();
}
