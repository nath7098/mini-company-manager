package central.model.company;

import central.model.time.CheckInOut;
import central.model.time.RoundTime;
import central.model.time.WorkingDay;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class Employee {

    private int id;
    private String name;
    private String lastName;
    private LocalTime start;
    private LocalTime stop;
    private EmployeeHistory history;
    private CheckInOut check;
    private Department department;
    private boolean manager = false;
    private static int count = 0;

    /**
     *
     * @param name the name of the employee
     * @param lastName the last name of the employee
     **/
    public Employee(String name, String lastName){
        this.id = count;
        this.name = name;
        this.lastName = lastName;
        this.start = null;
        this.stop = null;
        history = new EmployeeHistory(this);
        this.check = new CheckInOut(new WorkingDay(LocalDate.now()));
        this.department = null;
        count++;
    }

    /**
     *
     * @param name the employee's name
     * @param lastName the employee's last name
     * @param start the start of day
     * @param stop the stop of day
     * @param department the employee's department
     */
    public Employee(String name, String lastName, LocalTime start, LocalTime stop, Department department) {
        this.id = count;
        this.name = name;
        this.lastName = lastName;
        this.start = start;
        this.stop = stop;
        history = new EmployeeHistory(this);
        this.check = new CheckInOut(new WorkingDay(LocalDate.now()));
        this.department = department;
        count++;
    }

    /**
     *
     * @param name the employee's name
     * @param lastName the employee's last  name
     * @param start the employee's normal start
     * @param stop the employee's normal stop
     */
    public Employee(String name, String lastName, LocalTime start, LocalTime stop) {
        this.id = count;
        this.name = name;
        this.lastName = lastName;
        this.start = start;
        this.stop = stop;
        history = new EmployeeHistory(this);
        this.check = new CheckInOut(new WorkingDay(LocalDate.now()));
        this.department = null;
        count++;
    }

    /**
     * gets the employee's id
     *
     * @return the id of the employee
     */
    public int getId(){
        return id;
    }

    /**
     * gets the employee's name
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * gets the employee's last name
     *
     * @return the last name of the employee
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * gets the employee's department
     *
     * @return the department of the employee
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * gets the employee's check object
     *
     * @return the check object of the employee
     */
    public CheckInOut getCheck(){
        return check;
    }

    /**
     * gets the number of employees
     *
     * @return the number of employees
     */
    public static int getCount() {
        return count;
    }

    /**
     * gets the employee's normal start
     *
     * @return the normal start time of the employee
     */
    public LocalTime getStart() {
        return start;
    }

    /**
     * gets the employee's normal stop
     *
     * @return the normal stop time of the employee
     */
    public LocalTime getStop() {
        return stop;
    }

    /**
     * gets employee's history
     *
     * @return the employee's history object
     */
    public EmployeeHistory getHistory() {
        return history;
    }

    /**
     * determines if an employee is a manager
     *
     * @return <code>true</code> if the employee is a manager, else <code>false</code>
     */
    public boolean isManager() {
        return manager;
    }

    /**
     * gets an employee as a list of string values in order save it to csv file
     *
     * @return the list of values of an employee's object
     */
    public List<String> getAsList() {
        List<String> list = new LinkedList<>();
        list.add(String.valueOf(getId()));
        list.add(getName());
        list.add(getLastName());
        list.add(String.valueOf(getStart()));
        list.add(String.valueOf(getStop()));
        list.add(getDepartment().getDepartmentName());
        list.add(String.valueOf(isManager()));
        for(int i = 0; i < getHistory().getEmployeeHistory().size(); i++) {
            list.add(getHistory().getEmployeeHistory().get(i).getDay().toString());
            list.add(getHistory().getEmployeeHistory().get(i).getStart().getRoundTime().toString());
            list.add(getHistory().getEmployeeHistory().get(i).getStop().getRoundTime().toString());
        }
        return list;
    }

    /**
     * sets the employee's department
     *
     * @param department the department in which the employee should work
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * sets the employee's normal start
     *
     * @param start the normal start time to set
     */
    public void setStart(LocalTime start) {
        this.start = start;
    }

    /**
     * sets the normal start of day from strings
     *
     * @param h the hour string value
     * @param m the minutes string value
     */
    public void setStart(String h, String m) {
        int hour = Integer.valueOf(h);
        int min = Integer.valueOf(m);
        this.start = LocalTime.of(hour,min);
    }

    /**
     * sets the normal start of day from string
     *
     * @param start the string value of start
     */
    public void setStart(String start) {
        int hour = Integer.valueOf(start.substring(0,start.indexOf(':')));
        int min = Integer.valueOf(start.substring(start.indexOf(':')+1,start.length()));
        this.setStart(LocalTime.of(hour,min));
    }
    /**
     * sets the employee's normal stop
     *
     * @param stop the normal stop time to set
     */
    public void setStop(LocalTime stop) {
        this.stop = stop;
    }

    /**
     * sets the normal stop of day from strings
     *
     * @param h the string value of hours
     * @param m the string value of minutes
     */
    public void setStop(String h, String m) {
        int hour = Integer.valueOf(h);
        int min = Integer.valueOf(m);
        this.stop = LocalTime.of(hour,min);
    }

    /**
     * sets the normal stop of day from string
     *
     * @param stop the string value of stop
     */
    public void setStop(String stop) {
        int hour = Integer.valueOf(stop.substring(0,stop.indexOf(':')));
        int min = Integer.valueOf(stop.substring(stop.indexOf(':')+1,stop.length()));
        this.setStop(LocalTime.of(hour,min));
    }

    /**
     * sets the history
     *
     * @param history the employee's history
     */
    public void setHistory(EmployeeHistory history) {
        this.history = history;
    }

    /**
     * adds a day day from strings values to history
     *
     * @param day the day of check
     * @param start the start of day checked
     * @param stop the stop of day checked
     */
    public void addStringToHistory(String day, String start, String stop) {
        this.history.addToHistory(new WorkingDay(day,start,stop));
    }

    /**
     * sets the boolean value to design an employee as manager
     *
     * @param b <code>true</code> if manager, else <code>false</code>
     */
    public void setManager(boolean b) {
        manager = b;
    }

    /**
     * this method sets the employee's arrival and departure for one day
     *
     * @param day the day
     * @param time the time of arrival or departure
     */
    public void check(LocalDate day,RoundTime time){
        if(check == null || !check.getDayStop().getRoundTime().equals(LocalTime.of(0,0))) {
            check = new CheckInOut(new WorkingDay(day));
        }
        //if the employee hasn't checked for the day then we assume that it is his arrival
        if(check.getDayStart().getRoundTime().equals(LocalTime.of(0,0))) {
            check.setDayStart(time);
        }
        //else we assume that he's leaving
        else {
            check.setDayStop(time);
            history.addToHistory(check.getDay());
        }
    }

    /**
     * turns an employee object to string
     *
     * @return the string value of an employee
     */
    public String toString(){
        return name;
    }
}
