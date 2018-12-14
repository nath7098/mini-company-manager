package central.model.company;

public class Manager extends Employee {

    /**
     *
     * @param name the name of the employee
     * @param lastName the last name of the employee
     **/
    public Manager(String name, String lastName) {
        super(name, lastName);
    }

    /**
     *
     * @param emp the employee to copy
     */
    public Manager(Employee emp) {
        super(emp.getName(),emp.getLastName());
    }
}
