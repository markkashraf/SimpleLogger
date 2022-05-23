package com.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;

public class HelloApplication
{

    public static void main(String[] args) throws Exception
    {
        XSSFSheet sheet = readexcel.getSheet1("src\\Test Excel File\\Example.xlsx");

        Service x = new Service(sheet);

        //launch(args);

    }
}

   /* @Override
    public void start(Stage primaryStage) throws IOException {



        //declare grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        grid.setHgap(20);

        //declare choiceBox
        ChoiceBox<String> choiceBox = new ChoiceBox<>();


        //getItems of checkbox
        choiceBox.getItems().add("Choose Operation");
        for(int i =0; i < x.GetNumberOfOperations(); i++) {
            choiceBox.getItems().add(x.getOperation(i).getAPI_Name());
        }
        //set default value of choiceBox
        choiceBox.setValue("Choose Operation");


        //specify places on grid
        GridPane.setConstraints(choiceBox, 0, 0);

        //add children to grid
        grid.getChildren().addAll(choiceBox);

        choiceBox.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue)-> {

            //print "Request"
            Text request = new Text("Request:");
            request.setFont(Font.font(20));
            GridPane.setConstraints(request, 0, 1);
            grid.getChildren().addAll(request);

            for(int i = 0; i < x.getOperation(newValue.intValue()); i++){
                //`
            }


        });


        //declare scene
        Scene scene = new Scene(grid, 1200, 700);

        //show primary stage
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}*/

