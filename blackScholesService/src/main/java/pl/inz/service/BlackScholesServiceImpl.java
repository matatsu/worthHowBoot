package pl.inz.service;

import org.apache.commons.math3.analysis.function.Log;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import static java.lang.Math.exp;

/**
 * Created by matat on 25.11.2016.
 */
@Service("BlackScholes")
public class BlackScholesServiceImpl implements BlackScholesService {


    @Override
    public double[] estimatePrices(Double[] priceList) {

        double time = 1.50; //z palca (year) < 0
        double curPrice;
        double executePrice = 600; //z palca > 0
        double riskFreeRate = 0.08; // z palca > 0
        double dividendYield = 0.03; //z palca > 0
        double sigma = 0; // standard deviation
        double bsCall = 0;
        double bsPut = 0;
        double[] options;

        StandardDeviation strDev = new StandardDeviation();
        NormalDistribution normDist = new NormalDistribution();
        Log logathm = new Log();
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
        bsCall = (curPrice * eqt * nd1c - executePrice * ert * nd2c);
        bsCall = Precision.round(bsCall,2);
        bsPut = (executePrice * ert * nd2p - curPrice * eqt * nd1p);
        bsPut = Precision.round(bsPut,2);
        options = new double[]{bsCall, bsPut};
        return options;

    }
}
