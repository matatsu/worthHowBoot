package pl.inz.WorthHowBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/druga")
	public String view2(){
		return "view/druga";
	}
	
	@RequestMapping("/hello")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="I am your App") String name, Model model){
		model.addAttribute("name", name);
	return "greeting";
	}
	
}
