package central.app.tables;

import central.model.company.Company;
import central.model.company.Department;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DepartmentModel extends AbstractTableModel {
    private final String[] names = {"name","manager","nb employees"};
    private Company company;
    private ArrayList<Department> departments = new ArrayList<>();

    public DepartmentModel(Company company) {
        this.company = company;
        this.departments = company.getDepartments();
    }

    public ArrayList getDepartments() {
        return departments;
    }

    @Override
    public int getRowCount() {
        return departments.size();
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
                return departments.get(rowIndex).getDepartmentName();
            case 1 :
                return departments.get(rowIndex).getManager().getName();
            case 2 :
                return departments.get(rowIndex).getEmployees().size();
            default :
                throw new  IllegalArgumentException();
        }

    }
}
