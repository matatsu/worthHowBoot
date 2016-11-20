package pl.inz.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.inz.model.Dataset;

/**
 * Created by matat on 17.09.2016.
 */
@Repository
public interface DatasetRepository extends CrudRepository<Dataset, Long> {

    Dataset save(Dataset dataset);

    @Query("SELECT data.closePrice FROM Dataset data")
    Double[] selectClosePrices();

    Iterable<Dataset> findAll();

    long count();

    void deleteAll();
}
