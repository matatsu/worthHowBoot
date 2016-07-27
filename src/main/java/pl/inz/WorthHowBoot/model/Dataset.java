package pl.inz.WorthHowBoot.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
