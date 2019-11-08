package com.smd.enigma.Interface;

import javax.swing.*;

import com.smd.enigma.Board;
import com.smd.enigma.Enigma;
import com.smd.enigma.Rotor;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class MainFrame {
    private final String alphabet[] =  {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private final String rotorNumber[] = {"I","II","III","IV","V"};
    private ComboBox rotor1;
    private ComboBox rotor2;
    private ComboBox rotor3;
    private ComboBox positionRotor1;
    private ComboBox positionRotor2;
    private ComboBox positionRotor3;
    private ComboBox ringSetting1;
    private ComboBox ringSetting2;
    private ComboBox ringSetting3;
    private TextField plugBoard;
    private TextField output;
    private Enigma enigma;

    private TextField input;
    private Button btn;

    public MainFrame(Stage primaryStage){
        primaryStage.setTitle("Enigma Machine");

        GridPane layout = new GridPane();
        Scene scene = new Scene(layout, 500, 500);
        settingUI();

        //Rotor 1 settings
        Label R1 = new Label("Rotor 1");
        layout.add(R1,0,0);
        layout.add(rotor1,0,1);

        Label position1 = new Label("Position");
        layout.add(position1,1,0);
        layout.add(positionRotor1,1,1);


        Label ring1 = new Label("Ring Setting");
        layout.add(ring1,2,0);
        layout.add(ringSetting1,2,1);


        //Rotor 2 settings
        Label R2 = new Label("Rotor 2");
        layout.add(R2,0,2);
        layout.add(rotor2,0,3);

        Label position2 = new Label("Position");
        layout.add(position2,1,2);
        layout.add(positionRotor2,1,3);

        Label ring2 = new Label("Ring Setting");
        layout.add(ring2,2,2);
        layout.add(ringSetting2,2,3);

        //Rotor 3 settings
        Label R3 = new Label("Rotor 3");
        layout.add(R3,0,4);
        layout.add(rotor3,0,5);

        Label position3 = new Label("Position");
        layout.add(position3,1,4);
        layout.add(positionRotor3,1,5);

        Label ring3 = new Label("Ring Setting");
        layout.add(ring3,2,4);
        layout.add(ringSetting3,2,5);


        //Text Field input
        input = new TextField();
        input.promptTextProperty().setValue("input");
        layout.add(input,4,4);

        output = new TextField();
        layout.add(output,4,5);

        plugBoard = new TextField();
        plugBoard.setText("swaqnpfovyuxmkclhtzj");

        layout.add(plugBoard,4,6);

        btn = new Button("encrypt");
        layout.add(btn,4,7);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(rotor1.getValue().toString());
                Rotor r1 = new Rotor(rotor1.getValue().toString(),positionRotor1.getValue().toString(),ringSetting1.getValue().toString());
                Rotor r2 = new Rotor(rotor2.getValue().toString(),positionRotor2.getValue().toString(),ringSetting2.getValue().toString());
                Rotor r3 = new Rotor(rotor3.getValue().toString(),positionRotor3.getValue().toString(),ringSetting3.getValue().toString());
                if(plugBoard.getText().length() <= 20){
                    Board board = new Board(plugBoard.getText());
                    enigma = new Enigma(r1, r2, r3, board);
                    output.setText(enigma.cipherStr(input.getText()));

                }else{
                    System.out.println("too many pairs");
                }



            }
        });


        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public ComboBox getComboBox(String text, String option[]){
        ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(option));
        comboBox.setValue(text);
        return comboBox;
    }
    public void settingUI(){
        this.rotor1 = getComboBox("I", this.rotorNumber);
        this.rotor2 = getComboBox("II", this.rotorNumber);
        this.rotor3 = getComboBox("III", this.rotorNumber);
        this.positionRotor1 = getComboBox("A", this.alphabet);
        this.positionRotor2 = getComboBox("A", this.alphabet);
        this.positionRotor3 = getComboBox("A", this.alphabet);
        this.ringSetting1 = getComboBox("A", this.alphabet);
        this.ringSetting2 = getComboBox("A", this.alphabet);
        this.ringSetting3 = getComboBox("A", this.alphabet);

    }





}
