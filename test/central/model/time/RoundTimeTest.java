package central.model.time;

import central.model.time.RoundTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalTime;

public class RoundTimeTest {

    RoundTime before;
    RoundTime after;

    @Before
    public void setup(){
        before = new RoundTime(12,18);
        after = new RoundTime(12,24);
    }

    @Test
    public void testRoundTime_before(){
        LocalTime resultat = LocalTime.of(12,15);
        assertEquals(resultat,before.getRoundTime());
    }

    @Test
    public void testRoundTime_after(){
        LocalTime resultat = LocalTime.of(12,30);
        assertEquals(resultat,after.getRoundTime());
    }
}
