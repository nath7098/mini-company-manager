package central.model.company;

import central.model.time.WorkingDay;
import java.util.ArrayList;
import java.util.HashMap;

public class CompanyHistory {

    private HashMap<String,ArrayList<WorkingDay>> companyHistory;

    /**
     *
     */
    CompanyHistory() {
        companyHistory = new HashMap<>();
    }

    /**
     * initializes company history from employees
     *
     * @param employees the employees to get history from
     */
    CompanyHistory(ArrayList<Employee> employees){
        this.companyHistory = new HashMap<>();
        for(Employee e : employees){
            companyHistory.put(e.getName(),e.getHistory().getEmployeeHistory());
        }
    }

    /**
     * gets the map between <code>String</code> the name of employee and a list of his working days
     *
     * @return the company history
     */
    public HashMap<String, ArrayList<WorkingDay>> getCompanyHistory() {
        return companyHistory;
    }
}
