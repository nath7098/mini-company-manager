package central.model.company;

import central.model.company.Employee;
import central.model.time.RoundTime;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class testEmployee {
    private Employee e;

    @Before
    public void setup(){
        e = new Employee("nathan","couton");
        e.setStart(LocalTime.of(8,0));
        e.setStop(LocalTime.of(16,0));
    }

    @Test
    public void testCheckIn(){
        LocalTime result = LocalTime.of(8,0);
        LocalTime result1 = LocalTime.of(0,0);
        e.check(LocalDate.of(2018,2,27),new RoundTime(8,5));
        assertEquals(result,e.getCheck().getDayStart().getRoundTime());
        assertEquals(result1,e.getCheck().getDayStop().getRoundTime());
        assertEquals(0,e.getHistory().getEmployeeHistory().size());
    }

    @Test
    public void testCheckOut(){
        LocalTime result = LocalTime.of(8,15);
        LocalTime result1 = LocalTime.of(16,0);
        e.check(LocalDate.of(2018,2,27),new RoundTime(8,9));
        e.check(LocalDate.of(2018,2,27),new RoundTime(16,5));
        assertEquals(result,e.getCheck().getDayStart().getRoundTime());
        assertEquals(result1, e.getCheck().getDayStop().getRoundTime());
        assertEquals(1,e.getHistory().getEmployeeHistory().size());
    }




}
