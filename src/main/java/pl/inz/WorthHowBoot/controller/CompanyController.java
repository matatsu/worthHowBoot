package pl.inz.WorthHowBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.inz.WorthHowBoot.model.Company;
import pl.inz.WorthHowBoot.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value= "/company")
	public String companyIndex(Model model){
		
		model.addAttribute("companies", companyService.findAll());
		
		return "view/CompanyView";
	}
	
	@RequestMapping(value = "/company/add", method = RequestMethod.GET)
	public void addCompany(@RequestParam(value = "companyCode") String companyCode,
						 	 @RequestParam(value = "companyName") String companyName,
						 	 @RequestParam(value = "databaseCode") String databaseCode){
				Company company = new Company(companyCode, companyName, databaseCode);
				companyService.save(company);
//		return companyIndex(null);
	}
	
	@RequestMapping(value = "company/delete/{id}")
	public String delete(@PathVariable Integer id){
		companyService.delete(companyService.findOne(id));
	return "redirect:/company";
	}
}
