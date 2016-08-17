package pl.inz.service;

import pl.inz.service.quandlapi.Dataset;

/**
 * Created by matat on 13.08.2016.
 */

public interface QuandlApiService {

    void getData(String path);

    void getClosePrice(Dataset dataset);
}
