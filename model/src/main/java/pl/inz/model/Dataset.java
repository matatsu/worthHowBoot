package pl.inz.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Dataset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long stockDataId;

    @ManyToOne
    public Company companyId;

    public Date ratingDate;

    public Double closePrice;

    public Dataset(){
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }
}