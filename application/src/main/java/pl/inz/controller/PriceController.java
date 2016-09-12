package pl.inz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.inz.model.Company;
import pl.inz.service.CompanyService;

@Controller
public class PriceController {
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "/price")
	public String priceIndex(Model model){
		model.addAttribute("companies", companyService.getAllCompany());
	return "view/PriceView";
	}

	@RequestMapping(value = "/price/load", method = RequestMethod.GET)
	public String setDataset(Company company){

	return "redirect:/price";
	}
	
}
