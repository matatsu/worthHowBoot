package pl.inz.model;

import javax.persistence.*;

@Entity
public class Dataset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    public Long stockDataId;


    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    private Company companyId;

//    @NotNull
    @Column(nullable = false)
    private String stockDate;

//    @NotNull
    @Column(nullable = false)
    private Double closePrice;

    public Dataset(){
    }

    public Dataset(Company company, String stockDate, String closePrice){
        this.setCompanyId(company);
        this.setStockDate(stockDate);
        this.setClosePrice(Double.parseDouble(closePrice));
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public String getStockDate() {
        return stockDate;
    }

    public void setStockDate(String stockDate) {
        this.stockDate = stockDate;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }
}