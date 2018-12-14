package central.model.company;

import central.model.company.Company;
import central.model.company.Department;
import central.model.company.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class testCompany {

    private Company company;
    private Company initCie;

    @Before
    public void setup() {
        company = new Company();
        initCie = new Company(Company.initCompany());
    }

    @Test
    public void testGetters() {
        assertNotNull(initCie.getDepartments().get(1));
        assertNotNull(initCie.getEmployees().get(1));
        assertEquals("dpt1",initCie.getDepartments().get(1).getDepartmentName());
        assertEquals("emp1",initCie.getEmployees().get(1).getName());
        assertEquals(initCie.getDepartments().get(1),initCie.getDepartmentByName("dpt1"));
        assertEquals(initCie.getEmployees().get(1),initCie.getEmployeeByName("emp1"));
    }

    @Test
    public void testAdd() {
        Department dpt = new Department("info");
        Employee emp = new Employee("emp","test");
        Employee emp1 = new Employee("emp2","test2");
        emp1.setDepartment(dpt);
        dpt.addEmployee(emp);
        assertEquals(0,company.getDepartments().size());

        company.addDepartment(dpt);
        assertEquals(1,company.getDepartments().size());
        assertEquals(1,company.getEmployees().size());
        assertEquals("info",company.getDepartment(dpt).getDepartmentName());
        assertEquals("emp",company.getEmployee(emp).getName());

        company.addEmployee(emp1);
        assertEquals(1,company.getDepartments().size());
        assertEquals(2,company.getEmployees().size());
    }

    @Test
    public void testAddArray() {
        Department dpt1 = new Department("info");
        Department dpt2 = new Department("maths");
        Employee emp1 = new Employee("emp1","test1");
        Employee emp2 = new Employee("emp2","test2");
        Employee emp3 = new Employee("emp3","test3");
        ArrayList<Employee> emps = new ArrayList<>();
        ArrayList<Department> dpts = new ArrayList<>();
        emps.add(emp2);
        emps.add(emp3);
        emp2.setDepartment(dpt2);
        emp3.setDepartment(dpt2);
        dpt1.addEmployee(emp1);
        dpts.add(dpt1);
        dpts.add(dpt2);
        assertEquals(0,company.getDepartments().size());

        company.addDepartments(dpts);
        assertEquals(2,company.getDepartments().size());
        assertEquals(1,company.getEmployees().size());
        assertEquals("info",company.getDepartments().get(0).getDepartmentName());
        assertEquals("maths",company.getDepartments().get(1).getDepartmentName());
        assertEquals("emp1",company.getEmployee(emp1).getName());

        company.addEmployees(emps);
        assertEquals(2,company.getDepartments().size());
        assertEquals(3,company.getEmployees().size());
    }

    @Test
    public void testDelete() {
        int dptsize = initCie.getDepartments().size();
        Department dpt = initCie.getDepartments().get(1);
        Employee emp = initCie.getEmployees().get(1);
        ArrayList<Employee> removedEmps = dpt.getEmployees();

        initCie.deleteDepartment(dpt);

        assertEquals(dptsize-1,initCie.getDepartments().size());
        for(Employee re : removedEmps) {
            assertEquals(false,initCie.getEmployees().contains(re));
        }

        initCie.deleteEmployee(emp);
        assertEquals(false,initCie.getEmployees().contains(emp));
        for(Department d : initCie.getDepartments()){
            assertEquals(false,d.getEmployees().contains(emp));
        }
    }


}
