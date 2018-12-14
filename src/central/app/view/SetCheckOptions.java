package central.app.view;

import central.app.tables.CheckViewModel;
import central.model.company.Company;

import javax.swing.*;

import java.awt.*;

public class SetCheckOptions extends JFrame {

    protected static Company company;

    protected static JTable viewTable;

    public SetCheckOptions(Company c) {
        this.company = c;
    }

    public void setViewCheck(JPanel pannel) {
        CheckViewModel model = new CheckViewModel(company);
        viewTable = new JTable(model);
        viewTable.setPreferredSize(new Dimension(990,990));
        viewTable.setPreferredScrollableViewportSize(viewTable.getPreferredSize());
        viewTable.setFillsViewportHeight(true);
        pannel.add(new JScrollPane(viewTable));
    }

    public void updateViewTable(Company cmp) {
        company = cmp;
        CheckViewModel model = new CheckViewModel(company);
        viewTable.setModel(model);
    }

}
