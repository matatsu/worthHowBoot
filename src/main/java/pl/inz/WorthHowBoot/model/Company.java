package pl.inz.WorthHowBoot.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Company {	
	
	
	private Integer id;
	
	@NotNull
	private String companyCode;
	
	@NotNull
	private String companyName;
	
	@NotNull
	private String databaseCode;
	
	private StockData stockData;

	protected Company(){
	}
	
	public Company(Integer id, String companyName, String companyCode, String databaseCode){
		this.setId(id);
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

	public StockData getStockData() {
		return stockData;
	}

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
	
	public void setStockData(StockData stockData) {
		this.stockData = stockData;
	}

}
