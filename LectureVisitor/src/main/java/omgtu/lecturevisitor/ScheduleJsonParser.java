package omgtu.lecturevisitor;

import com.google.gson.*;

import java.util.*;


public class ScheduleJsonParser{
    String patternUrl;
    JsonElement unparsedData;
    ArrayList<Lesson> lessons;

    ScheduleJsonParser(ArrayList<Lesson> lessons){
        this.lessons = lessons;
    }

    public void putData(JsonElement unparsedData) {
        this.unparsedData = unparsedData;
    }

    private void parseData(Object value) {
        JsonArray jsonArrayData = unparsedData.getAsJsonArray();
        for(JsonElement jsonElement: jsonArrayData){

            String disciplineName = jsonElement.getAsJsonObject().get("discipline").getAsString();
            String beginLesson = jsonElement.getAsJsonObject().get("beginLesson").getAsString();
            String endLesson = jsonElement.getAsJsonObject().get("endLesson").getAsString();

            for(Lesson lesson: lessons) {
                if (Objects.equals(lesson.getName(), disciplineName)) {
                    System.out.println("Match name");
                    lesson.setStartTime(beginLesson);
                    lesson.setEndTime(endLesson);
                }
            }
        }
    }

    public ArrayList<Lesson> getData() {
        return lessons;
    }
}
