package pl.inz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.inz.model.Company;
import pl.inz.model.Dataset;
import pl.inz.service.CompanyService;
import pl.inz.service.DatasetService;
import pl.inz.service.QuandlApiService;

import java.util.List;

@Controller
public class DatasetController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private DatasetService datasetService;

	@Autowired
	private QuandlApiService quandlApiService;
	
	@RequestMapping(value = "/price")
	public String priceIndex(Model model){
		model.addAttribute("companies", companyService.getAllCompany());
		model.addAttribute("datasets", datasetService.getAllData());
	return "view/PriceView";
	}

	@RequestMapping(value = "/price/load", method = RequestMethod.GET)
	public String loadDataset(Company company){
		//Company company = companyService.findCompany(companyId);
		List<List<String>> pricesList = quandlApiService.getData(company.getDatabaseCode(), company.getCompanyCode());
		pricesList.forEach(price -> {
			datasetService.saveDataset(new Dataset(company, price.get(0), price.get(1)));
		});
	return "redirect:/price";
	}

	@RequestMapping(value = "/price/load/{id}", method = RequestMethod.GET)
	public String loadDataset(@PathVariable Long id, Model model){
		if (datasetService.findByCompany(id) == null) {
			Company company = companyService.findCompany(id);
			List<List<String>> pricesList = quandlApiService.getData(company.getDatabaseCode(), company.getCompanyCode());
			pricesList.forEach(price -> {
				datasetService.saveDataset(new Dataset(company, price.get(0), price.get(1)));
			});
		}
		model.addAttribute("companies", companyService.getAllCompany());
		model.addAttribute("datasets", datasetService.findByCompany(id));
		return "view/PriceView";
	}
}
