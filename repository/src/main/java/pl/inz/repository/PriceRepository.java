package pl.inz.repository;

import org.springframework.data.repository.CrudRepository;
import pl.inz.model.Dataset;

/**
 * Created by matat on 12.09.2016.
 */
public interface PriceRepository extends CrudRepository<Dataset, Integer> {
}
