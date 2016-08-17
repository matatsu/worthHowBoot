package pl.inz.service.quandlapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"dataset_code",
	"database_code",
	"name",
	"newest_available_date",
	"oldest_available_date",
	"start_date",
	"end_date",
	"data",
	"collapse"})
public class Dataset {
	
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("dataset_code")
	private String datasetCode;
	@JsonProperty("database_code")
	private String databaseCode;
	@JsonProperty("name")
	private String name;
	@JsonProperty("newest_available_date")
	private String newestAvailableDate;
	@JsonProperty("oldest_available_date")
	private String oldestAvailableDate;
	@JsonProperty("start_date")
	private String startDate;
	@JsonProperty("end_date")
	private String endDate;
	@JsonProperty("data")
	private List<List<String>> data = new ArrayList<List<String>>();
	@JsonProperty("collapse")
	private String collapse;
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}
	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonProperty("dataset_code")
	public String getDatasetCode() {
		return datasetCode;
	}
	@JsonProperty("dataset_code")
	public void setDatasetCode(String datasetCode) {
		this.datasetCode = datasetCode;
	}
	@JsonProperty("database_code")
	public String getDatabaseCode() {
		return databaseCode;
	}
	@JsonProperty("database_code")
	public void setDatabaseCode(String databaseCode) {
		this.databaseCode = databaseCode;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("start_date")
	public String getStartDate() {
		return startDate;
	}
	@JsonProperty("start_date")
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	@JsonProperty("end_date")
	public String getEndDate() {
		return endDate;
	}
	@JsonProperty("end_date")
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@JsonProperty("data")
	public List<List<String>> getData() {
		return data;
	}
	@JsonProperty("data")
	public void setData(List<List<String>> data) {
		//Data example = new Data(data);
		this.data = data;
	}
	@JsonProperty("collapse")
	public String getCollapse() {
		return collapse;
	}
	@JsonProperty("collapse")
	public void setCollapse(String collapse) {
		this.collapse = collapse;
	}
	@JsonProperty("newest_available_date")
	public String getNewestAvailableDate() {
		return newestAvailableDate;
	}
	@JsonProperty("newest_available_date")
	public void setNewestAvailableDate(String newestAvailableDate) {
		this.newestAvailableDate = newestAvailableDate;
	}
	@JsonProperty("oldest_available_date")
	public String getOldestAvailableDate() {
		return oldestAvailableDate;
	}
	@JsonProperty("oldest_available_date")
	public void setOldestAvailableDate(String oldestAvailableDate) {
		this.oldestAvailableDate = oldestAvailableDate;
	}
	public Dataset(){
		
	}
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		data.forEach(dataPair -> {
			sb.append("data "+ dataPair.get(0) + ", ");
			sb.append("close price "+ dataPair.get(1) + ", ");
			});
		return sb.toString();
	}
}
