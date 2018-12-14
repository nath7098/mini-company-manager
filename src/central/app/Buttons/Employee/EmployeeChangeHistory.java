package central.app.Buttons.Employee;

import central.model.company.Company;
import central.model.company.Employee;
import central.app.tables.EmployeeHistoryModel;
import central.app.view.SetEmployeesOptions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeChangeHistory extends SetEmployeesOptions implements ActionListener {

    private SetEmployeesOptions SEO;

    public EmployeeChangeHistory(Company company) {
        super(company);
        SEO = new SetEmployeesOptions(company);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Employee employee = company.getEmployeeByName(String.valueOf(cbemphist.getSelectedItem()));
        EmployeeHistoryModel model = new EmployeeHistoryModel(employee);
        employeeHistoryTable.setModel(model);
    }
}
