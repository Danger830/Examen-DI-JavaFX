package org.example.examendijavafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalTime;

public class Concurrency extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        TextField texto = new TextField();
        final int[] time = new int[1];
        Label second = new Label("");
        Button startButton = new Button("iniciar");
        VBox vBox = new VBox(texto, startButton, second);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setTitle("Temporizador con alarma");
        stage.show();



        if (isNumber(texto.getText())) {
            second.setVisible(true);
            time[0] = Integer.parseInt(texto.getText());
            while (second.getText().equals("0")) {

                Thread taskThread = new Thread(new Runnable() {


                    @Override
                    public void run() {


                        Platform.runLater(new Runnable() {    // controls JavaFX update
                            @Override
                            public void run() {
                                second.setText(String.valueOf(time[0]));
                                if (second.getText().equals("0")) {
                                    System.out.println();
                                }
                            }
                        });

                        try {                                 // wait one second
                            Thread.sleep(1000);
                            time[0]--;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } else {
            second.setText("Datos incorrectos");
        }
    }

    private static boolean isNumber(String cadena) {
        return cadena.matches("^[0-9]");
    }
}



