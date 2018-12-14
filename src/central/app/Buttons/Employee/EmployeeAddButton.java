package central.app.Buttons.Employee;

import central.app.view.SetCheckOptions;
import central.model.company.Company;
import central.model.company.Department;
import central.model.company.Employee;
import central.app.tables.EmployeeModel;
import central.app.view.SetEmployeesOptions;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EmployeeAddButton extends SetEmployeesOptions implements MouseListener {


    private SetCheckOptions SCO;

    public EmployeeAddButton(Company company) {
        super(company);
        SCO = new SetCheckOptions(company);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(tname.getText().equals("")){
            JOptionPane.showMessageDialog(null,"you need to fill name");
        }
        else if(tlastname.getText().equals("")){
            JOptionPane.showMessageDialog(null,"you need to fill last name");
        }
        else{

            Department dpt = company.getDepartmentByName(String.valueOf(cbdepartment.getSelectedItem()));
            Employee nEmp = new Employee(tname.getText(), tlastname.getText(), null, null,
                    dpt);
            nEmp.setStart(tstarthour.getText(),tstartminute.getText());
            nEmp.setStop(tstophour.getText(),tstopminute.getText());
            company.addEmployee(nEmp);
            EmployeeModel model = new EmployeeModel(company);
            tname.setText("");
            tlastname.setText("");
            tstarthour.setText("8");
            tstartminute.setText("0");
            tstophour.setText("16");
            tstopminute.setText("0");
            employeeTable.setModel(model);
            employees.addItem(nEmp.getName());
            empSet.addItem(nEmp.getName());
            SCO.updateViewTable(company);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

