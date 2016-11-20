package pl.inz.controller;

import org.apache.commons.math3.analysis.function.Log;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.inz.service.DatasetService;

import static java.lang.Math.exp;

/**
 * Created by matat on 19.11.2016.
 */
@Controller
public class BlackScholesController {

    @Autowired
    private DatasetService datasetService;

    private double time = 1.50; //z palca (year) < 0
    private double curPrice;
    private double executePrice = 120; //z palca > 0
    private double riskFreeRate = 0.08; // z palca > 0
    private double dividendYield = 0.03; //z palca > 0
    private double sigma = 0; // standard deviation
    //

    @RequestMapping(value = "/blackscholes")
    public String blackScholesMain(Model model) {
        model.addAttribute("Result",sigma);
        return "view/BlackScholesView";
    }
    //One day after deadline
    @RequestMapping(value = "/blackscholes/calculate")
    public String blackScholesCalc() {
        StandardDeviation strDev = new StandardDeviation();
        NormalDistribution normDist = new NormalDistribution();
        Log logathm = new Log();
        Double[] priceList = datasetService.selectClosePrices();
        double[] arr = new double[priceList.length];
        for(int i =0; i<priceList.length; i++){
            arr[i] =  priceList[i].doubleValue();
        }
        sigma = strDev.evaluate(arr)*0.01;
        curPrice = arr[0];

        double p1=logathm.value(curPrice/executePrice);
        double p21=(riskFreeRate-dividendYield+0.5*Math.pow(sigma, 2))*time;
        double p22=(riskFreeRate-dividendYield-0.5*Math.pow(sigma, 2))*time;
        double p3=sigma*Math.sqrt(time);
        double d1= (p1 + p21) / p3;
        double d2= (p1 + p22) / p3;
        double nd1c = normDist.cumulativeProbability(d1);
        double nd1p = normDist.cumulativeProbability(-d1);
        double nd2c = normDist.cumulativeProbability(d2);
        double nd2p = normDist.cumulativeProbability(-d2);
        double ert = exp(-riskFreeRate*time);
        double eqt = exp(-dividendYield*time);
        double bscall = (curPrice * eqt * nd1c - executePrice * ert * nd2c);
        double bsput = (executePrice * ert * nd2p - curPrice * eqt * nd1p);
        return "redirect:/blackscholes";
    }
}
