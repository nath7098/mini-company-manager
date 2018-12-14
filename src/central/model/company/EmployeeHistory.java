package central.model.company;

import central.model.time.WorkingDay;
import java.util.ArrayList;

public class EmployeeHistory {

    private Employee employee;
    private ArrayList<WorkingDay> employeeHistory;

    /**
     *
     * @param e the employee's object reference
     */
    EmployeeHistory(Employee e) {
        employee = e;
        employeeHistory = new ArrayList<>();
    }

    /**
     * gets the employee object (makes easier for companyHistory)
     *
     * @return the employee object
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * gets the list of checks
     *
     * @return the list of checks
     */
    public ArrayList<WorkingDay> getEmployeeHistory() {
        return employeeHistory;
    }

    /**
     * adds a day t history
     *
     * @param day the day
     */
    public void addToHistory(WorkingDay day) {
        employeeHistory.add(day);
    }

}
