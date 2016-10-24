package pl.inz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.inz.model.Dataset;
import pl.inz.repository.DatasetRepository;

import javax.transaction.Transactional;

/**
 * Created by matat on 17.09.2016.
 */
@Service("DatasetService")
@Transactional
public class DatasetServiceImpl implements DatasetService{

    @Autowired
    private DatasetRepository datasetRepository;

    public Dataset saveDataset (Dataset dataset) {return datasetRepository.save(dataset); }

    public Iterable<Dataset> getAllData() {
        return datasetRepository.findAll();
    }

    public Iterable<Dataset> findByCompany(Long companyId){return datasetRepository.findByCompany(companyId);}

    public long checkDataExist() {return datasetRepository.count();}

    public void deleteAllDataSets() { datasetRepository.deleteAll();}

}
