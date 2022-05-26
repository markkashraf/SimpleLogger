package com.project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;

public class HelloApplication extends Application
{

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        XSSFSheet sheet = readexcel.getSheet1("src\\Test Excel File\\Example.xlsx");

        Service x = new Service(sheet);

        primaryStage.setTitle("HTTP Program");

        //make scene scrollable
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPannable(true);


        //declare grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(40);
        grid.setHgap(40);
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
                    Text allowedValues = new Text(x.getOperation(newValue.intValue()- 1).getObjectFromRequest(i).getField(j).getAllowedValues());
                    Text mandatory = new Text(x.getOperation(newValue.intValue()- 1).getObjectFromRequest(i).getField(j).getMandatory());


                    field.setFont(Font.font(15));
                    allowedValues.setFont(Font.font(15));
                    mandatory.setFont(Font.font(15));
                    if(i == 0)
                    {
                        GridPane.setConstraints(field, 2, j + 1);
                        GridPane.setConstraints(allowedValues, 3, j + 1);
                        GridPane.setConstraints(mandatory, 4, j + 1);

                    }
                    else
                    {
                        GridPane.setConstraints(field, 2, j + rowIndex);
                        GridPane.setConstraints(allowedValues, 3, j + rowIndex);
                        GridPane.setConstraints(mandatory, 4, j + rowIndex);
                    }

                    grid.getChildren().addAll(field, allowedValues, mandatory);
                }
            }

            rowIndex+= x.getOperation(newValue.intValue() - 1).getObjectFromRequest(x.getOperation(newValue.intValue() - 1).getRequestSize() - 1).getNumberofFields();

            int offset = rowIndex;

            //print "Response"
            Text response = new Text("Response:");
            response.setFont(Font.font(20));
            GridPane.setConstraints(response, 0, offset);
            grid.getChildren().addAll(response);

            int rowIndex2 = offset;

            //iterate over all objects in response in current operation
            for(int i = 0; i < x.getOperation(newValue.intValue() - 1).getResponseSize(); i++){



                Text object = new Text(x.getOperation(newValue.intValue() - 1).getObjectFromResponse(i).getObjectName() + ":");
                object.setFont(Font.font(15));
                if(i == 0)
                {
                    GridPane.setConstraints(object, 1, i + offset);
                    System.out.println(x.getOperation(newValue.intValue() - 1).getObjectFromResponse(i).getNumberofFields());
                }
                else
                {
                    rowIndex2 += x.getOperation(newValue.intValue() - 1).getObjectFromResponse(i - 1).getNumberofFields();
                    GridPane.setConstraints(object, 1, rowIndex2);
                }

                grid.getChildren().addAll(object);



                //iterate over every field in current object
                for(int j = 0; j < x.getOperation(newValue.intValue() - 1).getObjectFromResponse(i).getNumberofFields(); j++){

                    Text field = new Text(x.getOperation(newValue.intValue()- 1).getObjectFromResponse(i).getField(j).getName());
                    Text allowedValues = new Text(x.getOperation(newValue.intValue()- 1).getObjectFromResponse(i).getField(j).getAllowedValues());
                    Text mandatory = new Text(x.getOperation(newValue.intValue()- 1).getObjectFromResponse(i).getField(j).getMandatory());


                    field.setFont(Font.font(15));
                    allowedValues.setFont(Font.font(15));
                    mandatory.setFont(Font.font(15));
                    if(i == 0)
                    {
                        GridPane.setConstraints(field, 2, j + offset);
                        GridPane.setConstraints(allowedValues, 3, j + offset);
                        GridPane.setConstraints(mandatory, 4, j + offset);

                    }
                    else
                    {
                        GridPane.setConstraints(field, 2, j + rowIndex2);
                        GridPane.setConstraints(allowedValues, 3, j + rowIndex2);
                        GridPane.setConstraints(mandatory, 4, j + rowIndex2);
                        System.out.println(x.getOperation(newValue.intValue()- 1).getObjectFromResponse(i).getField(j).getName());
                    }

                    grid.getChildren().addAll(field, allowedValues, mandatory);
                }
            }



        });

        // //add grid to scrollPane
        scrollPane.setContent(grid);

        //declare scene
        Scene scene = new Scene(scrollPane, 1400, 700);

        //show primary stage
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}