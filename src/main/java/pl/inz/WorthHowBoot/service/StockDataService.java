package pl.inz.WorthHowBoot.service;

import org.springframework.stereotype.Service;

import pl.inz.WorthHowBoot.model.StockData;

@Service
public interface StockDataService{
	
	Iterable<StockData> findAll();

}
