package central.app.Buttons.Employee;

import central.app.view.SetEmployeesOptions;
import central.model.company.Company;
import central.model.company.Employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeSetTimeComboBox extends SetEmployeesOptions implements ActionListener {

    public EmployeeSetTimeComboBox(Company company) {
        super(company);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Employee emp = company.getEmployeeByName(String.valueOf(empSet.getSelectedItem()));
        if(emp!=null) {
            String hstr = String.valueOf(emp.getStart().getHour());
            String mstr = String.valueOf(emp.getStart().getMinute());
            String hstp = String.valueOf(emp.getStop().getHour());
            String mstp = String.valueOf(emp.getStop().getMinute());

            tstartseth.setText(hstr);
            tstartsetm.setText(mstr);
            tstopseth.setText(hstp);
            tstopsetm.setText(mstp);
        }
    }
}
