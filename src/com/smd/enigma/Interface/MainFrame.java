package com.smd.enigma.Interface;

import com.smd.enigma.Board;
import com.smd.enigma.Enigma;
import com.smd.enigma.Rotor;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainFrame {
    private final String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private final String[] rotorNumber = {"I", "II", "III", "IV", "V"};
    private ComboBox<String> rotor1;
    private ComboBox<String> rotor2;
    private ComboBox<String> rotor3;
    private ComboBox<String> positionRotor1;
    private ComboBox<String> positionRotor2;
    private ComboBox<String> positionRotor3;
    private ComboBox<String> ringSetting1;
    private ComboBox<String> ringSetting2;
    private ComboBox<String> ringSetting3;
    private TextField plugBoard;

    private TextArea input;
    private TextArea output;

    public MainFrame(Stage primaryStage) {
        primaryStage.setTitle("Enigma Machine");

        GridPane layout = new GridPane();
        Scene scene = new Scene(layout, 750, 550);
        layout.setPadding(new Insets(5,20,20,20));
        layout.setVgap(5);
        layout.setHgap(5);
        settingUI();

        //Rotor 1 settings
        Label R1 = new Label("Rotor 1");
        layout.add(R1, 0, 1);
        layout.add(rotor1, 0, 2);

        Label position1 = new Label("Position");
        layout.add(position1, 1, 1);
        layout.add(positionRotor1, 1, 2);

        Label ring1 = new Label("Ring Setting");
        layout.add(ring1, 2, 1);
        layout.add(ringSetting1, 2, 2);

        //Rotor 2 settings
        Label R2 = new Label("Rotor 2");
        layout.add(R2, 0, 3);
        layout.add(rotor2, 0, 4);

        Label position2 = new Label("Position");
        layout.add(position2, 1, 3);
        layout.add(positionRotor2, 1, 4);

        Label ring2 = new Label("Ring Setting");
        layout.add(ring2, 2, 3);
        layout.add(ringSetting2, 2, 4);

        //Rotor 3 settings
        Label R3 = new Label("Rotor 3");
        layout.add(R3, 0, 5);
        layout.add(rotor3, 0, 6);

        Label position3 = new Label("Position");
        layout.add(position3, 1, 5);
        layout.add(positionRotor3, 1, 6);

        Label ring3 = new Label("Ring Setting");
        layout.add(ring3, 2, 5);
        layout.add(ringSetting3, 2, 6);

        //Text Field input
        input = new TextArea();
        input.setWrapText(true);
        input.promptTextProperty().setValue("input");
        input.setOnKeyReleased(event -> encrypt());
        layout.add(input, 2, 8);

        output = new TextArea();
        output.setWrapText(true);
        layout.add(output, 2, 9);

        plugBoard = new TextField();
        plugBoard.setText("swaqnpfovyuxmkclhtzj");
        plugBoard.setOnKeyReleased(event -> encrypt());

        layout.add(plugBoard, 2, 7);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void encrypt() {
        if (input.getText().length() == 0) {
            return;
        }
        Rotor r1 = new Rotor(rotor1.getValue(), positionRotor1.getValue(), ringSetting1.getValue());
        Rotor r2 = new Rotor(rotor2.getValue(), positionRotor2.getValue(), ringSetting2.getValue());
        Rotor r3 = new Rotor(rotor3.getValue(), positionRotor3.getValue(), ringSetting3.getValue());
        if (plugBoard.getText().length() > 20) {
            plugBoard.setText(plugBoard.getText().substring(0, 20));
        }
        try {
            Board board = new Board(plugBoard.getText());
            Enigma enigma = new Enigma(r1, r2, r3, board);
            String s = enigma.cipherStr(input.getText());
            plugBoard.promptTextProperty().setValue(board.toString());
            output.setText(split(s));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Plug can not connect to itself");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Can't use the same char twice");
            alert.showAndWait();
        }
    }

    private String split(String s) {
        return s.replaceAll("(.{5})", "$1 ");
    }

    public ComboBox<String> getComboBox(String text, String[] option) {
        ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList(option));
        comboBox.setValue(text);
        return comboBox;
    }

    public void settingUI() {
        rotor1 = getComboBox("I", this.rotorNumber);
        rotor1.setOnAction(e -> encrypt());
        rotor2 = getComboBox("II", this.rotorNumber);
        rotor2.setOnAction(e -> encrypt());
        rotor3 = getComboBox("III", this.rotorNumber);
        rotor3.setOnAction(e -> encrypt());
        positionRotor1 = getComboBox("A", this.alphabet);
        positionRotor1.setOnAction(e -> encrypt());
        positionRotor2 = getComboBox("A", this.alphabet);
        positionRotor2.setOnAction(e -> encrypt());
        positionRotor3 = getComboBox("A", this.alphabet);
        positionRotor3.setOnAction(e -> encrypt());
        ringSetting1 = getComboBox("A", this.alphabet);
        ringSetting1.setOnAction(e -> encrypt());
        ringSetting2 = getComboBox("A", this.alphabet);
        ringSetting2.setOnAction(e -> encrypt());
        ringSetting3 = getComboBox("A", this.alphabet);
        ringSetting3.setOnAction(e -> encrypt());
    }
}
