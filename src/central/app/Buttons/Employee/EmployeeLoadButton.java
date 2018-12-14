package central.app.Buttons.Employee;

import central.model.company.Company;
import central.app.view.SetEmployeesOptions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class EmployeeLoadButton extends SetEmployeesOptions implements MouseListener {

    public EmployeeLoadButton(Company company) {
        super(company);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            company.loadDepartmentsFromCSV();
            company.loadEmployeesFromCSV();
            update(company);
        }catch(IOException io) {
            System.out.println(io);
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
