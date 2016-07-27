package pl.inz.WorthHowBoot.service;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.inz.WorthHowBoot.model.Company;

public class QuandlApiServiceImpl implements QuandlApiService {
	
	String path = "https://www.quandl.com/api/v3/datasets/WIKI/AAPL.json?order=asc&column_index=4&collapse=daily";
	ObjectMapper mapper = new ObjectMapper();
	Company company;
	
	private QuandlApiServiceImpl(Company company){
		this.company = company;
	}
	
	public void getJJson(){
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(path, String.class);
		System.out.println(result);
	}
	
	
}
