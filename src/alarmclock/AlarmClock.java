package alarmclock;

import java.util.Calendar;

public class AlarmClock 
{
    private int hour;
    private int minute;
    private int amPm;
    private int alarmHour;
    private int alarmMinute;
    private int alarmAmPm;
    private boolean alarmRinging;
    
    Calendar calendar = Calendar.getInstance();
    
    AlarmClock()
    {
        hour = 12;
        alarmHour = 12;
        minute = 0;
        alarmMinute = 0;
        alarmAmPm = 0;
        amPm = 0;
        alarmRinging = false;
    }
    
    AlarmClock( int newAlarmHour, int newAlarmMinute, int newAlarmAmPm)
    {
        setAlarmHour(newAlarmHour);
        setAlarmMinute(newAlarmMinute);
        setAlarmAmPm(newAlarmAmPm);
    }
    
    public int getHour()
    {
        return hour;
    }
    
    public int getMinute()
    {
        return minute;
    }
    
    public int getAmPm()
    {
        return amPm;
    }
    
    public int getalarmHour()
    {
        return alarmHour;
    }
    
    public int getAlarmMinute()
    {
        return alarmMinute;
    }
    
    public int getAlarmAmPm()
    {
        return alarmAmPm;
    }
    
    public boolean isAlarmRinging()
    {
        if(hour >= 12){
            alarmRinging = true; 
        }
        return alarmRinging;
    }
    
    public void setHour(int newHour)
    {
        newHour = calendar.get(Calendar.HOUR);                    
    }
    
    public void setMinute(int newMinute)
    {
        newMinute = calendar.get(Calendar.MINUTE);
    }
    
    public void setAmPm(int newAmPm){
        newAmPm = calendar.get(Calendar.AM_PM);
    }
    
    public void setAlarmHour(int newAlarmHour){
        if((newAlarmHour >= 0) && (newAlarmHour <= 12)){
            alarmHour = newAlarmHour;
        }
    }
    
    public void setAlarmMinute(int newAlarmMinute){
        if((newAlarmMinute >= 0) && (newAlarmMinute <= 59)){
            alarmMinute = newAlarmMinute;
        }
    }
    
    public void setAlarmAmPm(int newAlarmAmPm)//still trying to get this to work with the calendar's 0 or 1 for am/pm
    {

            alarmAmPm = newAlarmAmPm;
        
    }
    
    
    public void setAlarmRinging(boolean alarmRinging){
        if (alarmRinging = true){
            System.out.println("Wake Up!");
        }
    }
    

    public void setAlarmTime(int newAlarmHour, int newAlarmMinute, int newAlarmAmPm){//same with setAlarmAmPm
        if(hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59){
            newAlarmHour = hour;
            newAlarmMinute = minute;
        }
    }
    
    public void turnOffAlarm(){
        alarmRinging = false;
    }
}


