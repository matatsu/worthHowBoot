package pl.inz.service;

import pl.inz.model.Dataset;

/**
 * Created by matat on 17.09.2016.
 */
public interface DatasetService {

    Dataset saveDataset(Dataset dataset);

    Iterable<Dataset> getAllData();

    Double[] selectClosePrices();

    long checkDataExist();

    void deleteAllDataSets();
}
