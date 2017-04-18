package pl.inz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.inz.service.BlackScholesService;
import pl.inz.service.DatasetService;

/**
 * Created by matat on 19.11.2016.
 */
@Controller
public class BlackScholesController {

    @Autowired
    private DatasetService datasetService;

    @Autowired
    private BlackScholesService blackScholesService;

    private double bsCall = 0;
    private double bsPut = 0;

    @RequestMapping(value = "/blackscholes")
    public String blackScholesMain(Model model) {
        model.addAttribute("priceCall",bsCall);
        model.addAttribute("pricePut",bsPut);
        return "view/BlackScholesView";
    }

    @RequestMapping(value = "/blackscholes/calculate")
    public String blackScholesCalc() {

        Double[] priceList = datasetService.selectClosePrices();
        double[] optionsPrice = blackScholesService.valuationOptions(priceList);
        bsPut = optionsPrice[1];
        bsCall = optionsPrice[0];

        return "redirect:/blackscholes";
    }
}
