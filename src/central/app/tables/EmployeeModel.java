package central.app.tables;

import central.model.company.Company;
import central.model.company.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class EmployeeModel extends AbstractTableModel{

    private final String[] names = {"id","name","last name","start","stop","check","department"};
    private Company company;
    private ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeModel(Company company) {
        this.company = company;
        this.employees = company.getEmployees();
    }

    public ArrayList getEmployees() {
        return employees;
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return names[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 :
                return employees.get(rowIndex).getId();
            case 1 :
                return employees.get(rowIndex).getName();
            case 2 :
                return employees.get(rowIndex).getLastName();
            case 3 :
                return employees.get(rowIndex).getStart();
            case 4 :
                return employees.get(rowIndex).getStop();
            case 5 :
                return "check";
            case 6 :
                return employees.get(rowIndex).getDepartment().getDepartmentName();
            default :
                throw new  IllegalArgumentException();
        }

    }
}
