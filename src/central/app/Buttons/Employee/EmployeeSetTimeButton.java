package central.app.Buttons.Employee;

import central.app.view.SetCheckOptions;
import central.app.view.SetEmployeesOptions;
import central.app.tables.EmployeeModel;
import central.model.company.Company;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EmployeeSetTimeButton extends SetEmployeesOptions implements MouseListener {

    private SetCheckOptions SCO;

    public EmployeeSetTimeButton(Company company) {
        super(company);
        SCO = new SetCheckOptions(company);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //JOptionPane.showMessageDialog(null,"are you sure you want to delete ?");
        company.getEmployeeByName(String.valueOf(empSet.getSelectedItem())).setStart(tstartseth.getText(),tstartsetm.getText());
        company.getEmployeeByName(String.valueOf(empSet.getSelectedItem())).setStop(tstopseth.getText(),tstopsetm.getText());
        EmployeeModel model = new EmployeeModel(company);
        employeeTable.setModel(model);
        SCO.updateViewTable(company);
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
