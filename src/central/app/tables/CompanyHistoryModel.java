package central.app.tables;

import central.model.company.Company;
import central.model.company.CompanyHistory;

public class CompanyHistoryModel{

    private final String[] names = {"employee","day","start","stop"};
    private Company company;
    private CompanyHistory history;

    public CompanyHistoryModel(Company company) {
        this.company = company;
        this.history = company.getCompanyHistory();
    }

    public CompanyHistory getHistory() {
        return history;
    }


}
