module omgtu.lecturevisitor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.google.gson;
    requires org.seleniumhq.selenium.chromium_driver;
    requires io.github.bonigarcia.webdrivermanager;
    requires org.seleniumhq.selenium.chrome_driver;


    opens omgtu.lecturevisitor to javafx.fxml;
    exports omgtu.lecturevisitor;
}