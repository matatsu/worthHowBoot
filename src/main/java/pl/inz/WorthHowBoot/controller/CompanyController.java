package pl.inz.WorthHowBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.inz.WorthHowBoot.model.Company;
import pl.inz.WorthHowBoot.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value= "/company")
	public String companyIndex(Model model){
		model.addAttribute("companies", companyService.findAll());
		model.addAttribute("company", new Company());
		return "view/CompanyView";
	}
	
	@RequestMapping(value= "/company/edit/{id}")
	public String editCompany(@PathVariable Integer id, Model model){
		model.addAttribute("companies", companyService.findAll());
		model.addAttribute("company", companyService.findOne(id));
		return "view/CompanyView";
	}
	
	@RequestMapping(value = "/company/add", method = RequestMethod.GET)
	public String addCompany(Company company){
		companyService.save(company);
		return "redirect:/company";
	}
	
	@RequestMapping(value = "company/delete/{id}")
	public String delete(@PathVariable Integer id){
		companyService.delete(id);
		return "redirect:/company";
	}
}
