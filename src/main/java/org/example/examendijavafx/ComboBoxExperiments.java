package org.example.examendijavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class ComboBoxExperiments extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ComboBox Experiment 1");

        // You create a ComboBox simply by creating a new instance of the ComboBox class

        @SuppressWarnings("rawtypes")
        ComboBox comboBox = new ComboBox();

        // You can add choices to a ComboBox by obtaining its item collection and add items to it

        comboBox.getItems().add("Choice 1");
        comboBox.getItems().add("Choice 2");
        comboBox.getItems().add("Choice 3");

        // A ComboBox is not editable by default.
        // To make a ComboBox editable you must call the setEditable() method of the ComboBox

        comboBox.setEditable(true);

        // You can read the selected value of a ComboBox via its getValue() method.
        // If no choice is selected, the getValue() method returns null

        Button button = new Button("Check");
        button.setOnAction(value -> {
            System.out.println("The select value is " + comboBox.getValue());
        });


        VBox hbox = new VBox(comboBox, button);
        Scene scene = new Scene(hbox);
        scene.getStylesheets().add(Objects.requireNonNull(getClass()
                .getResource("/css/styles.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

        Button info = new Button("Ingresar Información");
        //info.setOnAction();
    }
}
