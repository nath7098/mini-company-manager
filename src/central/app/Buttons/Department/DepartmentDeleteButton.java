package central.app.Buttons.Department;

import central.model.company.Company;
import central.app.view.SetDepartmentOptions;
import central.app.view.SetEmployeesOptions;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DepartmentDeleteButton extends SetDepartmentOptions implements MouseListener {

    private SetEmployeesOptions SEO;

    public DepartmentDeleteButton(Company company) {
        super(company);
        SEO = new SetEmployeesOptions(company);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null,"are you sure you want to delete ?");
        company.deleteDepartment(company.getDepartmentByName(String.valueOf(departments.getSelectedItem())));
        SEO.update(company);
        updateCBDepartment(company);
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
