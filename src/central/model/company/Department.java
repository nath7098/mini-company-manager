package central.model.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Department {

    private String departmentName;
    private ArrayList<Employee> employees;
    private Manager manager;

    /**
     *
     * @param name the department's name
     */
    public Department(String name){
        this.departmentName = name;
        employees = new ArrayList<>();
        manager = null;
    }

    /**
     *
     * @param name the department's name
     * @param employees the list of employees
     */
    public Department(String name, ArrayList<Employee> employees){
        this.departmentName = name;
        this.employees = employees;
        manager = null;
    }

    /**
     *
     * @param name the name of the department
     * @param employees the employees to add
     */
    public Department(String name, Employee[] employees){
        this.departmentName = name;
        for(Employee e : employees){
            this.addEmployee(e);
        }
        manager = null;
    }

    /**
     *
     * @param d the department to copy
     */
    public Department(Department d){
        departmentName = d.departmentName;
        employees = d.employees;
        manager = d.manager;
    }

    /**
     * gets the manager
     *
     * @return the manager
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * gets the employee the is the manager
     *
     * @return the employee's object
     */
    public Employee getEmployeeManager() {
        for(Employee e : employees){
            if(e.isManager())
                return e;
        }
        return null;
    }

    /**
     * gets the department's name
     *
     * @return the department's name
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * gets the department's employees list
     *
     * @return the department's employees list
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * gets employees names
     *
     * @return names of all employees of the department
     */
    public ArrayList<String> getEmployeesName(){
        ArrayList<String> s = new ArrayList<>();
        for(int i = 0; i < employees.size(); i++){
            s.add(employees.get(i).getName());
        }
        return s;
    }

    /**
     * turns a department's object to a list of values
     *
     * @return the list of values
     */
    public List<String> getAsList() {
        return Arrays.asList(getDepartmentName());
    }

    /**
     * sets the department's manager
     *
     * @param manager the manager to set
     */
    public void setManager(Employee manager) {
        if(this.manager!=null){
            getEmployeeManager().setManager(false);
        }
        this.manager = new Manager(manager);
        getEmployees().get(getEmployees().indexOf(manager)).setManager(true);
    }

    /**
     * adds a given employee
     *
     * @param e the employee to add
     */
    public void addEmployee(Employee e){
        employees.add(e);
        e.setDepartment(this);
    }

    /**
     * adds a list of employees
     *
     * @param employees the list of employees
     */
    public void addEmployees(ArrayList<Employee> employees){
        for(Employee e : employees){
            addEmployee(e);
        }
    }

    /**
     * deletes a given employee
     *
     * @param e the employee to delete
     */
    public void deleteEmployee(Employee e){
        if(e.isManager()) {
            e.setManager(false);
            manager = null;
        }
        employees.remove(e);
    }

    /**
     * turns a department to string
     *
     * @return the string value for  department
     */
    public String toString(){
        return departmentName;
    }


}
