package omgtu.lecturevisitor;

import java.net.MalformedURLException;
import java.net.URL;

public class Lesson{
    String name, startTime, endTime;
    String link;

    Lesson(String name, String link) throws MalformedURLException {
        this.name = name;
        this.link = link;
        System.out.println("Lesson obj was created");
    }

    public String getLink(){
        return this.link;
    }

    public void setStartTime(String time){
        this.startTime = startTime;
    }
    public void setEndTime(String time){
        this.startTime = endTime;
    }
    public String getName(){
        return this.name;
    }
    public String getStartTime(){
        return this.startTime;
    } // to Date
    public String getEndTime(){
        return this.endTime;
    }  // to Date
}