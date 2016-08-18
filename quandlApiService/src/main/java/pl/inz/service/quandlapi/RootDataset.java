package pl.inz.service.quandlapi;

public class RootDataset {

	public Dataset dataset;

	public Dataset getDataset() {
		return dataset;
	}
	public void setDataset(Dataset dataset) {
		this.dataset = dataset;
	}
	
	@Override
    public String toString() {
        return "id " + dataset.getId() + 
        		"; dataset_code " + dataset.getDatasetCode() + 
        		"; database_code " + dataset.getDatabaseCode() + 
        		"; name " + dataset.getName() +
        		"; newest " + dataset.getNewestAvailableDate() +
        		"; oldest " + dataset.getOldestAvailableDate();
    }
	
}
