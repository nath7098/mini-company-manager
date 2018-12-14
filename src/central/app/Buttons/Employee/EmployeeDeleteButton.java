package central.app.Buttons.Employee;

import central.model.company.Company;
import central.app.view.SetEmployeesOptions;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EmployeeDeleteButton extends SetEmployeesOptions implements MouseListener{

    public EmployeeDeleteButton(Company company) {
        super(company);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null,"are you sure you want to delete ?");
        company.deleteEmployee(company.getEmployeeByName(String.valueOf(employees.getSelectedItem())));
        update(company);
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
