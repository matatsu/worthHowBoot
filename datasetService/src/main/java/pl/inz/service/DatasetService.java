package pl.inz.service;

import pl.inz.model.Dataset;

/**
 * Created by matat on 17.09.2016.
 */
public interface DatasetService {

    Dataset saveDataset(Dataset dataset);

    Iterable<Dataset> getAllData();

    Iterable<Dataset> findByCompany(Long companyId);

    long checkDataExist();

    void deleteAllDataSets();
}
