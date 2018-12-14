package central.app.view;

import central.app.Buttons.Employee.*;
import central.app.tables.EmployeeModel;
import central.model.company.Company;
import central.model.time.WorkingDay;
import central.app.tables.EmployeeHistoryModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class SetEmployeesOptions extends JFrame{

    protected static Company company;
    protected static JTable employeeTable, employeeHistoryTable, companyHistoryTable;
    protected static JComboBox cbdepartment, employees = new JComboBox(), empSet = new JComboBox(),
    cbemphist = new JComboBox();
    protected JButton delete = new JButton("delete");

    protected JLabel name = new JLabel("name"),
            lastName = new JLabel("lastName"),
            start = new JLabel("start"),
            stop = new JLabel("stop"),
            department = new JLabel("Department"),
            h1 = new JLabel("h"), h2 = new JLabel("h"), h3 = new JLabel("h"), h4 = new JLabel("h"),
            min1 = new JLabel("min"), min2 = new JLabel("min"), min3 = new JLabel("min"), min4 = new JLabel("min"),
            startlab = new JLabel("start time"), stoplab = new JLabel("stop time");

    protected static JTextField tname = new JTextField(), tlastname = new JTextField(),
            tstartminute = new JTextField("0"), tstarthour = new JTextField("8"),
            tstopminute = new JTextField("0"), tstophour = new JTextField("16"),
            tstartseth, tstartsetm, tstopseth, tstopsetm;

    protected JButton add = new JButton("add"), loadCSV = new JButton("load from csv");
    protected JButton set = new JButton("set");

    public SetEmployeesOptions(Company company){
        this.company = company;
    }

    public void setAddEmployee(JPanel pannel) {

        cbdepartment = new JComboBox();

        pannel.setLayout(null);

        pannel.add(name);
        name.setBounds(10,20,120,20);
        pannel.add(tname);
        tname.setBounds(120,20,120,20);
        pannel.add(lastName);
        lastName.setBounds(10,40,120,20);
        pannel.add(tlastname);
        tlastname.setBounds(120,40,120,20);
        pannel.add(start);
        start.setBounds(10,60,120,20);
        pannel.add(tstarthour);
        pannel.add(tstartminute);
        tstarthour.setBounds(120,60,30,20);
        tstartminute.setBounds(180,60,30,20);
        pannel.add(h1);
        pannel.add(min1);
        h1.setBounds(150,60,30,20);
        min1.setBounds(210,60,30,20);
        pannel.add(stop);
        stop.setBounds(10,80,120,20);
        pannel.add(tstophour);
        pannel.add(tstopminute);
        tstophour.setBounds(120,80,30,20);
        tstopminute.setBounds(180,80,30,20);
        pannel.add(h2);
        pannel.add(min2);
        h2.setBounds(150,80,30,20);
        min2.setBounds(210,80,30,20);
        pannel.add(department);
        department.setBounds(10,100,120,20);
        pannel.add(cbdepartment);
        cbdepartment.setBounds(120,100,120,20);
        pannel.add(add);
        add.setBounds(260,50,80,25);
        pannel.add(loadCSV);
        loadCSV.setBounds(110,140,140,20);

        updateCBDepartment(company);

        add.addMouseListener(new EmployeeAddButton(company));

        loadCSV.addMouseListener(new EmployeeLoadButton(company));
    }

    public void setDeleteEmployee(JPanel pannel) {
        pannel.setLayout(null);
        for(int i = 0; i < company.getEmployees().size(); i++) {
            employees.addItem(company.getEmployees().get(i).toString());
        }
        pannel.add(employees);
        employees.setBounds(125,20,250,20);
        pannel.add(delete);
        delete.setBounds(175,60,150,20);
        delete.addMouseListener(new EmployeeDeleteButton(company));
    }

    public void setViewEmployees(JPanel pannel) {
        EmployeeModel model = new EmployeeModel(company);
        employeeTable = new JTable(model);
        employeeTable.setPreferredSize(new Dimension(990,990));
        employeeTable.setPreferredScrollableViewportSize(employeeTable.getPreferredSize());
        employeeTable.setFillsViewportHeight(true);
        pannel.add(new JScrollPane(employeeTable));
    }


    public void setTimeEmployees(JPanel pannel) {
        pannel.setLayout(null);
        pannel.add(empSet);
        empSet.setBounds(120 , 30,120,20);
        String hstr,mstr, hstp,mstp;
        if(company.getEmployeeByName(String.valueOf(empSet.getSelectedItem()))==null){
            hstr = "8";
            mstr = "0";
            hstp = "16";
            mstp = "0";
        }
        else {
            hstr = String.valueOf(company.getEmployeeByName(String.valueOf(empSet.getSelectedItem())).getStart().getHour());
            mstr = String.valueOf(company.getEmployeeByName(String.valueOf(empSet.getSelectedItem())).getStart().getMinute());
            hstp = String.valueOf(company.getEmployeeByName(String.valueOf(empSet.getSelectedItem())).getStop().getHour());
            mstp = String.valueOf(company.getEmployeeByName(String.valueOf(empSet.getSelectedItem())).getStop().getMinute());
        }

        pannel.add(startlab);
        startlab.setBounds(20,80,80,20);
        tstartseth = new JTextField(hstr);
        pannel.add(tstartseth);
        tstartseth.setBounds(120,80,30,20);
        pannel.add(h3);
        h3.setBounds(150,80,30,20);
        tstartsetm = new JTextField(mstr);
        pannel.add(tstartsetm);
        tstartsetm.setBounds(180,80,30,20);
        pannel.add(min3);
        min3.setBounds(210,80,30,20);

        pannel.add(stoplab);
        stoplab.setBounds(20,100,80,20);
        tstopseth = new JTextField(hstp);
        pannel.add(tstopseth);
        tstopseth.setBounds(120,100,30,20);
        pannel.add(h4);
        h4.setBounds(150,100,30,20);
        tstopsetm = new JTextField(mstp);
        pannel.add(tstopsetm);
        tstopsetm.setBounds(180,100,30,20);
        pannel.add(min4);
        min4.setBounds(210,100,30,20);

        pannel.add(set);
        set.setBounds(120,120,120,20);
        set.addMouseListener(new EmployeeSetTimeButton(company));

        updateCBEmpSet(company);

        empSet.addActionListener(new EmployeeSetTimeComboBox(company));
    }

    public void setHistoryEmployee(JPanel pannel) {
        EmployeeHistoryModel model = new EmployeeHistoryModel(company.getEmployees().get(0));

        pannel.add(cbemphist);
        cbemphist.setBounds(350,20,150,20);
        updateCBEmpHist(company);

        employeeHistoryTable = new JTable(model);
        employeeHistoryTable.setPreferredSize(new Dimension(990,990));
        employeeHistoryTable.setPreferredScrollableViewportSize(employeeHistoryTable.getPreferredSize());
        employeeHistoryTable.setFillsViewportHeight(true);
        pannel.add(new JScrollPane(employeeHistoryTable));

        cbemphist.addActionListener(new EmployeeChangeHistory(company));



    }

    public void setHistoryCompany(JPanel pannel) {
        companyHistoryTable = new JTable(toTableModel(company.getCompanyHistory().getCompanyHistory()));
        companyHistoryTable.setPreferredSize(new Dimension(990,990));
        companyHistoryTable.setPreferredScrollableViewportSize(companyHistoryTable.getPreferredSize());
        companyHistoryTable.setFillsViewportHeight(true);
        pannel.add(new JScrollPane(companyHistoryTable));
    }

    public void updateCBEmployee(Company c) {
        employees.removeAllItems();
        for(int i = 0; i < c.getEmployees().size(); i++) {
            employees.addItem(c.getEmployees().get(i).toString());
        }
    }

    public void updateCBEmpSet(Company c) {
        empSet.removeAllItems();
        for(int i = 0; i < c.getEmployees().size(); i++) {
            empSet.addItem(c.getEmployees().get(i).toString());
        }
    }

    public void updateCBEmpHist(Company c) {
        cbemphist.removeAllItems();
        for(int i = 0; i < c.getEmployees().size(); i++) {
            cbemphist.addItem(c.getEmployees().get(i).toString());
        }
    }

    public void updateCBDepartment(Company c) {
        cbdepartment.removeAllItems();
        for(int i = 0; i < c.getDepartmentsName().size(); i++){
            cbdepartment.addItem(c.getDepartmentsName().get(i));
        }
    }

    public void updateEmloyeeTable(Company c) {
        EmployeeModel model = new EmployeeModel(c);
        employeeTable.setModel(model);
    }

    public void update(Company c) {
        company = c;
        updateCBEmployee(c);
        updateCBEmpSet(c);
        updateCBDepartment(c);
        updateEmloyeeTable(c);
        updateCBEmpHist(c);
    }

    public TableModel toTableModel(Map<String,ArrayList<WorkingDay>> map) {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "employee", "day","start","stop" }, 0
        );
        for (Map.Entry<String,ArrayList<WorkingDay>> entry : map.entrySet()) {
            if(entry.getValue().size()!=0) {
                for(int i = 0; i < entry.getValue().size(); i++) {
                    model.addRow(new Object[]{entry.getKey(), entry.getValue().get(i).getDay(),
                            entry.getValue().get(i).getStart().getRoundTime(),
                            entry.getValue().get(i).getStop().getRoundTime()});
                }
            }
        }
        return model;
    }
}
