package central.app.view;

import central.app.Buttons.Department.DepartmentAddButton;
import central.app.Buttons.Department.DepartmentDeleteButton;
import central.app.tables.DepartmentModel;
import central.model.company.Company;

import javax.swing.*;
import java.awt.*;

public class SetDepartmentOptions extends JFrame {

    protected static Company company;

    protected static JTable table;

    protected static JComboBox departments = new JComboBox<>();
    protected JButton delete = new JButton("delete");

    protected JLabel name = new JLabel("name");
    protected static JTextField tname = new JTextField();
    protected JButton add = new JButton("add");

    public SetDepartmentOptions(Company company) {
        this.company = company;
    }

    public void setAddDepartment(JPanel pannel) {

        pannel.setLayout(null);

        pannel.add(name);
        name.setBounds(10,20,60,20);
        pannel.add(tname);
        tname.setBounds(70,20,120,20);
        pannel.add(add);
        add.setBounds(200,20,80,20);
        add.addMouseListener(new DepartmentAddButton(company));
    }


    public void setDeleteDepartment(JPanel pannel) {
        pannel.setLayout(null);
        for(int i = 0; i < company.getDepartments().size(); i++) {
            departments.addItem(company.getDepartmentsName().get(i));
        }
        pannel.add(departments);
        departments.setBounds(125,20,250,20);
        pannel.add(delete);
        delete.setBounds(175,60,150,20);
        delete.addMouseListener(new DepartmentDeleteButton(company));

    }


    public void setViewDepartment(JPanel pannel) {
        DepartmentModel model = new DepartmentModel(company);
        table = new JTable(model);
        table.setPreferredSize(new Dimension(990,990));
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        pannel.add(new JScrollPane(table));

    }

    public void updateCBDepartment(Company c) {
        departments.removeAllItems();
        for(int i = 0; i < c.getDepartmentsName().size(); i++){
            departments.addItem(c.getDepartmentsName().get(i));
        }
    }

}
