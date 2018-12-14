package central.model.company;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class testDepartment {
    private ArrayList<Employee> emp = new ArrayList<>();
    private Employee e1;
    private Department department;

    @Before
    public void setup(){
        e1 = new Employee("nath", "couton");
        for(int i = 0; i < 10; i++){
            emp.add(new Employee("e"+i ,"l"+i));
        }
        department = new Department("info");
    }

    @Test
    public void testAddOne(){
        department.addEmployee(e1);
        String result = "nath";
        String resultDpt = department.getDepartmentName();
        assertEquals(result,department.getEmployees().get(0).getName());
        assertEquals(resultDpt,e1.getDepartment().getDepartmentName());
    }

    @Test
    public void testAddByArrayList(){
        department.addEmployees(emp);
        ArrayList<String> result = new ArrayList<>();
        result.add("e0");result.add("e1");result.add("e2");result.add("e3");
        result.add("e4");result.add("e5");result.add("e6");result.add("e7");
        result.add("e8");result.add("e9");
        assertEquals(result,department.getEmployeesName());
    }

    @Test
    public void testRemoveEmployee(){
        department.addEmployees(emp);
        department.deleteEmployee(emp.get(5));
        ArrayList<String> result = new ArrayList<>();
        result.add("e0");result.add("e1");result.add("e2");
        result.add("e3");result.add("e4");result.add("e6");
        result.add("e7");result.add("e8");result.add("e9");
        assertEquals(result,department.getEmployeesName());
        assertEquals("e6",department.getEmployees().get(5).getName());
    }


}
