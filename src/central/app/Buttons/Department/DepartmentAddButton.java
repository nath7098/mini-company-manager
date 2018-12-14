package central.app.Buttons.Department;

import central.model.company.Company;
import central.app.tables.DepartmentModel;
import central.app.view.SetDepartmentOptions;
import central.app.view.SetEmployeesOptions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DepartmentAddButton extends SetDepartmentOptions implements MouseListener {

    private SetEmployeesOptions SEO;

    public DepartmentAddButton(Company company) {
        super(company);
        SEO = new SetEmployeesOptions(company);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        company.addDepartment(tname.getText());
        tname.setText("");
        DepartmentModel model = new DepartmentModel(company);
        table.setModel(model);
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
