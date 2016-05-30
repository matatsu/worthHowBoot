package pl.inz.WorthHowBoot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Entity
@Transactional
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
	
	@OneToMany(mappedBy="companyId", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<StockData> stockDatas = new ArrayList<StockData>();

	public Company(){
	}
	
	public List<StockData> getStockData() {
		return stockDatas;
	}

	public void setStockData(List<StockData> stockDatas) {
		this.stockDatas = stockDatas;
	}

//	public Company(String companyName, String companyCode, String databaseCode){
//		this.setCompanyCode(companyCode);
//		this.setCompanyName(companyName);
//		this.setDatabaseCode(databaseCode);
//	}

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
	
}
