package com.smd.enigma;

import com.smd.enigma.Interface.MainFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args){

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainFrame mainFrame = new MainFrame(primaryStage);
    }

}