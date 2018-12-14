package central.model.time;

import java.time.LocalDate;
import java.time.LocalTime;

public class WorkingDay {
    private RoundTime start;
    private RoundTime stop;
    private LocalDate day;

    /**
     *
     * @param day the day
     */
    public WorkingDay(LocalDate day){
        this.start = null;
        this.stop = null;
        this.day = day;
        //this.gap = 0;
    }

    /**
     *
     * @param day the day
     * @param start the start of day
     * @param stop the stop of day
     */
    public WorkingDay(String day, String start, String stop) {
        this.day = LocalDate.parse(day);
        this.start = new RoundTime(LocalTime.parse(start));
        this.stop = new RoundTime(LocalTime.parse(stop));
    }

    /**
     * sets the day's roundTime start
     *
     * @param start the roundTime start
     */
    public void setStart(RoundTime start){
        this.start = start;
    }

    /**
     * sets the day's roundTime stop
     *
     * @param stop the roundTime stop
     */
    public void setStop(RoundTime stop){
        this.stop = stop;
        //this.gap = Duration.between(stop.getRoundTime(),start.getRoundTime()).toMinutes();
    }

    /**
     * sets the day
     *
     * @param day the day
     */
    public void setDay(LocalDate day) {
        this.day = day;
    }

    /**
     * gets the start
     *
     * @return the roundTime start
     */
    public RoundTime getStart() {
        return this.start;
    }

    /**
     * gets the stop
     *
     * @return the roundTime stop
     */
    public RoundTime getStop() {
        return this.stop;
    }

    /**
     * gets the day
     *
     * @return the day
     */
    public LocalDate getDay() {
        return day;
    }

}
