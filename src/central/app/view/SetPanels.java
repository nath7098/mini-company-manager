package central.app.view;

import central.model.company.Company;

import javax.swing.*;
import java.awt.*;

public class SetPanels {

    private Company company;

    private SetEmployeesOptions SEO;
    private SetDepartmentOptions SDO;
    private SetCheckOptions SCO;

    public SetPanels(Company company){
        this.company = company;
        SEO = new SetEmployeesOptions(company);
        SDO = new SetDepartmentOptions(company);
        SCO = new SetCheckOptions(company);
    }

    public void setEmployeePanel(JPanel onglet) {
        JTabbedPane empOptions = new JTabbedPane(SwingConstants.TOP);
        JPanel empAdd = new JPanel(), empDelete = new JPanel(),empView = new JPanel(),
                empSet = new JPanel(), empHist = new JPanel(), cmpHist = new JPanel();
        empAdd.setPreferredSize(new Dimension(990, 990));
        empDelete.setPreferredSize(new Dimension(990, 990));
        empView.setPreferredSize(new Dimension(990, 990));
        empSet.setPreferredSize(new Dimension(990, 990));
        empHist.setPreferredSize(new Dimension(990, 990));
        cmpHist.setPreferredSize(new Dimension(990, 990));
        SEO.setAddEmployee(empAdd);
        SEO.setViewEmployees(empView);
        SEO.setDeleteEmployee(empDelete);
        SEO.setTimeEmployees(empSet);
        SEO.setHistoryEmployee(empHist);
        SEO.setHistoryCompany(cmpHist);
        empOptions.addTab("add",empAdd);
        empOptions.addTab("delete",empDelete);
        empOptions.addTab("view",empView);
        empOptions.addTab("set",empSet);
        empOptions.addTab("history",empHist);
        empOptions.addTab("company history",cmpHist);
        onglet.setPreferredSize(new Dimension(990, 990));
        onglet.add(empOptions);
    }

    public void setDepartmentPanel(JPanel onglet) {

        JTabbedPane dptOptions = new JTabbedPane(SwingConstants.TOP);
        JPanel dptAdd = new JPanel(), dptDelete = new JPanel(), dptView = new JPanel();
        dptAdd.setPreferredSize(new Dimension(990, 990));
        dptDelete.setPreferredSize(new Dimension(990, 990));
        dptView.setPreferredSize(new Dimension(990, 990));
        SDO.setAddDepartment(dptAdd);
        SDO.setViewDepartment(dptView);
        SDO.setDeleteDepartment(dptDelete);
        dptOptions.addTab("add",dptAdd);
        dptOptions.addTab("delete",dptDelete);
        dptOptions.addTab("view",dptView);
        onglet.setPreferredSize(new Dimension(990, 990));
        onglet.add(dptOptions);
    }

    public void setCheckPanel(JPanel onglet) {
        JTabbedPane cieOptions = new JTabbedPane(SwingConstants.TOP);
        JPanel chkView = new JPanel(), cieOption2 = new JPanel();
        chkView.setPreferredSize(new Dimension(990, 990));
        //cieOption2.setPreferredSize(new Dimension(990, 990));
        SCO.setViewCheck(chkView);
        cieOptions.addTab("add",chkView);
        //cieOptions.addTab("delete",cieOption2);
        onglet.setPreferredSize(new Dimension(990, 990));
        onglet.add(cieOptions);
    }

}
