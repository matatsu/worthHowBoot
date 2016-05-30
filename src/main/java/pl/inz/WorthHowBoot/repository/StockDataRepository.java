package pl.inz.WorthHowBoot.repository;

import org.springframework.data.repository.CrudRepository;

import pl.inz.WorthHowBoot.model.StockData;

public interface StockDataRepository extends CrudRepository<StockData, Integer> {
}
