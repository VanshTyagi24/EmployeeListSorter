module project.employeelist {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens project.employeelist to javafx.fxml;
    exports project.employeelist;
}