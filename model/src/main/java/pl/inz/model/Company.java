package pl.inz.model;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Entity
@Transactional
@Table(name = "Companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "companyId", unique = true, nullable = false)
    private Long id;

//    @NotNull
    @Column(nullable = false)
    private String companyCode;

//    @NotNull
    @Column(nullable = false)
    private String companyName;

//    @NotNull
    @Column(nullable = false)
    private String databaseCode;

    @OneToMany(mappedBy = "companyId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Dataset> stockDatas;

    public Company() {
    }

    public List<Dataset> getStockData() {
        return stockDatas;
    }

    public void setStockData(List<Dataset> stockDatas) {
        this.stockDatas = stockDatas;
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

    public Long getId() {
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

    public void setId(Long id) {
        this.id = id;
    }

}
