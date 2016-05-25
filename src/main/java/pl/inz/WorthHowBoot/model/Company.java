package pl.inz.WorthHowBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "Companies")
public class Company {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String companyCode;
	
	@NotNull
	private String companyName;
	
	@NotNull
	private String databaseCode;
	
	//when basic dataSource will be set then will be add it
	//private StockData stockData;

	public Company(){
	}
	
	public Company(String companyName, String companyCode, String databaseCode){
		this.setCompanyCode(companyCode);
		this.setCompanyName(companyName);
		this.setDatabaseCode(databaseCode);
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getDatabaseCode() {
		return databaseCode;
	}

	public Integer getId() {
		return id;
	}

//	public StockData getStockData() {
//		return stockData;
//	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setDatabaseCode(String databaseCode) {
		this.databaseCode = databaseCode;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
//	public void setStockData(StockData stockData) {
//		this.stockData = stockData;
//	}

}
