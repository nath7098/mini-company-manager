package central.model.company;

import central.model.company.Department;
import central.model.company.Manager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class testManager {

    private Department department;

    @Before
    public void setup() {
        department = new Department("Info");
        department.addEmployee(new Employee("emp0","last0"));
        department.addEmployee(new Employee("emp1","last1"));
        department.addEmployee(new Employee("emp2","last2"));
    }

    @Test
    public void testAddManager() {
        department.setManager(department.getEmployees().get(0));
        assertEquals(true,department.getEmployees().get(0).isManager());
    }

    @Test
    public void testChangeManager() {
        department.setManager(department.getEmployees().get(0));
        department.setManager(department.getEmployees().get(1));
        assertEquals(false,department.getEmployees().get(0).isManager());
        assertEquals(true,department.getEmployees().get(1).isManager());
    }

    @Test
    public void testDeleteManager() {
        department.setManager(department.getEmployees().get(0));
        department.deleteEmployee(department.getEmployees().get(0));
        assertEquals(null,department.getEmployeeManager());
        assertEquals(null,department.getManager());
    }



}
