package pl.inz.service;

import java.util.List;

/**
 * Created by matat on 13.08.2016.
 */

public interface QuandlApiService {

    List<List<String>> getData(String databaseCode, String path);

    //void getClosePrice(Dataset dataset);
}
