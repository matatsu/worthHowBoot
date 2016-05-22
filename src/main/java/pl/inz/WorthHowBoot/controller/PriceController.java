package pl.inz.WorthHowBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PriceController {

	@RequestMapping(value = "/price")
	public String priceIndex(){
		
	return "view/PriceView";
	}
	
}
