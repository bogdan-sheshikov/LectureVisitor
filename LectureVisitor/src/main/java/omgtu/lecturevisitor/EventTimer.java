package omgtu.lecturevisitor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class EventTimer extends Thread{
    LocalDateTime startTime;
    LocalDateTime endTime;
    ArrayList<Lesson> lessons;
    WebDriverController webDriver;
    Iterator<Lesson> lessonIterator;
    LocalDateTime updateTime;

    EventTimer(ArrayList<Lesson> lessons, WebDriverController webDriver){
        this.lessons = lessons;
        this.webDriver = webDriver;
    }

    private void castStringToDate(String startTime, String endTime){
        String startHour = startTime.substring(0,1);
        String startMinute = startTime.substring(2,3);
        String endHour = startTime.substring(0,1);
        String endMinute = startTime.substring(2,3);

        this.startTime = LocalDate.now().atTime(Integer.parseInt(startHour), Integer.parseInt(startMinute));
        this.endTime = LocalDate.now().atTime(Integer.parseInt(endHour), Integer.parseInt(endMinute));
    }

    private void waitForNextDate(){
        updateTime = LocalDate.now().atTime(4, 0);
        updateTime = updateTime.plusDays(1);
        while (!updateTime.isAfter(LocalDateTime.now())){
            if(updateTime.isAfter(LocalDateTime.now())){
                initFields();
                startTimer();
            }
        }
    }

    private void initFields(){
        lessonIterator = lessons.iterator();
        if(lessonIterator.hasNext()){
            webDriver.setUrl(lessonIterator.next().getLink());
            String startTime = lessonIterator.next().getStartTime();
            String endTime = lessonIterator.next().getEndTime();
            castStringToDate(startTime, endTime);
        }
        else{
            waitForNextDate();
        }
    }

    private void startTimer(){
        while(!startTime.isAfter(LocalDateTime.now())){
            if(endTime.isAfter(LocalDateTime.now())){
                initFields();
                startTimer();
            }
        }
    }

    @Override
    public void run() {
        initFields();
        startTimer();
    }
}
