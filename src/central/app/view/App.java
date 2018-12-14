package central.app.view;

import central.model.company.Company;

import javax.swing.*;


public class App extends JFrame {

    private Company company;
    private JPanel pannel = new JPanel();
    private JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
    private SetPanels sp;

    public App() {
        super("Central Application");
        this.company = Company.initCompany();// Company.initFromCSV();
        System.out.println(company.getDepartmentsName());
        setLocationRelativeTo(null);
        setSize(1000,1000);
        sp = new SetPanels(company);

        JPanel onglet1 = new JPanel();
        sp.setEmployeePanel(onglet1);
        onglets.addTab("Employees",onglet1);

        JPanel onglet2 = new JPanel();
        sp.setDepartmentPanel(onglet2);
        onglets.addTab("Departments",onglet2);

        JPanel onglet3 = new JPanel();
        sp.setCheckPanel(onglet3);
        onglets.addTab("Check",onglet3);

        onglets.setOpaque(true);
        pannel.add(onglets);
        getContentPane().add(pannel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


}
