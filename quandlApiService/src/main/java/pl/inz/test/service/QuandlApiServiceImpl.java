package pl.inz.test.service;

import org.springframework.web.client.RestTemplate;
import pl.inz.test.service.quandlapi.Dataset;
import pl.inz.test.service.quandlapi.RootDataset;

/**
 * Created by matat on 13.08.2016.
 */
public class QuandlApiServiceImpl implements QuandlApiService{

    private String path;

    public QuandlApiServiceImpl(String path){
        this.path = path;
    }

    public void getData(String path){
        RestTemplate restTemplate = new RestTemplate();
        RootDataset rootDataSet = restTemplate.getForObject(path, RootDataset.class);
        Dataset dataset = rootDataSet.dataset;
        //log.info(dataset.toString());
    }

    public void getClosePrice(Dataset dataset){

    }

}
