package omgtu.lecturevisitor;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FxController implements Initializable {
    @FXML
    private TableView<Lesson> lessonsTable;

    @FXML
    private TableColumn<Lesson, String> name;

    @FXML
    private TableColumn<Lesson, String> startTime;

    @FXML
    private TableColumn<Lesson, String> endTime;


    private void setTable(ObservableList<Lesson> data) {
        name.setCellValueFactory(new PropertyValueFactory<Lesson, String>("name"));
        startTime.setCellValueFactory(new PropertyValueFactory<Lesson, String>("startTime"));
        endTime.setCellValueFactory(new PropertyValueFactory<Lesson, String>("endTime"));

        lessonsTable.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LinksParser linksParser = new LinksParser();
        HashMap<String, String> links = linksParser.getListOfLinks();
        ArrayList<Lesson> lessons = new ArrayList<>();
        for(String lessonName : links.keySet()){
            try {
                lessons.add(new Lesson(lessonName, links.get(lessonName)));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        ScheduleJsonParser jsonParser = new ScheduleJsonParser(lessons);
        lessons.clear();
        lessons = jsonParser.getData();

        WebDriverController webDriver = new WebDriverController("Иванов", "Иван", "ГРУ-322");
        EventTimer timer = new EventTimer(lessons, webDriver);
        timer.start();
    }
}