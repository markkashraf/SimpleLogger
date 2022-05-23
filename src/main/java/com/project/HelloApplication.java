package com.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;

public class HelloApplication extends Application {



    public static void main(String[] args) throws Exception
    {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        XSSFSheet sheet = readexcel.getSheet1("src\\Test Excel File\\Example.xlsx");

        Service x = new Service(sheet);

        primaryStage.setTitle("Main Window");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(200);
        grid.setHgap(200);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();


        //getItems of checkbox
        choiceBox.getItems().add("Choose Operation");
        for(int i =0; i < x.Operations.size(); i++) {
            choiceBox.getItems().add(x.);

        }

        choiceBox.setValue("Choose Operation");


        GridPane.setConstraints(choiceBox, 0, 0);


        grid.getChildren().addAll(choiceBox);

        Scene scene = new Scene(grid, 800, 400);


        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

