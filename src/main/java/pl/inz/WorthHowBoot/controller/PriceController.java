package pl.inz.WorthHowBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.inz.WorthHowBoot.service.CompanyService;

@Controller
public class PriceController {
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "/price")
	public String priceIndex(Model model){
		model.addAttribute("companies", companyService.findAll());
	return "view/PriceView";
	}
	
}
