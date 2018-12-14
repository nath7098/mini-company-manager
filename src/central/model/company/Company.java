package central.model.company;

import central.model.time.RoundTime;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static central.model.company.CSVUtils.*;

public class Company {

    private ArrayList<Department> departments;
    private ArrayList<Employee> employees;
    private CompanyHistory companyHistory;

    public Company(){
        departments = new ArrayList<>();
        employees = new ArrayList<>();
        companyHistory = new CompanyHistory();
    }

    /**
     *  constructor
     *
     * @param c the company to copy
     */
    public Company(Company c){
        departments = c.departments;
        employees = c.employees;
        companyHistory = c.companyHistory;
    }

    /**
     * gets all the departments
     *
     * @return all the departments
     */
    public ArrayList<Department> getDepartments() {
        return departments;
    }

    /**
     * gets the department
     *
     * @param dpt the department to get
     * @return the department
     */
    public Department getDepartment(Department dpt){
        return departments.get(departments.indexOf(dpt));
    }

    /**
     * gets the list of departments names
     *
     * @return the names of all departments
     */
    public ArrayList<String> getDepartmentsName(){
        ArrayList<String> dptn = new ArrayList<>();
        for(Department d : departments){
            dptn.add(d.getDepartmentName());
        }
        return dptn;
    }

    /**
     * gets all employees
     *
     * @return all employees
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * gets an employee
     *
     * @param emp the employee to get
     * @return the employee
     */
    public Employee getEmployee(Employee emp) {
        return employees.get(employees.indexOf(emp));
    }

    /**
     * gets an employee by his name
     *
     * @param name the employee's name
     * @return an employee object
     */
    public Employee getEmployeeByName(String name) {
        for(Employee emp : employees) {
            if(emp.getName().equals(name))
                return emp;
        }
        return null;
    }

    /**
     * gets a department by its name
     *
     * @param name the department's name
     * @return the department object
     */
    public Department getDepartmentByName(String name) {
        for(Department dpt : departments){
            if(dpt.getDepartmentName().equals(name))
                return dpt;
        }
        return null;
    }

    /**
     *
     * @return the history of the company
     */
    public CompanyHistory getCompanyHistory() {
        return companyHistory;
    }

    /**
     * sets the history of the company
     *
     * @param e the list of employees to get history from
     */
    private void setCompanyHistory(ArrayList<Employee> e) {
        companyHistory = new CompanyHistory(e);
    }

    /**
     * adds a given department
     *
     * @param dpt the new department to add
     */
    public void addDepartment(Department dpt){
        departments.add(dpt);
        for(Employee e : dpt.getEmployees()){
            if(!employees.contains(e))
                this.employees.add(e);
        }
    }

    /**
     * adds a department by it's name
     *
     * @param name the department's name
     */
    public void addDepartment(String name) {
        addDepartment(new Department(name));
    }

    /**
     * adds departments from a list
     *
     * @param dpts the departments to add
     */
    public void addDepartments(ArrayList<Department> dpts){
        for(Department dpt : dpts) {
            addDepartment(dpt);
        }
    }

    /**
     * adds an employee
     *
     * @param employee the employee to add
     */
    public void addEmployee(Employee employee) {
        int index = departments.indexOf(employee.getDepartment());
        departments.get(index).addEmployee(employee);
        this.employees.add(employee);
        setCompanyHistory(employees);
    }

    /**
     * adds a list of employees
     *
     * @param emps the list of employees to add
     */
    public void addEmployees(ArrayList<Employee> emps) {
        for(Employee employee : emps) {
            addEmployee(employee);
        }
    }

    /**
     * deletes a given employee
     *
     * @param employee the employee to delete
     */
    public void deleteEmployee(Employee employee) {
        Department dpt = departments.get(departments.indexOf(employee.getDepartment()));
        employees.remove(employee);
        dpt.deleteEmployee(employee);
        setCompanyHistory(employees);
    }

    /**
     * deletes employees from a list
     *
     * @param emps the list of employees to delete
     */
    private void deleteEmployees(ArrayList<Employee> emps) {
        int empsize = emps.size();
        for(int i = empsize-1; i >=0; i--){
            deleteEmployee(emps.get(i));
        }
    }

    /**
     * deletes a department
     *
     * @param dpt the department to delete
     */
    public void deleteDepartment(Department dpt){
        deleteEmployees(dpt.getEmployees());
        departments.remove(dpt);
    }

