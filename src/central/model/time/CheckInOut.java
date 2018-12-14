package central.model.time;

public class CheckInOut {
    private WorkingDay day;

    /**
     *
     * @param day the working day
     */
    public CheckInOut(WorkingDay day){
        this.day = day;
    }

    /**
     * gets the day
     *
     * @return the working day
     */
    public WorkingDay getDay() {
        return day;
    }

    /**
     * gets the day's start
     *
     * @return the roundTime object for day's start
     */
    public RoundTime getDayStart(){
        if(day.getStart() == null)
            return new RoundTime(0,0);
        return day.getStart();
    }

    /**
     * gets the day's stop
     *
     * @return the roundTime object for day's stop
     */
    public RoundTime getDayStop(){
        if(day.getStop() == null)
            return new RoundTime(0,0);
        return day.getStop();
    }

    /**
     * sets the day's start
     *
     * @param time the start time
     */
    public void setDayStart(RoundTime time){
        this.day.setStart(time);
    }

    /**
     * sets the day's stop
     *
     * @param time the stop time
     */
    public void setDayStop(RoundTime time){
        this.day.setStop(time);
    }
}
