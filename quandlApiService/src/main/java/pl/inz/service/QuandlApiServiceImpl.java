package pl.inz.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.inz.service.quandlapi.Dataset;
import pl.inz.service.quandlapi.RootDataset;

import java.util.List;

/**
 * Created by matat on 13.08.2016.
 */
@Service("QuandlApiService")
public class QuandlApiServiceImpl implements QuandlApiService{
    //YAHOO/CSGKF
    //private String path = "https://www.quandl.com/api/v3/datasets/WIKI/FB.json";
    public List<List<String>> getData(String dataCode, String companyCode){
        RestTemplate restTemplate = new RestTemplate();
        String path = "https://www.quandl.com/api/v3/datasets/";
        path = path+dataCode+"/"+companyCode+".json?api_key=MPWVjea-4qscAe4Fy9zx";
        RootDataset rootDataSet = restTemplate.getForObject(path, RootDataset.class);
        Dataset dataset = rootDataSet.dataset;
        //log.info(dataset.toString());
        return dataset.getData();
    }

    public void setDataSetModel(Dataset dataset){

        dataset.getData().forEach(dataPair -> {

        });
    }
}