    /**
     * initializes a company
     *
     * @return the initialized company
     */
    public static Company initCompany(){
        Company cie = new Company();
        Department[] dpts = new Department[2];
        ArrayList<Employee> emps = new ArrayList<>();
        LocalTime str = LocalTime.of(8,0);
        LocalTime stp = LocalTime.of(16,0);
        for(int i = 0; i < 2; i++)
            dpts[i] = new Department("dpt"+i);
        for(int i = 0 ; i < 10 ; i++){
            emps.add(new Employee("emp"+ i,"last"+ i,str,stp));
            emps.get(i).check(LocalDate.of(2018,2,27),new RoundTime(8,0));
            emps.get(i).check(LocalDate.of(2018,2,27),new RoundTime(16,0));
            emps.get(i).check(LocalDate.of(2018,2,28),new RoundTime(8,0));
            emps.get(i).check(LocalDate.of(2018,2,27),new RoundTime(16,0));

            dpts[0].addEmployee(emps.get(i));
        }
        for(int i = 10; i < 20 ; i++){
            emps.add(new Employee("emp"+i,"last"+i,str,stp));
            emps.get(i).check(LocalDate.of(2018,2,27),new RoundTime(8,0));
            dpts[1].addEmployee(emps.get(i));
        }
        for(int i = 0; i < 2;i++) {
            dpts[i].setManager(dpts[i].getEmployees().get(0));
            cie.addDepartment(dpts[i]);
        }
        cie.setCompanyHistory(emps);
        return cie;
    }

    /**
     * initializes a company from csv file
     *
     * @return the company
     */
    public static Company initFromCSV() {
        Company c = new Company();

        c.loadFromCSV();
        for(Employee e : c.getEmployees()){
            for(Department d : c.getDepartments()){
                if(d.getDepartmentName().equals(e.getDepartment().getDepartmentName())){
                    d.addEmployee(e);
                }
            }
        }

        return c;
    }

    /**
     * loads company's data from csv files
     */
    private void loadFromCSV() {
        try {
            loadDepartmentsFromCSV();
            loadEmployeesFromCSV();
        }catch(IOException e) {
            System.err.println("can't load " + e);
        }
    }

    /**
     * saves company's data to csv files
     */
    public void saveToCSV() {
        try{
            saveDepartmentsToCSV();
            saveEmployeesToCSV();
        }catch(IOException e){
            System.err.println("can't save " + e);
        }
    }

    /**
     * saves departments to csv file
     *
     * @throws IOException if the writer can't write
     */
    private void saveDepartmentsToCSV() throws IOException {
        String csvFile = "./data/departments.csv";
        FileWriter writer = new FileWriter(csvFile);
        for(Department dpt : departments) {
            writeLine(writer,dpt.getAsList());
        }
        writer.flush();
        writer.close();
    }

    /**
     * saves employees to csv file
     *
     * @throws IOException if the writer can't write
     */
    private void saveEmployeesToCSV() throws IOException {
        String csvFile = "./data/employees.csv";
        FileWriter writer = new FileWriter(csvFile);
        writeLine(writer,List.of("id","name","last name","normal start","normal stop","department","manage","history"));
        for(Employee emp : employees) {
            writeLine(writer,emp.getAsList());
        }
        writer.flush();
        writer.close();
    }

    /**
     * loads departments from csv file
     *
     * @throws IOException if the scanner can't read
     */
    public void loadDepartmentsFromCSV() throws IOException{
        String csvFile = "./data/departments.csv";
        Scanner scanner = new Scanner(new File(csvFile));
        while(scanner.hasNext()){
            List<String> line = readLine(scanner.nextLine());
            addDepartment(line.get(0));
        }
        scanner.close();
    }

    /**
     * loads employees from csv file
     *
     * @throws IOException if the scanner can't read
     */
    public void loadEmployeesFromCSV() throws IOException {
        String csvFile = "./data/employees.csv";
        Scanner scanner = new Scanner(new File(csvFile));
        List<String> tmp = readLine(scanner.nextLine());
        tmp.clear();
        int j = 0;
        while(scanner.hasNext()) {
            List<String> line = readLine(scanner.nextLine());
            addEmployee(new Employee(line.get(1),line.get(2),null,null, getDepartmentByName(line.get(5))));

            employees.get(employees.size()-1).setStart(line.get(3));
            employees.get(employees.size()-1).setStop(line.get(4));
            employees.get(employees.size()-1).setManager(Boolean.valueOf(line.get(5)));
            if(employees.get(employees.size()-1).isManager())
                employees.get(employees.size()-1).getDepartment().setManager(employees.get(employees.size()-1));
            while(line.size()-1>6+j) {
                employees.get(employees.size() - 1).addStringToHistory(line.get(7+j),line.get(8+j),line.get(9+j));
                j+=3;
            }
            j=0;
        }
        scanner.close();
    }
}
