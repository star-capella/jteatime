/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jteatime;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main class for the tea timer.
 *
 * @author curttre
 *
 */
public class JTeaTime extends Application {

    /**
     * current selected tea
     */
    private Tea currentTea = null;

    @Override
    public void start(Stage primaryStage) {
        ListView<Tea> teaList = new ListView<Tea>();
        ObservableList<Tea> teas = FXCollections.observableArrayList(loadTeas());
        teaList.setItems(teas);

        Label time = new Label("test");
        Button startTimer = new Button("Start");
        Button cancelTimer = new Button("Cancel");

        VBox frame = new VBox();
        frame.getChildren().addAll(teaList, time, startTimer, cancelTimer);
        Scene scene = new Scene(frame, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("jTeaTime");

        /* add listener to select list */
        teaList.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Tea>() {
            @Override
            public void changed(ObservableValue<? extends Tea> observable, Tea oldValue,
                    Tea newValue) {
                time.setText(newValue.getTimer().getLength() + "min(s)");
                currentTea = newValue;

            }
        });

        startTimer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                currentTea.startTimer();
            }
        });

        cancelTimer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentTea.cancelTimer();
            }
        });

        primaryStage.show();
    }

    /**
     * Method to load a list of teas
     *
     * @return List of Tea objects
     */
    private ArrayList<Tea> loadTeas() {
        ArrayList<Tea> teaCollections = new ArrayList<Tea>();

        Tea aTea = new Tea("Earl Grey", 4L);
        teaCollections.add(aTea);
        return teaCollections;
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
