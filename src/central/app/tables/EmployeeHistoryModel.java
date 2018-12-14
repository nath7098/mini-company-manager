package central.app.tables;

import central.model.company.Employee;
import central.model.time.WorkingDay;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class EmployeeHistoryModel extends AbstractTableModel{

    private final String[] names = {"day","start","stop"};
    private Employee employee;
    private ArrayList<WorkingDay> history;

    public EmployeeHistoryModel(Employee employee) {
        this.employee = employee;
        this.history = employee.getHistory().getEmployeeHistory();
    }

    public ArrayList<WorkingDay> getEmployees() {
        return history;
    }

    @Override
    public int getRowCount() {
        return history.size();
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
        switch (columnIndex) {
            case 0:
                return history.get(rowIndex).getDay();
            case 1:
                return history.get(rowIndex).getStart().getRoundTime();
            case 2:
                return history.get(rowIndex).getStop().getRoundTime();
            default:
                throw new IllegalArgumentException();
        }
    }
}
