package com.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;

public class HelloApplication {
    public static void main(String[] args) throws IOException {
        XSSFSheet sheet = readexcel.getSheet1("src\\Test Excel File\\Exampl.xlsx");

        Service x = new Service(sheet);


    }

   /* @Override
    public void start(Stage primaryStage) throws IOException {

        XSSFSheet sheet = readexcel.getSheet1("src\\Test Excel File\\Exampl.xlsx");

        Service x = new Service(sheet);

        //declare grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setGridLinesVisible(true);


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

            //row index
            int rowIndex = 1;

            //iterate over all objects in request in current operation
            for(int i = 0; i < x.getOperation(newValue.intValue() - 1).getRequestSize(); i++){



                Text object = new Text(x.getOperation(newValue.intValue() - 1).getObjectFromRequest(i).getObjectName() + ":");
                object.setFont(Font.font(15));
                if(i == 0)
                {
                    GridPane.setConstraints(object, 1, i + 1);
                    System.out.println(x.getOperation(newValue.intValue() - 1).getObjectFromRequest(i).getNumberofFields());
                }
                else
                {
                    rowIndex += x.getOperation(newValue.intValue() - 1).getObjectFromRequest(i - 1).getNumberofFields();
                    GridPane.setConstraints(object, 1, rowIndex);
                }

                grid.getChildren().addAll(object);



                //iterate over every field in current object
                for(int j = 0; j < x.getOperation(newValue.intValue() - 1).getObjectFromRequest(i).getNumberofFields(); j++){

                    Text field = new Text(x.getOperation(newValue.intValue()- 1).getObjectFromRequest(i).getField(j).getName());

                    field.setFont(Font.font(15));
                    if(i == 0)
                    {
                        GridPane.setConstraints(field, 2, j + 1);
                    }
                    else
                    {
                        GridPane.setConstraints(field, 2, j + rowIndex);
                    }

                    grid.getChildren().addAll(field);

                }
            }


        });


        //declare scene
        Scene scene = new Scene(grid, 1400, 700);

        //show primary stage
        primaryStage.setScene(scene);
        primaryStage.show();

    }*/

}

