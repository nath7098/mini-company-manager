package central.model.time;

import java.time.LocalTime;

public class RoundTime {
    private LocalTime roundTime;

    /**
     *
     * @param h the amount of hours
     * @param m the amount of minutes
     */
    public RoundTime(int h, int m){
        LocalTime t = LocalTime.of(h,m);
        if(t.getMinute()%15 >= 7){
            roundTime = t.plusMinutes(15-t.getMinute()%15);
        }
        else{
            roundTime = t.minusMinutes(t.getMinute()%15);
        }
    }

    /**
     *
     * @param t the time to round
     */
    public RoundTime(LocalTime t) {
        if(t.getMinute()%15 >= 7) {
            roundTime = t.plusMinutes(15-t.getMinute()%15);
        }
        else {
            roundTime = t.minusMinutes(t.getMinute()%15);
        }
    }

    /**
     * gets the rounded time
     *
     * @return the rounded time in LocalTime format
     */
    public LocalTime getRoundTime() {
        return roundTime;
    }
}
