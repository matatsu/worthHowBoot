package pl.inz.service;

import org.springframework.web.client.RestTemplate;
import pl.inz.service.quandlapi.Dataset;
import pl.inz.service.quandlapi.RootDataset;

/**
 * Created by matat on 13.08.2016.
 */
public class QuandlApiServiceImpl implements QuandlApiService{

    private String path = "https://www.quandl.com/api/v3/datasets/WIKI/FB.json";

    public QuandlApiServiceImpl(String companyId, String sourceId){
        //this.path = "https://www.quandl.com/api/v3/datasets/"+sourceId+"/"+companyId+".json";
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
