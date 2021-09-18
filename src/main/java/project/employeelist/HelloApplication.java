package project.employeelist;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author vansh
 */

public class HelloApplication extends Application {
    List<Employee> EmployeeList = new ArrayList<Employee>();
    int count = 0;
    FlowPane area = new FlowPane();
    ListView list = new ListView();
    Label error = new Label();

    @Override
    public void start(Stage stage) throws IOException {
        initUI(stage);
    }

    private void initUI(Stage primaryStage) {
        var root = new Pane();
                 root.setPadding(new Insets(10, 10, 10, 10));
                 var scene = new Scene(root,500,300);
        
                 area.setLayoutX(0);
                 area.setLayoutY(0);
        
                 list.setLayoutX(250);
                 list.setLayoutY(0);
                 root.getChildren().addAll(area,list);
        
                 TextField name = new TextField();
                 name.setLayoutX(10);
                 name.setLayoutY(10);
                 root.getChildren().add(name);
        
                 TextField hourlyRate = new TextField();
                 hourlyRate.setLayoutX(10);
                 hourlyRate.setLayoutY(50);
                 root.getChildren().add(hourlyRate);
                 TextField hours = new TextField();
                 hours.setLayoutX(10);
                 hours.setLayoutY(90);
                 root.getChildren().add(hours);
        
                 Button save = new Button("Save");
                 save.setLayoutX(10);
                 save.setLayoutY(130);
                 root.getChildren().add(save);
                 save.setOnAction((e) -> savePressed(name.getText(),hourlyRate.getText(),hours.getText()));
        
                 Button sort = new Button("Sort");
                 sort.setLayoutX(10);
                 sort.setLayoutY(170);
                 root.getChildren().add(sort);
                 sort.setOnAction((e) -> sortPressed());
        
                 error.setLayoutX(10);
                 error.setLayoutY(210);
                 error.setFont(Font.font("Serif", FontWeight.BOLD,13));
        
                 root.getChildren().add(error);
        
                 primaryStage.setTitle("Employee List");
                 primaryStage.setScene(scene);
                 primaryStage.show();

    }

    private void sortPressed() {

        Collections.sort(EmployeeList);
                  list.getItems().clear();
                 // list.getItems().add(EmployeeList);
                 Iterator element = EmployeeList.iterator();
                 while(element.hasNext()){
                         list.getItems().add(element.next());
                     }


    }

    private void savePressed(String name, String rate, String hours) {


                     try{
                             double hourlyRate = Double.parseDouble(rate);
                             double hoursWorked = Double.parseDouble(hours);
                             if(hourlyRate<0){
                                     throw new Exception("Type Positive Hourly Rate");
                                 }
                             if(hoursWorked<0){
                                     throw new Exception("Type Positive Hours");
                                 }

                             Employee emp = new Employee(name,hourlyRate,hoursWorked);
                             EmployeeList.add(emp);
                             Iterator element = EmployeeList.iterator();
                             list.getItems().add(EmployeeList.get(count));
                             count++;
                          }
                     catch (IllegalArgumentException e){
                             error.setText("Double value expected");
                         }
                     catch(Exception e){

                             error.setText(e.getMessage());
                         }


        }


    public static void main(String[] args) {
        launch();
    }
}