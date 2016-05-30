package pl.inz.WorthHowBoot.service;

import org.springframework.beans.factory.annotation.Autowired;

import pl.inz.WorthHowBoot.model.StockData;
import pl.inz.WorthHowBoot.repository.StockDataRepository;

public class StockDataServiceImpl implements StockDataService {

	@Autowired
	private StockDataRepository stockDataRepository;
	
	@Override
	public Iterable<StockData> findAll() {
		return stockDataRepository.findAll();
	}

}
