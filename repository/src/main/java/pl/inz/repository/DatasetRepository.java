package pl.inz.repository;

import org.springframework.data.repository.CrudRepository;
import pl.inz.model.Dataset;

/**
 * Created by matat on 17.09.2016.
 */
public interface DatasetRepository extends CrudRepository<Dataset, Integer> {

}
